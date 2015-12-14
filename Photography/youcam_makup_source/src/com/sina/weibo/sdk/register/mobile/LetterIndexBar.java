// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.sina.weibo.sdk.utils.ResourceManager;

public class LetterIndexBar extends View
{

    public static final int INDEX_COUNT_DEFAULT = 27;
    public static final String SEARCH_ICON_LETTER = "";
    private int count;
    private int mIndex;
    private String mIndexLetter[];
    private int mItemHeight;
    private int mItemPadding;
    private OnIndexChangeListener mListener;
    private boolean mNeedIndex[];
    private int mOrgTextSzie;
    private Paint mPaint;
    private RectF mRect;
    private Drawable mSeatchIcon;
    private boolean mTouching;

    public LetterIndexBar(Context context)
    {
        super(context);
        mPaint = new Paint();
        count = 27;
        init();
    }

    public LetterIndexBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mPaint = new Paint();
        count = 27;
        init();
    }

    public LetterIndexBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mPaint = new Paint();
        count = 27;
        init();
    }

    private void init()
    {
        mPaint.setAntiAlias(true);
        mPaint.setStyle(android.graphics.Paint.Style.FILL);
        mPaint.setColor(0xff5d5d5d);
        mOrgTextSzie = ResourceManager.dp2px(getContext(), 13);
    }

    protected void onDraw(Canvas canvas)
    {
        int k = 0;
        boolean flag = false;
        super.onDraw(canvas);
        if (mTouching)
        {
            int i = mPaint.getColor();
            mPaint.setColor(0x88777788);
            canvas.drawRoundRect(mRect, getMeasuredWidth() / 2, getMeasuredWidth() / 2, mPaint);
            mPaint.setColor(i);
        }
        int j;
        if (mOrgTextSzie > mItemHeight)
        {
            j = mItemHeight;
        } else
        {
            j = mOrgTextSzie;
        }
        mPaint.setTextSize(j);
        if (mIndexLetter == null)
        {
            char c = 'A';
            k = ((flag) ? 1 : 0);
            do
            {
label0:
                {
                    if (k >= count)
                    {
                        return;
                    }
                    int l = mItemHeight;
                    int j1 = getPaddingTop();
                    int i2 = mItemPadding;
                    char c1;
                    if (mNeedIndex != null)
                    {
                        c1 = c;
                        if (!mNeedIndex[k])
                        {
                            break label0;
                        }
                    }
                    String s;
                    int k2;
                    if (k == count - 1)
                    {
                        s = "#";
                    } else
                    {
                        char c2 = (char)(c + 1);
                        s = String.valueOf(c);
                        c = c2;
                    }
                    k2 = (int)mPaint.measureText(s);
                    canvas.drawText(s, (getMeasuredWidth() - k2) / 2, i2 + (l * k + j1 + j), mPaint);
                    c1 = c;
                }
                k++;
                c = c1;
            } while (true);
        } else
        {
            while (k < count) 
            {
                int i1 = mItemHeight * k + getPaddingTop() + j + mItemPadding;
                if (mNeedIndex == null || mNeedIndex[k])
                {
                    String s1 = mIndexLetter[k];
                    if (s1.equals(""))
                    {
                        int k1 = (int)mPaint.measureText("M");
                        int j2 = (getMeasuredWidth() - k1) / 2;
                        mSeatchIcon.setBounds(j2, i1 - j2, k1 + j2, (i1 + k1) - j2);
                        mSeatchIcon.draw(canvas);
                    } else
                    {
                        int l1 = (int)mPaint.measureText(s1);
                        canvas.drawText(s1, (getMeasuredWidth() - l1) / 2, i1, mPaint);
                    }
                }
                k++;
            }
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        i = android.view.View.MeasureSpec.getSize(j);
        mItemHeight = (i - getPaddingTop() - getPaddingBottom()) / count;
        mItemPadding = (int)(((float)mItemHeight - mPaint.getTextSize()) / 2.0F);
        setMeasuredDimension(mOrgTextSzie + getPaddingLeft() + getPaddingRight(), j);
        mRect = new RectF(0.0F, getPaddingTop(), getMeasuredWidth(), i - getPaddingTop() - getPaddingBottom());
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 4: default 40
    //                   0 46
    //                   1 131
    //                   2 46
    //                   3 131
    //                   4 131;
           goto _L1 _L2 _L3 _L2 _L3 _L3
_L1:
        invalidate();
        return true;
_L2:
        mTouching = true;
        int i = ((int)motionevent.getY() - getPaddingTop()) / mItemHeight;
        if (i != mIndex && (mNeedIndex == null || mNeedIndex[i]) && i < count && i >= 0)
        {
            mIndex = i;
            if (mListener != null)
            {
                mListener.onIndexChange(mIndex);
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        mTouching = false;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setIndexChangeListener(OnIndexChangeListener onindexchangelistener)
    {
        mListener = onindexchangelistener;
    }

    public void setIndexLetter(String as[])
    {
        if (as == null)
        {
            return;
        } else
        {
            mIndexLetter = as;
            count = mIndexLetter.length;
            mIndex = -1;
            invalidate();
            return;
        }
    }

    public void setIndexMark(boolean aflag[])
    {
        if (aflag == null)
        {
            return;
        } else
        {
            mNeedIndex = aflag;
            invalidate();
            return;
        }
    }

    private class OnIndexChangeListener
    {

        public abstract void onIndexChange(int i);
    }

}
