// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Executor;

public final class rs
{

    final bgm a;
    public bgi b;
    buz c;
    final cwq d;
    cwo e;
    final pg f;
    pf g;
    final s h = null;
    final cwz i;
    cww j;
    final pm k;
    ph l;
    final px m;
    pv n;
    final ve o;
    va p;
    String q;
    rt r;
    bfz s;
    buz t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;

    public rs(bgm bgm1, cwq cwq1, pg pg1, s s1, cwz cwz1, pm pm1, px px1, 
            ve ve1)
    {
        a = (bgm)b.a(bgm1);
        d = (cwq)b.a(cwq1);
        f = (pg)b.a(pg1);
        i = (cwz)b.a(cwz1);
        k = (pm)b.a(pm1);
        m = (px)b.a(px1);
        o = (ve)b.a(ve1);
        r = null;
        c = null;
    }

    static void a(cwv cwv1)
    {
        if (cwv1 != null)
        {
            cwv1.b();
        }
    }

    public final void a()
    {
        if (u)
        {
            bmo.d("Warning: extra call to reset. See b/12133789");
        }
        u = true;
        x = false;
        v = false;
        w = false;
        c = null;
        q = null;
        r = null;
        a(((cwv) (g)));
        a(((cwv) (l)));
        a(((cwv) (n)));
        a(((cwv) (p)));
        a(((cwv) (e)));
        a(((cwv) (j)));
        a(((cwv) (b)));
        s s1;
        if (h != null)
        {
            s1 = h;
        }
        g = null;
        l = null;
        n = null;
        p = null;
        e = null;
        j = null;
        b = null;
    }

    public final void a(cjq cjq1)
    {
        if (cjq1.e != 3) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1;
        ph ph1;
        Object obj = cjq1.a;
        int i1;
        int j1;
        int k1;
        int l1;
        if (obj != null)
        {
            i1 = ((bwb) (obj)).a.b;
        } else
        {
            i1 = 0;
        }
        if (e != null)
        {
            obj1 = cjq1.b;
            bwb bwb1;
            String s1;
            StringBuilder stringbuilder;
            StringBuilder stringbuilder1;
            boolean flag;
            boolean flag1;
            int i2;
            long l2;
            if (obj != null && ((bwb) (obj)).e() || obj1 != null && ((bwb) (obj1)).e())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = e;
            if (flag)
            {
                obj.k = 0L;
            } else
            if (!flag && ((cwo) (obj)).k == 0L)
            {
                obj.k = ((cwo) (obj)).a.b() + 2000L;
            }
        }
        if (l == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ph1 = l;
        obj = cjq1.a;
        if (obj != null)
        {
            j1 = ((bwb) (obj)).a.b;
        } else
        {
            j1 = 0;
        }
        if (obj != null)
        {
            obj1 = ((bwb) (obj)).a.q;
        } else
        {
            obj1 = "";
        }
        obj = cjq1.b;
        if (obj != null)
        {
            k1 = ((bwb) (obj)).a.b;
        } else
        {
            k1 = 0;
        }
        if (obj != null)
        {
            obj = ((bwb) (obj)).a.q;
        } else
        {
            obj = "";
        }
        bwb1 = cjq1.c;
        if (bwb1 != null)
        {
            l1 = bwb1.a.b;
        } else
        {
            l1 = 0;
        }
        i2 = cjq1.e;
        i2;
        JVM INSTR tableswitch 0 2: default 208
    //                   0 765
    //                   1 772
    //                   2 779;
           goto _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_779;
_L3:
        cjq1 = null;
_L8:
label0:
        {
            s1 = ph1.e();
            flag1 = false;
            if (TextUtils.isEmpty(cjq1))
            {
                continue; /* Loop/switch isn't completed */
            }
            if (j1 < 0 || j1 == ph1.f)
            {
                flag = flag1;
                if (obj1 == null)
                {
                    break label0;
                }
                flag = flag1;
                if (((String) (obj1)).equals(ph1.g))
                {
                    break label0;
                }
            }
            flag = true;
            stringbuilder = (new StringBuilder()).append(s1).append(":").append(j1);
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                stringbuilder.append(";").append(((String) (obj1)));
            }
            stringbuilder1 = stringbuilder.append(":");
            Object obj2;
            if (l1 != 0)
            {
                obj2 = Integer.valueOf(l1);
            } else
            {
                obj2 = "";
            }
            stringbuilder1 = stringbuilder1.append(obj2).append(":");
            if (ph1.f < 0)
            {
                obj2 = "";
            } else
            {
                obj2 = Integer.valueOf(ph1.f);
            }
            stringbuilder1.append(obj2).append(":").append(cjq1);
            ph1.c.a("vfs", stringbuilder.toString());
            ph1.f = j1;
            ph1.g = ((String) (obj1));
        }
label1:
        {
            if (k1 < 0 || k1 == ph1.h)
            {
                j1 = ((flag) ? 1 : 0);
                if (obj == null)
                {
                    break label1;
                }
                j1 = ((flag) ? 1 : 0);
                if (((String) (obj)).equals(ph1.i))
                {
                    break label1;
                }
            }
            obj2 = (new StringBuilder()).append(s1).append(":").append(k1);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                ((StringBuilder) (obj2)).append(";").append(((String) (obj)));
            }
            stringbuilder = ((StringBuilder) (obj2)).append(":");
            if (ph1.h < 0)
            {
                obj1 = "";
            } else
            {
                obj1 = Integer.valueOf(ph1.h);
            }
            stringbuilder.append(obj1).append(":").append(cjq1);
            ph1.c.a("afs", ((StringBuilder) (obj2)).toString());
            ph1.h = k1;
            ph1.i = ((String) (obj));
            j1 = 1;
        }
        if (j1 != 0 && i2 == 2)
        {
            if (ph1.k > 0L)
            {
                ph1.c.a("bh", String.format(Locale.US, "%s:%.2f", new Object[] {
                    s1, Float.valueOf((float)ph1.k / 1000F)
                }));
            }
            l2 = ph1.b.a;
            if (l2 > 0L)
            {
                ph1.c.a("bwe", String.format(Locale.US, "%s:%.2f", new Object[] {
                    s1, Float.valueOf((float)l2 / 8F)
                }));
            }
        }
        if (n == null) goto _L1; else goto _L7
_L7:
        n.v = i1;
        return;
_L4:
        cjq1 = "i";
          goto _L8
_L5:
        cjq1 = "m";
          goto _L8
        cjq1 = "a";
          goto _L8
    }

    public final void a(cte cte1)
    {
        if (b != null)
        {
            b.a(cte1);
        }
        if (e != null)
        {
            cwo cwo1 = e;
            if (cte1.d && cwo1.k != 0L && !cwo1.m && cwo1.k <= cwo1.a.b())
            {
                cwo1.m = true;
                cwo1.b.execute(cwo1.j);
            }
        }
        if (j != null)
        {
            j.a(cte1);
        }
        s s1;
        if (h != null)
        {
            s1 = h;
        }
        if (l != null)
        {
            ph ph1 = l;
            if (cte1.d)
            {
                ph1.k = cte1.c - cte1.a;
            }
        }
        if (n == null) goto _L2; else goto _L1
_L1:
        Object obj = n;
        if (!cte1.d) goto _L2; else goto _L3
_L3:
        long l1 = cte1.a;
        if (l1 >= ((pv) (obj)).o - 5000L && l1 <= ((pv) (obj)).o + 5000L) goto _L5; else goto _L4
_L4:
        long l2 = ((pv) (obj)).o;
        bmo.c((new StringBuilder(109)).append("Warning: unexpected playback progress ").append(l1).append(" for current playback position ").append(l2).toString());
        ((pv) (obj)).a(l1);
_L2:
        if (p != null)
        {
            obj = p;
            if (cte1.d && cte1.a >= (long)(((va) (obj)).e * 1000))
            {
                ((va) (obj)).a();
            }
        }
        return;
_L5:
        if (l1 >= ((pv) (obj)).o)
        {
            obj.p = (int)((long)((pv) (obj)).p + (l1 - ((pv) (obj)).o));
            obj.o = l1;
            ((pv) (obj)).n.b = ((pv) (obj)).o;
            if (!((pv) (obj)).s)
            {
                obj.s = true;
                ((pv) (obj)).a(bnf.a(((pv) (obj)).a));
            }
            if (!((pv) (obj)).q && ((pv) (obj)).j > 0 && ((pv) (obj)).p >= ((pv) (obj)).j * 1000)
            {
                ((pv) (obj)).e();
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    void a(String s1, csg csg)
    {
        c = rt.b(r);
        if (s != null && t != null)
        {
            b = a.a(s, t, s1, rt.c(r));
        } else
        if (c != null)
        {
            b = a.a(null, c, s1, rt.c(r));
        }
        if (rt.d(r) == null)
        {
            s1 = null;
        } else
        {
            s1 = d;
            cwr cwr1 = rt.d(r);
            b.a(((cwq) (s1)).f);
            if (cwr1 == null)
            {
                s1 = null;
            } else
            {
                s1 = new cwo(((cwq) (s1)).a, ((cwq) (s1)).b, ((cwq) (s1)).c, ((cwq) (s1)).d, ((cwq) (s1)).f, cwr.a(cwr1), cwr.b(cwr1), cwr.c(cwr1), cwr.d(cwr1), ((cwq) (s1)).e);
                s1.k = cwr.e(cwr1);
            }
        }
        e = s1;
        if (rt.e(r) == null)
        {
            s1 = null;
        } else
        {
            s1 = i;
            cxa cxa1 = rt.e(r);
            s1 = s1.a(Arrays.asList(cxa.a(cxa1)), cxa.b(cxa1));
        }
        j = s1;
        if (rt.f(r) == null)
        {
            s1 = null;
        } else
        {
            s1 = k;
            pr pr1 = rt.f(r);
            File file = (File)((pm) (s1)).j.b_();
            bje bje = ((pm) (s1)).c;
            bmi bmi1 = ((pm) (s1)).a;
            cpz cpz = ((pm) (s1)).b;
            bkn bkn = ((pm) (s1)).d;
            bmh bmh = ((pm) (s1)).e;
            asa asa = ((pm) (s1)).f;
            asa asa1 = ((pm) (s1)).g;
            cna cna = ((pm) (s1)).h;
            clv clv = ((pm) (s1)).i;
            long l1;
            long l2;
            if (file == null)
            {
                l1 = -1L;
            } else
            {
                l1 = file.getFreeSpace();
            }
            if (file == null)
            {
                l2 = -1L;
            } else
            {
                l2 = file.getTotalSpace();
            }
            s1 = new ph(bje, bmi1, cpz, bkn, bmh, asa, asa1, cna, clv, l1, l2, ((pm) (s1)).k, ((pm) (s1)).l, pr1.a, pr1.f, pr1.g, (byte)0);
            ph.a(s1, pr1.b);
            ph.a(s1, pr1.c);
            ph.b(s1, pr1.d);
            ph.b(s1, pr1.e);
            s1.d();
        }
        l = s1;
        if (rt.g(r) == null)
        {
            s1 = null;
        } else
        {
            s1 = m.a(csg, rt.g(r));
        }
        n = s1;
        if (rt.h(r) == null)
        {
            s1 = null;
        } else
        {
            s1 = o;
            csg = rt.h(r);
            s1 = new va(((ve) (s1)).a, ((ve) (s1)).b, ((ve) (s1)).c, (vc)b.a(csg));
        }
        p = s1;
    }

    public final void a(boolean flag)
    {
        Object obj;
        if (g != null)
        {
            obj = g;
            if (flag)
            {
                obj.g = ((pf) (obj)).c.a();
            } else
            if (!((pf) (obj)).h)
            {
                if (((pf) (obj)).g != -1L)
                {
                    long l1 = ((pf) (obj)).c.a() - ((pf) (obj)).g;
                    if (l1 < 0L)
                    {
                        bmo.c((new StringBuilder(66)).append("buffering ended before it began, buffer time: ").append(l1).toString());
                    } else
                    {
                        obj1 = new Bundle();
                        ((Bundle) (obj1)).putString("cpn", ((pf) (obj)).a);
                        ((Bundle) (obj1)).putString("buffering_delay_millis", Long.toString(l1));
                        ((pf) (obj)).f.a(((pf) (obj)).b, null, null, null, null, ((Bundle) (obj1)));
                    }
                }
                obj.h = true;
            }
        }
        if (l != null)
        {
            Object obj1 = l;
            if (flag)
            {
                if (((ph) (obj1)).d == po.e)
                {
                    obj = po.h;
                } else
                {
                    obj = po.a;
                }
            } else
            if (((ph) (obj1)).d == po.h)
            {
                obj = po.e;
            } else
            {
                obj = po.f;
            }
            ((ph) (obj1)).a(((po) (obj)));
        }
    }

    boolean a(String s1)
    {
        String s2;
        boolean flag;
        if (r != null && rt.a(r) != null && rt.a(r).equals(s1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            s2 = "RESTORED";
        } else
        {
            s2 = "NEW";
        }
        bmo.e((new StringBuilder(String.valueOf(s2).length() + 32 + String.valueOf(s1).length())).append("PlaybackClientManager ").append(s2).append(": videoId=").append(s1).toString());
        return flag;
    }

    public final void b()
    {
        if (n != null)
        {
            pv pv1 = n;
            pv1.d();
            if (pv1.s)
            {
                pv1.b(true);
            }
        }
        if (g != null)
        {
            g.a();
        }
        if (l != null)
        {
            ph ph1 = l;
            ph1.a(po.d);
            ph1.a(true);
            ph1.c.a();
        }
        if (p != null)
        {
            p.a();
        }
    }

    public final void handleStreamerUrlsExpiredEvent(ctl ctl)
    {
        x = true;
    }
}
