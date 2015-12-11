// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.apache40;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

public class KeepAliveStrategy extends DefaultConnectionKeepAliveStrategy
{

    private final long timeout;

    public KeepAliveStrategy(long l)
    {
        timeout = l;
    }

    public long getKeepAliveDuration(HttpResponse httpresponse, HttpContext httpcontext)
    {
        long l1 = super.getKeepAliveDuration(httpresponse, httpcontext);
        long l;
        if (l1 == -1L)
        {
            l = timeout;
        } else
        {
            l = l1;
            if (timeout != -1L)
            {
                return Math.min(l1, timeout);
            }
        }
        return l;
    }
}
