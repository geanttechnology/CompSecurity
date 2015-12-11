// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

final class bc
{

    public static float a(View view)
    {
        return view.getAlpha();
    }

    static long a()
    {
        return ValueAnimator.getFrameDelay();
    }

    public static void a(View view, float f)
    {
        view.setTranslationX(f);
    }

    public static void a(View view, int i, Paint paint)
    {
        view.setLayerType(i, paint);
    }

    public static int b(View view)
    {
        return view.getLayerType();
    }

    public static void b(View view, float f)
    {
        view.setTranslationY(f);
    }

    public static float c(View view)
    {
        return view.getTranslationX();
    }

    public static void c(View view, float f)
    {
        view.setAlpha(f);
    }

    public static float d(View view)
    {
        return view.getTranslationY();
    }
}
