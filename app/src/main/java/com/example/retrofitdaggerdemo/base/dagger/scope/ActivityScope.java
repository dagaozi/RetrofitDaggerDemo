package com.example.retrofitdaggerdemo.base.dagger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by 海滨 .（dagaozi@163.com）
 * 创建时间：2016/4/22 17:22
 * 类描述：
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
    public @interface ActivityScope{}

