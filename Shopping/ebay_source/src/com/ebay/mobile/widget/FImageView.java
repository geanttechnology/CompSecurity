// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class FImageView extends ImageView
{

    private boolean backgroundAsForeground;
    private Drawable foreground;
    private boolean foregroundBoundsChanged;
    private boolean foregroundPadding;
    private final Rect rectPadding;

    public FImageView(Context context)
    {
        super(context);
        rectPadding = new Rect();
        foregroundPadding = false;
        foregroundBoundsChanged = false;
        backgroundAsForeground = false;
    }

    public FImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FImageView(Context context, AttributeSet attributeset, int i)
    {
        Drawable drawable;
        super(context, attributeset, i);
        rectPadding = new Rect();
        foregroundPadding = false;
        foregroundBoundsChanged = false;
        backgroundAsForeground = false;
        context = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.ForegroundLayout, i, 0);
        attributeset = context.getDrawable(0);
        foregroundPadding = context.getBoolean(1, false);
        backgroundAsForeground = context.getBoolean(2, false);
        if (!foregroundPadding && (getBackground() instanceof NinePatchDrawable))
        {
            NinePatchDrawable ninepatchdrawable = (NinePatchDrawable)getBackground();
            if (ninepatchdrawable != null && ninepatchdrawable.getPadding(rectPadding))
            {
                foregroundPadding = true;
            }
        }
        drawable = getBackground();
        if (!backgroundAsForeground || drawable == null) goto _L2; else goto _L1
_L1:
        setForegroundPre23(drawable);
_L4:
        context.recycle();
        return;
_L2:
        if (attributeset != null)
        {
            setForegroundPre23(attributeset);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (foreground != null)
        {
            Drawable drawable = foreground;
            if (foregroundBoundsChanged)
            {
                foregroundBoundsChanged = false;
                int i = getRight() - getLeft();
                int j = getBottom() - getTop();
                if (foregroundPadding)
                {
                    drawable.setBounds(rectPadding.left, rectPadding.top, i - rectPadding.right, j - rectPadding.bottom);
                } else
                {
                    drawable.setBounds(0, 0, i, j);
                }
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f1)
    {
        super.drawableHotspotChanged(f, f1);
        if (foreground != null)
        {
            foreground.setHotspot(f, f1);
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (foreground != null && foreground.isStateful())
        {
            foreground.setState(getDrawableState());
        }
    }

    public Drawable getForegroundPre23()
    {
        return foreground;
    }

    public void jumpDrawablesToCurrentState()
    {
        super.jumpDrawablesToCurrentState();
        if (foreground != null)
        {
            foreground.jumpToCurrentState();
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        foregroundBoundsChanged = true;
    }

    public void setForegroundPre23(Drawable drawable)
    {
        if (foreground != drawable)
        {
            if (foreground != null)
            {
                foreground.setCallback(null);
                unscheduleDrawable(foreground);
            }
            foreground = drawable;
            if (drawable != null)
            {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful())
                {
                    drawable.setState(getDrawableState());
                }
            } else
            {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == foreground;
    }
}
