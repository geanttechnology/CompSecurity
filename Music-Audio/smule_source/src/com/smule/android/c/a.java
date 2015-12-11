// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.smule.android.f.p;
import com.smule.android.network.core.b;

// Referenced classes of package com.smule.android.c:
//            w, b, aa, d, 
//            y, e, j, k, 
//            l, p, i, f, 
//            g, o, n, x, 
//            m, q

public class a
{

    protected static String a = null;
    private static final String b = com/smule/android/c/a.getName();

    public a()
    {
    }

    public static void a()
    {
        w.a().a("search_clk", null, null);
    }

    public static void a(com.smule.android.c.b b1)
    {
        a = b1.a();
        b1 = com.smule.android.network.core.b.d().e().getSharedPreferences("ANALYTICS_PREFERENCES", 0).edit();
        b1.putString("referrer", a);
        p.a(b1);
    }

    protected static void a(com.smule.android.c.b b1, String s)
    {
        if (b1 == null)
        {
            com.smule.android.c.aa.b(b, s);
        }
    }

    public static void a(d d1, e e1, String s, String s1)
    {
        a(((com.smule.android.c.b) (d1)), "earnFrom is required");
        if (d1.equals(com.smule.android.c.d.b) || d1.equals(d.a))
        {
            a(((com.smule.android.c.b) (e1)), "adsVendor is required");
        }
        y y1 = (new y()).a("vc_earn_clk").b(d1.a());
        if (e1 == null)
        {
            d1 = null;
        } else
        {
            d1 = e1.a();
        }
        d1 = y1.d(d1).e(s).g(s1);
        w.a().a(d1);
    }

    public static void a(j j1, k k1)
    {
        a(((com.smule.android.c.b) (j1)), "accountType is required");
        a(((com.smule.android.c.b) (k1)), "flow is required");
        j1 = (new y()).a("reg_flow_complete").c(j1.a()).d(k1.a()).a(true);
        w.a().a(j1);
    }

    public static void a(l l1)
    {
        a(((com.smule.android.c.b) (l1)), "type is required");
        l1 = (new y()).a("reg_acct_found").c(l1.a()).a(true);
        w.a().a(l1);
    }

    public static void a(m m1, String s, Integer integer, String s1, q q)
    {
        m1 = (new y()).a("search_result_clk").a(m1).d(s).b(integer.intValue()).h(s1).f(q);
        w.a().a(m1);
    }

    public static void a(com.smule.android.c.p p1, float f1, String s, boolean flag, String s1)
    {
        p1 = (new y()).a("vc_spend_clk").b(p1.a()).c(Float.toString(f1)).d(s).e(Boolean.toString(flag)).g(s1);
        w.a().a(p1);
    }

    public static void a(String s)
    {
        a(s, "adUnitId is required");
        s = (new y()).a("interstitial_ad_shown").c(s);
        w.a().a(s);
    }

    public static void a(String s, int i1, String s1, String s2)
    {
        a(s, i1, s1, s2, ((String) (null)));
    }

    public static void a(String s, int i1, String s1, String s2, Number number)
    {
        a(s, i1, s1, s2, ((String) (null)), number);
    }

    public static void a(String s, int i1, String s1, String s2, String s3)
    {
        a(s1, "costType is required");
        a(s, "songUid is required");
        a(s2, "sectionUid is required");
        s = (new y()).a("song_preview").d(s).a(i1).f(s1).g(s2).h(s3);
        w.a().a(s);
    }

    public static void a(String s, int i1, String s1, String s2, String s3, Number number)
    {
        a(s1, "costType is required");
        a(s, "songUid is required");
        s = (new y()).a("song_clk").a(number).d(s).a(i1).f(s1).g(s2).h(s3);
        w.a().a(s);
    }

    public static void a(String s, i i1, String s1, f f1, String s2)
    {
        a(s, "perfKey is required");
        a(s1, "songUid is required");
        a(s, i1, s1, f1, s2, ((g) (null)));
    }

    protected static void a(String s, i i1, String s1, f f1, String s2, g g1)
    {
        a(s, "perfKey is required");
        a(s1, "songUid is required");
        s = (new y()).a("perf_listen").b(s).c(i1.a()).d(s1).f(f1.a()).g(s2).a();
        if (g1 != null)
        {
            g1.a(s);
        }
        w.a().a(s);
    }

    public static void a(String s, o o1, n n1, i i1, f f1)
    {
        a(s, "perfKey is required");
        a(s, o1, n1, i1, f1, ((g) (null)));
    }

    protected static void a(String s, o o1, n n1, i i1, f f1, g g1)
    {
        a(s, "perfKey is required");
        s = (new y()).a("share_ext_clk").b(s).c(o1.a()).d(n1.a()).e(i1.a()).f(f1.a()).a();
        if (g1 != null)
        {
            g1.a(s);
        }
        w.a().a(s);
    }

    public static void a(String s, o o1, n n1, i i1, f f1, String s1, q q)
    {
        a(s, "perfKey is required");
        s = (new y()).a("share_ext").b(s).b(o1).c(n1).d(i1).e(f1).h(s1).f(q);
        w.a().a(s);
    }

    protected static void a(String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            com.smule.android.c.aa.b(b, s1);
        }
    }

    public static void a(String s, String s1, f f1)
    {
        a(s1, "songUid is required");
        s = (new y()).a("perf_start_clk").b(s).d(s1).f(f1.a());
        w.a().a(s);
    }

    protected static void a(String s, String s1, f f1, g g1)
    {
        a(s, "perfKey is required");
        a(s1, "songUid is required");
        s = (new y()).a("perf_join_clk").b(s).d(s1).f(f1.a()).a();
        if (g1 != null)
        {
            g1.a(s);
        }
        w.a().a(s);
    }

    public static void a(String s, String s1, f f1, String s2)
    {
        a(s, "perfKey is required");
        a(s1, "songUid is required");
        a(s, s1, f1, s2, ((g) (null)));
    }

    protected static void a(String s, String s1, f f1, String s2, g g1)
    {
        a(s, "perfKey is required");
        a(s1, "songUid is required");
        s = new x("perf_love", s, null, null, s1, null, f1.a(), s2, null, null, null);
        if (g1 != null)
        {
            g1.a(s);
        }
        w.a().a(s);
    }

    public static void a(String s, String s1, String s2)
    {
        a(s, "sku is required");
        a(s1, "period is required");
        s = (new y()).a("subs_buy_clk").b(s).c(s1).d(s2);
        w.a().a(s);
    }

    public static void a(String s, String s1, String s2, String s3)
    {
        s = (new y()).a("subs_buy_fail").b(s).c(s1).d(s2).e(s3);
        w.a().a(s);
    }

    protected static void a(String s, String s1, String s2, String s3, int i1, f f1, g g1)
    {
        a(s3, "songUid is required");
        s = (new y()).a("rec_complete").b(s).c(s2).d(s3).e(Long.toString(i1)).f(f1.a()).h(s1).a();
        if (g1 != null)
        {
            g1.a(s);
        }
        w.a().a(s);
    }

    protected static void a(String s, String s1, String s2, String s3, long l1, f f1, g g1)
    {
        a(s3, "songUid is required");
        s = (new y()).a("rec_cancel").b(s).c(s2).d(s3).e(Long.toString(l1)).f(f1.a()).h(s1).a();
        if (g1 != null)
        {
            g1.a(s);
        }
        w.a().a(s);
    }

    protected static void a(String s, String s1, String s2, String s3, f f1, g g1)
    {
        a(s3, "songUid is required");
        s = (new y()).a("rec_start").b(s).c(s2).d(s3).f(f1.a()).h(s1).a();
        if (g1 != null)
        {
            g1.a(s);
        }
        w.a().a(s);
    }

    public static void a(boolean flag)
    {
        y y1 = (new y()).a("reg_flow_start").c(Boolean.toString(flag)).a(true);
        w.a().a(y1);
    }

    protected static void a(boolean flag, String s)
    {
        if (!flag)
        {
            com.smule.android.c.aa.b(b, s);
        }
    }

    public static void b()
    {
        w.a().a("subs_restore_clk");
    }

    public static void b(String s)
    {
        w.a().a("subs_restore_fail", null, null, s);
    }

    public static void b(String s, o o1, n n1, i i1, f f1)
    {
        a(s, o1, n1, i1, f1, ((String) (null)), ((q) (null)));
    }

    public static void b(String s, String s1, f f1)
    {
        a(s, "perfKey is required");
        a(s1, "songUid is required");
        a(s, s1, f1, ((g) (null)));
    }

    public static void c()
    {
        y y1 = (new y()).a("reg_fbconnect_success").a(true);
        w.a().a(y1);
    }

    public static void c(String s)
    {
        a(s, "referrer is required");
        w.a().a("reg_fbconnect_click", null, s, true);
    }

    public static void d()
    {
        w.a().a("reg_forgotpwd_pgview", true);
    }

    public static void e()
    {
        w.a().a("reg_forgotpwd_success", true);
    }

    public static void f()
    {
        w.a().a("reg_gplusconnect_click", true);
    }

    public static void g()
    {
        w.a().a("reg_gplusconnect_success", true);
    }

    public static void h()
    {
        w.a().a("reg_gplusdisconnect_success", true);
    }

    public static void i()
    {
        y y1 = (new y()).a("reg_landing_exit").a(true);
        w.a().a(y1);
    }

    public static void j()
    {
        y y1 = (new y()).a("reg_landing_pgview").a(true);
        w.a().a(y1);
    }

    public static void k()
    {
        y y1 = (new y()).a("reg_newacct_pgview").a(true);
        w.a().a(y1);
    }

    public static void l()
    {
        w.a().a("reg_profile_update", true);
    }

    public static void m()
    {
        y y1 = (new y()).a("reg_signin_pgview");
        w.a().a(y1);
    }

    public static void n()
    {
        w.a().a("reg_welcome_pgview");
    }

}
