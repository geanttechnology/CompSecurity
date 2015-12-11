// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.socket;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public interface ConnectionSocketFactory
{

    public abstract Socket connectSocket(int i, Socket socket, HttpHost httphost, InetSocketAddress inetsocketaddress, InetSocketAddress inetsocketaddress1, HttpContext httpcontext)
        throws IOException;

    public abstract Socket createSocket(HttpContext httpcontext)
        throws IOException;
}
