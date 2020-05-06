import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ApiClient {
    private static Retrofit retrofit=null;
    private static OkHttpClient  client;

    static  Retrofit getRetrofitInstance(){
        if (client==null){
            initClient();
        }
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BaseURL.BASEURL)
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    private static void initClient(){
        int TIMEOUT = 60;
        final OkHttpClient.Builder builder=new OkHttpClient.Builder().connectTimeout(TIMEOUT,
               TimeUnit.SECONDS)
               .writeTimeout(TIMEOUT,TimeUnit.SECONDS).readTimeout(TIMEOUT,TimeUnit.SECONDS);
       HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
       httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
       builder.addInterceptor(httpLoggingInterceptor);
       builder.addInterceptor(chain -> {
           Request request=chain.request();
           Request.Builder builder1=request.newBuilder()
                   .addHeader("Accept","application/json")
                   .addHeader("Content-Type","application/json");
           Request request1=builder1.build();
           return chain.proceed(request1);
       });
       client=builder.build();

    }
}
