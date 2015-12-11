// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.m;
import com.a.a.u;
import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

// Referenced classes of package com.a.a.a.a:
//            aa, v, b, f, 
//            x

public final class z
{

    static final String a;
    static final String b;
    static final String c;
    static final String d;
    final URI e;
    final v f;
    Date g;
    Date h;
    Date i;
    long j;
    long k;
    boolean l;
    int m;
    boolean n;
    String o;
    int p;
    public Set q;
    String r;
    int s;
    String t;
    private boolean u;
    private int v;
    private boolean w;
    private String x;

    public z(URI uri, v v1)
    {
        m = -1;
        v = -1;
        p = -1;
        q = Collections.emptySet();
        s = -1;
        e = uri;
        f = v1;
        uri = new aa(this);
        int i1 = 0;
        while (i1 < v1.a()) 
        {
            Object obj = v1.a(i1);
            String s1 = v1.b(i1);
            if ("Cache-Control".equalsIgnoreCase(((String) (obj))))
            {
                com.a.a.a.a.b.a(s1, uri);
            } else
            if ("Date".equalsIgnoreCase(((String) (obj))))
            {
                g = com.a.a.a.a.f.a(s1);
            } else
            if ("Expires".equalsIgnoreCase(((String) (obj))))
            {
                i = com.a.a.a.a.f.a(s1);
            } else
            if ("Last-Modified".equalsIgnoreCase(((String) (obj))))
            {
                h = com.a.a.a.a.f.a(s1);
            } else
            if ("ETag".equalsIgnoreCase(((String) (obj))))
            {
                o = s1;
            } else
            if ("Pragma".equalsIgnoreCase(((String) (obj))))
            {
                if ("no-cache".equalsIgnoreCase(s1))
                {
                    l = true;
                }
            } else
            if ("Age".equalsIgnoreCase(((String) (obj))))
            {
                p = com.a.a.a.a.b.a(s1);
            } else
            if ("Vary".equalsIgnoreCase(((String) (obj))))
            {
                if (q.isEmpty())
                {
                    q = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                obj = s1.split(",");
                int k1 = obj.length;
                int j1 = 0;
                while (j1 < k1) 
                {
                    s1 = obj[j1];
                    q.add(s1.trim());
                    j1++;
                }
            } else
            if ("Content-Encoding".equalsIgnoreCase(((String) (obj))))
            {
                r = s1;
            } else
            if ("Transfer-Encoding".equalsIgnoreCase(((String) (obj))))
            {
                x = s1;
            } else
            if ("Content-Length".equalsIgnoreCase(((String) (obj))))
            {
                try
                {
                    s = Integer.parseInt(s1);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj) { }
            } else
            if ("Connection".equalsIgnoreCase(((String) (obj))))
            {
                t = s1;
            } else
            if (a.equalsIgnoreCase(((String) (obj))))
            {
                j = Long.parseLong(s1);
            } else
            if (b.equalsIgnoreCase(((String) (obj))))
            {
                k = Long.parseLong(s1);
            }
            i1++;
        }
    }

    static int a(z z1, int i1)
    {
        z1.m = i1;
        return i1;
    }

    static int b(z z1, int i1)
    {
        z1.v = i1;
        return i1;
    }

    static boolean b(z z1)
    {
        z1.l = true;
        return true;
    }

    private static boolean b(String s1)
    {
        return !"Connection".equalsIgnoreCase(s1) && !"Keep-Alive".equalsIgnoreCase(s1) && !"Proxy-Authenticate".equalsIgnoreCase(s1) && !"Proxy-Authorization".equalsIgnoreCase(s1) && !"TE".equalsIgnoreCase(s1) && !"Trailers".equalsIgnoreCase(s1) && !"Transfer-Encoding".equalsIgnoreCase(s1) && !"Upgrade".equalsIgnoreCase(s1);
    }

    static boolean c(z z1)
    {
        z1.u = true;
        return true;
    }

    static boolean d(z z1)
    {
        z1.w = true;
        return true;
    }

    static boolean e(z z1)
    {
        z1.n = true;
        return true;
    }

    public final z a(z z1)
    {
        boolean flag = false;
        v v1 = new v();
        v1.b(f.b);
        int i1 = 0;
        int j1;
        do
        {
            j1 = ((flag) ? 1 : 0);
            if (i1 >= f.a())
            {
                break;
            }
            String s1 = f.a(i1);
            String s3 = f.b(i1);
            if ((!"Warning".equals(s1) || !s3.startsWith("1")) && (!b(s1) || z1.f.e(s1) == null))
            {
                v1.a(s1, s3);
            }
            i1++;
        } while (true);
        for (; j1 < z1.f.a(); j1++)
        {
            String s2 = z1.f.a(j1);
            if (b(s2))
            {
                v1.a(s2, z1.f.b(j1));
            }
        }

        return new z(e, v1);
    }

    public final void a(u u1)
    {
        f.b(c, (new StringBuilder()).append(u1.toString()).append(" ").append(f.d).toString());
    }

    public final void a(String s1)
    {
        f.b(d, s1);
    }

    public final boolean a()
    {
        return "chunked".equalsIgnoreCase(x);
    }

    public final boolean a(x x1)
    {
        for (int i1 = f.d; i1 != 200 && i1 != 203 && i1 != 300 && i1 != 301 && i1 != 410 || x1.g && !w && !n && v == -1 || u;)
        {
            return false;
        }

        return true;
    }

    static 
    {
        StringBuilder stringbuilder = new StringBuilder();
        com.a.a.a.m.a();
        a = stringbuilder.append(com.a.a.a.m.b()).append("-Sent-Millis").toString();
        stringbuilder = new StringBuilder();
        com.a.a.a.m.a();
        b = stringbuilder.append(com.a.a.a.m.b()).append("-Received-Millis").toString();
        stringbuilder = new StringBuilder();
        com.a.a.a.m.a();
        c = stringbuilder.append(com.a.a.a.m.b()).append("-Response-Source").toString();
        stringbuilder = new StringBuilder();
        com.a.a.a.m.a();
        d = stringbuilder.append(com.a.a.a.m.b()).append("-Selected-Transport").toString();
    }
}
