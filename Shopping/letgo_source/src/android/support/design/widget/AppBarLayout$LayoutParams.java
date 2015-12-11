// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

// Referenced classes of package android.support.design.widget:
//            AppBarLayout

public static class a extends android.widget.t.LayoutParams
{

    int a;
    Interpolator b;

    public int a()
    {
        return a;
    }

    public Interpolator b()
    {
        return b;
    }

    public (int i, int j)
    {
        super(i, j);
        a = 1;
    }

    public a(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 1;
        attributeset = context.obtainStyledAttributes(attributeset, android.support.v7.ams);
        a = attributeset.getInt(android.support.v7.ams_layout_scrollFlags, 0);
        if (attributeset.hasValue(android.support.v7.ams_layout_scrollInterpolator))
        {
            b = AnimationUtils.loadInterpolator(context, attributeset.getResourceId(android.support.v7.ams_layout_scrollInterpolator, 0));
        }
        attributeset.recycle();
    }

    public scrollInterpolator(android.view.out.LayoutParams layoutparams)
    {
        super(layoutparams);
        a = 1;
    }

    public a(android.view.ms ms)
    {
        super(ms);
        a = 1;
    }

    public a(android.widget.t.LayoutParams layoutparams)
    {
        super(layoutparams);
        a = 1;
    }
}
