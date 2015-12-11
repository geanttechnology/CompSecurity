// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.thirdparty.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class n
{

    private int a;
    private String b;
    private Map c;
    private byte d[];

    public n(HttpURLConnection httpurlconnection, byte abyte0[])
    {
        try
        {
            a = httpurlconnection.getResponseCode();
            b = httpurlconnection.getURL().toString();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        c = httpurlconnection.getHeaderFields();
        d = abyte0;
    }

    public int a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public Map c()
    {
        return c;
    }

    public byte[] d()
    {
        return d;
    }

    public String e()
    {
        if (d != null)
        {
            return new String(d);
        } else
        {
            return null;
        }
    }
}
