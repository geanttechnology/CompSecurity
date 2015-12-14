// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.nineoldandroids.view.ViewHelper;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ContinuousPhotoViewPager extends ViewPager
{

    private static final float SCALE_MAX = 0.5F;
    private static final String TAG = "MyJazzyViewPager";
    private HashMap mChildrenViews;
    private View mLeft;
    private View mRight;
    private float mScale;
    private float mTrans;

    public ContinuousPhotoViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mChildrenViews = new LinkedHashMap();
    }

    private boolean isSmall(float f)
    {
        return (double)Math.abs(f) < 0.0001D;
    }

    protected void animateStack(View view, View view1, float f, int i)
    {
        if (view1 != null)
        {
            mScale = 0.5F * f + 0.5F;
            mTrans = (-getWidth() - getPageMargin()) + i;
            ViewHelper.setScaleX(view1, mScale);
            ViewHelper.setScaleY(view1, mScale);
            ViewHelper.setTranslationX(view1, mTrans);
        }
        if (view != null)
        {
            view.bringToFront();
        }
    }

    public View findViewFromObject(int i)
    {
        return (View)mChildrenViews.get(Integer.valueOf(i));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        try
        {
            flag = super.onInterceptTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            return false;
        }
        return flag;
    }

    public void onPageScrolled(int i, float f, int j)
    {
        float f1;
        if (isSmall(f))
        {
            f1 = 0.0F;
        } else
        {
            f1 = f;
        }
        mLeft = findViewFromObject(i);
        mRight = findViewFromObject(i + 1);
        animateStack(mLeft, mRight, f1, j);
        super.onPageScrolled(i, f, j);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        try
        {
            flag = super.onTouchEvent(motionevent);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            return false;
        }
        return flag;
    }

    public void setObjectForPosition(View view, int i)
    {
        mChildrenViews.put(Integer.valueOf(i), view);
    }
}
