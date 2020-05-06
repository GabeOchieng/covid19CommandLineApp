import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("countries/{countryName}")
    Single<CountryData> getCountryData(@Path(value = "countryName")String countryName);
}
