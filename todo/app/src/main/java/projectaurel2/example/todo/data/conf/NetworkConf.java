package projectaurel2.example.todo.data.conf;

import java.util.concurrent.TimeUnit;

import projectaurel2.example.todo.data.service.ApiService;

public class NetworkConf {

    public static ApiService getApiService() {
        return createRetrofit().create(ApiService.class); }

    //mmebuat object retrofit
    public static Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://xplnpnxfmiefovhoffra.supabase.co/rest")
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build();
    }
    //membuat OK Http client
    public static OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).build();
//            return new OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
//                .connectTimeout(60, TimeUnit.SECONDS).build();
    }
}
