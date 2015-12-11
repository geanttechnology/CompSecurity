// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn;

import com.comcast.cim.httpcomponentsandroid.HttpClientConnection;
import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpInetConnection;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.io.IOException;
import java.net.Socket;

public interface OperatedClientConnection
    extends HttpClientConnection, HttpInetConnection
{

    public abstract Socket getSocket();

    public abstract HttpHost getTargetHost();

    public abstract boolean isSecure();

    public abstract void openCompleted(boolean flag, HttpParams httpparams)
        throws IOException;

    public abstract void opening(Socket socket, HttpHost httphost)
        throws IOException;

    public abstract void update(Socket socket, HttpHost httphost, boolean flag, HttpParams httpparams)
        throws IOException;
}
