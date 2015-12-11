// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.log.appenders;


public interface LogAppender
{

    public abstract void d(String s, String s1);

    public abstract void d(String s, String s1, Throwable throwable);

    public abstract void e(String s, String s1);

    public abstract void e(String s, String s1, Throwable throwable);

    public abstract void i(String s, String s1);

    public abstract void v(String s, String s1);

    public abstract void w(String s, String s1);

    public abstract void w(String s, String s1, Throwable throwable);
}
