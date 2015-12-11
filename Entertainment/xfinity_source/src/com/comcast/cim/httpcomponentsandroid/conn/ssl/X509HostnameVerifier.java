// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn.ssl;

import java.io.IOException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;

public interface X509HostnameVerifier
    extends HostnameVerifier
{

    public abstract void verify(String s, SSLSocket sslsocket)
        throws IOException;

    public abstract void verify(String s, String as[], String as1[])
        throws SSLException;
}
