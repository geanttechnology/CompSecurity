// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import java.net.InetAddress;
import java.net.InetSocketAddress;

class HttpInetSocketAddress extends InetSocketAddress
{

    private final HttpHost host;

    public HttpInetSocketAddress(HttpHost httphost, InetAddress inetaddress, int i)
    {
        super(inetaddress, i);
        if (httphost == null)
        {
            throw new IllegalArgumentException("HTTP host may not be null");
        } else
        {
            host = httphost;
            return;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(host.getHostName()).append(":").append(getPort()).toString();
    }
}
