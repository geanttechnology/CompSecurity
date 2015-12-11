// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class OverlayImageView extends ImageView
{

    private boolean mFramed;
    private int mImageHeight;
    private int mImageWidth;
    private Drawable mOverlayDrawable;

    public OverlayImageView(Context context)
    {
        super(context);
        init(context, null);
    }

    public OverlayImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context, attributeset);
    }

    public OverlayImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context, attributeset);
    }

    private void init(Context context, AttributeSet attributeset)
    {
        if (attributeset == null)
        {
            return;
        }
        context = context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.OverlayImageView);
        attributeset = context.getDrawable(0);
        if (attributeset != null)
        {
            setOverlayDrawable(attributeset);
        }
        context.recycle();
    }

    private void setDrawableBounds(Drawable drawable)
    {
        if (mFramed && drawable != null)
        {
            drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            invalidate();
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        Drawable drawable = mOverlayDrawable;
        if (drawable != null && drawable.isStateful())
        {
            drawable.setState(getDrawableState());
        }
    }

    public void invalidateDrawable(Drawable drawable)
    {
        if (drawable == mOverlayDrawable)
        {
            invalidate();
            return;
        } else
        {
            super.invalidateDrawable(drawable);
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Drawable drawable = mOverlayDrawable;
        if (drawable != null)
        {
            drawable.draw(canvas);
        }
    }

    protected void onMeasure(int i, int j)
    {
        int j1 = mImageWidth;
        int i1 = mImageHeight;
        if (j1 > 0 && i1 > 0)
        {
            int k = getDefaultSize(j1, i);
            int l = getDefaultSize(i1, j);
            int k1 = j1 * l;
            int l1 = i1 * k;
            if (k1 > l1)
            {
                i = l1 / j1;
                j = k;
            } else
            {
                i = l;
                j = k;
                if (k1 < l1)
                {
                    j = k1 / i1;
                    i = l;
                }
            }
            setMeasuredDimension(j, i);
        } else
        {
            super.onMeasure(i, j);
        }
        setDrawableBounds(mOverlayDrawable);
    }

    protected boolean setFrame(int i, int j, int k, int l)
    {
        boolean flag = super.setFrame(i, j, k, l);
        mFramed = true;
        setDrawableBounds(mOverlayDrawable);
        return flag;
    }

    public void setImageSize(int i, int j)
    {
        int k = mImageWidth;
        int l = mImageHeight;
        if (k != i || l != j)
        {
            mImageWidth = i;
            mImageHeight = j;
            requestLayout();
        }
    }

    public void setOverlayDrawable(int i)
    {
        setOverlayDrawable(getResources().getDrawable(i));
    }

    public void setOverlayDrawable(Drawable drawable)
    {
        if (mOverlayDrawable != drawable)
        {
            if (mOverlayDrawable != null)
            {
                mOverlayDrawable.setCallback(null);
                unscheduleDrawable(mOverlayDrawable);
            }
            mOverlayDrawable = drawable;
            if (drawable != null)
            {
                drawable.setCallback(this);
                if (drawable.isStateful())
                {
                    drawable.setState(getDrawableState());
                }
            }
            requestLayout();
        }
    }
}
