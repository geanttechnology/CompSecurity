// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.params;


// Referenced classes of package org.apache.http.params:
//            HttpParams

public final class HttpConnectionParams
{

    public static void setConnectionTimeout(HttpParams httpparams, int i)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            httpparams.setIntParameter("http.connection.timeout", i);
            return;
        }
    }

    public static void setSoTimeout(HttpParams httpparams, int i)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            httpparams.setIntParameter("http.socket.timeout", i);
            return;
        }
    }

    public static void setSocketBufferSize(HttpParams httpparams, int i)
    {
        if (httpparams == null)
        {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        } else
        {
            httpparams.setIntParameter("http.socket.buffer-size", i);
            return;
        }
    }
}
