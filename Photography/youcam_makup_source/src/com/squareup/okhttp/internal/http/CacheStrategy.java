// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public final class CacheStrategy
{

    public final Response cacheResponse;
    public final Request networkRequest;

    private CacheStrategy(Request request, Response response)
    {
        networkRequest = request;
        cacheResponse = response;
    }


    public static boolean isCacheable(Response response, Request request)
    {
        int i = response.code();
        if (i == 200 || i == 203 || i == 300 || i == 301 || i == 410 || i == 308)
        {
            response = response.cacheControl();
            request = request.cacheControl();
            if (!response.noStore() && !request.noStore())
            {
                return true;
            }
        }
        return false;
    }
}
