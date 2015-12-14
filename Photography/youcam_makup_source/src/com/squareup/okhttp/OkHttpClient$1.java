// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Network;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.Transport;

// Referenced classes of package com.squareup.okhttp:
//            OkHttpClient, Connection, ConnectionPool, Request, 
//            Protocol

final class ttpEngine extends Internal
{

    public void addLine( , String s)
    {
        .addLine(s);
    }

    public boolean clearOwner(Connection connection)
    {
        return connection.clearOwner();
    }

    public void closeIfOwnedBy(Connection connection, Object obj)
    {
        connection.closeIfOwnedBy(obj);
    }

    public void connectAndSetOwner(OkHttpClient okhttpclient, Connection connection, HttpEngine httpengine, Request request)
    {
        connection.connectAndSetOwner(okhttpclient, httpengine, request);
    }

    public InternalCache internalCache(OkHttpClient okhttpclient)
    {
        return okhttpclient.internalCache();
    }

    public boolean isReadable(Connection connection)
    {
        return connection.isReadable();
    }

    public Network network(OkHttpClient okhttpclient)
    {
        return OkHttpClient.access$000(okhttpclient);
    }

    public Transport newTransport(Connection connection, HttpEngine httpengine)
    {
        return connection.newTransport(httpengine);
    }

    public void recycle(ConnectionPool connectionpool, Connection connection)
    {
        connectionpool.recycle(connection);
    }

    public int recycleCount(Connection connection)
    {
        return connection.recycleCount();
    }

    public RouteDatabase routeDatabase(OkHttpClient okhttpclient)
    {
        return okhttpclient.routeDatabase();
    }

    public void setCache(OkHttpClient okhttpclient, InternalCache internalcache)
    {
        okhttpclient.setInternalCache(internalcache);
    }

    public void setNetwork(OkHttpClient okhttpclient, Network network1)
    {
        OkHttpClient.access$002(okhttpclient, network1);
    }

    public void setOwner(Connection connection, HttpEngine httpengine)
    {
        connection.setOwner(httpengine);
    }

    public void setProtocol(Connection connection, Protocol protocol)
    {
        connection.setProtocol(protocol);
    }

    ttpEngine()
    {
    }
}
