// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            b, cm, ba, bc, 
//            co, bg, bh, bb, 
//            af, dy, dq, ad, 
//            h, cl, cn

class y
{
    static final class a
    {

        af a;
        ao.a b;

        a()
        {
        }
    }

    static final class b
    {

        final JSONObject a = new JSONObject();
        com.amazon.device.ads.b b[];
        Map c;
        b.o d;
        private final cn e;

        private void a(String s, Object obj)
        {
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_14;
            }
            a.put(s, obj);
            return;
            JSONException jsonexception;
            jsonexception;
            e.b("Could not add parameter to JSON %s: %s", new Object[] {
                s, obj
            });
            return;
        }

        final void a()
        {
            com.amazon.device.ads.b ab[] = b;
            int j1 = ab.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                com.amazon.device.ads.b b1 = ab[i1];
                a(b1, b1.a(d));
            }

            if (c != null)
            {
                Iterator iterator = c.entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if (!dq.b((String)entry.getValue()))
                    {
                        a((String)entry.getKey(), entry.getValue());
                    }
                } while (true);
            }
        }

        final void a(com.amazon.device.ads.b b1, Object obj)
        {
            a(b1.b, obj);
        }

        b(cn cn1)
        {
            e = cn1;
        }
    }

    static final class c
    {

        static final com.amazon.device.ads.b a[];
        final af b;
        final b c;
        final ad d;

        static 
        {
            a = (new com.amazon.device.ads.b[] {
                com.amazon.device.ads.b.t, com.amazon.device.ads.b.u, com.amazon.device.ads.b.v, com.amazon.device.ads.b.w, com.amazon.device.ads.b.x, com.amazon.device.ads.b.y, com.amazon.device.ads.b.z, com.amazon.device.ads.b.A, com.amazon.device.ads.b.B
            });
        }

        c(ad ad1, y y1, cn cn)
        {
            b = ad1.c;
            d = ad1;
            ad1 = b.a();
            b.o o = new b.o();
            o.d = b;
            o.b = ad1;
            o.c = this;
            o.a = y1;
            y1 = new b(cn);
            y1.b = a;
            y1.c = ad1;
            y1.d = o;
            c = y1;
        }
    }


    private static final String f = com/amazon/device/ads/y.getSimpleName();
    private static final com.amazon.device.ads.b g[];
    final af a;
    final String b;
    String c;
    ao.a d;
    protected final Map e;
    private final b h;
    private final bb i;
    private final dy.d j;
    private final ba k;
    private final bc l;
    private final cn m;

    public y(af af1)
    {
        dy.d d1 = new dy.d();
        cm cm1 = cm.a();
        ba ba1 = ba.a();
        bc bc1 = bc.a();
        new co();
        this(af1, d1, cm1, ba1, bc1);
    }

    private y(af af1, dy.d d1, cm cm1, ba ba1, bc bc1)
    {
        a = af1;
        j = d1;
        e = new HashMap();
        bh.a(cm1.b.k.b());
        JVM INSTR lookupswitch 4: default 80
    //                   0: 197
    //                   1: 191
    //                   8: 197
    //                   9: 191;
           goto _L1 _L2 _L3 _L2 _L3
_L1:
        af1 = "unknown";
_L5:
        b = af1;
        i = new bb(cm1);
        k = ba1;
        l = bc1;
        m = co.a(f);
        af1 = a.a();
        d1 = new b.o();
        d1.d = a;
        d1.b = af1;
        d1.a = this;
        cm1 = new b(m);
        cm1.b = g;
        cm1.c = af1;
        cm1.d = d1;
        h = cm1;
        return;
_L3:
        af1 = "portrait";
        continue; /* Loop/switch isn't completed */
_L2:
        af1 = "landscape";
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final dy a()
    {
        boolean flag2 = true;
        dy dy1 = j.a();
        boolean flag1 = ba.a().b(ba.a.f);
        Object obj;
        Object obj1;
        boolean flag;
        if (!ba.a().b(ba.a.g) && flag1 && a.e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag2;
        if (!flag)
        {
            if (dy1.f())
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
        }
        dy1.a(flag1);
        dy1.e(f);
        dy1.a(dy.a.b);
        dy1.b(k.a(ba.a.a));
        dy1.e = "/e/msdk/ads";
        dy1.e();
        dy1.c = "application/json";
        dy1.i = false;
        h.a();
        obj1 = com.amazon.device.ads.b.q.a(h.d);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new JSONArray();
            c c1;
            for (obj1 = e.values().iterator(); ((Iterator) (obj1)).hasNext(); ((JSONArray) (obj)).put(c1.c.a))
            {
                c1 = (c)((Iterator) (obj1)).next();
                c1.c.a();
            }

        }
        h.a(com.amazon.device.ads.b.q, obj);
        obj = h.a;
        obj1 = l.a("debug.aaxAdParams", null);
        if (!dq.a(((String) (obj1))))
        {
            dy1.d(((String) (obj1)));
        }
        dy1.a = ((JSONObject) (obj)).toString();
        return dy1;
    }

    public final void a(ad ad1)
    {
        if (d.e())
        {
            ad1.b.f.a(ck.a.w);
        }
        Object obj = i;
        ad1.b.A = ((bb) (obj));
        obj = new c(ad1, this, m);
        e.put(Integer.valueOf(ad1.a), obj);
    }

    static 
    {
        g = (new com.amazon.device.ads.b[] {
            com.amazon.device.ads.b.d, com.amazon.device.ads.b.e, com.amazon.device.ads.b.f, com.amazon.device.ads.b.g, com.amazon.device.ads.b.h, com.amazon.device.ads.b.i, com.amazon.device.ads.b.j, com.amazon.device.ads.b.k, com.amazon.device.ads.b.l, com.amazon.device.ads.b.m, 
            com.amazon.device.ads.b.n, com.amazon.device.ads.b.o, com.amazon.device.ads.b.p, com.amazon.device.ads.b.r, com.amazon.device.ads.b.s
        });
    }
}
