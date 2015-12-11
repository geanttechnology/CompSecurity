// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.shazam.android.b.d;
import com.shazam.i.b.c;

// Referenced classes of package com.shazam.android.advert:
//            ShazamAdView, l, f, b, 
//            a

public class i
{
    protected static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/shazam/android/advert/i$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("IDLE", 0);
            b = new a("TAGGING", 1);
            c = new a("DEFAULT", 2);
            d = new a("DEFAULT_FACEBOOK", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int j)
        {
            super(s, j);
        }
    }

    public static interface b
    {

        public abstract void a();

        public abstract void o_();
    }


    protected final ShazamAdView a;
    protected final ShazamAdView b;
    final Animation c;
    protected final b d;
    protected a e;
    private final l f = new f() {

        final i a;

        public final void a(ShazamAdView shazamadview2, com.shazam.android.advert.b b2, com.shazam.android.advert.a a1, String s)
        {
            if (i.a(a, com.shazam.android.advert.a.c))
            {
                a.e = com.shazam.android.advert.a.d;
                a.b.h();
            }
        }

        public final void a(ShazamAdView shazamadview2, com.shazam.android.advert.b b2, String s)
        {
            if (a.a(shazamadview2, com.shazam.android.advert.a.c))
            {
                a.d.o_();
            }
        }

        public final void b(ShazamAdView shazamadview2, com.shazam.android.advert.b b2, String s)
        {
            super.b(shazamadview2, b2, s);
        }

            
            {
                a = i.this;
                super();
            }
    };
    private final l g = new f() {

        final i a;

        public final void a(ShazamAdView shazamadview2, com.shazam.android.advert.b b2, com.shazam.android.advert.a a1, String s)
        {
            if (i.a(a, com.shazam.android.advert.a.d))
            {
                a.a();
            }
        }

        public final void a(ShazamAdView shazamadview2, com.shazam.android.advert.b b2, String s)
        {
            if (a.a(shazamadview2, com.shazam.android.advert.a.d))
            {
                a.d.o_();
            }
        }

            
            {
                a = i.this;
                super();
            }
    };
    private final Animation h;
    private final Animation i = AnimationUtils.loadAnimation(com.shazam.i.b.c.a(), 0x7f040012);

    public i(b b1, ShazamAdView shazamadview, ShazamAdView shazamadview1)
    {
        e = a.a;
        d = b1;
        a = shazamadview;
        a.setVisibility(8);
        b = shazamadview1;
        b.setVisibility(8);
        b1 = AnimationUtils.loadAnimation(com.shazam.i.b.c.a(), 0x7f040010);
        c = b1;
        h = b1;
        a.setListener(f);
        b.setListener(g);
    }

    private boolean a(a a1)
    {
        if (e != a1)
        {
            (new StringBuilder("showViewIfState but no longer in ")).append(a1.name());
            return false;
        } else
        {
            return true;
        }
    }

    static boolean a(i j, a a1)
    {
        return j.a(a1);
    }

    public void a()
    {
        (new StringBuilder("showIdle: currentState: ")).append(e.name());
        static final class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[a.values().length];
                try
                {
                    a[com.shazam.android.advert.a.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.shazam.android.advert.a.d.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4.a[e.ordinal()];
        JVM INSTR tableswitch 1 2: default 52
    //                   1 60
    //                   2 71;
           goto _L1 _L2 _L3
_L1:
        e = a.a;
        return;
_L2:
        b(a);
        continue; /* Loop/switch isn't completed */
_L3:
        b(b);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void a(Activity activity)
    {
        ShazamAdView.a();
        ShazamAdView.a();
    }

    protected void a(View view)
    {
        if (view.getVisibility() == 0)
        {
            i.cancel();
            i.reset();
            i.setAnimationListener(new d(view, 8));
            view.startAnimation(i);
        }
    }

    protected final void a(View view, View view1)
    {
        for (int j = 0; j < 2; j++)
        {
            View view2 = (new View[] {
                view, view1
            })[j];
            if (view2 == null || view2.getVisibility() != 0)
            {
                continue;
            }
            i.cancel();
            h.cancel();
            if (view2.getAnimation() != null)
            {
                view2.clearAnimation();
            }
            view2.setVisibility(8);
        }

    }

    protected boolean a(View view, a a1)
    {
        return a(view, a1, null);
    }

    protected final boolean a(View view, a a1, View view1)
    {
        if (!a(a1))
        {
            return false;
        } else
        {
            h.cancel();
            h.reset();
            h.setAnimationListener(new d(view, view1) {

                final View a;
                final i b;

                public final void onAnimationStart(Animation animation)
                {
                    super.onAnimationStart(animation);
                    if (a != null)
                    {
                        b.c.cancel();
                        b.c.reset();
                        b.c.setAnimationListener(new d(a, 0));
                        a.clearAnimation();
                        a.startAnimation(b.c);
                    }
                }

            
            {
                b = i.this;
                a = view1;
                super(view, 0);
            }
            });
            view.clearAnimation();
            view.startAnimation(h);
            return true;
        }
    }

    public void b()
    {
        if (e == com.shazam.android.advert.a.c)
        {
            return;
        } else
        {
            (new StringBuilder("showAd: currentState: ")).append(e.name());
            e = com.shazam.android.advert.a.c;
            a.h();
            return;
        }
    }

    public void b(Activity activity)
    {
        a.c();
        b.c();
    }

    protected void b(View view)
    {
        a(view, ((View) (null)));
    }

    public void c(Activity activity)
    {
        a.d();
        b.d();
        d();
    }

    public boolean c()
    {
        return a.getAndResetAdClick() || b.getAndResetAdClick();
    }

    protected void d()
    {
        a.g();
        b.g();
    }

    public void d(Activity activity)
    {
        ShazamAdView.e();
        ShazamAdView.e();
    }

    public void e(Activity activity)
    {
        a.f();
        b.f();
    }
}
