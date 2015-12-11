// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import android.net.Uri;
import com.g.b.t;
import com.g.c.j;
import com.g.c.r;
import java.net.HttpURLConnection;
import java.net.URL;

public final class u
    implements j
{

    private final t a;

    public u(t t1)
    {
        a = t1;
    }

    private static boolean a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        s = s.split(" ", 2);
        if ("CACHE".equals(s[0]))
        {
            return true;
        }
        if (s.length == 1) goto _L1; else goto _L3
_L3:
        if (!"CONDITIONAL_CACHE".equals(s[0])) goto _L1; else goto _L4
_L4:
        int i = Integer.parseInt(s[1]);
        if (i == 304)
        {
            return true;
        }
          goto _L1
        s;
        return false;
    }

    public final com.g.c.j.a a(Uri uri, int i)
    {
        HttpURLConnection httpurlconnection = a.a(new URL(uri.toString()));
        httpurlconnection.setConnectTimeout(40000);
        httpurlconnection.setReadTimeout(20000);
        httpurlconnection.setUseCaches(true);
        if (r.c(i))
        {
            httpurlconnection.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        int k = httpurlconnection.getResponseCode();
        if (k >= 300)
        {
            httpurlconnection.disconnect();
            throw new com.g.c.j.b(httpurlconnection.getResponseMessage(), i, k);
        }
        String s = httpurlconnection.getHeaderField("OkHttp-Response-Source");
        uri = s;
        if (s == null)
        {
            uri = httpurlconnection.getHeaderField("X-Android-Response-Source");
        }
        boolean flag = a(((String) (uri)));
        return new com.g.c.j.a(httpurlconnection.getInputStream(), flag);
    }
}
