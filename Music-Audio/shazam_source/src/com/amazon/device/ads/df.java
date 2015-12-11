// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            dj, co, ao, cn, 
//            cm, bg, cz, ba, 
//            dz, av, dn

abstract class df
    implements dj
{

    ck.a a;
    String b;
    ao.a c;
    private String d;
    private ao e;
    private final cn f;

    df()
    {
        new co();
        f = co.a(d);
    }

    public final df a(ao ao1)
    {
        e = ao1;
        c = e.a();
        return this;
    }

    public final df a(String s)
    {
        d = s;
        f.g(s);
        return this;
    }

    public final String a()
    {
        return d;
    }

    public final ck.a b()
    {
        return a;
    }

    public final String c()
    {
        return b;
    }

    public dy.b d()
    {
        dy.b b1 = new dy.b();
        Object obj = cm.a().b;
        b1.a("dt", bg.b());
        b1.a("app", cm.a().c.b);
        b1.a("aud", ba.a().a(ba.a.e));
        b1.a("ua", dz.a(cm.a().b.i()));
        obj = cm.a().b;
        b1.a("dinfo", dz.a(String.format("{\"make\":\"%s\",\"model\":\"%s\",\"os\":\"%s\",\"osVersion\":\"%s\"}", new Object[] {
            ((bg) (obj)).a, ((bg) (obj)).b, bg.c(), ((bg) (obj)).c
        })));
        obj = cm.a().a;
        boolean flag;
        if (((av) (obj)).a != null)
        {
            obj = ((av) (obj)).a.toString();
        } else
        {
            obj = null;
        }
        b1.a("pkg", dz.a(((String) (obj))));
        if (c.b())
        {
            b1.a("idfa", c.a());
            String s;
            if (c.c())
            {
                obj = "1";
            } else
            {
                obj = "0";
            }
            b1.a("oo", ((String) (obj)));
        } else
        {
            bg bg1 = cm.a().b;
            b1.a("sha1_mac", bg1.d());
            b1.a("sha1_serial", bg1.f());
            b1.a("sha1_udid", bg1.h());
            b1.a("badMac", "true", bg1.e());
            b1.a("badSerial", "true", bg1.g());
            bg1.a();
            b1.a("badUdid", "true", bg1.f);
        }
        obj = e;
        s = ((ao) (obj)).b.a("adIdTransistion", null);
        ((ao) (obj)).b.c("adIdTransistion");
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b1.a("aidts", s, flag);
        return b1;
    }

    public final HashMap e()
    {
        return null;
    }

    public final cn f()
    {
        return f;
    }
}
