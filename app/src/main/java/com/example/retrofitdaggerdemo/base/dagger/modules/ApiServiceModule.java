package com.example.retrofitdaggerdemo.base.dagger.modules;

import com.example.retrofitdaggerdemo.base.dagger.http.ApiStores;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 海滨 .（dagaozi@163.com）
 * 创建时间：2016/4/20 13:42
 * 类描述：提供网络访问客户端
 */
@Module
public class ApiServiceModule {
    public static final String BASE_URL = "http://www.weather.com.cn/";
    private static final int DEFAULT_TIMEOUT = 5;
    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClient(){
        //OKhttp的日志系统
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //手动创建一个OkHttpClient并设置超时时间，和日志
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return httpClientBuilder;
    }
    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient.Builder httpClientBuilder){
        Retrofit  retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }
    @Provides
    @Singleton
    ApiStores provideApiStores(Retrofit retrofit){
        return retrofit.create(ApiStores.class);
    }
}
