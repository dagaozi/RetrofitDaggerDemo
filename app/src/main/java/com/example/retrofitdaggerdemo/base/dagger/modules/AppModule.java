package com.example.retrofitdaggerdemo.base.dagger.modules;

import android.content.Context;
import android.content.res.Resources;

import com.example.retrofitdaggerdemo.base.dagger.BaseApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 海滨 .（dagaozi@163.com）
 * 创建时间：2016/4/20 13:35
 * 类描述：
 */
@Module
public class AppModule {
    private BaseApp app;
    public AppModule(BaseApp app){
        this.app=app;
    }
    @Provides
    @Singleton
    public Context produceAppContext(){
        return app;
    }
    @Provides
    @Singleton
    public Resources provideResources(){
        return app.getResources();
    }
}
