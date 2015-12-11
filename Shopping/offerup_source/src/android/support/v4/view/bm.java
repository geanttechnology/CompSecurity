// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            bl

class bm extends bl
{

    bm()
    {
    }

    public final int a(int i, int k)
    {
        return View.combineMeasuredStates(i, k);
    }

    public final int a(int i, int k, int l)
    {
        return View.resolveSizeAndState(i, k, l);
    }

    final long a()
    {
        return ValueAnimator.getFrameDelay();
    }

    public final void a(View view, float f1)
    {
        view.setTranslationX(f1);
    }

    public final void a(View view, int i, Paint paint)
    {
        view.setLayerType(i, paint);
    }

    public final void b(View view, float f1)
    {
        view.setTranslationY(f1);
    }

    public final void b(View view, boolean flag)
    {
        view.setSaveFromParentEnabled(flag);
    }

    public final void c(View view, float f1)
    {
        view.setAlpha(f1);
    }

    public final void c(View view, boolean flag)
    {
        view.setActivated(flag);
    }

    public final void d(View view, float f1)
    {
        view.setScaleX(f1);
    }

    public final void e(View view, float f1)
    {
        view.setScaleY(f1);
    }

    public final float f(View view)
    {
        return view.getAlpha();
    }

    public final int g(View view)
    {
        return view.getLayerType();
    }

    public final int j(View view)
    {
        return view.getMeasuredState();
    }

    public final float n(View view)
    {
        return view.getTranslationX();
    }

    public final float o(View view)
    {
        return view.getTranslationY();
    }

    public final float p(View view)
    {
        return view.getScaleX();
    }

    public final void y(View view)
    {
        view.jumpDrawablesToCurrentState();
    }
}
