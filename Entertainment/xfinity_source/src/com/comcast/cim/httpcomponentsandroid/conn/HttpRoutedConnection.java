// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn;

import com.comcast.cim.httpcomponentsandroid.HttpInetConnection;
import com.comcast.cim.httpcomponentsandroid.conn.routing.HttpRoute;
import javax.net.ssl.SSLSession;

public interface HttpRoutedConnection
    extends HttpInetConnection
{

    public abstract HttpRoute getRoute();

    public abstract SSLSession getSSLSession();

    public abstract boolean isSecure();
}
