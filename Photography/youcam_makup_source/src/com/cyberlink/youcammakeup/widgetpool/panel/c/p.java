// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            q, g

public class p
{

    private final HashMap a;
    private final HashMap b;
    private final HashMap c;
    private g d;
    private int e;
    private boolean f;
    private com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType g;

    private p()
    {
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
        d = null;
        e = 0;
        f = false;
        g = null;
    }


    public static p a()
    {
        return q.a();
    }

    public static r f()
    {
        if (a().d == null)
        {
            return null;
        } else
        {
            g g1 = a().d;
            String s = a().a(BeautyMode.n);
            MotionControlHelper.e().b(g1.b);
            return new r(s, g1.a, null, g1.b, 70F);
        }
    }

    public static r g()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a().c(BeautyMode.l));
        int k = a().c(BeautyMode.l).d();
        String s = a().a(BeautyMode.l);
        String s1 = a().b(BeautyMode.l);
        float f1;
        if (k == 0)
        {
            f1 = 50F;
        } else
        {
            f1 = k;
        }
        return new r(s, s1, null, arraylist, f1);
    }

    public static r h()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a().c(BeautyMode.m));
        int k = a().c(BeautyMode.m).d();
        String s = a().a(BeautyMode.m);
        String s1 = a().b(BeautyMode.m);
        float f1;
        if (k == 0)
        {
            f1 = 75F;
        } else
        {
            f1 = k;
        }
        return new r(s, s1, null, arraylist, f1);
    }

    public static r i()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a().c(BeautyMode.a));
        int k = a().c(BeautyMode.a).d();
        String s = a().a(BeautyMode.a);
        String s1 = a().b(BeautyMode.a);
        float f1;
        if (k == 0)
        {
            f1 = 25F;
        } else
        {
            f1 = k;
        }
        return new r(s, s1, null, arraylist, f1);
    }

    public static r j()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a().c(BeautyMode.v));
        int k = a().c(BeautyMode.v).d();
        String s = a().a(BeautyMode.v);
        String s1 = a().b(BeautyMode.v);
        float f1;
        if (k == 0)
        {
            f1 = 50F;
        } else
        {
            f1 = k;
        }
        return new r(s, s1, null, arraylist, f1);
    }

    public String a(BeautyMode beautymode)
    {
        return (String)a.get(beautymode);
    }

    public void a(int k)
    {
        e = k;
    }

    public void a(BeautyMode beautymode, at at1)
    {
        c.put(beautymode, at1);
    }

    public void a(BeautyMode beautymode, String s)
    {
        a.put(beautymode, s);
    }

    public void a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType sourcetype)
    {
        g = sourcetype;
    }

    public void a(g g1)
    {
        d = g1;
    }

    public void a(boolean flag)
    {
        f = flag;
    }

    public String b(BeautyMode beautymode)
    {
        return (String)b.get(beautymode);
    }

    public void b()
    {
        a.clear();
        b.clear();
        c.clear();
        a(((g) (null)));
        a(0);
        a(false);
        g = null;
    }

    public void b(BeautyMode beautymode, String s)
    {
        b.put(beautymode, s);
    }

    public at c(BeautyMode beautymode)
    {
        return (at)c.get(beautymode);
    }

    public g c()
    {
        return d;
    }

    public boolean d()
    {
        return a.size() > 0;
    }

    public i e()
    {
        i k = new i();
        BeautyMode abeautymode[] = BeautyMode.values();
        int i1 = abeautymode.length;
        int l = 0;
        while (l < i1) 
        {
            BeautyMode beautymode = abeautymode[l];
            if (a(beautymode) != null)
            {
                if (beautymode == BeautyMode.n)
                {
                    k.a(f());
                } else
                if (beautymode == BeautyMode.l)
                {
                    k.b(g());
                } else
                if (beautymode == BeautyMode.m)
                {
                    k.c(h());
                } else
                if (beautymode == BeautyMode.a)
                {
                    k.d(i());
                } else
                if (beautymode == BeautyMode.v)
                {
                    k.e(j());
                }
            }
            l++;
        }
        if (f)
        {
            k.d(70F);
        }
        return k;
    }
}
