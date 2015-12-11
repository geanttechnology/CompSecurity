// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;


public interface LogInterface
{

    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static final int WTF = 8;

    public abstract void d(String s, String s1);

    public abstract void d(String s, String s1, Throwable throwable);

    public abstract void e(String s, String s1);

    public abstract void e(String s, String s1, Throwable throwable);

    public abstract int getLoggingLevel();

    public abstract void i(String s, String s1);

    public abstract void i(String s, String s1, Throwable throwable);

    public abstract boolean isLoggingEnabled();

    public abstract void setLoggingEnabled(boolean flag);

    public abstract void setLoggingLevel(int j);

    public abstract boolean shouldLog(int j);

    public abstract void v(String s, String s1);

    public abstract void v(String s, String s1, Throwable throwable);

    public abstract void w(String s, String s1);

    public abstract void w(String s, String s1, Throwable throwable);

    public abstract void wtf(String s, String s1);

    public abstract void wtf(String s, String s1, Throwable throwable);
}
