// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.crop.util;


public class Log
{

    private static final String TAG = "android-crop";

    public Log()
    {
    }

    public static final void e(String s)
    {
        android.util.Log.e("android-crop", s);
    }

    public static final void e(String s, Throwable throwable)
    {
        android.util.Log.e("android-crop", s, throwable);
    }
}
