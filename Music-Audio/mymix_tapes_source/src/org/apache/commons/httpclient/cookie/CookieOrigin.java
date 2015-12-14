// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;


public final class CookieOrigin
{

    private final String host;
    private final String path;
    private final int port;
    private final boolean secure;

    public CookieOrigin(String s, int i, String s1, boolean flag)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Host of origin may not be null");
        }
        if (s.trim().equals(""))
        {
            throw new IllegalArgumentException("Host of origin may not be blank");
        }
        if (i < 0)
        {
            throw new IllegalArgumentException("Invalid port: " + i);
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("Path of origin may not be null.");
        } else
        {
            host = s;
            port = i;
            path = s1;
            secure = flag;
            return;
        }
    }

    public String getHost()
    {
        return host;
    }

    public String getPath()
    {
        return path;
    }

    public int getPort()
    {
        return port;
    }

    public boolean isSecure()
    {
        return secure;
    }
}
