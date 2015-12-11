// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            dj, co, cd, cn, 
//            au, cm, bg, cz, 
//            ba, dg, dm, df

final class dh
    implements dj
{
    static final class a
    {

        public static df a(b b1)
        {
            static final class _cls1
            {

                static final int a[];

                static 
                {
                    a = new int[b.values().length];
                    try
                    {
                        a[b.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[b.b.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[b.c.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1.a[b1.ordinal()])
            {
            default:
                throw new IllegalArgumentException((new StringBuilder("SISRequestType ")).append(b1).append(" is not a SISDeviceRequest").toString());

            case 1: // '\001'
                return new dg();

            case 2: // '\002'
                return new dm();
            }
        }

        a()
        {
        }
    }

    static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        private static final b d[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/amazon/device/ads/dh$b, s);
        }

        public static b[] values()
        {
            return (b[])d.clone();
        }

        static 
        {
            a = new b("GENERATE_DID", 0);
            b = new b("UPDATE_DEVICE_INFO", 1);
            c = new b("REGISTER_EVENT", 2);
            d = (new b[] {
                a, b, c
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    private static final ck.a a;
    private final cn b = co.a("SISRegisterEventRequest");
    private final ao.a c;
    private final JSONArray d;

    public dh(ao.a a1, JSONArray jsonarray)
    {
        new co();
        c = a1;
        d = jsonarray;
    }

    public final String a()
    {
        return "SISRegisterEventRequest";
    }

    public final void a(JSONObject jsonobject)
    {
        int i = cd.a(jsonobject, "rcode", 0);
        if (i == 1)
        {
            b.b("Application events registered successfully.", null);
            au.a().c();
            return;
        } else
        {
            b.c((new StringBuilder("Application events not registered. rcode:")).append(i).toString());
            return;
        }
    }

    public final ck.a b()
    {
        return a;
    }

    public final String c()
    {
        return "/register_event";
    }

    public final dy.b d()
    {
        dy.b b1 = new dy.b();
        b1.a("adId", c.d());
        Object obj = cm.a().b;
        b1.a("dt", bg.b());
        obj = cm.a().c;
        b1.a("app", ((cz) (obj)).b);
        b1.a("appId", ((cz) (obj)).d());
        b1.a("aud", ba.a().a(ba.a.e));
        return b1;
    }

    public final HashMap e()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("events", d.toString());
        return hashmap;
    }

    public final cn f()
    {
        return b;
    }

    static 
    {
        a = ck.a.O;
    }
}
