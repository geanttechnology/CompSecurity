// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;

public class TouchableImageView extends ImageView
{

    private Drawable mForeground;
    private boolean mForegroundBoundsChanged;
    private final int mForegroundGravity;
    private final Rect mOverlayBounds;
    private final Rect mSelfBounds;

    public TouchableImageView(Context context)
    {
        super(context);
        mForegroundGravity = 119;
        mForegroundBoundsChanged = false;
        mSelfBounds = new Rect();
        mOverlayBounds = new Rect();
    }

    public TouchableImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public TouchableImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mForegroundGravity = 119;
        mForegroundBoundsChanged = false;
        mSelfBounds = new Rect();
        mOverlayBounds = new Rect();
        context = getContext().obtainStyledAttributes(new int[] {
            0x101030e
        });
        attributeset = context.getDrawable(0);
        if (attributeset != null)
        {
            setForeground(attributeset);
        }
        context.recycle();
    }

    private void setForeground(Drawable drawable)
    {
        if (mForeground != drawable)
        {
            if (mForeground != null)
            {
                mForeground.setCallback(null);
                unscheduleDrawable(mForeground);
            }
            mForeground = drawable;
            if (drawable != null)
            {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful())
                {
                    drawable.setState(getDrawableState());
                }
                drawable.getPadding(new Rect());
            } else
            {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (mForeground != null)
        {
            Drawable drawable = mForeground;
            if (mForegroundBoundsChanged)
            {
                mForegroundBoundsChanged = false;
                Rect rect = mSelfBounds;
                Rect rect1 = mOverlayBounds;
                rect.set(0, 0, getRight() - getLeft(), getBottom() - getTop());
                Gravity.apply(119, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect1);
                drawable.setBounds(rect1);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f1)
    {
        super.drawableHotspotChanged(f, f1);
        if (android.os.Build.VERSION.SDK_INT >= 21 && mForeground != null)
        {
            mForeground.setHotspot(f, f1);
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (mForeground != null && mForeground.isStateful())
        {
            mForeground.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState()
    {
        super.jumpDrawablesToCurrentState();
        if (mForeground != null)
        {
            mForeground.jumpToCurrentState();
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        mForegroundBoundsChanged = flag;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        mForegroundBoundsChanged = true;
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == mForeground;
    }
}
