// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.content.SharedPreferences;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import roboguice.util.Strings;

public class ProxyHeaderHttpRequestInterceptor
    implements Interceptor
{

    private SharedPreferences prefs;

    public ProxyHeaderHttpRequestInterceptor()
    {
    }

    public Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
        throws IOException
    {
        String s = prefs.getString("proxyClientUUID", null);
        if (!Strings.isEmpty(s))
        {
            return chain.proceed(chain.request().newBuilder().addHeader("Odo-Client-UUID", s).build());
        } else
        {
            return chain.proceed(chain.request());
        }
    }
}
