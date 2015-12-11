// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            l, s, q, bl, 
//            h, bq, ay, ak, 
//            k, dc, bk, o, 
//            be, dd, ap, bc, 
//            bx, by, cp, bo, 
//            bu, cq, bt, br, 
//            bg, d, cx

class db
    implements l
{

    be a;
    ArrayList b;
    ArrayList c;
    int d;
    boolean e;

    db(be be1)
    {
        b = new ArrayList();
        c = new ArrayList();
        d = 0;
        e = false;
        a = be1;
    }

    void a()
    {
        b();
        d = 0;
    }

    void a(double d1, s s1)
    {
        double d2 = s1.i;
        if (d1 < d2)
        {
            return;
        }
        if (d2 < 0.25D && d1 >= 0.25D)
        {
            if (!q.c(s1.b) && s1.f.equals("native"))
            {
                b("native_first_quartile", s1);
            } else
            {
                b("first_quartile", s1);
            }
        }
        if (d2 < 0.5D && d1 >= 0.5D)
        {
            if (!q.c(s1.b) && s1.f.equals("native"))
            {
                b("native_midpoint", s1);
            } else
            {
                b("midpoint", s1);
            }
        }
        if (d2 < 0.75D && d1 >= 0.75D)
        {
            if (!q.c(s1.b) && s1.f.equals("native"))
            {
                b("native_third_quartile", s1);
            } else
            {
                b("third_quartile", s1);
            }
        }
        if (d2 < 1.0D && d1 >= 1.0D && !s1.f.equals("native"))
        {
            bl.a.a("Tracking ad event - complete");
            h h1 = new h();
            if (s1.m)
            {
                h1.b("ad_slot", s1.c.k.d);
            } else
            {
                h1.b("ad_slot", s1.c.k.d);
            }
            h1.b("replay", s1.n);
            a("complete", h1, s1);
        }
        s1.i = d1;
    }

    public void a(k k1)
    {
        dc dc1;
        char c1;
        c1 = '\u2710';
        ak.i = true;
        e = true;
        d = d - 1;
        dc1 = (dc)k1.e;
        bl.a.a("on_download_finished - event.type = ").b(dc1.a);
        dc1.j = false;
        boolean flag1 = k1.i;
        boolean flag = flag1;
        if (flag1)
        {
            flag = flag1;
            if (dc1.c != null)
            {
                Object obj = bk.b(k1.m);
                if (obj != null)
                {
                    flag1 = ((h) (obj)).d("status").equals("success");
                    flag = flag1;
                    if (flag1)
                    {
                        flag = flag1;
                        if (dc1.a.equals("reward_v4vc"))
                        {
                            if (((h) (obj)).g("v4vc_status"))
                            {
                                obj = ((h) (obj)).d("v4vc_callback");
                                if (((String) (obj)).length() > 0)
                                {
                                    dc dc2 = new dc();
                                    dc2.a = "v4vc_callback";
                                    dc2.b = ((String) (obj));
                                    dc2.d = dc1.d;
                                    dc2.h = dc1.h;
                                    b.add(dc2);
                                    flag = flag1;
                                } else
                                {
                                    if (ak.B != null)
                                    {
                                        ak.B.n = true;
                                    }
                                    bl.a.b("Client-side V4VC success");
                                    flag = flag1;
                                }
                            } else
                            {
                                bl.a.b("Client-side V4VC failure");
                                flag = flag1;
                            }
                        }
                    }
                } else
                {
                    flag = false;
                }
            }
        }
        flag1 = flag;
        if (flag)
        {
            flag1 = flag;
            if (dc1.a.equals("v4vc_callback"))
            {
                bl.a.b("v4vc_callback response:").b(k1.m);
                if (k1.m.indexOf("vc_success") != -1)
                {
                    if (ak.B != null)
                    {
                        ak.B.n = true;
                    }
                    bl.a.b("v4vc_callback success");
                    a.a(true, dc1.d, dc1.h);
                    flag1 = flag;
                } else
                if (k1.m.indexOf("vc_decline") != -1 || k1.m.indexOf("vc_noreward") != -1)
                {
                    bl.c.a("Server-side V4VC failure: ").b(k1.c);
                    bl.a.b("v4vc_callback declined");
                    a.a(false, "", 0);
                    flag1 = flag;
                } else
                {
                    bl.c.a("Server-side V4VC failure: ").b(k1.c);
                    flag1 = false;
                }
            }
        }
        if (!flag1) goto _L2; else goto _L1
_L1:
        bl.a.a("Event submission SUCCESS for type: ").b(dc1.a);
        dc1.i = true;
_L4:
        if (!a.e.b)
        {
            c();
        }
        return;
_L2:
        bl.a.a("Event submission FAILED for type: ").a(dc1.a).a(" on try ").b(dc1.f + 1);
        dc1.f = dc1.f + 1;
        if (dc1.f >= 24)
        {
            bl.d.b("Discarding event after 24 attempts to report.");
            dc1.i = true;
            if (dc1.a.equals("v4vc_callback"))
            {
                a.a(false, "", 0);
            }
        } else
        {
            int i = 20;
            if (dc1.g > 0)
            {
                i = dc1.g * 3;
            }
            if (i > 10000)
            {
                i = c1;
            }
            bl.a.a("Retrying in ").a(i).a(" seconds (attempt ").a(dc1.f).b(")");
            dc1.g = i;
            dc1.e = ap.b() + (double)i;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void a(String s1, h h1)
    {
        by by1 = a.b.j.k;
        if (by1 != null)
        {
            a(s1, by1.h.d(s1), h1);
        }
        h1 = a.b.j.l;
        if (h1 != null)
        {
            a(s1, (ArrayList)((cp) (h1)).d.get(s1));
        }
    }

    void a(String s1, h h1, s s2)
    {
        if (s1 == null)
        {
            bl.d.b("No such event type:").b(s1);
            return;
        }
        if (s1.equals("start") || s1.equals("native_start"))
        {
            dd dd1 = ak.c.e;
            dd1.i = dd1.i + 1;
        }
        h h2 = h1;
        if (h1 == null)
        {
            h2 = new h();
            h2.b("replay", s2.n);
        }
        h2.b("s_imp_count", ak.c.e.i);
        a(s1, s2.d.s.D.d(s1), h2, s2);
        a(s1, (ArrayList)s2.d.p.C.get(s1));
    }

    void a(String s1, s s2)
    {
        if (a != null && a.b != null && a.b.j != null && a.b.j.n != null && a.b.j.n.a(s1) != null)
        {
            bl.a.a("Ad request for zone ").b(s1);
            s1 = a.b.j.n.a(s1);
            if (s1 != null && ((bq) (s1)).h != null && ((bq) (s1)).h.a != null)
            {
                h h1 = new h();
                if (ak.T == 0)
                {
                    h1.b("request_denied", false);
                } else
                {
                    h1.b("request_denied", true);
                }
                h1.b("request_denied_reason", ak.T);
                a("request", ((bq) (s1)).h.a, h1, s2);
                bl.a.a("Tracking ad request - URL : ").b(((bq) (s1)).h.a);
                return;
            }
        }
    }

    void a(String s1, String s2, h h1)
    {
        a(s1, s2, h1, null);
    }

    void a(String s1, String s2, h h1, s s3)
    {
        if (s2 == null || s2.equals(""))
        {
            return;
        }
        h h2 = h1;
        if (h1 == null)
        {
            h2 = new h();
        }
        h1 = ap.a();
        if (s3 != null)
        {
            h2.b("asi", s3.g);
        }
        h2.b("sid", a.e.j);
        h2.b("guid", h1);
        h2.b("guid_key", ap.b((new StringBuilder()).append(h1).append("DUBu6wJ27y6xs7VWmNDw67DD").toString()));
        h1 = new dc();
        h1.a = s1;
        h1.b = s2;
        bl.a.b("EVENT ---------------------------");
        bl.a.a("EVENT - TYPE = ").b(s1);
        bl.a.a("EVENT - URL  = ").b(s2);
        h1.c = h2.p();
        if (s1.equals("reward_v4vc"))
        {
            h1.d = h2.d("v4vc_name");
            h1.h = h2.f("v4vc_amount");
        }
        b.add(h1);
        e = true;
        ak.i = true;
    }

    void a(String s1, ArrayList arraylist)
    {
        if (arraylist == null || arraylist.size() == 0)
        {
            return;
        }
        for (int i = 0; i < arraylist.size(); i++)
        {
            String s2 = (String)arraylist.get(i);
            dc dc1 = new dc();
            dc1.a = s1;
            dc1.b = s2;
            dc1.k = true;
            b.add(dc1);
        }

        e = true;
        ak.i = true;
    }

    void b()
    {
        ak.i = true;
        d d1 = bk.c(new bg("tracking_info.txt"));
        if (d1 != null)
        {
            b.clear();
            for (int i = 0; i < d1.a_(); i++)
            {
                h h1 = d1.a(i);
                dc dc1 = new dc();
                dc1.a = h1.d("type");
                dc1.b = h1.d("url");
                dc1.c = h1.a("payload", null);
                dc1.f = h1.f("attempts");
                dc1.k = h1.g("third_party");
                if (dc1.a.equals("v4vc_callback") || dc1.a.equals("reward_v4vc"))
                {
                    dc1.d = h1.d("v4vc_name");
                    dc1.h = h1.f("v4vc_amount");
                }
                b.add(dc1);
            }

        }
        bl.a.a("Loaded ").a(b.size()).b(" events");
    }

    void b(String s1, s s2)
    {
        a(s1, ((h) (null)), s2);
    }

    void c()
    {
        c.clear();
        c.addAll(b);
        b.clear();
        d d1 = new d();
        for (int i = 0; i < c.size(); i++)
        {
            dc dc1 = (dc)c.get(i);
            if (dc1.i)
            {
                continue;
            }
            b.add(dc1);
            h h1 = new h();
            h1.b("type", dc1.a);
            h1.b("url", dc1.b);
            if (dc1.c != null)
            {
                h1.b("payload", dc1.c);
            }
            h1.b("attempts", dc1.f);
            if (dc1.d != null)
            {
                h1.b("v4vc_name", dc1.d);
                h1.b("v4vc_amount", dc1.h);
            }
            if (dc1.k)
            {
                h1.b("third_party", true);
            }
            d1.a(h1);
        }

        c.clear();
        bl.a.a("Saving tracking_info (").a(b.size()).b(" events)");
        bk.a(new bg("tracking_info.txt"), d1);
    }

    void d()
    {
        if (e)
        {
            e = false;
            c();
        }
        e();
    }

    void e()
    {
        if (b.size() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        for (; b.size() > 1000; b.remove(b.size() - 1)) { }
        if (!cx.c()) goto _L1; else goto _L3
_L3:
        double d1;
        int i;
        d1 = ap.b();
        i = 0;
_L6:
        if (i >= b.size()) goto _L1; else goto _L4
_L4:
        dc dc1;
        dc1 = (dc)b.get(i);
        if (dc1.e >= d1 || dc1.j)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        if (d == 5) goto _L1; else goto _L5
_L5:
        d = d + 1;
        dc1.j = true;
        if (dc1.a.equals("v4vc_callback"))
        {
            ak.P.add(dc1.b);
        }
        k k1 = (new k(a, dc1.b, this)).a(dc1);
        if (dc1.k)
        {
            k1.h = true;
        }
        if (dc1.c != null)
        {
            k1.a("application/json", dc1.c);
        }
        bl.b.a("Submitting '").a(dc1.a).b("' event.");
        k1.a();
        ak.i = true;
        i++;
          goto _L6
    }
}
