// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            q, ae, ai, aj, 
//            b, e, ac, as, 
//            s, aa, g, ao, 
//            r

final class ar
    implements b.a
{
    static final class a
    {

        String a;
        String b;
        String c;
        String d;
        double e;
        int f;
        int g;
        int h;
        boolean i;
        boolean j;
        boolean k;

        a()
        {
        }
    }


    ac a;
    ArrayList b;
    ArrayList c;
    int d;
    boolean e;

    ar(ac ac1)
    {
        b = new ArrayList();
        c = new ArrayList();
        d = 0;
        e = false;
        a = ac1;
    }

    private void a(String s1, ArrayList arraylist)
    {
        if (arraylist == null || arraylist.size() == 0)
        {
            return;
        }
        for (int i = 0; i < arraylist.size(); i++)
        {
            String s2 = (String)arraylist.get(i);
            a a1 = new a();
            a1.a = s1;
            a1.b = s2;
            a1.k = true;
            b.add(a1);
        }

        e = true;
        q.i = true;
    }

    final void a()
    {
        q.i = true;
        a.c c1 = ai.b(new ae("tracking_info.txt"));
        if (c1 != null)
        {
            b.clear();
            for (int i = 0; i < c1.a.size(); i++)
            {
                a.g g1 = c1.a(i);
                a a1 = new a();
                a1.a = g1.a("type", "");
                a1.b = g1.a("url", "");
                a1.c = g1.a("payload", null);
                a1.f = g1.e("attempts");
                a1.k = g1.a("third_party", false);
                if (a1.a.equals("v4vc_callback") || a1.a.equals("reward_v4vc"))
                {
                    a1.d = g1.a("v4vc_name", "");
                    a1.h = g1.e("v4vc_amount");
                }
                b.add(a1);
            }

        }
        aj.a.a("Loaded ").a(b.size()).b(" events");
    }

    public final void a(b b1)
    {
        a a1;
        char c1;
        c1 = '\u2710';
        q.i = true;
        e = true;
        d = d - 1;
        a1 = (a)b1.e;
        aj.a.a("on_download_finished - event.type = ").b(a1.a);
        a1.j = false;
        boolean flag1 = b1.i;
        boolean flag = flag1;
        if (flag1)
        {
            flag = flag1;
            if (a1.c != null)
            {
                Object obj = ai.a(b1.m);
                if (obj != null)
                {
                    flag1 = ((a.g) (obj)).a("status", "").equals("success");
                    flag = flag1;
                    if (flag1)
                    {
                        flag = flag1;
                        if (a1.a.equals("reward_v4vc"))
                        {
                            if (((a.g) (obj)).a("v4vc_status", false))
                            {
                                obj = ((a.g) (obj)).a("v4vc_callback", "");
                                if (((String) (obj)).length() > 0)
                                {
                                    a a2 = new a();
                                    a2.a = "v4vc_callback";
                                    a2.b = ((String) (obj));
                                    a2.d = a1.d;
                                    a2.h = a1.h;
                                    b.add(a2);
                                    flag = flag1;
                                } else
                                {
                                    if (q.B != null)
                                    {
                                        q.B.n = true;
                                    }
                                    aj.a.b("Client-side V4VC success");
                                    flag = flag1;
                                }
                            } else
                            {
                                aj.a.b("Client-side V4VC failure");
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
            if (a1.a.equals("v4vc_callback"))
            {
                aj.a.b("v4vc_callback response:").b(b1.m);
                if (b1.m.indexOf("vc_success") != -1)
                {
                    if (q.B != null)
                    {
                        q.B.n = true;
                    }
                    aj.a.b("v4vc_callback success");
                    a.a(true, a1.d, a1.h);
                    flag1 = flag;
                } else
                if (b1.m.indexOf("vc_decline") != -1 || b1.m.indexOf("vc_noreward") != -1)
                {
                    aj.c.a("Server-side V4VC failure: ").b(b1.c);
                    aj.a.b("v4vc_callback declined");
                    a.a(false, "", 0);
                    flag1 = flag;
                } else
                {
                    aj.c.a("Server-side V4VC failure: ").b(b1.c);
                    flag1 = false;
                }
            }
        }
        if (!flag1) goto _L2; else goto _L1
_L1:
        aj.a.a("Event submission SUCCESS for type: ").b(a1.a);
        a1.i = true;
_L4:
        if (!a.e.b)
        {
            b();
        }
        return;
_L2:
        aj.a.a("Event submission FAILED for type: ").a(a1.a).a(" on try ").b(a1.f + 1);
        a1.f = a1.f + 1;
        if (a1.f >= 24)
        {
            aj.d.b("Discarding event after 24 attempts to report.");
            a1.i = true;
            if (a1.a.equals("v4vc_callback"))
            {
                a.a(false, "", 0);
            }
        } else
        {
            int i = 20;
            if (a1.g > 0)
            {
                i = a1.g * 3;
            }
            if (i > 10000)
            {
                i = c1;
            }
            aj.a.a("Retrying in ").a(i).a(" seconds (attempt ").a(a1.f).b(")");
            a1.g = i;
            a1.e = s.b() + (double)i;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    final void a(String s1, a.g g1)
    {
        al.k k = a.b.j.k;
        if (k != null)
        {
            a(s1, k.h.a(s1, ""), g1, null);
        }
        g1 = a.b.j.l;
        if (g1 != null)
        {
            a(s1, (ArrayList)((al.ab) (g1)).d.get(s1));
        }
    }

    final void a(String s1, a.g g1, g g2)
    {
        if (s1 == null)
        {
            aj.d.b("No such event type:").b(s1);
            return;
        }
        if (s1.equals("start") || s1.equals("native_start"))
        {
            as as1 = q.c.e;
            as1.i = as1.i + 1;
        }
        a.g g3 = g1;
        if (g1 == null)
        {
            g3 = new a.g();
            g3.b("replay", g2.n);
        }
        g3.a("s_imp_count", q.c.e.i);
        a(s1, g2.d.s.D.a(s1, ""), g3, g2);
        a(s1, (ArrayList)g2.d.p.C.get(s1));
    }

    final void a(String s1, String s2, a.g g1, g g2)
    {
        if (s2 == null || s2.equals(""))
        {
            return;
        }
        a.g g3 = g1;
        if (g1 == null)
        {
            g3 = new a.g();
        }
        g1 = s.a();
        if (g2 != null)
        {
            g3.b("asi", g2.g);
        }
        g3.b("sid", a.e.j);
        g3.b("guid", g1);
        g3.b("guid_key", s.b((new StringBuilder()).append(g1).append("DUBu6wJ27y6xs7VWmNDw67DD").toString()));
        g1 = new a();
        g1.a = s1;
        g1.b = s2;
        aj.a.b("EVENT ---------------------------");
        aj.a.a("EVENT - TYPE = ").b(s1);
        aj.a.a("EVENT - URL  = ").b(s2);
        g1.c = g3.o();
        if (s1.equals("reward_v4vc"))
        {
            g1.d = g3.a("v4vc_name", "");
            g1.h = g3.e("v4vc_amount");
        }
        b.add(g1);
        e = true;
        q.i = true;
    }

    final void b()
    {
        c.clear();
        c.addAll(b);
        b.clear();
        a.c c1 = new a.c();
        for (int i = 0; i < c.size(); i++)
        {
            a a1 = (a)c.get(i);
            if (a1.i)
            {
                continue;
            }
            b.add(a1);
            a.g g1 = new a.g();
            g1.b("type", a1.a);
            g1.b("url", a1.b);
            if (a1.c != null)
            {
                g1.b("payload", a1.c);
            }
            g1.a("attempts", a1.f);
            if (a1.d != null)
            {
                g1.b("v4vc_name", a1.d);
                g1.a("v4vc_amount", a1.h);
            }
            if (a1.k)
            {
                g1.b("third_party", true);
            }
            c1.a(g1);
        }

        c.clear();
        aj.a.a("Saving tracking_info (").a(b.size()).b(" events)");
        ai.a(new ae("tracking_info.txt"), c1);
    }

    final void c()
    {
        if (b.size() != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        for (; b.size() > 1000; b.remove(b.size() - 1)) { }
        if (!ao.c()) goto _L1; else goto _L3
_L3:
        double d1;
        int i;
        d1 = s.b();
        i = 0;
_L6:
        if (i >= b.size()) goto _L1; else goto _L4
_L4:
        a a1;
        a1 = (a)b.get(i);
        if (a1.e >= d1 || a1.j)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        if (d == 5) goto _L1; else goto _L5
_L5:
        d = d + 1;
        a1.j = true;
        if (a1.a.equals("v4vc_callback"))
        {
            q.P.add(a1.b);
        }
        b b1 = new b(a, a1.b, this);
        b1.e = a1;
        if (a1.k)
        {
            b1.h = true;
        }
        if (a1.c != null)
        {
            String s1 = a1.c;
            b1.f = "application/json";
            b1.g = s1;
        }
        aj.b.a("Submitting '").a(a1.a).b("' event.");
        r.a(b1);
        q.i = true;
        i++;
          goto _L6
    }
}
