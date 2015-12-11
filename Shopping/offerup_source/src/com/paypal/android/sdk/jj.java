// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Date;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            gu, gg, js, dd, 
//            jz, gq, ji, fo, 
//            gv, gi, gr

public final class jj
{

    private long a;
    private gq b;
    private gu c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l;

    public jj(long l1, gq gq1, gu gu1)
    {
        l = -1;
        a = l1;
        b = gq1;
        c = gu1;
        if (gu1 != null)
        {
            gq1 = gu1.g();
            int i1 = 0;
            int j1 = gq1.a();
            while (i1 < j1) 
            {
                gu1 = gq1.a(i1);
                String s = gq1.b(i1);
                if ("Date".equalsIgnoreCase(gu1))
                {
                    d = js.a(s);
                    e = s;
                } else
                if ("Expires".equalsIgnoreCase(gu1))
                {
                    h = js.a(s);
                } else
                if ("Last-Modified".equalsIgnoreCase(gu1))
                {
                    f = js.a(s);
                    g = s;
                } else
                if ("ETag".equalsIgnoreCase(gu1))
                {
                    k = s;
                } else
                if ("Age".equalsIgnoreCase(gu1))
                {
                    l = dd.b(s, -1);
                } else
                if (jz.a.equalsIgnoreCase(gu1))
                {
                    i = Long.parseLong(s);
                } else
                if (jz.b.equalsIgnoreCase(gu1))
                {
                    j = Long.parseLong(s);
                }
                i1++;
            }
        }
    }

    private static boolean a(gq gq1)
    {
        return gq1.a("If-Modified-Since") != null || gq1.a("If-None-Match") != null;
    }

    public final ji a()
    {
        if (c != null) goto _L2; else goto _L1
_L1:
        Object obj = new ji(b, null, (byte)0);
_L16:
        ji ji1 = ((ji) (obj));
        if (((ji) (obj)).a != null)
        {
            ji1 = ((ji) (obj));
            if (b.i().i())
            {
                ji1 = new ji(null, null, (byte)0);
            }
        }
        return ji1;
_L2:
        if (!b.j() || c.f() != null) goto _L4; else goto _L3
_L3:
        obj = new ji(b, null, (byte)0);
          goto _L5
_L4:
        if (ji.a(c, b)) goto _L7; else goto _L6
_L6:
        obj = new ji(b, null, (byte)0);
          goto _L5
_L7:
        obj = b.i();
        if (!((fo) (obj)).a() && !a(b)) goto _L9; else goto _L8
_L8:
        obj = new ji(b, null, (byte)0);
          goto _L5
_L9:
        long l1;
        fo fo1;
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
        fo1 = c.k();
        if (fo1.c() == -1) goto _L11; else goto _L10
_L10:
        l1 = TimeUnit.SECONDS.toMillis(fo1.c());
_L13:
        l2 = l1;
        if (((fo) (obj)).c() != -1)
        {
            l2 = Math.min(l1, TimeUnit.SECONDS.toMillis(((fo) (obj)).c()));
        }
        l1 = 0L;
        if (((fo) (obj)).h() != -1)
        {
            l1 = TimeUnit.SECONDS.toMillis(((fo) (obj)).h());
        }
        l5 = 0L;
        fo1 = c.k();
        l4 = l5;
        if (!fo1.f())
        {
            l4 = l5;
            if (((fo) (obj)).g() != -1)
            {
                l4 = TimeUnit.SECONDS.toMillis(((fo) (obj)).g());
            }
        }
        if (fo1.a() || l6 + l1 >= l4 + l2)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = c.i();
        if (l1 + l6 >= l2)
        {
            ((gv) (obj)).b("Warning", "110 HttpURLConnection \"Response is stale\"");
        }
        if (l6 > 0x5265c00L)
        {
            boolean flag;
            long l3;
            if (c.k().c() == -1 && h == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                ((gv) (obj)).b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
        }
        obj = new ji(null, ((gv) (obj)).a(), (byte)0);
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
        if (f != null && c.a().a().l() == null)
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
        obj = b.h();
        if (k == null) goto _L15; else goto _L14
_L14:
        ((gr) (obj)).a("If-None-Match", k);
_L17:
        obj = ((gr) (obj)).a();
        if (a(((gq) (obj))))
        {
            obj = new ji(((gq) (obj)), c, (byte)0);
        } else
        {
            obj = new ji(((gq) (obj)), null, (byte)0);
        }
_L5:
        if (true) goto _L16; else goto _L15
_L15:
        if (f != null)
        {
            ((gr) (obj)).a("If-Modified-Since", g);
        } else
        if (d != null)
        {
            ((gr) (obj)).a("If-Modified-Since", e);
        }
          goto _L17
    }
}
