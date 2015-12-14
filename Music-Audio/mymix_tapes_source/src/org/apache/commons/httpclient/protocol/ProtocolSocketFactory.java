// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;

public interface ProtocolSocketFactory
{

    public abstract Socket createSocket(String s, int i)
        throws IOException, UnknownHostException;

    public abstract Socket createSocket(String s, int i, InetAddress inetaddress, int j)
        throws IOException, UnknownHostException;

    public abstract Socket createSocket(String s, int i, InetAddress inetaddress, int j, HttpConnectionParams httpconnectionparams)
        throws IOException, UnknownHostException, ConnectTimeoutException;
}
