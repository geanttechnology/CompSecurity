// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn.scheme;

import com.comcast.cim.httpcomponentsandroid.conn.ConnectTimeoutException;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public interface SchemeSocketFactory
{

    public abstract Socket connectSocket(Socket socket, InetSocketAddress inetsocketaddress, InetSocketAddress inetsocketaddress1, HttpParams httpparams)
        throws IOException, UnknownHostException, ConnectTimeoutException;

    public abstract Socket createSocket(HttpParams httpparams)
        throws IOException;

    public abstract boolean isSecure(Socket socket)
        throws IllegalArgumentException;
}
