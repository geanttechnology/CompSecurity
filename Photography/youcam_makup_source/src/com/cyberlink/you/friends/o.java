// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import com.squareup.okhttp.OkHttpClient;
import java.util.concurrent.TimeUnit;

class o
{

    private static OkHttpClient a;

    public static OkHttpClient a()
    {
        com/cyberlink/you/friends/o;
        JVM INSTR monitorenter ;
        OkHttpClient okhttpclient;
        if (a == null)
        {
            a = new OkHttpClient();
            a.setConnectTimeout(30000L, TimeUnit.MILLISECONDS);
            a.setReadTimeout(30000L, TimeUnit.MILLISECONDS);
        }
        okhttpclient = a;
        com/cyberlink/you/friends/o;
        JVM INSTR monitorexit ;
        return okhttpclient;
        Exception exception;
        exception;
        throw exception;
    }

    static OkHttpClient a(OkHttpClient okhttpclient)
    {
        a = okhttpclient;
        return okhttpclient;
    }
}
