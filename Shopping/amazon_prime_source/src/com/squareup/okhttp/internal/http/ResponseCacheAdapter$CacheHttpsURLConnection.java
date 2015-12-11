// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Handshake;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            DelegatingHttpsURLConnection, ResponseCacheAdapter, Response

private static final class delegate extends DelegatingHttpsURLConnection
{

    private final etFixedLengthStreamingMode _flddelegate;

    public HostnameVerifier getHostnameVerifier()
    {
        throw ResponseCacheAdapter.access$400();
    }

    public SSLSocketFactory getSSLSocketFactory()
    {
        throw ResponseCacheAdapter.access$400();
    }

    protected Handshake handshake()
    {
        return ccess._mth300(_flddelegate).handshake();
    }

    public void setFixedLengthStreamingMode(long l)
    {
        _flddelegate.etFixedLengthStreamingMode(l);
    }

    public void setHostnameVerifier(HostnameVerifier hostnameverifier)
    {
        throw ResponseCacheAdapter.access$000();
    }

    public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        throw ResponseCacheAdapter.access$000();
    }

    public ( )
    {
        super();
        _flddelegate = ;
    }
}
