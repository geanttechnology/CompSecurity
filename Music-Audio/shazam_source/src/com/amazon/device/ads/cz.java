// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            bc, dn, dq

final class cz
{

    String a;
    String b;

    public cz()
    {
        b = "app";
    }

    public static String a()
    {
        return bc.a().a("debug.adid", dn.a().a("amzn-ad-id", null));
    }

    public static void a(String s, ao.a a1)
    {
        dn dn1 = dn.a();
        dn1.c("amzn-ad-id", s);
        if (a1.b())
        {
            dn.a().c("amzn-ad-id-origin", a1.a());
        } else
        {
            dn.a().c("amzn-ad-id-origin", "non-advertising-identifier");
        }
        dn1.b("newSISDIDRequested", false);
        dn1.c();
    }

    public static boolean b()
    {
        return !dq.a(a());
    }

    public static boolean c()
    {
        String s = dn.a().a("amzn-ad-id-origin", null);
        return s == null || "non-advertising-identifier".equals(s);
    }

    public static void e()
    {
        dn dn1 = dn.a();
        dn1.a("newSISDIDRequested", new dn.c(dn1, java/lang/Boolean, Boolean.valueOf(true)));
    }

    public final String d()
    {
        return bc.a().a("debug.appid", a);
    }
}
