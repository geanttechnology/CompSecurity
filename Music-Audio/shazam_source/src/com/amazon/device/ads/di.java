// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            ao, cm, ba, dn, 
//            au, dr, co, bc, 
//            cn, dl, dh, dj, 
//            dk, cz, df

class di
{
    protected static final class a
        implements dl
    {

        private final di a;

        public final void a()
        {
            Object obj = a;
            if (ds.l.b())
            {
                ((di) (obj)).b.d("Registering events must be done on a background thread.", null);
            } else
            {
                Object obj1 = ((di) (obj)).c.a();
                if (((ao.a) (obj1)).e())
                {
                    org.json.JSONArray jsonarray = ((di) (obj)).h.b();
                    if (jsonarray != null)
                    {
                        obj1 = new dh(((ao.a) (obj1)), jsonarray);
                        obj = ((di) (obj)).d;
                        dk.a.a(null, new dj[] {
                            obj1
                        }).a();
                        return;
                    }
                }
            }
        }

        public a(di di1)
        {
            a = di1;
        }
    }


    private static final String j = com/amazon/device/ads/di.getSimpleName();
    private static final ds.h k = new ds.h();
    final ds.g a;
    final cn b;
    final ao c;
    final dk.a d;
    final cm e;
    final ba f;
    final dn g;
    final au h;
    final bc i;
    private final ds.l l;
    private final dh.a m;
    private final dr n;

    public di()
    {
        dh.a a1 = new dh.a();
        dk.a a2 = new dk.a();
        ao ao1 = new ao();
        cm cm1 = cm.a();
        ba ba1 = ba.a();
        dn dn1 = dn.a();
        au au1 = au.a();
        dr dr1 = new dr();
        ds.h h1 = k;
        ds.l l1 = new ds.l();
        new co();
        this(a1, a2, ao1, cm1, ba1, dn1, au1, dr1, ((ds.g) (h1)), l1, bc.a());
    }

    private di(dh.a a1, dk.a a2, ao ao1, cm cm1, ba ba1, dn dn1, au au1, 
            dr dr1, ds.g g1, ds.l l1, bc bc1)
    {
        m = a1;
        d = a2;
        c = ao1;
        e = cm1;
        f = ba1;
        g = dn1;
        h = au1;
        n = dr1;
        a = g1;
        l = l1;
        b = co.a(j);
        i = bc1;
    }

    static cn a(di di1)
    {
        return di1.b;
    }


    // Unreferenced inner class com/amazon/device/ads/di$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final di a;

        public final void run()
        {
            di di1 = a;
            CountDownLatch countdownlatch = new CountDownLatch(1);
            Object obj = new AtomicBoolean(false);
            di1.f.a(di1. new ba.b(((AtomicBoolean) (obj)), countdownlatch) {

                final AtomicBoolean a;
                final CountDownLatch b;
                final di c;

                public final void c()
                {
                    a.set(true);
                    b.countDown();
                }

                public final void d()
                {
                    di.a(c).c("Configuration fetching failed so device registration will not proceed.", null);
                    b.countDown();
                }

            
            {
                c = di.this;
                a = atomicboolean;
                b = countdownlatch;
                super();
            }
            });
            boolean flag;
            long l1;
            try
            {
                countdownlatch.await();
            }
            catch (InterruptedException interruptedexception) { }
            if (!((AtomicBoolean) (obj)).get()) goto _L2; else goto _L1
_L1:
            l1 = System.currentTimeMillis();
            if (!di1.c.a().a) goto _L2; else goto _L3
_L3:
            obj = di1.e.c;
            if (l1 - di1.g.a("amzn-ad-sis-last-checkin", 0L) > 0x5265c00L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag || dn.a().a("newSISDIDRequested", false)) goto _L5; else goto _L4
_L4:
            if (!cz.b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && !di1.i.a("debug.shouldRegisterSIS", Boolean.valueOf(false)).booleanValue()) goto _L6; else goto _L5
_L5:
            flag = true;
_L8:
            if (flag)
            {
                obj = di1.g;
                ((dn) (obj)).a("amzn-ad-sis-last-checkin", new dn.c(((dn) (obj)), java/lang/Long, Long.valueOf(l1)));
                obj = di1.e.c;
                if (!cz.b())
                {
                    break; /* Loop/switch isn't completed */
                }
                obj = di1.c;
                obj = dh.a.a(dh.b.b).a(((ao) (obj)));
                dk.a.a(new a(di1), new dj[] {
                    obj
                }).a();
            }
_L2:
            return;
_L6:
            flag = false;
            if (true) goto _L8; else goto _L7
_L7:
            obj = di1.c;
            obj = dh.a.a(dh.b.a).a(((ao) (obj)));
            dk.a.a(new a(di1), new dj[] {
                obj
            }).a();
            return;
        }

            
            {
                a = di.this;
                super();
            }
    }

}
