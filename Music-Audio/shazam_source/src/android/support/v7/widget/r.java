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
//            RecyclerView

public abstract class r extends RecyclerView.q
{

    private final float a;
    protected final LinearInterpolator b = new LinearInterpolator();
    protected final DecelerateInterpolator c = new DecelerateInterpolator();
    protected PointF d;
    protected int e;
    protected int f;

    public r(Context context)
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

    protected final void a(int i, int j, RecyclerView.q.a a1)
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
                    a1.a = super.g;
                    b();
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
                    a1.a((int)((float)e * 1.2F), (int)((float)f * 1.2F), (int)((float)i * 1.2F), b);
                    return;
                }
            }
        }
    }

    protected final void a(View view, RecyclerView.q.a a1)
    {
        boolean flag = true;
        int i1 = 0;
        RecyclerView.i i;
        int k;
        int l;
        if (d == null || d.x == 0.0F)
        {
            k = 0;
        } else
        if (d.x > 0.0F)
        {
            k = 1;
        } else
        {
            k = -1;
        }
        i = super.i;
        if (!i.c())
        {
            l = 0;
        } else
        {
            RecyclerView.j j = (RecyclerView.j)view.getLayoutParams();
            l = RecyclerView.i.d(view);
            int i2 = j.leftMargin;
            int k2 = RecyclerView.i.f(view);
            l = a(l - i2, j.rightMargin + k2, i.m(), i.k() - i.o(), k);
        }
        if (d == null || d.y == 0.0F)
        {
            k = 0;
        } else
        {
            k = ((flag) ? 1 : 0);
            if (d.y <= 0.0F)
            {
                k = -1;
            }
        }
        i = super.i;
        if (!i.d())
        {
            k = i1;
        } else
        {
            RecyclerView.j j1 = (RecyclerView.j)view.getLayoutParams();
            int k1 = RecyclerView.i.e(view);
            int l1 = j1.topMargin;
            int j2 = RecyclerView.i.g(view);
            k = a(k1 - l1, j1.bottomMargin + j2, i.n(), i.l() - i.p(), k);
        }
        i1 = (int)Math.ceil((double)b((int)Math.sqrt(l * l + k * k)) / 0.33560000000000001D);
        if (i1 > 0)
        {
            a1.a(-l, -k, i1, c);
        }
    }
}
