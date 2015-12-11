// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.shazam.android.p.c;
import com.shazam.android.p.m;

public class b extends FrameLayout
{

    private boolean hasArrangedChildren;
    private final m platformChecker;

    public b(Context context)
    {
        super(context);
        hasArrangedChildren = false;
        platformChecker = new c();
    }

    public b(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        hasArrangedChildren = false;
        platformChecker = new c();
    }

    public b(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        hasArrangedChildren = false;
        platformChecker = new c();
    }

    private void arrangeChildren()
    {
        android.widget.FrameLayout.LayoutParams layoutparams = layoutParamsFrom(getBottomView());
        android.widget.FrameLayout.LayoutParams layoutparams1 = layoutParamsFrom(getTopView());
        layoutparams.gravity = 81;
        layoutparams1.gravity = 49;
        getBottomView().setLayoutParams(layoutparams);
        getTopView().setLayoutParams(layoutparams1);
        hasArrangedChildren = true;
    }

    private boolean hasProperChildren()
    {
        return getChildCount() == 2 && getBottomView() != null && getTopView() != null;
    }

    private android.widget.FrameLayout.LayoutParams layoutParamsFrom(View view)
    {
        view = view.getLayoutParams();
        if (view instanceof android.widget.FrameLayout.LayoutParams)
        {
            return (android.widget.FrameLayout.LayoutParams)view;
        }
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(view);
        if (view instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            layoutparams.topMargin = ((android.view.ViewGroup.MarginLayoutParams)view).topMargin;
            layoutparams.leftMargin = ((android.view.ViewGroup.MarginLayoutParams)view).leftMargin;
            layoutparams.bottomMargin = ((android.view.ViewGroup.MarginLayoutParams)view).bottomMargin;
            layoutparams.rightMargin = ((android.view.ViewGroup.MarginLayoutParams)view).rightMargin;
            if (platformChecker.b())
            {
                layoutparams.setMarginStart(((android.view.ViewGroup.MarginLayoutParams)view).getMarginStart());
                layoutparams.setMarginEnd(((android.view.ViewGroup.MarginLayoutParams)view).getMarginEnd());
            }
        }
        return layoutparams;
    }

    public View getBottomView()
    {
        return findViewById(0x7f110007);
    }

    public View getTopView()
    {
        return findViewById(0x7f110036);
    }

    public void hideBottomBar(Runnable runnable)
    {
        View view = getBottomView();
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F, (float)view.getHeight()
        });
        valueanimator.addListener(new _cls1(view, runnable));
        valueanimator.addUpdateListener(new _cls2(view));
        valueanimator.start();
    }

    public void hideBottomBarNoAnimation()
    {
        getBottomView().setVisibility(8);
    }

    protected void onMeasure(int i, int j)
    {
        if (hasProperChildren())
        {
            if (!hasArrangedChildren)
            {
                arrangeChildren();
            }
            int l = android.view.View.MeasureSpec.getSize(j);
            int i1 = getPaddingTop();
            int j1 = getPaddingBottom();
            android.view.ViewGroup.LayoutParams layoutparams = getTopView().getLayoutParams();
            View view = getBottomView();
            android.view.ViewGroup.LayoutParams layoutparams1 = view.getLayoutParams();
            int k;
            if (view.getVisibility() == 8)
            {
                k = 0;
            } else
            {
                k = (int)((float)layoutparams1.height - view.getTranslationY());
            }
            k = l - i1 - j1 - k;
            if (layoutparams.height != k)
            {
                layoutparams.height = k;
                getTopView().setLayoutParams(layoutparams);
            }
        }
        super.onMeasure(i, j);
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
