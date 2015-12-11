// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;

// Referenced classes of package android.support.design.widget:
//            bo, bt, bp

final class bs extends bo
{

    private ValueAnimator a;

    bs()
    {
        a = new ValueAnimator();
    }

    public final void a()
    {
        a.start();
    }

    public final void a(int i)
    {
        a.setDuration(i);
    }

    public final void a(int i, int j)
    {
        a.setIntValues(new int[] {
            i, j
        });
    }

    public final void a(bp bp)
    {
        a.addUpdateListener(new bt(this, bp));
    }

    public final void a(Interpolator interpolator)
    {
        a.setInterpolator(interpolator);
    }

    public final boolean b()
    {
        return a.isRunning();
    }

    public final int c()
    {
        return ((Integer)a.getAnimatedValue()).intValue();
    }

    public final void d()
    {
        a.cancel();
    }
}
