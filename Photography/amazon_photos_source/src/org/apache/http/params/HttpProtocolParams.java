// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.params;

import org.apache.http.ProtocolVersion;

// Referenced classes of package org.apache.http.params:
//            HttpParams

public final class HttpProtocolParams
{

    public static void setContentCharset(HttpParams httpparams, String s)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            httpparams.setParameter("http.protocol.content-charset", s);
            return;
        }
    }

    public static void setUserAgent(HttpParams httpparams, String s)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            httpparams.setParameter("http.useragent", s);
            return;
        }
    }

    public static void setVersion(HttpParams httpparams, ProtocolVersion protocolversion)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            httpparams.setParameter("http.protocol.version", protocolversion);
            return;
        }
    }
}
