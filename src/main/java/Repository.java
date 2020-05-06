import com.google.gson.JsonSyntaxException;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repository {
    private ApiService apiService;
    private static  Repository repository;
    private static  String tag=Repository.class.getSimpleName();
      void handleNonHttpException(Throwable throwable){
        if (throwable instanceof HttpException||
        throwable instanceof JsonSyntaxException ||
        throwable instanceof ConnectException||
        throwable instanceof SocketTimeoutException){
            Logger.getLogger(tag).log(Level.SEVERE,
                    "The following http exception occurred:  "+throwable.getMessage());
        }else {
            Logger.getLogger(tag).log(Level.SEVERE,"The following exception occurred: "+ throwable.getMessage());
        }
    }
    synchronized static  Repository getInstance(){
        if (repository==null){
            repository=new Repository();
        }
        return repository;
    }
private Repository(){
        apiService=ApiClient.getRetrofitInstance().
                create(ApiService.class);
}
CountryData getCovidData(){
    CompletableFuture<CountryData>countryDataCompletableFuture=new CompletableFuture<>();
    apiService.getCountryData("Kenya")
            .subscribeOn(Schedulers.io())
            .subscribe(new DisposableSingleObserver<CountryData>() {
                @Override
                public void onSuccess(CountryData countryData) {
                    countryDataCompletableFuture.complete(countryData);
                }

                @Override
                public void onError(Throwable e) {
                    handleNonHttpException(e);
                countryDataCompletableFuture.completeExceptionally(e);
                }
            });
    return countryDataCompletableFuture.join();
}

}

