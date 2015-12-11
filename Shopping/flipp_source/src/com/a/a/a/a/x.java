// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import java.net.URI;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.a.a.a.a:
//            y, v, b, f

public final class x
{

    public final v a;
    boolean b;
    int c;
    int d;
    int e;
    boolean f;
    boolean g;
    long h;
    String i;
    String j;
    String k;
    String l;
    String m;
    String n;
    String o;
    String p;
    private final URI q;
    private String r;

    public x(URI uri, v v1)
    {
        c = -1;
        d = -1;
        e = -1;
        h = -1L;
        q = uri;
        a = v1;
        uri = new y(this);
        int i1 = 0;
        while (i1 < v1.a()) 
        {
            Object obj = v1.a(i1);
            String s = v1.b(i1);
            if ("Cache-Control".equalsIgnoreCase(((String) (obj))))
            {
                com.a.a.a.a.b.a(s, uri);
            } else
            if ("Pragma".equalsIgnoreCase(((String) (obj))))
            {
                if ("no-cache".equalsIgnoreCase(s))
                {
                    b = true;
                }
            } else
            if ("If-None-Match".equalsIgnoreCase(((String) (obj))))
            {
                o = s;
            } else
            if ("If-Modified-Since".equalsIgnoreCase(((String) (obj))))
            {
                r = s;
            } else
            if ("Authorization".equalsIgnoreCase(((String) (obj))))
            {
                g = true;
            } else
            if ("Content-Length".equalsIgnoreCase(((String) (obj))))
            {
                try
                {
                    h = Integer.parseInt(s);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
            } else
            if ("Transfer-Encoding".equalsIgnoreCase(((String) (obj))))
            {
                i = s;
            } else
            if ("User-Agent".equalsIgnoreCase(((String) (obj))))
            {
                j = s;
            } else
            if ("Host".equalsIgnoreCase(((String) (obj))))
            {
                k = s;
            } else
            if ("Connection".equalsIgnoreCase(((String) (obj))))
            {
                l = s;
            } else
            if ("Accept-Encoding".equalsIgnoreCase(((String) (obj))))
            {
                m = s;
            } else
            if ("Content-Type".equalsIgnoreCase(((String) (obj))))
            {
                n = s;
            } else
            if ("Proxy-Authorization".equalsIgnoreCase(((String) (obj))))
            {
                p = s;
            }
            i1++;
        }
    }

    public final void a(long l1)
    {
        if (h != -1L)
        {
            a.d("Content-Length");
        }
        a.a("Content-Length", Long.toString(l1));
        h = l1;
    }

    public final void a(Date date)
    {
        if (r != null)
        {
            a.d("If-Modified-Since");
        }
        date = com.a.a.a.a.f.a(date);
        a.a("If-Modified-Since", date);
        r = date;
    }

    public final void a(Map map)
    {
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)map.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            if ("Cookie".equalsIgnoreCase(s) || "Cookie2".equalsIgnoreCase(s))
            {
                v v1 = a;
                obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    v1.a(s, (String)((Iterator) (obj)).next());
                }
            }
        } while (true);
    }

    public final boolean a()
    {
        return r != null || o != null;
    }
}
