// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.anim;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ExpandCollapseAnimation extends Animation
{

    private int mAnimType;
    private int mFullHeight;
    private int mMinHeight;
    private Rect mRect;
    private boolean mShowExpandedArea;
    private View mView;

    public ExpandCollapseAnimation(View view, int i, int j, boolean flag, long l)
    {
        mView = view;
        mFullHeight = j;
        mAnimType = i;
        mShowExpandedArea = flag;
        setDuration(l);
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        super.applyTransformation(f, transformation);
        if (mAnimType == 1)
        {
            if (f < 1.0F)
            {
                int i = Math.max((int)((float)mFullHeight * f), mMinHeight);
                mView.getLayoutParams().height = i;
            } else
            {
                mView.getLayoutParams().height = mFullHeight;
            }
            if (mShowExpandedArea)
            {
                if (mRect == null)
                {
                    mRect = new Rect();
                }
                mView.getHitRect(mRect);
                mView.requestRectangleOnScreen(mRect);
            }
        } else
        if (f < 1.0F)
        {
            int j = Math.max(mFullHeight - (int)((float)mFullHeight * f), mMinHeight);
            mView.getLayoutParams().height = j;
        } else
        {
            mView.getLayoutParams().height = mMinHeight;
        }
        mView.requestLayout();
    }

    public void setMinHeight(int i)
    {
        mMinHeight = i;
    }
}
