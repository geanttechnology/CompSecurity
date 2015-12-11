// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

// Referenced classes of package android.support.v7.widget:
//            bd, RecyclerView, au, be, 
//            av

public abstract class ac extends bd
{

    private final float a;
    protected final LinearInterpolator b = new LinearInterpolator();
    protected final DecelerateInterpolator c = new DecelerateInterpolator();
    protected PointF d;
    protected int e;
    protected int f;

    public ac(Context context)
    {
        e = 0;
        f = 0;
        a = 25F / (float)context.getResources().getDisplayMetrics().densityDpi;
    }

    private static int a(int i, int j)
    {
        int k = i - j;
        j = k;
        if (i * k <= 0)
        {
            j = 0;
        }
        return j;
    }

    private static int a(int i, int j, int k, int l, int i1)
    {
        i1;
        JVM INSTR tableswitch -1 1: default 28
    //                   -1 38
    //                   0 48
    //                   1 44;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
_L2:
        i = k - i;
_L6:
        return i;
_L4:
        return l - j;
_L3:
        k -= i;
        i = k;
        if (k <= 0)
        {
            j = l - j;
            i = j;
            if (j >= 0)
            {
                return 0;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private int b(int i)
    {
        return (int)Math.ceil((float)Math.abs(i) * a);
    }

    public abstract PointF a(int i);

    protected final void a()
    {
        f = 0;
        e = 0;
        d = null;
    }

    protected final void a(int i, int j, be be1)
    {
        if (RecyclerView.e(super.h).j() == 0)
        {
            b();
        } else
        {
            e = a(e, i);
            f = a(f, j);
            if (e == 0 && f == 0)
            {
                PointF pointf = a(super.g);
                if (pointf == null || pointf.x == 0.0F && pointf.y == 0.0F)
                {
                    Log.e("LinearSmoothScroller", "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
                    i = super.g;
                    b();
                    super.h.a(i);
                    return;
                } else
                {
                    double d1 = Math.sqrt(pointf.x * pointf.x + pointf.y * pointf.y);
                    pointf.x = (float)((double)pointf.x / d1);
                    pointf.y = (float)((double)pointf.y / d1);
                    d = pointf;
                    e = (int)(pointf.x * 10000F);
                    f = (int)(pointf.y * 10000F);
                    i = b(10000);
                    be1.a((int)((float)e * 1.2F), (int)((float)f * 1.2F), (int)((float)i * 1.2F), b);
                    return;
                }
            }
        }
    }

    protected final void a(View view, be be1)
    {
        boolean flag = true;
        int k = 0;
        au au1;
        int i;
        int j;
        if (d == null || d.x == 0.0F)
        {
            i = 0;
        } else
        if (d.x > 0.0F)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        au1 = super.i;
        if (!au1.e())
        {
            j = 0;
        } else
        {
            av av1 = (av)view.getLayoutParams();
            j = au.d(view);
            int j1 = av1.leftMargin;
            int l1 = au.f(view);
            j = a(j - j1, av1.rightMargin + l1, au1.m(), au1.k() - au1.o(), i);
        }
        if (d == null || d.y == 0.0F)
        {
            i = 0;
        } else
        {
            i = ((flag) ? 1 : 0);
            if (d.y <= 0.0F)
            {
                i = -1;
            }
        }
        au1 = super.i;
        if (!au1.f())
        {
            i = k;
        } else
        {
            av av2 = (av)view.getLayoutParams();
            int l = au.e(view);
            int i1 = av2.topMargin;
            int k1 = au.g(view);
            i = a(l - i1, av2.bottomMargin + k1, au1.n(), au1.l() - au1.p(), i);
        }
        k = (int)Math.ceil((double)b((int)Math.sqrt(j * j + i * i)) / 0.33560000000000001D);
        if (k > 0)
        {
            be1.a(-j, -i, k, c);
        }
    }
}
