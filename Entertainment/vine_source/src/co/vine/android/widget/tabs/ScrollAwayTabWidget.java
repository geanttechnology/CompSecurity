// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.tabs;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TabWidget;

public class ScrollAwayTabWidget extends TabWidget
{

    private int mCurrentDelta;

    public ScrollAwayTabWidget(Context context)
    {
        super(context);
        mCurrentDelta = 0;
    }

    public ScrollAwayTabWidget(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mCurrentDelta = 0;
    }

    public ScrollAwayTabWidget(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mCurrentDelta = 0;
    }

    public void draw(Canvas canvas)
    {
        canvas.save();
        canvas.translate(0.0F, mCurrentDelta);
        super.draw(canvas);
        canvas.restore();
    }

    public int getNavBottom()
    {
        return mCurrentDelta + getHeight();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return motionevent.getY() > (float)getNavBottom();
    }

    public void onScroll(int i)
    {
        int j;
        j = mCurrentDelta;
        mCurrentDelta = mCurrentDelta + i;
        if (mCurrentDelta >= -getHeight()) goto _L2; else goto _L1
_L1:
        mCurrentDelta = -getHeight();
_L4:
        if (mCurrentDelta != j)
        {
            invalidate();
        }
        return;
_L2:
        if (mCurrentDelta > 0)
        {
            mCurrentDelta = 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getY() > (float)getNavBottom())
        {
            return false;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
    }

    public void resetScroll()
    {
        mCurrentDelta = 0;
    }
}
