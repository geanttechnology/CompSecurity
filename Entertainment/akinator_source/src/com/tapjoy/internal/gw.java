// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.graphics.Point;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            gu, bu, gz, bq, 
//            gr, gv, gx, bp, 
//            fr

public final class gw extends gu
{

    public static final bp n = new bp() {

        public final Object a(bu bu1)
        {
            return new gw(bu1);
        }

    };
    public gz a;
    public gz b;
    public gz c;
    public Point d;
    public gz e;
    public gz f;
    public String g;
    public fr h;
    public ArrayList i;
    public ArrayList j;
    public Map k;
    public long l;
    public gx m;

    public gw()
    {
        i = new ArrayList();
        j = new ArrayList();
    }

    gw(bu bu1)
    {
        i = new ArrayList();
        j = new ArrayList();
        bu1.i();
        while (bu1.k()) 
        {
            String s = bu1.m();
            if ("frame".equals(s))
            {
                bu1.i();
                while (bu1.k()) 
                {
                    s = bu1.m();
                    if ("portrait".equals(s))
                    {
                        a = (gz)bu1.a(gz.b);
                    } else
                    if ("landscape".equals(s))
                    {
                        b = (gz)bu1.a(gz.b);
                    } else
                    if ("close_button".equals(s))
                    {
                        c = (gz)bu1.a(gz.b);
                    } else
                    if ("close_button_offset".equals(s))
                    {
                        d = (Point)bu1.a(bq.a);
                    } else
                    {
                        bu1.t();
                    }
                }
                bu1.j();
            } else
            if ("creative".equals(s))
            {
                bu1.i();
                while (bu1.k()) 
                {
                    s = bu1.m();
                    if ("portrait".equals(s))
                    {
                        e = (gz)bu1.a(gz.b);
                    } else
                    if ("landscape".equals(s))
                    {
                        f = (gz)bu1.a(gz.b);
                    } else
                    {
                        bu1.t();
                    }
                }
                bu1.j();
            } else
            if ("url".equals(s))
            {
                g = bu1.c();
            } else
            if (gr.a(s))
            {
                h = gr.a(s, bu1);
            } else
            if ("mappings".equals(s))
            {
                bu1.i();
                while (bu1.k()) 
                {
                    s = bu1.m();
                    if ("portrait".equals(s))
                    {
                        bu1.a(i, gv.g);
                    } else
                    if ("landscape".equals(s))
                    {
                        bu1.a(j, gv.g);
                    } else
                    {
                        bu1.t();
                    }
                }
                bu1.j();
            } else
            if ("meta".equals(s))
            {
                k = bu1.e();
            } else
            if ("ttl".equals(s))
            {
                double d1 = bu1.q();
                long l1 = SystemClock.elapsedRealtime();
                l = (long)(d1 * 1000D) + l1;
            } else
            if ("no_more_today".equals(s))
            {
                m = (gx)bu1.a(gx.b);
            } else
            {
                bu1.t();
            }
        }
        bu1.j();
        if (g == null)
        {
            g = "";
        }
    }

    public final boolean a()
    {
        return c != null && a != null && e != null;
    }

    public final boolean b()
    {
        return c != null && b != null && f != null;
    }

    public final void c()
    {
        if (a != null)
        {
            a.b();
        }
        if (b != null)
        {
            b.b();
        }
        c.b();
        if (e != null)
        {
            e.b();
        }
        if (f != null)
        {
            f.b();
        }
        if (m != null && m.a != null)
        {
            m.a.b();
        }
    }

    public final boolean d()
    {
        return c != null && c.a() != null && (m == null || m.a == null || m.a.a() != null) && (b != null && f != null && b.a() != null && f.a() != null || a != null && e != null && a.a() != null && e.a() != null);
    }

}
