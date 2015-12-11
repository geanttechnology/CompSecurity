// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class bm
{

    private long a;
    private long b;
    private long c;
    private long d;
    private final URL e;
    private boolean f;
    private boolean g;
    private boolean h;
    private bk i;

    private bm(bk bk1, URL url)
    {
        i = bk1;
        super();
        a = System.currentTimeMillis();
        d = 0L;
        b = -1L;
        c = -1L;
        e = url;
        f = false;
        g = false;
    }

    bm(bk bk1, URL url, byte byte0)
    {
        this(bk1, url);
    }

    static long a(bm bm1, long l)
    {
        bm1.c = l;
        return l;
    }

    static void a(bm bm1, URLConnection urlconnection)
    {
        if (bm1.c <= 0L || !bm1.f || bm1.g) goto _L2; else goto _L1
_L1:
        if (bm1.b < 0L)
        {
            bm1.b = 0L;
        }
        int j = ((HttpURLConnection)urlconnection).getResponseCode();
        if (j < 400) goto _L4; else goto _L3
_L3:
        Object obj = urlconnection.getHeaderField(null);
_L8:
        v v1;
        v1 = new v();
        urlconnection = urlconnection.getHeaderFields();
        if (urlconnection == null) goto _L6; else goto _L5
_L5:
        String s;
        for (Iterator iterator = urlconnection.keySet().iterator(); iterator.hasNext(); v1.a(s, (List)urlconnection.get(s)))
        {
            s = (String)iterator.next();
        }

          goto _L6
_L7:
        bm1.g = true;
_L2:
        return;
_L6:
        urlconnection = bk.a(bm1.i).a(bm1.e, bm1.a, bm1.c, j, ((String) (obj)), v1.a());
        if (urlconnection != null)
        {
            try
            {
                bk.b(bm1.i).b(urlconnection);
            }
            // Misplaced declaration of an exception variable
            catch (URLConnection urlconnection)
            {
                obj = bk.a(bm1.i).a(bm1.e, bm1.a, bm1.c, 0, null, null);
                if (obj != null)
                {
                    bk.b(bm1.i).b(((org.json.JSONObject) (obj)));
                }
                p.a("Unexpected error fetching HTTP response code", urlconnection);
            }
        }
        if (true) goto _L7; else goto _L4
_L4:
        obj = null;
          goto _L8
    }

    static boolean a(bm bm1)
    {
        return bm1.f;
    }

    static boolean a(bm bm1, boolean flag)
    {
        bm1.f = true;
        return true;
    }

    static long b(bm bm1, long l)
    {
        l = bm1.d + l;
        bm1.d = l;
        return l;
    }

    static boolean b(bm bm1)
    {
        return bm1.h;
    }

    static boolean b(bm bm1, boolean flag)
    {
        bm1.h = true;
        return true;
    }

    static long c(bm bm1)
    {
        return bm1.c;
    }

    static long c(bm bm1, long l)
    {
        bm1.b = l;
        return l;
    }

    static long d(bm bm1)
    {
        return bm1.a;
    }

    static long e(bm bm1)
    {
        return bm1.b;
    }

    static boolean f(bm bm1)
    {
        return bm1.g;
    }
}
