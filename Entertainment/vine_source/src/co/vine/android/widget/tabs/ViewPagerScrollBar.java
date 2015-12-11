// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.tabs;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.View;
import co.vine.android.VineLoggingException;
import co.vine.android.util.CrashUtil;

public class ViewPagerScrollBar extends View
{

    private int mColorIds[];
    private int mHeight;
    private boolean mNavBottomSet;
    private int mOffset;
    private int mOffsetPixels;
    private final Paint mPaint;
    private int mPosition;
    private int mRange;
    private final RectF mTabBounds;

    public ViewPagerScrollBar(Context context)
    {
        this(context, null, 0x7f010046);
    }

    public ViewPagerScrollBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f010046);
    }

    public ViewPagerScrollBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mHeight = 0;
        mRange = 1;
        mOffset = 0;
        mNavBottomSet = false;
        mPaint = new Paint();
        mTabBounds = new RectF();
        attributeset = context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.ViewPagerScrollBar, i, 0);
        i = attributeset.getResourceId(2, 0);
        mHeight = attributeset.getDimensionPixelSize(1, 0);
        if (i > 0)
        {
            context = context.getResources().obtainTypedArray(i);
            mColorIds = new int[context.length()];
            for (i = 0; i < context.length(); i++)
            {
                mColorIds[i] = context.getColor(i, 0);
            }

            context.recycle();
            mPaint.setColor(mColorIds[0]);
        } else
        {
            mPaint.setColor(attributeset.getColor(0, -1));
        }
        attributeset.recycle();
    }

    public void draw(Canvas canvas)
    {
        canvas.drawRect(mTabBounds, mPaint);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (!mNavBottomSet)
        {
            mOffset = getHeight();
        }
        updateBounds();
    }

    public void scroll(int i, int j)
    {
        mPosition = i;
        mOffsetPixels = (int)FloatMath.ceil(j / mRange);
        updateBounds();
        invalidate();
    }

    public void setColorIds(int i)
    {
        mColorIds = getResources().getIntArray(i);
        mPaint.setColor(mColorIds[0]);
        requestLayout();
        invalidate();
    }

    public void setLineColor(int i)
    {
        mPaint.setColor(i);
    }

    public void setNavOffset(int i)
    {
        mOffset = i;
        mNavBottomSet = true;
        updateBounds();
        invalidate();
    }

    public void setPageColor(int i)
    {
        if (mColorIds != null)
        {
            mPaint.setColor(mColorIds[i]);
        }
    }

    public void setPosition(int i)
    {
        mPosition = i;
        mOffsetPixels = 0;
        updateBounds();
        invalidate();
    }

    public void setRange(int i)
    {
        mRange = i;
        if (mRange == 0)
        {
            mRange = 1;
            CrashUtil.logException(new VineLoggingException("Someone is trying to set the range to be 0, defaulting back to 1."));
        }
        requestLayout();
        invalidate();
    }

    public void updateBounds()
    {
        float f = getWidth() / mRange;
        int i = mOffsetPixels;
        float f1 = mPosition;
        f1 = (float)i + f * f1;
        mTabBounds.set(f1, mOffset - mHeight, f1 + f, mOffset);
    }
}
