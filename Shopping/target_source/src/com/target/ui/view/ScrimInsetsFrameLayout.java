// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout extends FrameLayout
{

    private Drawable mInsetForeground;
    private Rect mInsets;
    private Rect mTempRect;

    public ScrimInsetsFrameLayout(Context context)
    {
        super(context);
        mTempRect = new Rect();
        a(context, null, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mTempRect = new Rect();
        a(context, attributeset, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mTempRect = new Rect();
        a(context, attributeset, i);
    }

    private void a(Context context, AttributeSet attributeset, int i)
    {
        context = context.obtainStyledAttributes(attributeset, com.target.ui.a.a.ScrimInsetsView, i, 0);
        if (context == null)
        {
            return;
        } else
        {
            mInsetForeground = context.getDrawable(0);
            context.recycle();
            setWillNotDraw(true);
            return;
        }
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        int i = getWidth();
        int j = getHeight();
        if (mInsets != null && mInsetForeground != null)
        {
            int k = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            mTempRect.set(0, 0, i, mInsets.top);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);
            mTempRect.set(0, j - mInsets.bottom, i, j);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);
            mTempRect.set(0, mInsets.top, mInsets.left, j - mInsets.bottom);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);
            mTempRect.set(i - mInsets.right, mInsets.top, i, j - mInsets.bottom);
            mInsetForeground.setBounds(mTempRect);
            mInsetForeground.draw(canvas);
            canvas.restoreToCount(k);
        }
    }

    protected boolean fitSystemWindows(Rect rect)
    {
        mInsets = new Rect(rect);
        boolean flag;
        if (mInsetForeground == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        ai.d(this);
        return true;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mInsetForeground != null)
        {
            mInsetForeground.setCallback(this);
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mInsetForeground != null)
        {
            mInsetForeground.setCallback(null);
        }
    }
}
