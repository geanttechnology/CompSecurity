// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

// Referenced classes of package com.jirbo.adcolony:
//            ab, aa, am, ar, 
//            as, d, y, aq, 
//            o, q, g, x, 
//            e, aj, AdColonyOverlay, AdColonyFullscreen, 
//            s, j, ah, f, 
//            ae, ai, af, aw, 
//            ao, z

public final class ac
{

    ab a;
    public aa b;
    am c;
    ar d;
    as e;
    d f;
    y g;
    aq h;
    ArrayList i;
    ArrayList j;
    volatile boolean k;
    boolean l;
    s.a m;

    ac()
    {
        a = new ab(this);
        b = new aa(this);
        c = new am(this);
        d = new ar(this);
        e = new as(this);
        f = new d(this);
        g = new y(this);
        h = new aq(this);
        i = new ArrayList();
        j = new ArrayList();
        m = new s.a();
    }

    private void b(o o1)
    {
        this;
        JVM INSTR monitorenter ;
        ab ab1 = a;
        o1 = o1.b;
        ab1.l = ab1.a.b.j.n.a(o1);
        ab1.m = ab1.l.a();
        o1 = ab1.a.c;
        al.b b1 = ab1.m.u;
        ab1.i.b("video_enabled", b1.a);
        ab1.i.b("video_filepath", b1.a());
        ab1.i.a("video_width", b1.b);
        ab1.i.a("video_height", b1.c);
        ab1.i.a("video_duration", b1.k);
        ab1.i.a("engagement_delay", b1.m.e);
        ab1.i.a("skip_delay", b1.l.e);
        ab1.a();
        al.h h1 = ab1.m.r;
        ab1.i.b("pre_popup_bg", o1.b(h1.b.d.e));
        ab1.i.b("v4vc_logo", o1.b(h1.b.d.l.d));
        ab1.i.b("no_button_normal", o1.b(h1.b.d.n.f));
        ab1.i.b("no_button_down", o1.b(h1.b.d.n.h));
        ab1.i.b("yes_button_normal", o1.b(h1.b.d.m.f));
        ab1.i.b("yes_button_down", o1.b(h1.b.d.m.h));
        ab1.i.b("done_button_normal", o1.b(h1.c.d.m.f));
        ab1.i.b("done_button_down", o1.b(h1.c.d.m.h));
        ab1.i.b("browser_close_image_normal", o1.b(ab1.m.q.k.f));
        ab1.i.b("browser_close_image_down", o1.b(ab1.m.q.k.h));
        ab1.i.b("browser_reload_image_normal", o1.b(ab1.m.q.m.f));
        ab1.i.b("browser_reload_image_down", o1.b(ab1.m.q.m.h));
        ab1.i.b("browser_back_image_normal", o1.b(ab1.m.q.j.f));
        ab1.i.b("browser_back_image_down", o1.b(ab1.m.q.j.h));
        ab1.i.b("browser_forward_image_normal", o1.b(ab1.m.q.l.f));
        ab1.i.b("browser_forward_image_down", o1.b(ab1.m.q.l.h));
        ab1.i.b("browser_stop_image_normal", o1.b(ab1.m.q.i.f));
        ab1.i.b("browser_stop_image_down", o1.b(ab1.m.q.i.h));
        ab1.i.b("browser_glow_button", o1.b(ab1.m.q.a));
        ab1.i.b("browser_icon", o1.b(ab1.m.q.h.d));
        ab1.i.b("skip_video_image_normal", o1.b(b1.l.f));
        ab1.i.b("skip_video_image_down", o1.b(b1.l.h));
        ab1.i.b("engagement_image_normal", o1.b(b1.m.f));
        ab1.i.b("engagement_image_down", o1.b(b1.m.h));
        ab1.i.a("engagement_height", b1.m.c);
        ab1.i.b("image_overlay_enabled", b1.n.a);
        ab1.i.b("image_overlay_filepath", o1.b(b1.n.f));
        ab1.i.b("haptics_enabled", b1.o.a);
        ab1.i.b("haptics_filepath", o1.b(b1.o.b));
        ab1.i.b("v4iap_enabled", ab1.m.w.c);
        ab1.i.b("product_id", ab1.m.w.a);
        ab1.i.b("in_progress", ab1.m.w.b);
        this;
        JVM INSTR monitorexit ;
        return;
        o1;
        throw o1;
    }

    private boolean b(g g1)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        al.c c1 = a.l;
        if (c1.b > 1) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L5:
        if (i1 == 0) goto _L4; else goto _L3
_L3:
        q.A.a = 3;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        q.c.g.b = true;
        x x1 = c1.k;
        i1 = x1.b;
        x1.b = i1 + 1;
label0:
        {
            if (i1 != 0)
            {
                break label0;
            }
            i1 = 0;
        }
          goto _L5
        if (c1.k.b >= c1.b)
        {
            c1.k.b = 0;
        }
          goto _L6
_L4:
        a(g1);
        com.jirbo.adcolony.e.a();
        if (q.d)
        {
            aj.a.b("Launching AdColonyOverlay");
            g1 = new Intent(q.b(), com/jirbo/adcolony/AdColonyOverlay);
            q.b().startActivity(g1);
            break MISSING_BLOCK_LABEL_199;
        }
        aj.a.b("Launching AdColonyFullscreen");
        g1 = new Intent(q.b(), com/jirbo/adcolony/AdColonyFullscreen);
        q.b().startActivity(g1);
        break MISSING_BLOCK_LABEL_199;
        g1;
        throw g1;
_L6:
        i1 = 1;
          goto _L5
        flag = true;
          goto _L7
    }

    final int a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = a.i.e(s1);
_L2:
        this;
        JVM INSTR monitorexit ;
        return i1;
        s1;
        q.a(s1);
        i1 = 0;
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        throw s1;
    }

    final void a()
    {
        k = true;
        new ah(this) {

            final ac a;

            final void a()
            {
                as as1 = n.e;
                aj.b.b("AdColony resuming");
                q.i = true;
                if (as1.b)
                {
                    aj.d.b("AdColony.onResume() called multiple times in succession.");
                }
                as1.b = true;
                a.g g1 = ai.a(new ae("session_info.txt"));
                double d1;
                if (g1 != null)
                {
                    as1.c = g1.a("allow_resume", false);
                    as1.f = g1.d("start_time");
                    as1.g = g1.d("finish_time");
                    as1.h = g1.d("session_time");
                } else
                {
                    as1.d = true;
                }
                d1 = s.b();
                if (as1.c)
                {
                    if (d1 - as1.g > (double)as1.a.a.d)
                    {
                        as1.a(as1.h);
                        as1.f = d1;
                        as1.b();
                    }
                    as1.c = false;
                    as1.a();
                } else
                {
                    as1.f = d1;
                    as1.b();
                }
                q.f();
            }

            
            {
                a = ac.this;
                super(ac2);
            }
        };
    }

    final void a(double d1, g g1)
    {
        new ah(this, d1, g1) {

            final double a;
            final g b;
            final ac c;

            final void a()
            {
                ar ar1 = n.d;
                double d2 = a;
                g g2 = b;
                double d3 = g2.i;
                if (d2 >= d3)
                {
                    if (d3 < 0.25D && d2 >= 0.25D)
                    {
                        if (!com.jirbo.adcolony.f.a(g2.b) && g2.f.equals("native"))
                        {
                            ar1.a("native_first_quartile", null, g2);
                        } else
                        {
                            ar1.a("first_quartile", null, g2);
                        }
                    }
                    if (d3 < 0.5D && d2 >= 0.5D)
                    {
                        if (!com.jirbo.adcolony.f.a(g2.b) && g2.f.equals("native"))
                        {
                            ar1.a("native_midpoint", null, g2);
                        } else
                        {
                            ar1.a("midpoint", null, g2);
                        }
                    }
                    if (d3 < 0.75D && d2 >= 0.75D)
                    {
                        if (!com.jirbo.adcolony.f.a(g2.b) && g2.f.equals("native"))
                        {
                            ar1.a("native_third_quartile", null, g2);
                        } else
                        {
                            ar1.a("third_quartile", null, g2);
                        }
                    }
                    if (d3 < 1.0D && d2 >= 1.0D && !g2.f.equals("native"))
                    {
                        aj.a.a("Tracking ad event - complete");
                        a.g g3 = new a.g();
                        g3.a("ad_slot", g2.c.k.d);
                        g3.b("replay", g2.n);
                        ar1.a("complete", g3, g2);
                    }
                    g2.i = d2;
                }
            }

            
            {
                c = ac.this;
                a = d1;
                b = g1;
                super(ac2);
            }
        };
    }

    final void a(ah ah1)
    {
label0:
        {
            synchronized (i)
            {
                if (q.d())
                {
                    break label0;
                }
            }
            return;
        }
        i.add(ah1);
        if (!k)
        {
            e();
        }
        arraylist;
        JVM INSTR monitorexit ;
        return;
        ah1;
        arraylist;
        JVM INSTR monitorexit ;
        throw ah1;
    }

    final void a(g g1)
    {
        this;
        JVM INSTR monitorenter ;
        a.n = 0.0D;
        aj.a.b("Tracking ad event - start");
        x x1 = g1.c.k;
        x1.d = x1.d + 1;
        if (!g1.d())
        {
            g1.c.b();
            h.a(g1.b, g1.d.d);
        }
        new ah(this, g1) {

            final g a;
            final ac b;

            final void a()
            {
                if (com.jirbo.adcolony.f.a(a.b) || !a.f.equals("native"))
                {
                    b.a("start", (new StringBuilder("{\"ad_slot\":")).append(a.c.k.d).append(", \"replay\":").append(a.n).append("}").toString(), a);
                }
            }

            
            {
                b = ac.this;
                a = g1;
                super(ac2);
            }
        };
        this;
        JVM INSTR monitorexit ;
        return;
        g1;
        throw g1;
    }

    final void a(String s1, String s2, g g1)
    {
        new ah(this, s1, s2, g1) {

            final String a;
            final String b;
            final g c;
            final ac d;

            final void a()
            {
                n.d.a(a, ai.a(b), c);
            }

            
            {
                d = ac.this;
                a = s1;
                b = s2;
                c = g1;
                super(ac2);
            }
        };
    }

    public final void a(String s1, String s2, String as1[])
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        int j1;
        q.a(q.e);
        aj.c.a("==== Configuring AdColony ").a(a.b).b(" ====");
        aj.a.a("package name: ").b(s.e());
        a.j = s2;
        a.k = as1;
        s2 = a;
        s1 = s1.split(",");
        j1 = s1.length;
_L9:
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        Object obj = s1[i1].split(":");
        if (obj.length != 2) goto _L2; else goto _L1
_L1:
        as1 = obj[0];
        obj = obj[1];
        if (as1.equals("version"))
        {
            s2.q = ((String) (obj));
            break MISSING_BLOCK_LABEL_265;
        }
        if (!as1.equals("store")) goto _L4; else goto _L3
_L6:
        q.a(s1);
_L7:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        if (((String) (obj)).toLowerCase().equals("google") || ((String) (obj)).toLowerCase().equals("amazon"))
        {
            s2.r = ((String) (obj));
            break MISSING_BLOCK_LABEL_265;
        }
        try
        {
            throw new j("Origin store in client options must be set to either 'google' or 'amazon'");
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        finally
        {
            this;
        }
        if (true) goto _L6; else goto _L5
_L5:
        JVM INSTR monitorexit ;
        throw s1;
_L4:
        if (as1.equals("skippable"))
        {
            s2.s = false;
        }
        break MISSING_BLOCK_LABEL_265;
_L2:
        if (obj[0].equals("skippable"))
        {
            s2.s = false;
        }
        break MISSING_BLOCK_LABEL_265;
        m.a = System.currentTimeMillis();
          goto _L7
        i1++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    final void a(boolean flag, g g1)
    {
        int i1;
        int j1;
        j1 = 0;
        i1 = 1;
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        if (g1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a(1.0D, g1);
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        o o1;
        String s1;
        int k1;
        int l1;
        if (!g1.d())
        {
            continue; /* Loop/switch isn't completed */
        }
        g1.c.b();
        h.a(g1.b, g1.d.d);
        o1 = (o)q.A;
        s1 = o1.e();
        k1 = o1.f();
        l1 = o1.g();
        if (l1 <= 1)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        i1 = h.b(o1.e()) + 1;
        aq aq1;
        String s2;
        if (i1 >= l1)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            boolean flag2 = false;
            j1 = i1;
            i1 = ((flag2) ? 1 : 0);
        }
        aq1 = h;
        s2 = o1.e();
        aq1.d.put(s2, Integer.valueOf(j1));
        aq1.e = true;
        if (i1 == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (o1.c.j.e)
        {
            a(true, s1, k1);
        }
        new ah(this, s1, k1, g1) {

            final String a;
            final int b;
            final g c;
            final ac d;

            final void a()
            {
                a.g g2 = new a.g();
                g2.b("v4vc_name", a);
                g2.a("v4vc_amount", b);
                n.d.a("reward_v4vc", g2, c);
            }

            
            {
                d = ac.this;
                a = s1;
                b = i1;
                c = g1;
                super(ac2);
            }
        };
        if (true) goto _L1; else goto _L3
_L3:
        g1;
        throw g1;
    }

    final void a(boolean flag, String s1, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        q.b b1 = q.E;
        if (!flag)
        {
            s1 = null;
        }
        b1.sendMessage(b1.obtainMessage(i1, s1));
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    final boolean a(o o1)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        String s1;
        boolean flag1;
        q.A = o1;
        s1 = o1.b;
        flag1 = f(s1);
        if (flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        aj.a.a("Showing v4vc for zone ").b(s1);
        b(o1);
        flag1 = b(o1);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        o1;
        q.a(o1);
        if (true) goto _L1; else goto _L3
_L3:
        o1;
        throw o1;
    }

    final boolean a(String s1, boolean flag, boolean flag1)
    {
        boolean flag3 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag2 = q.d();
        if (flag2) goto _L2; else goto _L1
_L1:
        flag2 = flag3;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag2;
_L2:
        flag2 = flag3;
        try
        {
            if (b.a(s1, flag))
            {
                flag2 = b.j.n.a(s1).a(flag1);
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        finally
        {
            this;
        }
        q.a(s1);
        flag2 = flag3;
        if (true) goto _L4; else goto _L3
_L3:
        throw s1;
    }

    final void b()
    {
        k = false;
        new ah(this) {

            final ac a;

            final void a()
            {
                as as1 = n.e;
                aj.b.b("AdColony suspending");
                q.i = true;
                if (!as1.b)
                {
                    aj.d.b("AdColony.onPause() called without initial call to onResume().");
                }
                as1.b = false;
                as1.c = true;
                as1.g = s.b();
                as1.a();
            }

            
            {
                a = ac.this;
                super(ac2);
            }
        };
    }

    final boolean b(String s1)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = a.i.a(s1, false);
        flag = flag1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag;
        s1;
        q.a(s1);
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        throw s1;
    }

    final boolean b(String s1, boolean flag, boolean flag1)
    {
        boolean flag3 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag2 = q.d();
        if (flag2) goto _L2; else goto _L1
_L1:
        flag2 = flag3;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag2;
_L2:
        flag2 = flag3;
        try
        {
            if (b.a(s1, flag))
            {
                flag2 = b.j.n.a(s1).b(flag1);
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        finally
        {
            this;
        }
        q.a(s1);
        flag2 = flag3;
        if (true) goto _L4; else goto _L3
_L3:
        throw s1;
    }

    final String c()
    {
        String s1;
        Object obj;
        s1 = null;
        obj = null;
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        aa aa1;
        boolean flag;
        aa1 = b;
        flag = aa1.b;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L4:
        i1++;
_L2:
        obj = s1;
        if (i1 >= aa1.j.n.a.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = aa1.j.n.a(i1);
        if (!((al.c) (obj)).a(true)) goto _L4; else goto _L3
_L3:
        s1 = ((al.c) (obj)).a;
        if (!((al.c) (obj)).a(false, true)) goto _L4; else goto _L5
_L5:
        obj = ((al.c) (obj)).a;
        if (true) goto _L1; else goto _L6
_L6:
        Exception exception;
        exception;
        throw exception;
    }

    final String c(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = a.i.a(s1, "");
_L2:
        this;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        q.a(s1);
        s1 = null;
        if (true) goto _L2; else goto _L1
_L1:
        s1;
        throw s1;
    }

    final int d(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = h.b(s1);
        this;
        JVM INSTR monitorexit ;
        return i1;
        s1;
        throw s1;
    }

    final String d()
    {
        String s1;
        Object obj;
        s1 = null;
        obj = null;
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        aa aa1;
        boolean flag;
        aa1 = b;
        flag = aa1.b;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L4:
        i1++;
_L2:
        obj = s1;
        if (i1 >= aa1.j.n.a.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = aa1.j.n.a(i1);
        if (!((al.c) (obj)).b(true)) goto _L4; else goto _L3
_L3:
        s1 = ((al.c) (obj)).a;
        if (!((al.c) (obj)).a(false, true)) goto _L4; else goto _L5
_L5:
        obj = ((al.c) (obj)).a;
        if (true) goto _L1; else goto _L6
_L6:
        Exception exception;
        exception;
        throw exception;
    }

    final void e()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = q.c();
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (l) goto _L4; else goto _L3
_L3:
        flag = q.d();
        if (!flag) goto _L4; else goto _L5
_L5:
        if (l && (k || i.size() <= 0)) goto _L7; else goto _L6
_L6:
        l = true;
        j.addAll(i);
        i.clear();
        int i1 = 0;
_L56:
        if (i1 >= j.size()) goto _L9; else goto _L8
_L8:
        if (j.get(i1) != null)
        {
            ((ah)j.get(i1)).a();
        }
          goto _L10
_L9:
        j.clear();
          goto _L5
        Object obj;
        obj;
        l = false;
        j.clear();
        i.clear();
        q.a(((RuntimeException) (obj)));
_L4:
        if (q.g) goto _L12; else goto _L11
_L11:
        ab ab1 = a;
_L14:
        if (f.a)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = ab1.e;
        if (i1 >= 60)
        {
            break; /* Loop/switch isn't completed */
        }
        ab1.e = ab1.e + 1;
        Thread.sleep(50L);
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L14; else goto _L13
_L7:
        l = false;
        if (true) goto _L4; else goto _L15
_L15:
        JVM INSTR monitorexit ;
        throw obj;
_L13:
        Object obj1;
        Object obj2;
        ab1.e = 0;
        obj1 = ab1.a.g;
        obj2 = ai.b(new ae("zone_state.txt"));
        if (obj2 == null) goto _L17; else goto _L16
_L16:
        ((y) (obj1)).c.clear();
        i1 = 0;
_L57:
        if (i1 >= ((a.c) (obj2)).a.size()) goto _L17; else goto _L18
_L18:
        a.g g1;
        x x1;
        g1 = ((a.c) (obj2)).a(i1);
        x1 = new x();
        if (g1 != null) goto _L20; else goto _L19
_L19:
        int j1 = 0;
_L23:
        if (!j1)
        {
            break; /* Loop/switch isn't completed */
        }
        String as1[];
        try
        {
            ((y) (obj1)).c.add(x1);
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        finally
        {
            this;
        }
          goto _L21
_L20:
        x1.a = g1.a("uuid", "error");
        x1.b = g1.e("skipped_plays");
        x1.c = g1.e("play_order_index");
        j1 = 1;
        if (true) goto _L23; else goto _L22
_L17:
        as1 = ((y) (obj1)).a.a.k;
        j1 = as1.length;
        i1 = 0;
_L25:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        ((y) (obj1)).a(as1[i1]);
        i1++;
        if (true) goto _L25; else goto _L24
_L24:
        ab1.K = ab.a(af.a, "");
        ab1.L = af.b;
        if (q.x != null) goto _L27; else goto _L26
_L26:
        obj1 = "";
_L46:
        ab1.t = ab.a(((String) (obj1)), "");
        if (ab1.K.equals("")) goto _L29; else goto _L28
_L28:
        obj1 = "";
_L47:
        ab1.u = ((String) (obj1));
        if (q.x != null) goto _L31; else goto _L30
_L30:
        obj1 = "";
_L49:
        ab1.w = ab.a(((String) (obj1)), "");
        if (ab1.y != null) goto _L33; else goto _L32
_L32:
        if (q.x != null) goto _L35; else goto _L34
_L34:
        obj1 = "";
_L50:
        ab1.y = ab.a(((String) (obj1)), "");
_L33:
        ab1.z = ab.a(Build.MANUFACTURER, "");
        ab1.A = ab.a(Build.MODEL, "");
        ab1.E = ab.a(Locale.getDefault().getLanguage(), "en");
        ab1.F = ab.a("", "");
        ab1.G = ab.a(android.os.Build.VERSION.RELEASE, "");
        ab1.J = ab.a((new StringBuilder()).append(android.os.Build.VERSION.SDK_INT).toString(), "");
        ab1.C = ab.a("", "");
        ab1.D = "";
        ab1.H = ab.a((new StringBuilder()).append(af.a()).toString(), "");
        obj1 = new StringBuilder();
        as1 = Runtime.getRuntime();
        ab1.I = ab.a(((StringBuilder) (obj1)).append((as1.totalMemory() - as1.freeMemory()) / 0x100000L).toString(), "");
        if (s.c() && s.d())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ab1.M = flag;
        q.M = ab1.G;
        q.N = ab1.b;
        if (!q.d) goto _L37; else goto _L36
_L36:
        ab1.B = "tablet";
_L51:
        ab1.v = "";
        if (s.a("com.android.vending") || s.a("com.android.market"))
        {
            ab1.v = "google";
        }
        if (s.a("com.amazon.venezia"))
        {
            if (ab1.v.length() > 0)
            {
                ab1.v = (new StringBuilder()).append(ab1.v).append(",").toString();
            }
            ab1.v = (new StringBuilder()).append(ab1.v).append("amazon").toString();
        }
        if (aj.b.f)
        {
            aj.b.a("sdk_version:").b(ab1.b);
            aj.b.a("ad_manifest_url:").b(ab.c);
            aj.b.a("app_id:").b(ab1.j);
            aj.b.a("zone_ids:").b(ab1.k);
            aj.b.a("os_name:").b(ab1.o);
            aj.b.a("sdk_type:").b(ab1.p);
            aj.b.a("app_version:").b(ab1.q);
            aj.b.a("origin_store:").b(ab1.r);
            aj.b.a("skippable:").b(ab1.s);
            aj.b.a("android_id:").b(ab1.t);
            aj.b.a("android_id_sha1:").b(ab1.u);
            aj.b.a("available_stores:").b(ab1.v);
            aj.b.a("carrier_name:").b(ab1.w);
            aj.b.a("custom_id:").b(ab1.x);
            aj.b.a("device_id:").b(ab1.y);
            aj.b.a("device_manufacturer:").b(ab1.z);
            aj.b.a("device_model:").b(ab1.A);
            aj.b.a("device_type:").b(ab1.B);
            aj.b.a("imei:").b(ab1.C);
            aj.b.a("imei_sha1:").b(ab1.D);
            aj.b.a("language:").b(ab1.E);
            aj.b.a("open_udid:").b(ab1.F);
            aj.b.a("os_version:").b(ab1.G);
        }
        obj1 = new aw();
        ((aw) (obj1)).a("&os_name=");
        ((aw) (obj1)).a(ao.a(ab1.o));
        ((aw) (obj1)).a("&os_version=");
        ((aw) (obj1)).a(ao.a(ab1.G));
        ((aw) (obj1)).a("&device_api=");
        ((aw) (obj1)).a(ao.a(ab1.J));
        ((aw) (obj1)).a("&app_version=");
        ((aw) (obj1)).a(ao.a(ab1.q));
        ((aw) (obj1)).a("&android_id_sha1=");
        ((aw) (obj1)).a(ao.a(ab1.u));
        ((aw) (obj1)).a("&device_id=");
        ((aw) (obj1)).a(ao.a(ab1.y));
        ((aw) (obj1)).a("&open_udid=");
        ((aw) (obj1)).a(ao.a(ab1.F));
        ((aw) (obj1)).a("&device_type=");
        ((aw) (obj1)).a(ao.a(ab1.B));
        ((aw) (obj1)).a("&ln=");
        ((aw) (obj1)).a(ao.a(ab1.E));
        ((aw) (obj1)).a("&device_brand=");
        ((aw) (obj1)).a(ao.a(ab1.z));
        ((aw) (obj1)).a("&device_model=");
        ((aw) (obj1)).a(ao.a(ab1.A));
        ((aw) (obj1)).a("&screen_width=");
        as1 = new StringBuilder();
        if (q.x != null) goto _L39; else goto _L38
_L38:
        i1 = 0;
_L52:
        ((aw) (obj1)).a(ao.a(as1.append(i1).toString()));
        ((aw) (obj1)).a("&screen_height=");
        as1 = new StringBuilder();
        if (q.x != null) goto _L41; else goto _L40
_L40:
        i1 = 0;
_L53:
        ((aw) (obj1)).a(ao.a(as1.append(i1).toString()));
        ((aw) (obj1)).a("&sdk_type=");
        ((aw) (obj1)).a(ao.a(ab1.p));
        ((aw) (obj1)).a("&sdk_version=");
        ((aw) (obj1)).a(ao.a(ab1.b));
        ((aw) (obj1)).a("&origin_store=");
        ((aw) (obj1)).a(ao.a(ab1.r));
        ((aw) (obj1)).a("&available_stores=");
        ((aw) (obj1)).a(ao.a(ab1.v));
        ((aw) (obj1)).a("&imei_sha1=");
        ((aw) (obj1)).a(ao.a(ab1.D));
        ((aw) (obj1)).a("&memory_class=");
        ((aw) (obj1)).a(ao.a(ab1.H));
        ((aw) (obj1)).a("&memory_used_mb=");
        ((aw) (obj1)).a(ao.a(ab1.I));
        ((aw) (obj1)).a("&advertiser_id=");
        ((aw) (obj1)).a(ao.a(ab1.K));
        ((aw) (obj1)).a("&limit_tracking=");
        ((aw) (obj1)).a(ab1.L);
        ((aw) (obj1)).a("&immersion=");
        ((aw) (obj1)).a(ab1.M);
        ab1.h = ((aw) (obj1)).toString();
        obj1 = ab1.a.f;
        aj.a.b("Configuring storage");
        if (com.jirbo.adcolony.d.c() != null && com.jirbo.adcolony.d.a(com.jirbo.adcolony.d.c()) > com.jirbo.adcolony.d.a(com.jirbo.adcolony.d.b()) + 1048576D && com.jirbo.adcolony.d.a(com.jirbo.adcolony.d.b()) < 31457280D)
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        if (i1 == 0) goto _L43; else goto _L42
_L42:
        aj.b.b("Using internal storage:");
        obj1.b = (new StringBuilder()).append(com.jirbo.adcolony.d.b()).append("/adc/").toString();
_L54:
        obj1.c = (new StringBuilder()).append(((d) (obj1)).b).append("media/").toString();
        aj.a.b(((d) (obj1)).c);
        obj1.e = new File(((d) (obj1)).c);
        if (!((d) (obj1)).e.isDirectory())
        {
            ((d) (obj1)).e.delete();
            ((d) (obj1)).e.mkdirs();
        }
        if (((d) (obj1)).e.isDirectory()) goto _L45; else goto _L44
_L44:
        q.a("Cannot create media folder.");
_L55:
        obj1 = ab1.a.c;
        ((am) (obj1)).a();
        obj1.h = true;
        obj1 = ab1.a.d;
        ((ar) (obj1)).a();
        obj1.d = 0;
        obj1 = ab1.a.h;
        ((aq) (obj1)).a();
        obj1.e = false;
        ab1.g = true;
        ab1.a.b.a();
        if (ab1.a.b.j.i == null || ab1.a.b.j.i.equals(""))
        {
            ab1.a.b.j.i = "all";
        }
        if (ab1.a.b.j.j == null || ab1.a.b.j.j.equals(""))
        {
            ab1.a.b.j.j = "all";
        }
        q.g = true;
        q.i = true;
_L12:
        b.b();
        obj1 = c;
        ((am) (obj1)).c();
        if (((am) (obj1)).i && ((am) (obj1)).e.a())
        {
            ((am) (obj1)).d();
            ((am) (obj1)).b();
        }
        obj1 = e;
        if (((as) (obj1)).a.b.b)
        {
            if (((as) (obj1)).d)
            {
                obj1.d = false;
                ((as) (obj1)).a.d.a("install", null);
            }
            if (((as) (obj1)).e)
            {
                obj1.e = false;
                ((as) (obj1)).a.d.a("session_start", null);
            }
        }
        obj1 = d;
        if (((ar) (obj1)).e)
        {
            obj1.e = false;
            ((ar) (obj1)).b();
        }
        ((ar) (obj1)).c();
        obj1 = h;
        if (((aq) (obj1)).e)
        {
            obj1.e = false;
            ((aq) (obj1)).b();
        }
        g.a();
          goto _L1
_L21:
        q.a(((RuntimeException) (obj1)));
          goto _L1
_L27:
        obj1 = android.provider.Settings.Secure.getString(q.b().getContentResolver(), "android_id");
          goto _L46
_L29:
        obj1 = ab.a(s.b(ab1.t), "");
          goto _L47
_L31:
        as1 = ((TelephonyManager)q.b().getSystemService("phone")).getNetworkOperatorName();
        obj1 = as1;
        if (as1.length() != 0) goto _L49; else goto _L48
_L48:
        obj1 = "unknown";
          goto _L49
_L35:
        obj1 = z.a(q.b());
          goto _L50
_L37:
        ab1.B = "phone";
          goto _L51
_L39:
        i1 = q.b().getWindowManager().getDefaultDisplay().getWidth();
          goto _L52
_L41:
        i1 = q.b().getWindowManager().getDefaultDisplay().getHeight();
          goto _L53
_L43:
        obj1.b = (new StringBuilder()).append(com.jirbo.adcolony.d.c()).append("/.adc2/").append(s.e()).append("/").toString();
        aj.b.b("Using external storage:");
          goto _L54
_L45:
label0:
        {
            if (com.jirbo.adcolony.d.a(((d) (obj1)).c) >= 20971520D)
            {
                break label0;
            }
            q.a((new StringBuilder("Not enough space to store temporary files (")).append(com.jirbo.adcolony.d.a(((d) (obj1)).c)).append(" bytes available).").toString());
        }
          goto _L55
        obj1.d = (new StringBuilder()).append(com.jirbo.adcolony.d.b()).append("/adc/data/").toString();
        if (q.e == 0)
        {
            obj1.d = (new StringBuilder()).append(((d) (obj1)).b).append("data/").toString();
        }
        aj.a.a("Internal data path: ").b(((d) (obj1)).d);
        obj1.f = new File(((d) (obj1)).d);
        if (!((d) (obj1)).f.isDirectory())
        {
            ((d) (obj1)).f.delete();
        }
        ((d) (obj1)).f.mkdirs();
        obj1 = new ae("iap_cache.txt");
        ((ae) (obj1)).c();
        ai.a(((ae) (obj1)), q.Q);
          goto _L55
_L10:
        i1++;
          goto _L56
_L22:
        i1++;
          goto _L57
    }

    final boolean e(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a(s1, false, true);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s1;
        throw s1;
    }

    final boolean f(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = b(s1, false, true);
        this;
        JVM INSTR monitorexit ;
        return flag;
        s1;
        throw s1;
    }

    final al.c g(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = b.j.n.a(s1);
        this;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        throw s1;
    }

    // Unreferenced inner class com/jirbo/adcolony/ac$3

/* anonymous class */
    final class _cls3 extends ah
    {

        final ac a;

        final void a()
        {
            as as1 = n.e;
            aj.b.b("AdColony terminating");
            q.i = true;
            as1.a(as1.h);
            as1.c = false;
            as1.a();
        }

            
            {
                a = ac.this;
                super(ac2);
            }
    }

}
