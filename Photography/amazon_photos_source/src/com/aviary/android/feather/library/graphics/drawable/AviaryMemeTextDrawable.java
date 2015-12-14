// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;

// Referenced classes of package com.aviary.android.feather.library.graphics.drawable:
//            AviaryTextDrawable, EditableDrawable, FeatherDrawable

public class AviaryMemeTextDrawable extends AviaryTextDrawable
    implements EditableDrawable, FeatherDrawable
{

    public static final int CURSOR_BLINK_TIME = 300;
    public static final float MAX_SIZE_DIVIDE = 7F;
    public static final float PAD_HORIZONTAL_DIVIDE = 40F;
    private boolean mBoundsChanged;
    protected int mContentHeight;
    protected int mContentWidth;
    private Paint mTempPaint;
    private boolean mTextChanged;
    boolean mTop;
    private float maxSize;
    private float padW;
    private float xoff;
    private float yoff;

    public AviaryMemeTextDrawable(String s, float f, Typeface typeface, boolean flag)
    {
        super(s, f, typeface);
        mTextChanged = true;
        mBoundsChanged = true;
        mTop = flag;
        mTempPaint = new Paint(mPaint);
        setText(s);
    }

    public void draw(Canvas canvas)
    {
        copyBounds(drawRect);
        if (mDebugPaint != null)
        {
            canvas.drawRect(drawRect, mDebugPaint);
        }
        int i = getNumLines();
        getFontMetrics(metrics);
        float f1 = metrics.ascent - (metrics.top - metrics.ascent);
        float f;
        float f2;
        if (mTop)
        {
            f = drawRect.top - f1;
        } else
        {
            f = drawRect.bottom - (metrics.bottom - metrics.descent);
        }
        f2 = drawRect.left + xoff;
        canvas.drawText(mText, f2, f, mStrokePaint);
        canvas.drawText(mText, f2, f, mPaint);
        if (mEditing)
        {
            long l = System.currentTimeMillis();
            if (l - mNow > 300L)
            {
                float f3;
                boolean flag;
                if (!mShowCursor)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                mShowCursor = flag;
                mNow = l;
            }
            if (mShowCursor)
            {
                getLineBounds(i - 1, lastRect);
                f2 = mCursorDistance + f2 + (float)lastRect.width();
                f1 = f + f1;
                f3 = f2 + mCursorWidth;
                canvas.drawRect(f2, f1, f3, f, mStrokePaint);
                canvas.drawRect(f2, f1, f3, f, mCursorPaint);
            }
        }
    }

    public int getIntrinsicHeight()
    {
        return (int)mPaint.getTextSize();
    }

    public int getIntrinsicWidth()
    {
        return mContentWidth;
    }

    public int getNumLines()
    {
        return 1;
    }

    public float getXoff()
    {
        return xoff;
    }

    public float getYoff()
    {
        return yoff;
    }

    protected void onTextInvalidate()
    {
        invalidateSize();
    }

    public void setBounds(float f, float f1, float f2, float f3)
    {
        if (f != mBoundsF.left || f1 != mBoundsF.top || f2 != mBoundsF.right || f3 != mBoundsF.bottom)
        {
            mBoundsF.set(f, f1, f2, f3);
            mBoundsChanged = true;
            mContentWidth = (int)mBoundsF.width();
        }
        if (mTextChanged || mBoundsChanged)
        {
            f1 = mDefaultTextSize;
            mTempPaint.setTextSize(f1);
            if (mText.length() > 0)
            {
                f = mTempPaint.measureText(mText);
            } else
            {
                f = mTempPaint.measureText("a");
            }
            f1 = Math.min(f1 * ((mBoundsF.width() - padW * 2.0F) / f), maxSize);
            mPaint.setTextSize(f1);
            mStrokePaint.setTextSize(f1);
            mStrokePaint.setStrokeWidth(f1 / 10F);
            mCursorDistance = mStrokePaint.getStrokeWidth();
            if (mText.length() > 0)
            {
                f = mPaint.measureText(mText);
            } else
            {
                f = mPaint.measureText("a");
            }
            yoff = f1;
            xoff = (mBoundsF.width() - f) / 2.0F;
            mTextChanged = false;
            mBoundsChanged = false;
        }
    }

    public void setContentSize(float f, float f1)
    {
        mContentWidth = (int)f;
        mContentHeight = (int)f1;
        maxSize = Math.min(f, f1) / 7F;
        padW = f / 40F;
    }

    public void setText(String s)
    {
        super.setText(s.toUpperCase());
        mTextChanged = true;
    }

    public void setTextSize(float f)
    {
        if (f != getTextSize())
        {
            mTextChanged = true;
        }
    }

    public boolean validateSize(RectF rectf)
    {
        return true;
    }
}
