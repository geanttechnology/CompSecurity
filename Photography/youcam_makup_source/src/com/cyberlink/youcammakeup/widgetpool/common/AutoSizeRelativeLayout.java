// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.cyberlink.youcammakeup.j;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            d

public class AutoSizeRelativeLayout extends RelativeLayout
{

    private static int a;
    private static int b;
    private static int c;
    private int d;
    private boolean e;
    private int f;

    public AutoSizeRelativeLayout(Context context)
    {
        super(context);
        context = getResources().getDisplayMetrics();
        a = ((DisplayMetrics) (context)).densityDpi;
        b = ((DisplayMetrics) (context)).widthPixels;
        c = ((DisplayMetrics) (context)).heightPixels;
        e = false;
        d = 0;
        f = 0;
    }

    public AutoSizeRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        a = displaymetrics.densityDpi;
        b = displaymetrics.widthPixels;
        c = displaymetrics.heightPixels;
        context = context.obtainStyledAttributes(attributeset, j.AutoResizeLayout);
        d = context.getInteger(0, 0);
        f = context.getInteger(1, 0);
        e = context.getBoolean(2, false);
        context.recycle();
    }

    public AutoSizeRelativeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        a = displaymetrics.densityDpi;
        b = displaymetrics.widthPixels;
        c = displaymetrics.heightPixels;
        context = context.obtainStyledAttributes(attributeset, j.AutoResizeLayout);
        d = context.getInteger(0, 0);
        f = context.getInteger(1, 0);
        e = context.getBoolean(2, false);
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

    protected d a()
    {
        return new d(-2, -2);
    }

    public d a(AttributeSet attributeset)
    {
        return new d(getContext(), attributeset, d, f, e);
    }

    protected d a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof d;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
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

    public android.widget.RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return a(attributeset);
    }
}
