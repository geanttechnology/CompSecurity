// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d.b;

import com.google.api.a.d.v;
import com.google.api.a.d.y;
import com.google.api.a.g.w;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.google.api.a.d.b:
//            b, a, c

public final class e extends v
{

    private static final String b[];
    private final a c;
    private final SSLSocketFactory d;
    private final HostnameVerifier e;

    public e()
    {
        this((byte)0);
    }

    private e(byte byte0)
    {
        c = new b();
        d = null;
        e = null;
    }

    protected final y a(String s, String s1)
    {
        w.a(a(s), "HTTP method %s not supported", new Object[] {
            s
        });
        s1 = new URL(s1);
        s1 = c.a(s1);
        s1.setRequestMethod(s);
        if (s1 instanceof HttpsURLConnection)
        {
            s = (HttpsURLConnection)s1;
            if (e != null)
            {
                s.setHostnameVerifier(e);
            }
            if (d != null)
            {
                s.setSSLSocketFactory(d);
            }
        }
        return new c(s1);
    }

    public final boolean a(String s)
    {
        return Arrays.binarySearch(b, s) >= 0;
    }

    static 
    {
        String as[] = new String[7];
        as[0] = "DELETE";
        as[1] = "GET";
        as[2] = "HEAD";
        as[3] = "OPTIONS";
        as[4] = "POST";
        as[5] = "PUT";
        as[6] = "TRACE";
        b = as;
        Arrays.sort(as);
    }
}
