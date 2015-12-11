// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            cf, bv, ci, ca, 
//            bp, cr, h, cg, 
//            cq, bu

class bo
{

    String a;
    String b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    cg o;
    cq p;
    cf q;
    bv r;
    bu s;
    ca t;
    bp u;
    ci v;
    cr w;

    bo()
    {
    }

    boolean a()
    {
        while (!q.a() || r.a && !r.a() || v.a && !v.a() || t.d && !t.a() || !u.a() || !w.a()) 
        {
            return false;
        }
        return true;
    }

    boolean a(h h1)
    {
        if (h1 != null)
        {
            a = h1.d("uuid");
            b = h1.d("title");
            c = h1.f("ad_campaign_id");
            d = h1.f("ad_id");
            e = h1.f("ad_group_id");
            f = h1.f("cpcv_bid");
            g = h1.f("net_earnings");
            h = h1.f("expires");
            i = h1.g("enable_in_app_store");
            j = h1.g("video_events_on_replays");
            k = h1.g("test_ad");
            l = h1.g("fullscreen");
            m = h1.g("house_ad");
            n = h1.g("contracted");
            o = new cg();
            if (o.a(h1.a("limits")))
            {
                p = new cq();
                if (p.a(h1.a("third_party_tracking")))
                {
                    q = new cf();
                    if (q.a(h1.a("in_app_browser")))
                    {
                        v = new ci();
                        if (v.a(h1.a("native")))
                        {
                            r = new bv();
                            if (r.a(h1.a("v4vc")))
                            {
                                s = new bu();
                                if (s.a(h1.a("ad_tracking")))
                                {
                                    t = new ca();
                                    if (t.a(h1.a("companion_ad")))
                                    {
                                        u = new bp();
                                        if (u.a(h1.a("video")))
                                        {
                                            w = new cr();
                                            if (w.a(h1.a("v4iap")))
                                            {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    void b()
    {
        r.b();
        q.b();
        v.b();
        t.b();
        u.c();
    }
}
