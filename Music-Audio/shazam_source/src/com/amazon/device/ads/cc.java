// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

// Referenced classes of package com.amazon.device.ads:
//            co, at, i, cn, 
//            cb, h, d, de, 
//            dd, f

public class cc
    implements AdActivity.b
{
    final class a
        implements de
    {

        final cc a;

        public final void a(dd dd1, f f1)
        {
            if (dd1.a.equals(dd.a.e) && !cc.a(a).isFinishing())
            {
                cc.b(a);
                cc.a(a).finish();
            }
        }

        a()
        {
            a = cc.this;
            super();
        }
    }


    private static final String a = com/amazon/device/ads/cc.getSimpleName();
    private final cn b;
    private Activity c;
    private h d;

    cc()
    {
        new co();
        b = co.a(a);
        c = null;
    }

    static Activity a(cc cc1)
    {
        return cc1.c;
    }

    static h b(cc cc1)
    {
        cc1.d = null;
        return null;
    }

    public final void a()
    {
        c.requestWindowFeature(1);
        c.getWindow().setFlags(1024, 1024);
        at.a(c);
    }

    public final void a(Activity activity)
    {
        c = activity;
    }

    public final void b()
    {
        at.a(c.getWindow());
        d = i.a();
        if (d == null)
        {
            b.d("Failed to show interstitial ad due to an error in the Activity.", null);
            cb.b();
            c.finish();
            return;
        }
        d.p = c;
        d.a(new a());
        ViewGroup viewgroup = (ViewGroup)d.a().getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(d.a());
        }
        c.setContentView(d.a());
        d.o();
    }

    public final void c()
    {
    }

    public final void d()
    {
    }

    public final void e()
    {
        if (c.isFinishing() && d != null)
        {
            d.j.a();
        }
    }

    public final void f()
    {
    }

    public final boolean g()
    {
        if (d != null)
        {
            return d.r();
        } else
        {
            return false;
        }
    }

}
