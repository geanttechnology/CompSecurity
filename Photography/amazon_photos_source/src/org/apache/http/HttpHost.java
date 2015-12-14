// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http;

import java.io.Serializable;
import java.util.Locale;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public final class HttpHost
    implements Serializable, Cloneable
{

    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;

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
        boolean flag = true;
        if (obj != null)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj instanceof HttpHost)
            {
                obj = (HttpHost)obj;
                if (!lcHostname.equals(((HttpHost) (obj)).lcHostname) || port != ((HttpHost) (obj)).port || !schemeName.equals(((HttpHost) (obj)).schemeName))
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
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
