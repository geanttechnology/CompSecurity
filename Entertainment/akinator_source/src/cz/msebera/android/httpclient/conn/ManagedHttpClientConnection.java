// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpInetConnection;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSession;

public interface ManagedHttpClientConnection
    extends HttpClientConnection, HttpInetConnection
{

    public abstract void bind(Socket socket)
        throws IOException;

    public abstract String getId();

    public abstract SSLSession getSSLSession();

    public abstract Socket getSocket();
}
