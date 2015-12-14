// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.j;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            b

public class AutoSizeFrameLayout extends FrameLayout
{

    private static int a;
    private static int b;
    private static int c;
    private int d;
    private int e;
    private boolean f;

    public AutoSizeFrameLayout(Context context)
    {
        super(context);
        context = getResources().getDisplayMetrics();
        a = ((DisplayMetrics) (context)).densityDpi;
        b = ((DisplayMetrics) (context)).widthPixels;
        c = ((DisplayMetrics) (context)).heightPixels;
        f = false;
        d = 0;
        e = 0;
    }

    public AutoSizeFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        a = displaymetrics.densityDpi;
        b = displaymetrics.widthPixels;
        c = displaymetrics.heightPixels;
        context = context.obtainStyledAttributes(attributeset, j.AutoResizeLayout);
        d = context.getInteger(0, 0);
        e = context.getInteger(1, 0);
        f = context.getBoolean(2, false);
        context.recycle();
    }

    public AutoSizeFrameLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        a = displaymetrics.densityDpi;
        b = displaymetrics.widthPixels;
        c = displaymetrics.heightPixels;
        context = context.obtainStyledAttributes(attributeset, j.AutoResizeLayout);
        d = context.getInteger(0, 0);
        e = context.getInteger(1, 0);
        f = context.getBoolean(2, false);
        context.recycle();
    }

    static int b()
    {
        return c;
    }

    static int c()
    {
        return b;
    }

    static int d()
    {
        return a;
    }

    protected b a()
    {
        return new b(-2, -2);
    }

    public b a(AttributeSet attributeset)
    {
        return new b(getContext(), attributeset, d, e, f);
    }

    protected b a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof b;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return a();
    }

    protected android.widget.FrameLayout.LayoutParams generateDefaultLayoutParams()
    {
        return a();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }
}
