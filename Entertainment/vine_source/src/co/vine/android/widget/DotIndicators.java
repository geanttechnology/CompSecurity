// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DotIndicators extends View
{

    private int mActivePos;
    private int mDotHeight;
    private int mDotPadding;
    private int mDotWidth;
    private Bitmap mFinalIconOff;
    private Bitmap mFinalIconOn;
    private int mFinalIconWidth;
    private int mHeight;
    private int mNum;
    private Bitmap mOff;
    private boolean mOffAlpha;
    private int mOffAlphaValue;
    private Bitmap mOn;
    private Paint mPaint;
    private boolean mShowFinalIcon;
    private int mWidth;

    public DotIndicators(Context context)
    {
        this(context, null);
    }

    public DotIndicators(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DotIndicators(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        attributeset = context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.DotIndicators, i, 0);
        i = attributeset.getResourceId(1, 0x7f020221);
        int j = attributeset.getResourceId(0, 0x7f020222);
        mOff = BitmapFactory.decodeResource(context.getResources(), i);
        mOn = BitmapFactory.decodeResource(context.getResources(), j);
        i = attributeset.getInt(2, 100);
        if (i != 100)
        {
            mOffAlpha = true;
            mOffAlphaValue = i;
        }
        mFinalIconOn = BitmapFactory.decodeResource(context.getResources(), 0x7f020220);
        mFinalIconOff = BitmapFactory.decodeResource(context.getResources(), 0x7f02021f);
        mDotPadding = attributeset.getDimensionPixelOffset(3, 0);
        mFinalIconWidth = mFinalIconOff.getWidth();
        mDotWidth = mOn.getWidth();
        mDotHeight = mOn.getHeight();
        mShowFinalIcon = true;
        mPaint = new Paint();
        attributeset.recycle();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mHeight != 0 && mWidth != 0 && mNum != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int j;
        int k;
        int i = (int)Math.floor(mNum / 2);
        j = mWidth / 2;
        boolean flag;
        if (mShowFinalIcon)
        {
            j = j - (mDotWidth + mDotPadding) * i - mFinalIconWidth / 2;
        } else
        {
            j -= (mDotWidth + mDotPadding) * i;
        }
        if (mShowFinalIcon)
        {
            i = j;
            if (mNum % 2 != 0)
            {
                i = j - (mDotWidth + mDotPadding) / 2;
            }
        } else
        {
            i = j;
            if (mNum % 2 == 0)
            {
                i = j + mDotPadding / 2;
            }
        }
        k = mHeight / 2 - mDotHeight;
        flag = false;
        j = i;
        i = ((flag) ? 1 : 0);
        while (i < mNum) 
        {
            if (mActivePos == i)
            {
                canvas.drawBitmap(mOn, j, k, null);
            } else
            if (mOffAlpha)
            {
                mPaint.setAlpha(mOffAlphaValue);
                canvas.drawBitmap(mOn, j, k, mPaint);
            } else
            {
                canvas.drawBitmap(mOff, j, k, null);
            }
            j += mDotWidth + mDotPadding;
            i++;
        }
        continue; /* Loop/switch isn't completed */
        if (!mShowFinalIcon) goto _L1; else goto _L3
_L3:
        if (mActivePos == mNum)
        {
            canvas.drawBitmap(mFinalIconOn, j, k, null);
            return;
        } else
        {
            canvas.drawBitmap(mFinalIconOff, j, k, null);
            return;
        }
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        mWidth = i;
        mHeight = j;
    }

    public void setActiveDot(int i)
    {
        mActivePos = i;
        invalidate();
    }

    public void setFinalIcon(boolean flag)
    {
        mShowFinalIcon = flag;
    }

    public void setNumberOfDots(int i)
    {
        mNum = i;
    }
}
