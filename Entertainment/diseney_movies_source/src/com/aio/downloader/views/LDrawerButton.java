// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

// Referenced classes of package com.aio.downloader.views:
//            LButton

public class LDrawerButton extends LButton
{

    private final String TAG = "LDrawerButton";
    private int mBaseDegrees;
    private int mCenterX;
    private int mCenterY;
    private int mCurrentDegrees;
    private boolean mIsLeftGravity;
    private float mLeftOffsetY;
    private int mLine1TopBase;
    private int mLine2TopBase;
    private int mLine3TopBase;
    private int mLineHalfWidth;
    private int mLineLeftBase;
    private float mLineLeftOffset;
    private Paint mLinePaint;
    private int mLineRightBase;
    private int mLineSplit;
    private float mRightOffsetY;
    private int mSplitHalfHeight;
    private int mStrokeWidth;

    public LDrawerButton(Context context, AttributeSet attributeset)
    {
        boolean flag = true;
        int i = 0;
        super(context, attributeset);
        mLinePaint = new Paint();
        mCurrentDegrees = 0;
        mIsLeftGravity = true;
        mBaseDegrees = 0;
        mLinePaint.setColor(-1);
        if (attributeset != null)
        {
            context = context.obtainStyledAttributes(attributeset, com.aio.downloader.R.styleable.LButtonStyle);
            if (context.getInt(3, 1) == 2)
            {
                flag = false;
            }
            mIsLeftGravity = flag;
            setDelayClick(context.getBoolean(2, false));
            if (!mIsLeftGravity)
            {
                i = 180;
            }
            mBaseDegrees = i;
            context.recycle();
        }
    }

    private void initDrawer()
    {
        if (getWidth() == 0 || getHeight() == 0)
        {
            return;
        } else
        {
            mCenterX = getWidth() / 2;
            mCenterY = getHeight() / 2;
            mStrokeWidth = getHeight() / 35;
            mLinePaint.setStrokeWidth(mStrokeWidth);
            mLineSplit = mStrokeWidth * 3;
            mLineHalfWidth = (int)((float)getHeight() / 4.5F);
            mLineLeftBase = mCenterX - mLineHalfWidth;
            mLineRightBase = mCenterX + mLineHalfWidth;
            mLine1TopBase = mCenterY - mLineSplit - mStrokeWidth;
            mLine2TopBase = mCenterY;
            mLine3TopBase = mCenterY + mLineSplit + mStrokeWidth;
            mSplitHalfHeight = mLine3TopBase - mLine2TopBase;
            return;
        }
    }

    public void onDrag(boolean flag, float f)
    {
        float f1;
        char c;
        int i;
        if (f < 0.0F)
        {
            f1 = 0.0F;
        } else
        {
            f1 = f;
            if (f > 1.0F)
            {
                f1 = 1.0F;
            }
        }
        mLineLeftOffset = (float)mLineHalfWidth * f1;
        mLeftOffsetY = ((float)mSplitHalfHeight / 1.5F) * f1;
        mRightOffsetY = (float)mSplitHalfHeight * f1;
        if (flag)
        {
            f = 1.0F - f1;
        } else
        {
            f = f1;
        }
        i = (int)(180F * f);
        if (flag)
        {
            c = '\264';
        } else
        {
            c = '\0';
        }
        mCurrentDegrees = c + i + mBaseDegrees;
        invalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mCenterX == 0 || mCenterY == 0)
        {
            initDrawer();
        }
        canvas.rotate(mCurrentDegrees, mCenterX, mCenterY);
        float f = mLineLeftBase;
        float f1 = mLineLeftOffset;
        float f2 = mLine1TopBase;
        float f3 = mLeftOffsetY;
        float f4 = mLineRightBase;
        float f5 = mLine1TopBase;
        canvas.drawLine(f1 + f, f2 - f3, f4, mRightOffsetY + f5, mLinePaint);
        f = mLineLeftBase;
        canvas.drawLine(mLineLeftOffset / 3F + f, mLine2TopBase, mLineRightBase, mLine2TopBase, mLinePaint);
        f = mLineLeftBase;
        f1 = mLineLeftOffset;
        f2 = mLine3TopBase;
        canvas.drawLine(f1 + f, mLeftOffsetY + f2, mLineRightBase, (float)mLine3TopBase - mRightOffsetY, mLinePaint);
    }
}
