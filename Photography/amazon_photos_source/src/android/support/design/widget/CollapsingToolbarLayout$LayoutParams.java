// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package android.support.design.widget:
//            CollapsingToolbarLayout

public static class mParallaxMult extends android.widget.t.LayoutParams
{

    int mCollapseMode;
    float mParallaxMult;

    public void setParallaxMultiplier(float f)
    {
        mParallaxMult = f;
    }

    public (Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mCollapseMode = 0;
        mParallaxMult = 0.5F;
        context = context.obtainStyledAttributes(attributeset, android.support.design.youtParams);
        mCollapseMode = context.getInt(android.support.design.youtParams_layout_collapseMode, 0);
        setParallaxMultiplier(context.getFloat(android.support.design.youtParams_layout_collapseParallaxMultiplier, 0.5F));
        context.recycle();
    }

    public (android.view.out.LayoutParams layoutparams)
    {
        super(layoutparams);
        mCollapseMode = 0;
        mParallaxMult = 0.5F;
    }

    public mParallaxMult(android.widget.t.LayoutParams layoutparams)
    {
        super(layoutparams);
        mCollapseMode = 0;
        mParallaxMult = 0.5F;
    }
}
