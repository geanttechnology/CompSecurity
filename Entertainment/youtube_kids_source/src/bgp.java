// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class bgp extends bgi
    implements bcz, bhv
{

    private final bgf a;
    private final buz b;
    private final bfz c;
    private final bfh d;
    private final crh e;
    private boolean f;
    private boolean g;
    private boolean h;
    private List i;
    private int j;
    private int k;
    private PriorityQueue l;
    private csg m;
    private final bcw n;
    private bje o;

    bgp(bje bje1, bgf bgf1, bfz bfz1, buz buz1, String s, int i1, boolean flag, 
            boolean flag1, boolean flag2, List list, int j1, csg csg1, bcw bcw1, crh crh1, 
            bfh bfh1)
    {
        this(bje1, bgf1, bfz1, buz1, s, csg1, bcw1, crh1, bfh1);
        j = i1;
        f = flag;
        g = flag1;
        h = flag2;
        i = new ArrayList(a.a(list));
        k = j1;
        l = a(j1);
        bfh1.g = j1;
    }

    bgp(bje bje1, bgf bgf1, bfz bfz1, buz buz1, String s, csg csg1, bcw bcw1, 
            crh crh1, bfh bfh1)
    {
        super(bje1);
        m = null;
        o = bje1;
        a = bgf1;
        b = buz1;
        c = bfz1;
        n = bcw1;
        i = new ArrayList();
        k = -1;
        l = a(k);
        m = (csg)b.a(csg1);
        d = bfh1;
        e = (crh)b.a(crh1);
        bfh1.a(bfz1.c, s);
        bfh1.b = bfz1;
        if (bfz1 != null && bfz1.k != null)
        {
            bje1 = Pattern.compile(bfz1.k, 0);
        } else
        {
            bje1 = null;
        }
        bfh1.c = bje1;
        bfh1.a = buz1;
        bfh1.d = m;
    }

    static buz a(bgp bgp1)
    {
        return bgp1.b;
    }

    private PriorityQueue a(int i1)
    {
        PriorityQueue priorityqueue = new PriorityQueue(b.u.size() + 1, new bgq(this));
label0:
        for (buz buz1 = b; buz1 != null; buz1 = buz1.P)
        {
            Iterator iterator = buz1.u.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    continue label0;
                }
                bvg bvg1 = (bvg)iterator.next();
                if (bvg1.a(b.k) > i1)
                {
                    priorityqueue.add(bvg1);
                }
            } while (true);
        }

        return priorityqueue;
    }

    private void a(Uri uri)
    {
        a(uri, cri.h);
    }

    private void a(Uri uri, cri cri1)
    {
        if (uri == null || Uri.EMPTY.equals(uri)) goto _L2; else goto _L1
_L1:
        cri1 = e.a(uri, cri1);
        uri = cri1;
_L4:
        cri1 = String.valueOf(uri);
        bmo.e((new StringBuilder(String.valueOf(cri1).length() + 8)).append("Pinging ").append(cri1).toString());
        cri1 = a;
        uri = a.a(uri, "vastad");
        uri.d = b.T;
        uri.e = b.J;
        cri1.a(uri, cni.a);
_L2:
        return;
        cri1;
        cri1 = String.valueOf(cri1);
        bmo.c((new StringBuilder(String.valueOf(cri1).length() + 32)).append("Failed to substitute URI macros ").append(cri1).toString());
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(String s)
    {
        if (!i.contains(s))
        {
            i.add(s);
            buz buz1 = b;
            while (buz1 != null) 
            {
                Uri uri;
                if (buz1.H == null)
                {
                    uri = null;
                } else
                {
                    uri = buz1.H.buildUpon().appendQueryParameter("label", s).build();
                }
                a(uri);
                buz1 = buz1.P;
            }
        }
    }

    private boolean a(List list)
    {
        return a(list, cri.h);
    }

    private boolean a(List list, cri cri1)
    {
        if (list != null && list.size() > 0)
        {
            for (list = list.iterator(); list.hasNext(); a((Uri)list.next(), cri1)) { }
            return true;
        } else
        {
            return false;
        }
    }

    private void o()
    {
        for (buz buz1 = b; buz1 != null; buz1 = buz1.P)
        {
            a(buz1.b);
            a(buz1.q);
        }

    }

    private boolean p()
    {
        return b.n.m();
    }

    public final void a()
    {
        for (buz buz1 = b; buz1 != null; buz1 = buz1.P)
        {
            a(buz1.W);
        }

    }

    public final void a(int i1, int j1)
    {
        if (n != null)
        {
            n.a.a(bct.h);
        }
        bfl bfl1 = new bfl(i1, j1);
        for (buz buz1 = b; buz1 != null; buz1 = buz1.P)
        {
            a(buz1.v, ((cri) (bfl1)));
        }

    }

    public final void a(cnd cnd)
    {
        bfg bfg1 = new bfg(crw.a(cnd));
        if (j != 5)
        {
            for (cnd = b; cnd != null; cnd = ((buz) (cnd)).P)
            {
                a(((buz) (cnd)).z, ((cri) (bfg1)));
                a(((buz) (cnd)).F, ((cri) (bfg1)));
            }

            j = 5;
        }
    }

    public final void a(crw crw1)
    {
        a(c.h, ((cri) (new bfg(crw1))));
    }

    public final void a(csg csg1)
    {
        boolean flag1 = true;
        boolean flag;
        if (m.a == ctr.c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (csg1.a != ctr.c)
        {
            flag1 = false;
        }
        m = csg1;
        d.d = m;
        if (!flag && flag1)
        {
            for (csg1 = b; csg1 != null; csg1 = ((buz) (csg1)).P)
            {
                a(((buz) (csg1)).C);
            }

        } else
        if (flag && !flag1)
        {
            for (csg1 = b; csg1 != null; csg1 = ((buz) (csg1)).P)
            {
                a(((buz) (csg1)).D);
            }

        }
    }

    public final void a(cte cte1)
    {
        if (!cte1.d) goto _L2; else goto _L1
_L1:
        buz buz1;
        int i1;
        int j1;
        boolean flag;
        int k1;
        k1 = (int)cte1.a;
        d.g = k1;
        if (!g && p())
        {
            o();
            g = true;
        }
        for (; l.size() > 0 && k1 >= ((bvg)l.peek()).a(b.k); a(((bvg)l.poll()).a)) { }
        k = k1;
        i1 = b.k * 1000;
        if (i1 > 0)
        {
            i1 = (k1 * 4) / i1;
        } else
        {
            i1 = 0;
        }
        if (i1 < j) goto _L4; else goto _L3
_L3:
        j1 = i1;
_L20:
        if (j1 < j) goto _L6; else goto _L5
_L5:
        buz1 = b;
        flag = false;
_L12:
        if (buz1 == null)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        j1;
        JVM INSTR tableswitch 1 3: default 192
    //                   1 219
    //                   2 227
    //                   3 235;
           goto _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_235;
_L8:
        break; /* Loop/switch isn't completed */
_L7:
        cte1 = Collections.emptyList();
_L13:
        flag |= a(((List) (cte1)));
        buz1 = buz1.P;
        if (true) goto _L12; else goto _L11
_L11:
        cte1 = buz1.r;
          goto _L13
_L9:
        cte1 = buz1.s;
          goto _L13
        cte1 = buz1.t;
          goto _L13
        if (n == null) goto _L15; else goto _L14
_L14:
        cte1 = n;
        j1;
        JVM INSTR tableswitch 0 2: default 284
    //                   0 298
    //                   1 311
    //                   2 324;
           goto _L15 _L16 _L17 _L18
_L15:
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        j1--;
        continue; /* Loop/switch isn't completed */
_L16:
        ((bcw) (cte1)).a.a(bct.b);
        continue; /* Loop/switch isn't completed */
_L17:
        ((bcw) (cte1)).a.a(bct.c);
        continue; /* Loop/switch isn't completed */
_L18:
        ((bcw) (cte1)).a.a(bct.d);
        if (true) goto _L15; else goto _L6
_L6:
        j = i1 + 1;
_L4:
        if (!f && k1 >= 30000)
        {
            for (cte1 = b; cte1 != null; cte1 = ((buz) (cte1)).P)
            {
                a(((buz) (cte1)).x);
            }

            f = true;
        }
_L2:
        return;
        if (true) goto _L20; else goto _L19
_L19:
    }

    public final void a(Object obj, Exception exception)
    {
        obj = String.valueOf((cqy)obj);
        bmo.d((new StringBuilder(String.valueOf(obj).length() + 12)).append("Ping failed ").append(((String) (obj))).toString(), exception);
    }

    public final volatile void a(Object obj, Object obj1)
    {
    }

    public final void b()
    {
        super.b();
        d.e = null;
        if (n != null)
        {
            bcn bcn1 = n.a;
            bcn1.b();
            bcn1.b = true;
            n.b = null;
        }
    }

    public final void b(crw crw1)
    {
        buz buz1 = b;
        bfg bfg1 = new bfg(crw1);
        for (crw1 = buz1; crw1 != null; crw1 = ((buz) (crw1)).P)
        {
            a(((buz) (crw1)).F, bfg1);
        }

    }

    public final void c()
    {
        a(c.f);
    }

    public final void d()
    {
        a(c.g);
    }

    public final void e()
    {
        if (b.d() && !g)
        {
            a(b.b);
            g = true;
        }
    }

    public final void f()
    {
        if (!h)
        {
            for (buz buz1 = b; buz1 != null; buz1 = buz1.P)
            {
                a(buz1.w);
            }

            h = true;
        }
    }

    public final void g()
    {
        d.f = true;
        if (!g && !p())
        {
            o();
            g = true;
            if (n != null)
            {
                n.a.a(bct.a);
            }
        }
        if (j == 0)
        {
            j = 1;
        } else
        {
            for (buz buz1 = b; buz1 != null; buz1 = buz1.P)
            {
                a(buz1.B);
            }

            if (n != null)
            {
                n.a.a(bct.f);
                return;
            }
        }
    }

    public final void h()
    {
        for (buz buz1 = b; buz1 != null; buz1 = buz1.P)
        {
            a(buz1.z);
        }

    }

    public final void handleAdCompanionClickEvent$7209291f(a a1)
    {
        a("clickcompanionad");
    }

    public final void i()
    {
        d.f = false;
        for (buz buz1 = b; buz1 != null; buz1 = buz1.P)
        {
            a(buz1.A);
        }

        if (n != null)
        {
            n.a.a(bct.g);
        }
    }

    public final void j()
    {
        d.f = false;
        d.g = TimeUnit.SECONDS.toMillis(b.k);
        buz buz1 = b;
        if (!f)
        {
            for (; buz1 != null; buz1 = buz1.P)
            {
                a(buz1.x);
            }

            f = true;
        }
        for (; l.size() > 0; a(((bvg)l.poll()).a)) { }
        for (buz buz2 = b; buz2 != null; buz2 = buz2.P)
        {
            a(buz2.y);
        }

        j = 5;
        if (n != null)
        {
            n.a.a(bct.e);
        }
    }

    public final bgj k()
    {
        return new bgj(j, f, g, h, i, k, bgl.a);
    }

    public final void l()
    {
        a("clickchannel");
    }

    public final void m()
    {
        if (n != null)
        {
            n.a.a(bct.g);
        }
    }

    public final void n()
    {
        super.n();
        o.a(this);
        d.e = n;
        if (n != null)
        {
            n.b = this;
        }
    }
}
