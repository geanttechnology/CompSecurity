// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ac, q, am, aa

final class ab
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
    ac a;
    String b;
    int d;
    int e;
    boolean f;
    boolean g;
    String h;
    a.g i;
    String j;
    String k[];
    al.c l;
    al.a m;
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

    ab(ac ac1)
    {
        b = "2.2.2";
        d = 300;
        e = 0;
        f = false;
        g = false;
        i = new a.g();
        n = 0.0D;
        o = "android";
        p = "android_native";
        q = "1.0";
        r = "google";
        s = false;
        x = "";
        a = ac1;
    }

    static String a(String s1, String s2)
    {
        if (s1 != null)
        {
            return s1;
        } else
        {
            return s2;
        }
    }

    final void a()
    {
        al.aa aa1 = m.t.h;
        al.o o1 = m.t.i;
        am am1 = a.c;
        if (!m.t.d)
        {
            i.b("end_card_enabled", m.t.d);
            return;
        }
        if (o1.a())
        {
            q.F = true;
            q.K = o1.g;
            q.L = am1.b(o1.f.b);
            i.b("close_image_normal", am1.b(o1.j.f));
            i.b("close_image_down", am1.b(o1.j.h));
            i.b("reload_image_normal", am1.b(o1.i.f));
            i.b("reload_image_down", am1.b(o1.i.h));
        } else
        {
            q.F = false;
            i.b("end_card_filepath", am1.b(aa1.d));
            i.b("info_image_normal", am1.b(aa1.f.f));
            i.b("info_image_down", am1.b(aa1.f.h));
            i.b("info_url", aa1.f.j);
            i.b("replay_image_normal", am1.b(aa1.h.f));
            i.b("replay_image_down", am1.b(aa1.h.h));
            i.b("continue_image_normal", am1.b(aa1.i.f));
            i.b("continue_image_down", am1.b(aa1.i.h));
            i.b("download_image_normal", am1.b(aa1.g.f));
            i.b("download_image_down", am1.b(aa1.g.h));
            i.b("download_url", aa1.g.j);
        }
        i.b("end_card_enabled", m.t.d);
        i.b("load_timeout_enabled", m.t.i.c);
        i.a("load_timeout", m.t.i.b);
        i.b("hardware_acceleration_disabled", a.b.j.e);
    }

    final void a(String s1, al.a a1)
    {
        l = a.b.j.n.a(s1);
        if (l != null)
        {
            if (a1 == null)
            {
                m = l.a();
            } else
            {
                m = a1;
            }
            if (m != null)
            {
                s1 = a.c;
                a1 = m.u;
                i.b("video_enabled", ((al.b) (a1)).a);
                i.b("video_filepath", a1.a());
                i.a("video_width", ((al.b) (a1)).b);
                i.a("video_height", ((al.b) (a1)).c);
                i.a("video_duration", ((al.b) (a1)).k);
                i.a("engagement_delay", ((al.b) (a1)).m.e);
                i.a("skip_delay", ((al.b) (a1)).l.e);
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
                i.b("skip_video_image_normal", s1.b(((al.b) (a1)).l.f));
                i.b("skip_video_image_down", s1.b(((al.b) (a1)).l.h));
                i.b("engagement_image_normal", s1.b(((al.b) (a1)).m.f));
                i.b("engagement_image_down", s1.b(((al.b) (a1)).m.h));
                i.a("engagement_height", ((al.b) (a1)).m.c);
                i.b("image_overlay_enabled", ((al.b) (a1)).n.a);
                i.b("image_overlay_filepath", s1.b(((al.b) (a1)).n.f));
                i.b("haptics_enabled", ((al.b) (a1)).o.a);
                i.b("haptics_filepath", s1.b(((al.b) (a1)).o.b));
                i.b("v4iap_enabled", m.w.c);
                i.b("product_id", m.w.a);
                i.b("in_progress", m.w.b);
                a();
                return;
            }
        }
    }

}
