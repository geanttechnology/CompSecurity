// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.shazam.android.advert:
//            i, ShazamAdView, l, f, 
//            b

public final class o extends i
{

    protected final TextView f;
    private final ShazamAdView g;
    private final l h = new f() {

        final o a;

        public final void a(ShazamAdView shazamadview3, b b2, String s)
        {
            if (a.a(shazamadview3, i.a.b))
            {
                a.d.a();
            }
        }

            
            {
                a = o.this;
                super();
            }
    };

    public o(i.b b1, ShazamAdView shazamadview, ShazamAdView shazamadview1, ShazamAdView shazamadview2, TextView textview)
    {
        super(b1, shazamadview1, shazamadview2);
        g = shazamadview;
        g.setVisibility(8);
        g.a = false;
        f = textview;
        f.setVisibility(8);
        g.setListener(h);
    }

    public final void a()
    {
        static final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[i.a.values().length];
                try
                {
                    a[i.a.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[i.a.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[i.a.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[i.a.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2.a[e.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 33;
           goto _L1 _L2
_L1:
        super.a();
        return;
_L2:
        b(g);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void a(Activity activity)
    {
        super.a(activity);
        ShazamAdView.a();
    }

    protected final void a(View view)
    {
        super.a(view);
        f.setVisibility(8);
    }

    protected final boolean a(View view, i.a a1)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(2, view.getId());
        layoutparams.addRule(5, view.getId());
        f.setLayoutParams(layoutparams);
        return super.a(view, a1, f);
    }

    public final void b()
    {
        _cls2.a[e.ordinal()];
        JVM INSTR tableswitch 1 1: default 28
    //                   1 33;
           goto _L1 _L2
_L1:
        super.b();
        return;
_L2:
        a(g);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void b(Activity activity)
    {
        super.b(activity);
        g.c();
    }

    protected final void b(View view)
    {
        super.a(view, f);
    }

    public final void c(Activity activity)
    {
        super.c(activity);
        g.d();
    }

    public final boolean c()
    {
        return g.getAndResetAdClick() || super.c();
    }

    protected final void d()
    {
        super.d();
        g.g();
    }

    public final void d(Activity activity)
    {
        super.d(activity);
        ShazamAdView.e();
    }

    public final void e()
    {
        if (e == i.a.b)
        {
            return;
        }
        (new StringBuilder("showLST: currentState: ")).append(e.name());
        _cls2.a[e.ordinal()];
        JVM INSTR tableswitch 2 4: default 68
    //                   2 68
    //                   3 83
    //                   4 94;
           goto _L1 _L1 _L2 _L3
_L1:
        e = i.a.b;
        g.h();
        return;
_L2:
        a(a);
        continue; /* Loop/switch isn't completed */
_L3:
        a(b);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void e(Activity activity)
    {
        super.e(activity);
        g.f();
    }
}
