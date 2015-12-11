// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class ee extends ed
{

    ee()
    {
    }

    public final int a(int i, int j, int k)
    {
        return View.resolveSizeAndState(i, j, k);
    }

    final long a()
    {
        return ValueAnimator.getFrameDelay();
    }

    public final void a(View view, float f)
    {
        view.setTranslationY(f);
    }

    public final void a(View view, int i, Paint paint)
    {
        view.setLayerType(i, paint);
    }

    public final int c(View view)
    {
        return view.getMeasuredState();
    }

    public final float d(View view)
    {
        return view.getTranslationY();
    }
}
