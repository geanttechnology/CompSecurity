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

public static class mScrollFlags extends android.widget.t.LayoutParams
{

    int mScrollFlags;
    Interpolator mScrollInterpolator;

    public int getScrollFlags()
    {
        return mScrollFlags;
    }

    public Interpolator getScrollInterpolator()
    {
        return mScrollInterpolator;
    }

    public (int i, int j)
    {
        super(i, j);
        mScrollFlags = 1;
    }

    public mScrollFlags(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mScrollFlags = 1;
        attributeset = context.obtainStyledAttributes(attributeset, android.support.design.ayoutParams);
        mScrollFlags = attributeset.getInt(android.support.design.ayoutParams_layout_scrollFlags, 0);
        if (attributeset.hasValue(android.support.design.ayoutParams_layout_scrollInterpolator))
        {
            mScrollInterpolator = AnimationUtils.loadInterpolator(context, attributeset.getResourceId(android.support.design.ayoutParams_layout_scrollInterpolator, 0));
        }
        attributeset.recycle();
    }

    public ator(android.view.out.LayoutParams layoutparams)
    {
        super(layoutparams);
        mScrollFlags = 1;
    }

    public mScrollFlags(android.view.ms ms)
    {
        super(ms);
        mScrollFlags = 1;
    }

    public mScrollFlags(android.widget.t.LayoutParams layoutparams)
    {
        super(layoutparams);
        mScrollFlags = 1;
    }
}
