// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

final class x
{

    public static Object a(Context context, Interpolator interpolator)
    {
        if (interpolator != null)
        {
            return new OverScroller(context, interpolator);
        } else
        {
            return new OverScroller(context);
        }
    }

    public static void a(Object obj, int i, int j)
    {
        ((OverScroller)obj).fling(0, 0, i, j, 0x80000000, 0x7fffffff, 0x80000000, 0x7fffffff);
    }

    public static void a(Object obj, int i, int j, int k, int l, int i1)
    {
        ((OverScroller)obj).startScroll(i, j, k, l, i1);
    }

    public static boolean a(Object obj)
    {
        return ((OverScroller)obj).isFinished();
    }

    public static int b(Object obj)
    {
        return ((OverScroller)obj).getCurrX();
    }

    public static int c(Object obj)
    {
        return ((OverScroller)obj).getCurrY();
    }

    public static boolean d(Object obj)
    {
        return ((OverScroller)obj).computeScrollOffset();
    }

    public static void e(Object obj)
    {
        ((OverScroller)obj).abortAnimation();
    }

    public static int f(Object obj)
    {
        return ((OverScroller)obj).getFinalX();
    }

    public static int g(Object obj)
    {
        return ((OverScroller)obj).getFinalY();
    }
}
