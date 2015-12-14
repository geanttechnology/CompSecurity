// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.other;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import nk;

public class SeperateMovieBar extends View
{

    private int mBarColor;
    private int mBarHeight;
    private MovieBarState mBarState;
    private int mBlankWidth;
    private int mCurrentPos;
    private int mDelBarColor;
    private int mEmptyColor;
    private nk mMovieHandler;
    private Paint mPaint;
    private List mRectList;
    private int mTipColor;
    private int mTotalHeight;
    private int mTotalWidth;

    public SeperateMovieBar(Context context)
    {
        this(context, null);
    }

    public SeperateMovieBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SeperateMovieBar(Context context, AttributeSet attributeset, int i)
    {
        int k;
        boolean flag = false;
        super(context, attributeset, i);
        mCurrentPos = 0;
        mRectList = new ArrayList();
        mMovieHandler = null;
        context = context.getTheme().obtainStyledAttributes(attributeset, com.fotoable.fotobeauty.R.styleable.SeperateMovieBar, i, 0);
        k = context.getIndexCount();
        i = ((flag) ? 1 : 0);
_L7:
        int j;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        j = context.getIndex(i);
        j;
        JVM INSTR tableswitch 0 3: default 100
    //                   0 107
    //                   1 122
    //                   2 137
    //                   3 164;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_164;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L8:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        mBarColor = context.getColor(j, 0xff00ff00);
          goto _L8
_L3:
        mDelBarColor = context.getColor(j, 0xffff0000);
          goto _L8
_L4:
        mBarHeight = context.getDimensionPixelSize(j, (int)TypedValue.applyDimension(2, 10F, getResources().getDisplayMetrics()));
          goto _L8
        mBlankWidth = context.getDimensionPixelSize(j, (int)TypedValue.applyDimension(2, 2.0F, getResources().getDisplayMetrics()));
          goto _L8
        Log.e("test", (new StringBuilder()).append("mBarColor = ").append(mBarColor).toString());
        context.recycle();
        return;
    }

    private void invalidateView()
    {
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            invalidate();
            return;
        } else
        {
            postInvalidate();
            return;
        }
    }

    private boolean isInsideBound()
    {
        return mCurrentPos < getMeasuredWidth();
    }

    public void clear()
    {
        mRectList.clear();
        mCurrentPos = 0;
        invalidateView();
    }

    public void deleteMovie()
    {
        if (mRectList.size() < 1)
        {
            return;
        } else
        {
            mCurrentPos = ((Rect)mRectList.get(mRectList.size() - 1)).left - mBlankWidth;
            mRectList.remove(mRectList.size() - 1);
            invalidateView();
            return;
        }
    }

    public MovieBarState getBarState()
    {
        return mBarState;
    }

    protected void onDraw(Canvas canvas)
    {
        mPaint = new Paint();
        Log.e("test", (new StringBuilder()).append("mPaint=").append(mPaint).toString());
        Log.e("test", (new StringBuilder()).append("mBarState=").append(mBarState).toString());
        Log.e("test", (new StringBuilder()).append("mRectList.size=").append(mRectList.size()).toString());
        Log.e("test", (new StringBuilder()).append("getMeasuredHeight()=").append(getMeasuredHeight()).toString());
        Log.e("test", (new StringBuilder()).append("getMeasuredWidth()=").append(getMeasuredWidth()).toString());
        mPaint.setColor(mBarColor);
        if (mBarState == MovieBarState.STATE_CAPTURING)
        {
            for (int i = 0; i < mRectList.size(); i++)
            {
                canvas.drawRect((Rect)mRectList.get(i), mPaint);
            }

        } else
        if (mBarState == MovieBarState.STATE_PREPARE_DELETE && mRectList.size() > 0)
        {
            for (int j = 0; j < mRectList.size() - 1; j++)
            {
                canvas.drawRect((Rect)mRectList.get(j), mPaint);
            }

            mPaint.setColor(mDelBarColor);
            canvas.drawRect((Rect)mRectList.get(mRectList.size() - 1), mPaint);
        }
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
    }

    public void processCapturing()
    {
        if (mRectList.size() < 1)
        {
            return;
        }
        if (!isInsideBound())
        {
            mMovieHandler.sendEmptyMessage(2);
            return;
        } else
        {
            mCurrentPos = mCurrentPos + 1;
            ((Rect)mRectList.get(mRectList.size() - 1)).right = mCurrentPos;
            Log.e("test", "invalidateView start");
            invalidateView();
            return;
        }
    }

    public void setBarState(MovieBarState moviebarstate)
    {
        mBarState = moviebarstate;
        invalidateView();
    }

    public void setMovieHandler(nk nk1)
    {
        mMovieHandler = nk1;
    }

    public void startCapture()
    {
        if (!isInsideBound())
        {
            return;
        }
        if (mCurrentPos > 0)
        {
            mCurrentPos = mCurrentPos + mBlankWidth;
        }
        Rect rect = new Rect(mCurrentPos, 0, mCurrentPos, mBarHeight);
        mRectList.add(rect);
    }

    public void stopCapture()
    {
        if (mRectList.size() >= 1);
    }

    private class MovieBarState extends Enum
    {

        private static final MovieBarState $VALUES[];
        public static final MovieBarState STATE_CAPTURING;
        public static final MovieBarState STATE_PREPARE_DELETE;

        public static MovieBarState valueOf(String s)
        {
            return (MovieBarState)Enum.valueOf(com/fotoable/beautyui/other/SeperateMovieBar$MovieBarState, s);
        }

        public static MovieBarState[] values()
        {
            return (MovieBarState[])$VALUES.clone();
        }

        static 
        {
            STATE_CAPTURING = new MovieBarState("STATE_CAPTURING", 0);
            STATE_PREPARE_DELETE = new MovieBarState("STATE_PREPARE_DELETE", 1);
            $VALUES = (new MovieBarState[] {
                STATE_CAPTURING, STATE_PREPARE_DELETE
            });
        }

        private MovieBarState(String s, int i)
        {
            super(s, i);
        }
    }

}
