// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            h, q, be, az, 
//            bh, ap, ak, bl, 
//            dh, cx, n, ct, 
//            db, bc, dd, cz, 
//            bx, y, bt, bq, 
//            bo, bp, bz, cf, 
//            ce, ci, cj, cd, 
//            cr, ca, cc, ch, 
//            co, bv, cn, cm, 
//            cl, ck

class bd
{

    static String c = "https://androidads21.adcolony.com/configure";
    String A;
    String B;
    String C;
    String D;
    String E;
    String F;
    String G;
    String H;
    String I;
    String J;
    String K;
    boolean L;
    boolean M;
    be a;
    String b;
    int d;
    int e;
    boolean f;
    boolean g;
    String h;
    h i;
    String j;
    String k[];
    bq l;
    bo m;
    double n;
    String o;
    String p;
    String q;
    String r;
    boolean s;
    String t;
    String u;
    String v;
    String w;
    String x;
    String y;
    String z;

    bd(be be1)
    {
        b = "2.2.2";
        d = 300;
        e = 0;
        f = false;
        g = false;
        i = new h();
        n = 0.0D;
        o = "android";
        p = "android_native";
        q = "1.0";
        r = "google";
        s = false;
        x = "";
        a = be1;
    }

    String a(String s1, String s2)
    {
        if (s1 != null)
        {
            return s1;
        } else
        {
            return s2;
        }
    }

    void a()
    {
        while (!q.a && e < 60) 
        {
            try
            {
                e = e + 1;
                Thread.sleep(50L);
            }
            catch (Exception exception) { }
        }
        e = 0;
        a.g.a();
        K = a(bh.a, "");
        L = bh.b;
        t = a(bh.a(), "");
        Object obj;
        boolean flag;
        if (!K.equals(""))
        {
            obj = "";
        } else
        {
            obj = a(ap.b(t), "");
        }
        u = ((String) (obj));
        w = a(bh.b(), "");
        if (y == null)
        {
            y = a(bh.e(), "");
        }
        z = a(bh.k(), "");
        A = a(bh.l(), "");
        E = a(bh.j(), "en");
        F = a(bh.m(), "");
        G = a(bh.n(), "");
        J = a((new StringBuilder()).append("").append(android.os.Build.VERSION.SDK_INT).toString(), "");
        C = a(bh.h(), "");
        D = "";
        H = a((new StringBuilder()).append("").append(bh.c()).toString(), "");
        I = a((new StringBuilder()).append("").append(bh.d()).toString(), "");
        if (ap.c() && ap.d())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        M = flag;
        ak.M = G;
        ak.N = b;
        if (ak.d)
        {
            B = "tablet";
        } else
        {
            B = "phone";
        }
        v = "";
        if (ap.a("com.android.vending") || ap.a("com.android.market"))
        {
            v = "google";
        }
        if (ap.a("com.amazon.venezia"))
        {
            if (v.length() > 0)
            {
                v = (new StringBuilder()).append(v).append(",").toString();
            }
            v = (new StringBuilder()).append(v).append("amazon").toString();
        }
        if (bl.b.f)
        {
            bl.b.a("sdk_version:").b(b);
            bl.b.a("ad_manifest_url:").b(c);
            bl.b.a("app_id:").b(j);
            bl.b.a("zone_ids:").b(k);
            bl.b.a("os_name:").b(o);
            bl.b.a("sdk_type:").b(p);
            bl.b.a("app_version:").b(q);
            bl.b.a("origin_store:").b(r);
            bl.b.a("skippable:").b(s);
            bl.b.a("android_id:").b(t);
            bl.b.a("android_id_sha1:").b(u);
            bl.b.a("available_stores:").b(v);
            bl.b.a("carrier_name:").b(w);
            bl.b.a("custom_id:").b(x);
            bl.b.a("device_id:").b(y);
            bl.b.a("device_manufacturer:").b(z);
            bl.b.a("device_model:").b(A);
            bl.b.a("device_type:").b(B);
            bl.b.a("imei:").b(C);
            bl.b.a("imei_sha1:").b(D);
            bl.b.a("language:").b(E);
            bl.b.a("open_udid:").b(F);
            bl.b.a("os_version:").b(G);
        }
        obj = new dh();
        ((dh) (obj)).a("&os_name=");
        ((dh) (obj)).a(cx.a(o));
        ((dh) (obj)).a("&os_version=");
        ((dh) (obj)).a(cx.a(G));
        ((dh) (obj)).a("&device_api=");
        ((dh) (obj)).a(cx.a(J));
        ((dh) (obj)).a("&app_version=");
        ((dh) (obj)).a(cx.a(q));
        ((dh) (obj)).a("&android_id_sha1=");
        ((dh) (obj)).a(cx.a(u));
        ((dh) (obj)).a("&device_id=");
        ((dh) (obj)).a(cx.a(y));
        ((dh) (obj)).a("&open_udid=");
        ((dh) (obj)).a(cx.a(F));
        ((dh) (obj)).a("&device_type=");
        ((dh) (obj)).a(cx.a(B));
        ((dh) (obj)).a("&ln=");
        ((dh) (obj)).a(cx.a(E));
        ((dh) (obj)).a("&device_brand=");
        ((dh) (obj)).a(cx.a(z));
        ((dh) (obj)).a("&device_model=");
        ((dh) (obj)).a(cx.a(A));
        ((dh) (obj)).a("&screen_width=");
        ((dh) (obj)).a(cx.a((new StringBuilder()).append("").append(bh.f()).toString()));
        ((dh) (obj)).a("&screen_height=");
        ((dh) (obj)).a(cx.a((new StringBuilder()).append("").append(bh.g()).toString()));
        ((dh) (obj)).a("&sdk_type=");
        ((dh) (obj)).a(cx.a(p));
        ((dh) (obj)).a("&sdk_version=");
        ((dh) (obj)).a(cx.a(b));
        ((dh) (obj)).a("&origin_store=");
        ((dh) (obj)).a(cx.a(r));
        ((dh) (obj)).a("&available_stores=");
        ((dh) (obj)).a(cx.a(v));
        ((dh) (obj)).a("&imei_sha1=");
        ((dh) (obj)).a(cx.a(D));
        ((dh) (obj)).a("&memory_class=");
        ((dh) (obj)).a(cx.a(H));
        ((dh) (obj)).a("&memory_used_mb=");
        ((dh) (obj)).a(cx.a(I));
        ((dh) (obj)).a("&advertiser_id=");
        ((dh) (obj)).a(cx.a(K));
        ((dh) (obj)).a("&limit_tracking=");
        ((dh) (obj)).a(L);
        ((dh) (obj)).a("&immersion=");
        ((dh) (obj)).a(M);
        h = ((dh) (obj)).toString();
        a.f.a();
        a.c.a();
        a.d.a();
        a.b.a();
        a.e.a();
        a.h.a();
        g = true;
        a.b.e();
        if (a.b.j.i == null || a.b.j.i.equals(""))
        {
            a.b.j.i = "all";
        }
        if (a.b.j.j == null || a.b.j.j.equals(""))
        {
            a.b.j.j = "all";
        }
    }

    void a(String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        s1 = s2.split(",");
        int j1 = s1.length;
        int i1 = 0;
        while (i1 < j1) 
        {
            Object obj = s1[i1].split(":");
            if (obj.length == 2)
            {
                String s3 = obj[0];
                obj = obj[1];
                if (s3.equals("version"))
                {
                    q = ((String) (obj));
                } else
                if (s3.equals("store"))
                {
                    if (((String) (obj)).toLowerCase().equals("google") || ((String) (obj)).toLowerCase().equals("amazon"))
                    {
                        r = ((String) (obj));
                    } else
                    {
                        throw new y("Origin store in client options must be set to either 'google' or 'amazon'");
                    }
                } else
                if (s3.equals("skippable"))
                {
                    s = false;
                }
            } else
            if (obj[0].equals("skippable"))
            {
                s = false;
            }
            i1++;
        }
    }

    void a(String s1, bo bo1)
    {
        l = a.b.j.n.a(s1);
        if (l != null)
        {
            if (bo1 == null)
            {
                m = l.h();
            } else
            {
                m = bo1;
            }
            if (m != null)
            {
                s1 = a.c;
                bo1 = m.u;
                i.b("video_enabled", ((bp) (bo1)).a);
                i.b("video_filepath", bo1.b());
                i.b("video_width", ((bp) (bo1)).b);
                i.b("video_height", ((bp) (bo1)).c);
                i.b("video_duration", ((bp) (bo1)).k);
                i.b("engagement_delay", ((bp) (bo1)).m.e);
                i.b("skip_delay", ((bp) (bo1)).l.e);
                i.b("browser_close_image_normal", s1.b(m.q.k.f));
                i.b("browser_close_image_down", s1.b(m.q.k.h));
                i.b("browser_reload_image_normal", s1.b(m.q.m.f));
                i.b("browser_reload_image_down", s1.b(m.q.m.h));
                i.b("browser_back_image_normal", s1.b(m.q.j.f));
                i.b("browser_back_image_down", s1.b(m.q.j.h));
                i.b("browser_forward_image_normal", s1.b(m.q.l.f));
                i.b("browser_forward_image_down", s1.b(m.q.l.h));
                i.b("browser_stop_image_normal", s1.b(m.q.i.f));
                i.b("browser_stop_image_down", s1.b(m.q.i.h));
                i.b("browser_glow_button", s1.b(m.q.a));
                i.b("browser_icon", s1.b(m.q.h.d));
                i.b("mute", s1.b(m.v.k.d));
                i.b("unmute", s1.b(m.v.l.d));
                i.b("poster_image", s1.b(m.v.c));
                i.b("thumb_image", s1.b(m.v.g));
                i.b("advertiser_name", m.v.d);
                i.b("description", m.v.e);
                i.b("title", m.v.f);
                i.b("native_engagement_enabled", m.v.j.a);
                i.b("native_engagement_type", m.v.j.c);
                i.b("native_engagement_command", m.v.j.e);
                i.b("native_engagement_label", m.v.j.d);
                i.b("skip_video_image_normal", s1.b(((bp) (bo1)).l.f));
                i.b("skip_video_image_down", s1.b(((bp) (bo1)).l.h));
                i.b("engagement_image_normal", s1.b(((bp) (bo1)).m.f));
                i.b("engagement_image_down", s1.b(((bp) (bo1)).m.h));
                i.b("engagement_height", ((bp) (bo1)).m.c);
                i.b("image_overlay_enabled", ((bp) (bo1)).n.a);
                i.b("image_overlay_filepath", s1.b(((bp) (bo1)).n.f));
                i.b("haptics_enabled", ((bp) (bo1)).o.a);
                i.b("haptics_filepath", s1.b(((bp) (bo1)).o.b));
                i.b("v4iap_enabled", m.w.c);
                i.b("product_id", m.w.a);
                i.b("in_progress", m.w.b);
                b();
                return;
            }
        }
    }

    void b()
    {
        Object obj = m.t.h;
        cc cc1 = m.t.i;
        ct ct1 = a.c;
        if (!m.t.d)
        {
            i.b("end_card_enabled", m.t.d);
            return;
        }
        if (cc1.a())
        {
            ak.F = true;
            ak.K = cc1.g;
            ak.L = ct1.b(cc1.f.b);
            i.b("close_image_normal", ct1.b(cc1.j.f));
            i.b("close_image_down", ct1.b(cc1.j.h));
            i.b("reload_image_normal", ct1.b(cc1.i.f));
            i.b("reload_image_down", ct1.b(cc1.i.h));
        } else
        {
            ak.F = false;
            i.b("end_card_filepath", ct1.b(((co) (obj)).d));
            i.b("info_image_normal", ct1.b(((co) (obj)).f.f));
            i.b("info_image_down", ct1.b(((co) (obj)).f.h));
            i.b("info_url", ((co) (obj)).f.j);
            i.b("replay_image_normal", ct1.b(((co) (obj)).h.f));
            i.b("replay_image_down", ct1.b(((co) (obj)).h.h));
            i.b("continue_image_normal", ct1.b(((co) (obj)).i.f));
            i.b("continue_image_down", ct1.b(((co) (obj)).i.h));
            i.b("download_image_normal", ct1.b(((co) (obj)).g.f));
            i.b("download_image_down", ct1.b(((co) (obj)).g.h));
            i.b("download_url", ((co) (obj)).g.j);
        }
        obj = m.u;
        i.b("end_card_enabled", m.t.d);
        i.b("load_timeout_enabled", m.t.i.c);
        i.b("load_timeout", m.t.i.b);
        i.b("hardware_acceleration_disabled", a.b.j.e);
    }

    void b(String s1)
    {
        a(s1, ((bo) (null)));
    }

    void c(String s1)
    {
        l = a.b.j.n.a(s1);
        m = l.h();
        s1 = a.c;
        bp bp1 = m.u;
        i.b("video_enabled", bp1.a);
        i.b("video_filepath", bp1.b());
        i.b("video_width", bp1.b);
        i.b("video_height", bp1.c);
        i.b("video_duration", bp1.k);
        i.b("engagement_delay", bp1.m.e);
        i.b("skip_delay", bp1.l.e);
        b();
        bv bv1 = m.r;
        i.b("pre_popup_bg", s1.b(bv1.b.d.e));
        i.b("v4vc_logo", s1.b(bv1.b.d.l.d));
        i.b("no_button_normal", s1.b(bv1.b.d.n.f));
        i.b("no_button_down", s1.b(bv1.b.d.n.h));
        i.b("yes_button_normal", s1.b(bv1.b.d.m.f));
        i.b("yes_button_down", s1.b(bv1.b.d.m.h));
        i.b("done_button_normal", s1.b(bv1.c.d.m.f));
        i.b("done_button_down", s1.b(bv1.c.d.m.h));
        i.b("browser_close_image_normal", s1.b(m.q.k.f));
        i.b("browser_close_image_down", s1.b(m.q.k.h));
        i.b("browser_reload_image_normal", s1.b(m.q.m.f));
        i.b("browser_reload_image_down", s1.b(m.q.m.h));
        i.b("browser_back_image_normal", s1.b(m.q.j.f));
        i.b("browser_back_image_down", s1.b(m.q.j.h));
        i.b("browser_forward_image_normal", s1.b(m.q.l.f));
        i.b("browser_forward_image_down", s1.b(m.q.l.h));
        i.b("browser_stop_image_normal", s1.b(m.q.i.f));
        i.b("browser_stop_image_down", s1.b(m.q.i.h));
        i.b("browser_glow_button", s1.b(m.q.a));
        i.b("browser_icon", s1.b(m.q.h.d));
        i.b("skip_video_image_normal", s1.b(bp1.l.f));
        i.b("skip_video_image_down", s1.b(bp1.l.h));
        i.b("engagement_image_normal", s1.b(bp1.m.f));
        i.b("engagement_image_down", s1.b(bp1.m.h));
        i.b("engagement_height", bp1.m.c);
        i.b("image_overlay_enabled", bp1.n.a);
        i.b("image_overlay_filepath", s1.b(bp1.n.f));
        i.b("haptics_enabled", bp1.o.a);
        i.b("haptics_filepath", s1.b(bp1.o.b));
        i.b("v4iap_enabled", m.w.c);
        i.b("product_id", m.w.a);
        i.b("in_progress", m.w.b);
    }

}
