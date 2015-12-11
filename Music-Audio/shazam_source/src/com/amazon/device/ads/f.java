// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.view.ViewGroup;

// Referenced classes of package com.amazon.device.ads:
//            h, e, cq, l, 
//            cn, ds, ae, ac, 
//            da

final class f
{

    final h a;

    public f(h h1)
    {
        a = h1;
    }

    public final void a()
    {
        cq cq1 = a.a().b;
        cq1.h = false;
        cq1.f.a(new cq._cls4(cq1), ds.b.a, ds.c.a);
    }

    public final void a(ViewGroup viewgroup, android.view.ViewGroup.LayoutParams layoutparams, boolean flag)
    {
        h h1 = a;
        ViewGroup viewgroup1 = h1.s();
        if (h1.B == null)
        {
            h1.B = viewgroup1;
        }
        if (viewgroup1 != null)
        {
            viewgroup1.removeView(h1.a());
        }
        h1.a().a(-1, -1, 17);
        viewgroup.addView(h1.a(), layoutparams);
        h1.F = flag;
        h1.b(true);
        if (h1.F)
        {
            h1.a().a(new h._cls2(h1));
        }
    }

    public final void a(l l1)
    {
        h h1 = a;
        h1.d.b("Firing AdEvent of type %s", new Object[] {
            l1.a
        });
        ds.b(new h._cls10(h1, l1));
    }

    public final void a(String s)
    {
        a.a(s, false);
    }

    public final void a(boolean flag, da da)
    {
        a.a(flag, da);
    }

    public final Context b()
    {
        return a.g();
    }

    public final void b(String s)
    {
        a.a(s, true);
    }

    public final boolean c()
    {
        h h1 = a;
        return ae.g.equals(h1.x) || ae.h.equals(h1.x);
    }

    public final boolean d()
    {
        h h1 = a;
        ac ac1 = h1.c;
        return ac.a.a.equals(ac1.m) || ae.h.equals(h1.x) && h1.F;
    }
}
