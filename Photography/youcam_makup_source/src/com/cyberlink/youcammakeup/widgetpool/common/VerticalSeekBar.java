// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class VerticalSeekBar extends SeekBar
{

    private int a;
    private android.widget.SeekBar.OnSeekBarChangeListener b;

    public VerticalSeekBar(Context context)
    {
        super(context);
        a = 0;
    }

    public VerticalSeekBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0;
    }

    public VerticalSeekBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = 0;
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.rotate(-90F);
        canvas.translate(-getHeight(), 0.0F);
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        super.onMeasure(j, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(j, i, l, k);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int j;
        if (!isEnabled())
        {
            return false;
        }
        j = getMax() - (int)(((float)getMax() * (motionevent.getY() - (float)getPaddingRight())) / (float)(getHeight() - getPaddingLeft() - getPaddingRight()));
        int i = j;
        if (j < 0)
        {
            i = 0;
        }
        j = i;
        if (i > getMax())
        {
            j = getMax();
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 104
    //                   0 106
    //                   1 257
    //                   2 187
    //                   3 287;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        if (b != null)
        {
            b.onStartTrackingTouch(this);
        }
        setProgress(j);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        if (j != a)
        {
            a = j;
            if (b != null)
            {
                b.onProgressChanged(this, j, true);
            }
        }
        setPressed(true);
        setSelected(true);
        continue; /* Loop/switch isn't completed */
_L4:
        super.onTouchEvent(motionevent);
        setProgress(j);
        if (j != a)
        {
            a = j;
            if (b != null)
            {
                b.onProgressChanged(this, j, true);
            }
        }
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        setPressed(true);
        setSelected(true);
        continue; /* Loop/switch isn't completed */
_L3:
        if (b != null)
        {
            b.onStopTrackingTouch(this);
        }
        setPressed(false);
        setSelected(false);
        continue; /* Loop/switch isn't completed */
_L5:
        super.onTouchEvent(motionevent);
        if (b != null)
        {
            b.onStopTrackingTouch(this);
        }
        setPressed(false);
        setSelected(false);
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void setOnSeekBarChangeListener(android.widget.SeekBar.OnSeekBarChangeListener onseekbarchangelistener)
    {
        b = onseekbarchangelistener;
    }

    public void setProgressAndThumb(int i)
    {
        this;
        JVM INSTR monitorenter ;
        setProgress(i);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        if (i != a)
        {
            a = i;
            if (b != null)
            {
                b.onProgressChanged(this, i, false);
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
