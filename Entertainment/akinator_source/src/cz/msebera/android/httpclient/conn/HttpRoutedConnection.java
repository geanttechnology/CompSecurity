// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpInetConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import javax.net.ssl.SSLSession;

public interface HttpRoutedConnection
    extends HttpInetConnection
{

    public abstract HttpRoute getRoute();

    public abstract SSLSession getSSLSession();

    public abstract boolean isSecure();
}
