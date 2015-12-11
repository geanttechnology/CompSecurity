// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public final class bgn extends bgi
    implements bhv
{

    private final bgf a;
    private final buz b;
    private final bfh c;
    private final crh d;
    private boolean e;
    private int f;
    private int g;
    private PriorityQueue h;
    private csg i;

    bgn(bje bje, bgf bgf1, buz buz1, String s, int i1, boolean flag, int j1, 
            csg csg1, crh crh1, bfh bfh1)
    {
        this(bje, bgf1, buz1, s, csg1, crh1, bfh1);
        f = i1;
        e = flag;
        g = j1;
        h = a(j1);
        bfh1.g = j1;
    }

    bgn(bje bje, bgf bgf1, buz buz1, String s, csg csg1, crh crh1, bfh bfh1)
    {
        super(bje);
        i = null;
        a = bgf1;
        b = buz1;
        g = -1;
        h = a(g);
        i = (csg)b.a(csg1);
        c = bfh1;
        d = (crh)b.a(crh1);
        bfh1.a(null, s);
        bfh1.a = buz1;
        bfh1.d = i;
    }

    static buz a(bgn bgn1)
    {
        return bgn1.b;
    }

    private PriorityQueue a(int i1)
    {
        PriorityQueue priorityqueue = new PriorityQueue(b.u.size() + 1, new bgo(this));
        Iterator iterator = b.u.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            bvg bvg1 = (bvg)iterator.next();
            if (bvg1.a(b.k) > i1)
            {
                priorityqueue.add(bvg1);
            }
        } while (true);
        return priorityqueue;
    }

    private void a()
    {
        a(b.b);
        a(b.q);
    }

    private void a(Uri uri)
    {
        a(uri, cri.h);
    }

    private void a(Uri uri, cri cri1)
    {
        if (uri == null) goto _L2; else goto _L1
_L1:
        cri1 = d.a(uri, cri1);
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

    private boolean a(List list)
    {
        return a(list, crw.a);
    }

    private boolean a(List list, crw crw1)
    {
        crw1 = new bfg(crw1);
        if (list != null && list.size() > 0)
        {
            for (list = list.iterator(); list.hasNext(); a((Uri)list.next(), ((cri) (crw1)))) { }
            return true;
        } else
        {
            return false;
        }
    }

    private boolean o()
    {
        return b.n.m();
    }

    public final void a(int i1, int j1)
    {
    }

    public final void a(cnd cnd)
    {
        cnd = crw.a(cnd);
        if (f != 5)
        {
            a(b.z, ((crw) (cnd)));
            a(b.F, ((crw) (cnd)));
            f = 5;
        }
    }

    public final void a(crw crw1)
    {
    }

    public final void a(csg csg1)
    {
        boolean flag1 = true;
        boolean flag;
        if (i.a == ctr.c)
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
        i = csg1;
        c.d = i;
        if (!flag && flag1)
        {
            a(b.C);
        } else
        if (flag && !flag1)
        {
            a(b.D);
            return;
        }
    }

    public final void a(cte cte1)
    {
        if (!cte1.d) goto _L2; else goto _L1
_L1:
        int i1;
        i1 = (int)cte1.a;
        if (!e && o())
        {
            a();
            e = true;
        }
        for (; h.size() > 0 && i1 >= ((bvg)h.peek()).a(b.k); a(((bvg)h.poll()).a)) { }
        g = i1;
        int j1 = b.k * 1000;
        if (j1 > 0)
        {
            i1 = (i1 * 4) / j1;
        } else
        {
            i1 = 0;
        }
        if (i1 < f) goto _L2; else goto _L3
_L3:
        j1 = i1;
_L12:
        if (j1 < f) goto _L5; else goto _L4
_L4:
        cte1 = b;
        j1;
        JVM INSTR tableswitch 1 3: default 168
    //                   1 192
    //                   2 200
    //                   3 208;
           goto _L6 _L7 _L8 _L9
_L6:
        cte1 = Collections.emptyList();
_L10:
        if (a(((List) (cte1))))
        {
            break; /* Loop/switch isn't completed */
        }
        j1--;
        continue; /* Loop/switch isn't completed */
_L7:
        cte1 = ((buz) (cte1)).r;
        continue; /* Loop/switch isn't completed */
_L8:
        cte1 = ((buz) (cte1)).s;
        continue; /* Loop/switch isn't completed */
_L9:
        cte1 = ((buz) (cte1)).t;
        if (true) goto _L10; else goto _L5
_L5:
        f = i1 + 1;
_L2:
        return;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public final void a(Object obj, Exception exception)
    {
        obj = String.valueOf((cqy)obj);
        bmo.d((new StringBuilder(String.valueOf(obj).length() + 12)).append("Ping failed ").append(((String) (obj))).toString(), exception);
    }

    public final volatile void a(Object obj, Object obj1)
    {
    }

    public final void b(crw crw1)
    {
        a(b.F, crw1);
    }

    public final void c()
    {
    }

    public final void d()
    {
    }

    public final void e()
    {
    }

    public final void f()
    {
    }

    public final void g()
    {
        if (!e && !o())
        {
            a();
            e = true;
        }
        if (f == 0)
        {
            f = 1;
            return;
        } else
        {
            a(b.B);
            return;
        }
    }

    public final void h()
    {
        a(b.z);
    }

    public final void i()
    {
        a(b.A);
    }

    public final void j()
    {
        for (; h.size() > 0; a(((bvg)h.poll()).a)) { }
        a(b.y);
        f = 5;
    }

    public final bgj k()
    {
        return new bgj(f, false, e, false, Collections.emptyList(), g, bgl.b);
    }

    public final void l()
    {
    }

    public final void m()
    {
    }
}
