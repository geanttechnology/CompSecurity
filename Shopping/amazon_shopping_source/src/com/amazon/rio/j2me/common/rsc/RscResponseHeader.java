// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.common.rsc;


public class RscResponseHeader
{

    private final byte cookieJar[];
    private final String exception;
    private final byte secureCookieJar[];
    private final byte status;

    public RscResponseHeader(String s)
    {
        status = 1;
        exception = s;
        cookieJar = null;
        secureCookieJar = null;
    }

    public RscResponseHeader(byte abyte0[], byte abyte1[])
    {
        status = 0;
        cookieJar = abyte0;
        secureCookieJar = abyte1;
        exception = null;
    }

    public byte[] getCookieJar()
    {
        return cookieJar;
    }

    public String getException()
    {
        return exception;
    }

    public byte[] getSecureCookieJar()
    {
        return secureCookieJar;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append('[');
        stringbuffer.append("rscVersion=").append(0);
        stringbuffer.append(", status=").append(status);
        stringbuffer.append(", exception=").append(exception);
        if (cookieJar == null)
        {
            stringbuffer.append(", cookieJar=null");
        } else
        {
            stringbuffer.append(", cookieJar.length=").append(cookieJar.length);
        }
        if (secureCookieJar == null)
        {
            stringbuffer.append(", secureCookieJar=null");
        } else
        {
            stringbuffer.append(", secureCookieJar.length=").append(secureCookieJar.length);
        }
        stringbuffer.append(']');
        return stringbuffer.toString();
    }
}
