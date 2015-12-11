// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.device.ads:
//            dn, cm, co, bc, 
//            dq, ds, cn, bq, 
//            cz, cy, br

class ao
{
    static final class a
    {

        boolean a;
        String b;
        boolean c;
        String d;
        private final bc e;

        final String a()
        {
            return e.a("debug.idfa", b);
        }

        final boolean b()
        {
            return !dq.a(a());
        }

        final boolean c()
        {
            return e.a("debug.optOut", Boolean.valueOf(c)).booleanValue();
        }

        final String d()
        {
            return e.a("debug.adid", d);
        }

        final boolean e()
        {
            return d() != null;
        }

        private a(bc bc1)
        {
            e = bc1;
            a = true;
        }

        a(bc bc1, byte byte0)
        {
            this(bc1);
        }
    }


    private static final String c = com/amazon/device/ads/ao.getSimpleName();
    boolean a;
    final dn b;
    private bq.a d;
    private final cn e;
    private final cm f;
    private final bc g;

    public ao()
    {
        dn dn1 = dn.a();
        cm cm1 = cm.a();
        new co();
        this(dn1, cm1, bc.a());
    }

    private ao(dn dn1, cm cm1, bc bc1)
    {
        a = true;
        b = dn1;
        f = cm1;
        e = co.a(c);
        g = bc1;
    }

    private String b()
    {
        return b.a("gpsAdId", "");
    }

    private boolean c()
    {
        return !dq.a(b());
    }

    final a a()
    {
        boolean flag3 = false;
        if (ds.b())
        {
            e.d("You must obtain the advertising indentifier information on a background thread.", null);
            a a1 = new a(g, (byte)0);
            a1.a = false;
            return a1;
        }
        Object obj = new bq();
        if (!dn.a().a("gps-available", true))
        {
            ((bq) (obj)).a.b("The Google Play Services Advertising Identifier feature is not available.");
            obj = bq.a.a();
        } else
        if (!dn.a().c.containsKey("gps-available") && !cy.a("com.google.android.gms.ads.identifier.AdvertisingIdClient"))
        {
            ((bq) (obj)).a.b("The Google Play Services Advertising Identifier feature is not available.");
            bq.a(false);
            obj = bq.a.a();
        } else
        {
            obj = (new br()).a();
            bq.a(((bq.a) (obj)).a);
        }
        d = ((bq.a) (obj));
        if (a)
        {
            obj = f.c;
            Object obj1;
            boolean flag;
            boolean flag4;
            if (cz.b() && cz.c() && !c() && d.b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                obj = "migrate";
            } else
            {
                boolean flag1;
                if (c() && d.b() && !b().equals(d.b))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    obj = "reset";
                } else
                {
                    boolean flag2;
                    if (c() && !d.b())
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    String s;
                    if (flag2)
                    {
                        obj = "revert";
                    } else
                    {
                        obj = null;
                    }
                }
            }
            if (obj != null)
            {
                e.b("Transition: %s", new Object[] {
                    obj
                });
                b.b("adIdTransistion", ((String) (obj)));
            } else
            {
                e.b("No transition detected.", null);
            }
        }
        obj = new a(g, (byte)0);
        if (d.b())
        {
            obj.b = d.b;
            obj.c = d.c;
            if (a)
            {
                obj1 = d.b;
                b.b("gpsAdId", ((String) (obj1)));
            }
        }
        obj1 = f.c;
        flag4 = cz.c();
        if (((a) (obj)).b())
        {
            if (!flag4)
            {
                s = dn.a().a("amzn-ad-id-origin", null);
                flag3 = ((a) (obj)).a().equals(s);
            }
        } else
        {
            flag3 = flag4;
        }
        if (flag3)
        {
            obj.d = cz.a();
            return ((a) (obj));
        } else
        {
            cz.e();
            return ((a) (obj));
        }
    }

}
