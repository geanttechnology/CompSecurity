// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import com.g.b.d;
import com.g.b.o;
import com.g.b.v;
import com.g.b.x;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.g.b.a.a:
//            f, d, j

public final class c
{
    public static final class a
    {

        final long a;
        final v b;
        final x c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        private static boolean a(v v1)
        {
            return v1.a("If-Modified-Since") != null || v1.a("If-None-Match") != null;
        }

        public final c a()
        {
            if (c != null) goto _L2; else goto _L1
_L1:
            Object obj = new c(b, null, (byte)0);
_L16:
            c c1 = ((c) (obj));
            if (((c) (obj)).a != null)
            {
                c1 = ((c) (obj));
                if (b.d().k)
                {
                    c1 = new c(null, null, (byte)0);
                }
            }
            return c1;
_L2:
            if (!b.e() || c.e != null) goto _L4; else goto _L3
_L3:
            obj = new c(b, null, (byte)0);
              goto _L5
_L4:
            if (c.a(c, b)) goto _L7; else goto _L6
_L6:
            obj = new c(b, null, (byte)0);
              goto _L5
_L7:
            obj = b.d();
            if (!((d) (obj)).c && !a(b)) goto _L9; else goto _L8
_L8:
            obj = new c(b, null, (byte)0);
              goto _L5
_L9:
            long l1;
            d d1;
            long l2;
            long l4;
            long l5;
            long l6;
            if (d != null)
            {
                l1 = Math.max(0L, j - d.getTime());
            } else
            {
                l1 = 0L;
            }
            l2 = l1;
            if (l != -1)
            {
                l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(l));
            }
            l6 = l2 + (j - i) + (a - j);
            d1 = c.g();
            if (d1.e == -1) goto _L11; else goto _L10
_L10:
            l1 = TimeUnit.SECONDS.toMillis(d1.e);
_L13:
            l2 = l1;
            if (((d) (obj)).e != -1)
            {
                l2 = Math.min(l1, TimeUnit.SECONDS.toMillis(((d) (obj)).e));
            }
            l1 = 0L;
            if (((d) (obj)).j != -1)
            {
                l1 = TimeUnit.SECONDS.toMillis(((d) (obj)).j);
            }
            l5 = 0L;
            d1 = c.g();
            l4 = l5;
            if (!d1.h)
            {
                l4 = l5;
                if (((d) (obj)).i != -1)
                {
                    l4 = TimeUnit.SECONDS.toMillis(((d) (obj)).i);
                }
            }
            if (d1.c || l6 + l1 >= l4 + l2)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = c.d();
            if (l1 + l6 >= l2)
            {
                ((com.g.b.x.a) (obj)).b("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if (l6 > 0x5265c00L)
            {
                boolean flag;
                long l3;
                if (c.g().e == -1 && h == null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    ((com.g.b.x.a) (obj)).b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
            }
            obj = new c(null, ((com.g.b.x.a) (obj)).a(), (byte)0);
              goto _L5
_L11:
            if (h != null)
            {
                if (d != null)
                {
                    l1 = d.getTime();
                } else
                {
                    l1 = j;
                }
                l3 = h.getTime() - l1;
                l1 = l3;
                if (l3 <= 0L)
                {
                    l1 = 0L;
                }
            } else
            if (f != null && c.a.a().getQuery() == null)
            {
                if (d != null)
                {
                    l1 = d.getTime();
                } else
                {
                    l1 = i;
                }
                l1 -= f.getTime();
                if (l1 > 0L)
                {
                    l1 /= 10L;
                } else
                {
                    l1 = 0L;
                }
            } else
            {
                l1 = 0L;
            }
            if (true) goto _L13; else goto _L12
_L12:
            obj = b.c();
            if (k == null) goto _L15; else goto _L14
_L14:
            ((com.g.b.v.a) (obj)).a("If-None-Match", k);
_L17:
            obj = ((com.g.b.v.a) (obj)).a();
            if (a(((v) (obj))))
            {
                obj = new c(((v) (obj)), c, (byte)0);
            } else
            {
                obj = new c(((v) (obj)), null, (byte)0);
            }
_L5:
            if (true) goto _L16; else goto _L15
_L15:
            if (f != null)
            {
                ((com.g.b.v.a) (obj)).a("If-Modified-Since", g);
            } else
            if (d != null)
            {
                ((com.g.b.v.a) (obj)).a("If-Modified-Since", e);
            }
              goto _L17
        }

        public a(long l1, v v1, x x1)
        {
            l = -1;
            a = l1;
            b = v1;
            c = x1;
            if (x1 != null)
            {
                v1 = x1.f;
                int i1 = 0;
                int j1 = ((o) (v1)).a.length / 2;
                while (i1 < j1) 
                {
                    x1 = v1.a(i1);
                    String s = v1.b(i1);
                    if ("Date".equalsIgnoreCase(x1))
                    {
                        d = com.g.b.a.a.f.a(s);
                        e = s;
                    } else
                    if ("Expires".equalsIgnoreCase(x1))
                    {
                        h = com.g.b.a.a.f.a(s);
                    } else
                    if ("Last-Modified".equalsIgnoreCase(x1))
                    {
                        f = com.g.b.a.a.f.a(s);
                        g = s;
                    } else
                    if ("ETag".equalsIgnoreCase(x1))
                    {
                        k = s;
                    } else
                    if ("Age".equalsIgnoreCase(x1))
                    {
                        l = com.g.b.a.a.d.b(s, -1);
                    } else
                    if (j.b.equalsIgnoreCase(x1))
                    {
                        i = Long.parseLong(s);
                    } else
                    if (j.c.equalsIgnoreCase(x1))
                    {
                        j = Long.parseLong(s);
                    }
                    i1++;
                }
            }
        }
    }


    public final v a;
    public final x b;

    private c(v v1, x x1)
    {
        a = v1;
        b = x1;
    }

    c(v v1, x x1, byte byte0)
    {
        this(v1, x1);
    }

    public static boolean a(x x1, v v1)
    {
        x1.c;
        JVM INSTR lookupswitch 13: default 120
    //                   200: 162
    //                   203: 162
    //                   204: 162
    //                   300: 162
    //                   301: 162
    //                   302: 122
    //                   307: 122
    //                   308: 162
    //                   404: 162
    //                   405: 162
    //                   410: 162
    //                   414: 162
    //                   501: 162;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L3 _L3 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
        return false;
_L3:
        if (x1.a("Expires") == null && x1.g().e == -1 && !x1.g().g && !x1.g().f)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        if (!x1.g().d && !v1.d().d)
        {
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
