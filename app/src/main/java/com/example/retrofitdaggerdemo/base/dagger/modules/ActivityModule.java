package com.example.retrofitdaggerdemo.base.dagger.modules;

import android.app.Activity;

import com.example.retrofitdaggerdemo.base.dagger.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 海滨 .（dagaozi@163.com）
 * 创建时间：2016/4/22 17:19
 * 类描述：
 */
@Module
public class ActivityModule {
    private Activity mActivity;
    public ActivityModule(Activity mActivity){
        this.mActivity=mActivity;
    }
    @Provides
    @ActivityScope
    Activity provideActivity(){return mActivity;}
}
