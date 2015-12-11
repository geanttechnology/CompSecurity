// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            bl, bt, bq, h, 
//            by, cp, cb

class bx
{

    boolean a;
    boolean b;
    String c;
    String d;
    boolean e;
    boolean f;
    double g;
    String h;
    String i;
    String j;
    by k;
    cp l;
    ArrayList m;
    bt n;
    cb o;

    bx()
    {
        e = false;
    }

    void a()
    {
        bl.a.b("Caching media");
        if (a)
        {
            int i1 = 0;
            while (i1 < n.a()) 
            {
                n.a(i1).k();
                i1++;
            }
        }
    }

    boolean a(h h1)
    {
        if (h1 != null)
        {
            a = h1.g("enabled");
            b = h1.g("log_screen_overlay");
            c = h1.d("last_country");
            d = h1.d("last_ip");
            f = h1.g("collect_iap_enabled");
            g = h1.e("media_pool_size");
            h = h1.d("log_level");
            i = h1.d("view_network_pass_filter");
            j = h1.d("cache_network_pass_filter");
            e = h1.g("hardware_acceleration_disabled");
            if (i == null || i.equals(""))
            {
                i = "all";
            }
            if (j == null || j.equals(""))
            {
                j = "all";
            }
            k = new by();
            if (k.a(h1.a("tracking")))
            {
                l = new cp();
                if (l.a(h1.a("third_party_tracking")))
                {
                    m = h1.c("console_messages");
                    bl.a.b("Parsing zones");
                    n = new bt();
                    if (n.a(h1.b("zones")))
                    {
                        o = new cb();
                        if (o.a(h1.a("device")))
                        {
                            bl.a.b("Finished parsing app info");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    boolean a(String s, boolean flag, boolean flag1)
    {
        if (a)
        {
            if ((s = n.a(s)) != null)
            {
                return s.a(flag, flag1);
            }
        }
        return false;
    }
}
