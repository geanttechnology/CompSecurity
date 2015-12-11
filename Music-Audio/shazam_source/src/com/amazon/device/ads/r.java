// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.device.ads:
//            ao, ds, cm, dn, 
//            ba, co, dr, ad, 
//            k, cn, af, y, 
//            h, ae, s, cl, 
//            dp, di

public class r
{

    private static final String a = com/amazon/device/ads/r.getSimpleName();
    private final cn b;
    private final s.b c;
    private final ao d;
    private final cm e;
    private final dn f;
    private final ba g;
    private final ds.k h;
    private final dr i;
    private final y.a j;

    public r()
    {
        s.b b1 = new s.b();
        ao ao1 = new ao();
        ds.k k1 = ds.a();
        cm cm1 = cm.a();
        dn dn1 = dn.a();
        ba ba1 = ba.a();
        new co();
        this(b1, ao1, k1, cm1, dn1, ba1, new dr(), new y.a());
    }

    private r(s.b b1, ao ao1, ds.k k1, cm cm1, dn dn1, ba ba1, dr dr1, 
            y.a a1)
    {
        c = b1;
        b = co.a(a);
        d = ao1;
        e = cm1;
        f = dn1;
        g = ba1;
        h = k1;
        i = dr1;
        j = a1;
    }

    static cm a(r r1)
    {
        return r1.e;
    }

    private void a(k k1, List list)
    {
        list = list.iterator();
        int l = 0;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            ad ad1 = (ad)list.next();
            if (ad1.a != -1)
            {
                ad1.a(k1);
                l++;
            }
        } while (true);
        if (l > 0)
        {
            b.d("%s; code: %s", new Object[] {
                k1.b, k1.a
            });
        }
    }

    static void a(r r1, int l, af af1, List list)
    {
        ao.a a1 = r1.d.a();
        if (!a1.a)
        {
            r1.a(new k(k.a.d, "An internal request was not made on a background thread."), list);
        } else
        {
            af af2 = af1;
            if (af1 == null)
            {
                af2 = new af();
            }
            af1 = r1.j;
            af1.a = af2;
            af1.b = a1;
            r1 = new y(((y.a) (af1)).a);
            r1.d = ((y.a) (af1)).b;
            af1 = new HashMap();
            list = list.iterator();
            int i1 = 1;
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                ad ad1 = (ad)list.next();
                boolean flag;
                if (!ad1.b.x.equals(ae.j))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    ad1.a = i1;
                    af1.put(Integer.valueOf(i1), ad1);
                    r1.a(ad1);
                    i1++;
                }
            } while (true);
            if (af1.size() > 0)
            {
                r1 = new s(r1, af1);
                r1.b = l;
                r1.b().c(ck.a.d);
                r1.b().b(ck.a.e);
                ((s) (r1)).f.a(new s._cls1(r1), ds.b.b, ds.c.b);
                return;
            }
        }
    }

    static void a(r r1, k k1, List list)
    {
        r1.a(k1, list);
    }

    static ds.k b(r r1)
    {
        return r1.h;
    }

    public final transient void a(int l, af af1, ad aad[])
    {
        Object obj = e;
        int i1;
        if (((cm) (obj)).f == 0 || ((cm) (obj)).g == 0L)
        {
            i1 = 0;
        } else
        {
            long l1 = System.currentTimeMillis();
            if (l1 >= ((cm) (obj)).g)
            {
                obj.f = 0;
                obj.g = 0L;
                i1 = 0;
            } else
            {
                i1 = (int)(((cm) (obj)).g - l1);
            }
        }
        if (i1 > 0)
        {
            i1 /= 1000;
            k.a a1;
            if (e.h)
            {
                obj = (new StringBuilder()).append("SDK Message: ").append("DISABLED_APP").toString();
                a1 = k.a.d;
            } else
            {
                obj = (new StringBuilder()).append("SDK Message: ").append("no results. Try again in ").append(i1).append(" seconds.").toString();
                a1 = k.a.c;
            }
            a(new k(a1, ((String) (obj))), ((List) (new ArrayList(Arrays.asList(aad)))));
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            return;
        }
        long l2 = System.nanoTime();
        obj = new ArrayList();
        for (int j1 = 0; j1 <= 0; j1++)
        {
            ad ad1 = aad[0];
            if (ad1.b.a(l2, ad1.d))
            {
                ((ArrayList) (obj)).add(ad1);
            }
        }

        af1 = new dp(f, g, l, af1, ((ArrayList) (obj))) {

            final int a;
            final af b;
            final ArrayList c;
            final r d;

            protected final void a()
            {
                cm cm1 = r.a(d);
                di di1 = cm1.d;
                di._cls1 _lcls1 = new di._cls1(di1);
                di1.a.a(_lcls1);
                cm1.e = true;
                r.a(d, a, b, c);
            }

            protected final void b()
            {
                r.b(d).a(new Runnable(this) {

                    final _cls1 a;

                    public final void run()
                    {
                        k k1 = new k(k.a.a, "The configuration was unable to be loaded");
                        r.a(a.d, k1, a.c);
                    }

            
            {
                a = _pcls1;
                super();
            }
                }, ds.b.a, ds.c.a);
            }

            
            {
                d = r.this;
                a = l;
                b = af1;
                c = arraylist;
                super(dn1, ba1);
            }
        };
        aad = ((dp) (af1)).e;
        ((dn) (aad)).b.lock();
        if (aad.b())
        {
            af1.e();
        } else
        {
            ((dn) (aad)).a.add(af1);
        }
        ((dn) (aad)).b.unlock();
    }

}
