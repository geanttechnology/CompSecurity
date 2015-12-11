// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid;

import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import com.comcast.cim.httpcomponentsandroid.util.LangUtils;
import java.io.Serializable;
import java.util.Locale;

public final class HttpHost
    implements Serializable, Cloneable
{

    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;

    public HttpHost(String s, int i)
    {
        this(s, i, null);
    }

    public HttpHost(String s, int i, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Host name may not be null");
        }
        hostname = s;
        lcHostname = s.toLowerCase(Locale.ENGLISH);
        if (s1 != null)
        {
            schemeName = s1.toLowerCase(Locale.ENGLISH);
        } else
        {
            schemeName = "http";
        }
        port = i;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof HttpHost)
            {
                if (!lcHostname.equals(((HttpHost) (obj = (HttpHost)obj)).lcHostname) || port != ((HttpHost) (obj)).port || !schemeName.equals(((HttpHost) (obj)).schemeName))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public String getHostName()
    {
        return hostname;
    }

    public int getPort()
    {
        return port;
    }

    public String getSchemeName()
    {
        return schemeName;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, lcHostname), port), schemeName);
    }

    public String toHostString()
    {
        if (port != -1)
        {
            CharArrayBuffer chararraybuffer = new CharArrayBuffer(hostname.length() + 6);
            chararraybuffer.append(hostname);
            chararraybuffer.append(":");
            chararraybuffer.append(Integer.toString(port));
            return chararraybuffer.toString();
        } else
        {
            return hostname;
        }
    }

    public String toString()
    {
        return toURI();
    }

    public String toURI()
    {
        CharArrayBuffer chararraybuffer = new CharArrayBuffer(32);
        chararraybuffer.append(schemeName);
        chararraybuffer.append("://");
        chararraybuffer.append(hostname);
        if (port != -1)
        {
            chararraybuffer.append(':');
            chararraybuffer.append(Integer.toString(port));
        }
        return chararraybuffer.toString();
    }
}
