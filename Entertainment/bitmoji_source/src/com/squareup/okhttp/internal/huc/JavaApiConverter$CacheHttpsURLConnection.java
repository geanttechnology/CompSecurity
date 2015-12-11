// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Response;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.squareup.okhttp.internal.huc:
//            DelegatingHttpsURLConnection, JavaApiConverter

private static final class delegate extends DelegatingHttpsURLConnection
{

    private final etFixedLengthStreamingMode _flddelegate;

    public long getContentLengthLong()
    {
        return _flddelegate.etContentLengthLong();
    }

    public long getHeaderFieldLong(String s, long l)
    {
        return _flddelegate.etHeaderFieldLong(s, l);
    }

    public HostnameVerifier getHostnameVerifier()
    {
        throw JavaApiConverter.access$400();
    }

    public SSLSocketFactory getSSLSocketFactory()
    {
        throw JavaApiConverter.access$400();
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
        throw JavaApiConverter.access$000();
    }

    public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        throw JavaApiConverter.access$000();
    }

    public ( )
    {
        super();
        _flddelegate = ;
    }
}
