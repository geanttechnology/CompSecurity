// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

final class q
    implements Interceptor
{

    q()
    {
    }

    public final Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
    {
        return chain.proceed(chain.request().newBuilder().removeHeader("Content-Type").build());
    }
}
