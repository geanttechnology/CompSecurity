// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn.scheme;

import com.comcast.cim.httpcomponentsandroid.conn.ConnectTimeoutException;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public interface SocketFactory
{

    public abstract Socket connectSocket(Socket socket, String s, int i, InetAddress inetaddress, int j, HttpParams httpparams)
        throws IOException, UnknownHostException, ConnectTimeoutException;

    public abstract Socket createSocket()
        throws IOException;

    public abstract boolean isSecure(Socket socket)
        throws IllegalArgumentException;
}
