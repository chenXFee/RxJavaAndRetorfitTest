package com.cxf.moudule_common.Retorfit;

import okhttp3.OkHttpClient;

import com.cxf.moudule_common.IPconfig;

import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkManager {

    private static final int DEFAULT_TIME_OUT = 5;//超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;

    private static NetWorkManager mInstance;
    private static Retrofit retrofit;

    public static NetWorkManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private NetWorkManager() {
        this.init();
    }

    private static class SingletonHolder{
        private static final NetWorkManager INSTANCE = new NetWorkManager();
    }


    /**
     * 初始化必要对象和参数
     */
    public void init() {
        //OKHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
        builder.writeTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT,TimeUnit.SECONDS);//读操作超时时间
        // 初始化Retrofit
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(IPconfig.IP)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public <T> T create(Class<T> service){
        return retrofit.create(service);
    }
}
