// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class al
{

    public static float a(View view)
    {
        return view.getAlpha();
    }

    public static int a(int i, int j)
    {
        return View.combineMeasuredStates(i, j);
    }

    public static int a(int i, int j, int k)
    {
        return View.resolveSizeAndState(i, j, k);
    }

    static long a()
    {
        return ValueAnimator.getFrameDelay();
    }

    public static void a(View view, float f1)
    {
        view.setTranslationX(f1);
    }

    public static void a(View view, int i, Paint paint)
    {
        view.setLayerType(i, paint);
    }

    public static void a(View view, boolean flag)
    {
        view.setSaveFromParentEnabled(flag);
    }

    public static int b(View view)
    {
        return view.getMeasuredWidthAndState();
    }

    public static void b(View view, float f1)
    {
        view.setTranslationY(f1);
    }

    public static void b(View view, boolean flag)
    {
        view.setActivated(flag);
    }

    public static int c(View view)
    {
        return view.getMeasuredState();
    }

    public static void c(View view, float f1)
    {
        view.setAlpha(f1);
    }

    public static float d(View view)
    {
        return view.getTranslationX();
    }

    public static void d(View view, float f1)
    {
        view.setScaleX(f1);
    }

    public static float e(View view)
    {
        return view.getTranslationY();
    }

    public static void e(View view, float f1)
    {
        view.setScaleY(f1);
    }

    public static float f(View view)
    {
        return view.getScaleX();
    }

    public static void g(View view)
    {
        view.jumpDrawablesToCurrentState();
    }
}
