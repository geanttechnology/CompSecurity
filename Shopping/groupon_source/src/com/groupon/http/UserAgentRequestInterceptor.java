// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class UserAgentRequestInterceptor
    implements Interceptor
{

    private static final String HEADER_USER_AGENT = "User-Agent";
    protected String userAgent;

    public UserAgentRequestInterceptor()
    {
    }

    public Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
        throws IOException
    {
        return chain.proceed(chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", userAgent).build());
    }
}
