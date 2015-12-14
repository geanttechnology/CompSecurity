// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;


public interface AppLovinLogger
{

    public static final String SDK_TAG = "AppLovinSdk";

    public abstract void d(String s, String s1);

    public abstract void e(String s, String s1);

    public abstract void e(String s, String s1, Throwable throwable);

    public abstract void i(String s, String s1);

    public abstract void userError(String s, String s1);

    public abstract void userError(String s, String s1, Throwable throwable);

    public abstract void w(String s, String s1);

    public abstract void w(String s, String s1, Throwable throwable);
}
