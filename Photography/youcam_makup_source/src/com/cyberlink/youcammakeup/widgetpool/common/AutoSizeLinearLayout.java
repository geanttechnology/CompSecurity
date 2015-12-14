// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import com.cyberlink.youcammakeup.j;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            c

public class AutoSizeLinearLayout extends LinearLayout
{

    private static int a;
    private static int b;
    private static int c;
    private int d;
    private int e;
    private boolean f;

    public AutoSizeLinearLayout(Context context)
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

    public AutoSizeLinearLayout(Context context, AttributeSet attributeset)
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

    public AutoSizeLinearLayout(Context context, AttributeSet attributeset, int i)
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

    protected c a()
    {
        return new c(-2, -2);
    }

    public c a(AttributeSet attributeset)
    {
        return new c(getContext(), attributeset, d, e, f);
    }

    protected c a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof c;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return a();
    }

    protected android.widget.LinearLayout.LayoutParams generateDefaultLayoutParams()
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

    public android.widget.LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }

    protected android.widget.LinearLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }
}
