import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main   {
    public static void main(String[] args) {
       Repository repository=Repository.getInstance();
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            CountryData covidData = repository.getCovidData();
            System.out.println(covidData.toString());
        });
        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
