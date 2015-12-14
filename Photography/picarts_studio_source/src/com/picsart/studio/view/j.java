// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.support.v4.view.VelocityTrackerCompat;
import android.view.View;

// Referenced classes of package com.picsart.studio.view:
//            o, SlidingUpPanelLayout, n, k

final class j extends o
{

    private SlidingUpPanelLayout a;

    private j(SlidingUpPanelLayout slidinguppanellayout)
    {
        a = slidinguppanellayout;
        super();
    }

    j(SlidingUpPanelLayout slidinguppanellayout, byte byte0)
    {
        this(slidinguppanellayout);
    }

    public final void a()
    {
        if (SlidingUpPanelLayout.d(a).a != 0) goto _L2; else goto _L1
_L1:
        SlidingUpPanelLayout.a(a, SlidingUpPanelLayout.a(a, SlidingUpPanelLayout.c(a).getTop()));
        if (SlidingUpPanelLayout.e(a) != 1.0F) goto _L4; else goto _L3
_L3:
        if (SlidingUpPanelLayout.f(a) != SlidingUpPanelLayout.PanelState.EXPANDED)
        {
            a.a();
            SlidingUpPanelLayout.a(a, SlidingUpPanelLayout.PanelState.EXPANDED);
            SlidingUpPanelLayout slidinguppanellayout = a;
            SlidingUpPanelLayout.c(a);
            slidinguppanellayout.sendAccessibilityEvent(32);
        }
_L2:
        return;
_L4:
        if (SlidingUpPanelLayout.e(a) != 0.0F)
        {
            break; /* Loop/switch isn't completed */
        }
        if (SlidingUpPanelLayout.f(a) != SlidingUpPanelLayout.PanelState.COLLAPSED)
        {
            SlidingUpPanelLayout.a(a, SlidingUpPanelLayout.PanelState.COLLAPSED);
            SlidingUpPanelLayout slidinguppanellayout1 = a;
            SlidingUpPanelLayout.c(a);
            slidinguppanellayout1.sendAccessibilityEvent(32);
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (SlidingUpPanelLayout.e(a) < 0.0F)
        {
            SlidingUpPanelLayout.a(a, SlidingUpPanelLayout.PanelState.HIDDEN);
            SlidingUpPanelLayout.c(a).setVisibility(8);
            SlidingUpPanelLayout slidinguppanellayout2 = a;
            SlidingUpPanelLayout.c(a);
            if (slidinguppanellayout2.b != null)
            {
                slidinguppanellayout2.b.a();
            }
            slidinguppanellayout2.sendAccessibilityEvent(32);
            return;
        }
        if (SlidingUpPanelLayout.f(a) != SlidingUpPanelLayout.PanelState.ANCHORED)
        {
            a.a();
            SlidingUpPanelLayout.a(a, SlidingUpPanelLayout.PanelState.ANCHORED);
            SlidingUpPanelLayout slidinguppanellayout3 = a;
            SlidingUpPanelLayout.c(a);
            slidinguppanellayout3.sendAccessibilityEvent(32);
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public final void a(int i)
    {
        SlidingUpPanelLayout.b(a, i);
        a.invalidate();
    }

    public final void a(View view, float f)
    {
        n n1;
        int i;
        int l;
        float f1 = f;
        if (SlidingUpPanelLayout.g(a))
        {
            f1 = -f;
        }
        if (f1 > 0.0F)
        {
            i = SlidingUpPanelLayout.b(a, 1.0F);
        } else
        {
label0:
            {
                if (f1 < 0.0F)
                {
                    break label0;
                }
                if (SlidingUpPanelLayout.a(a) != 1.0F && SlidingUpPanelLayout.e(a) >= (SlidingUpPanelLayout.a(a) + 1.0F) / 2.0F)
                {
                    i = SlidingUpPanelLayout.b(a, 1.0F);
                } else
                if (SlidingUpPanelLayout.a(a) == 1.0F && SlidingUpPanelLayout.e(a) >= 0.5F)
                {
                    i = SlidingUpPanelLayout.b(a, 1.0F);
                } else
                if (SlidingUpPanelLayout.a(a) != 1.0F && SlidingUpPanelLayout.e(a) >= SlidingUpPanelLayout.a(a))
                {
                    i = SlidingUpPanelLayout.b(a, SlidingUpPanelLayout.a(a));
                } else
                {
                    if (SlidingUpPanelLayout.a(a) == 1.0F || SlidingUpPanelLayout.e(a) < SlidingUpPanelLayout.a(a) / 2.0F)
                    {
                        break label0;
                    }
                    i = SlidingUpPanelLayout.b(a, SlidingUpPanelLayout.a(a));
                }
            }
        }
_L1:
        n1 = SlidingUpPanelLayout.d(a);
        l = view.getLeft();
        if (!n1.n)
        {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        } else
        {
            n1.a(l, i, (int)VelocityTrackerCompat.getXVelocity(n1.i, n1.c), (int)VelocityTrackerCompat.getYVelocity(n1.i, n1.c));
            a.invalidate();
            return;
        }
        i = SlidingUpPanelLayout.b(a, 0.0F);
          goto _L1
    }

    public final boolean a(View view)
    {
        while (SlidingUpPanelLayout.b(a) || view != SlidingUpPanelLayout.c(a)) 
        {
            return false;
        }
        return true;
    }

    public final int b(int i)
    {
        int l = SlidingUpPanelLayout.b(a, 0.0F);
        int i1 = SlidingUpPanelLayout.b(a, 1.0F);
        if (SlidingUpPanelLayout.g(a))
        {
            return Math.min(Math.max(i, i1), l);
        } else
        {
            return Math.min(Math.max(i, l), i1);
        }
    }

    public final void b()
    {
        a.b();
    }

    public final int c()
    {
        return SlidingUpPanelLayout.h(a);
    }
}
