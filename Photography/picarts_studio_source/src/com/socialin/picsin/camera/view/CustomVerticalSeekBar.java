// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class CustomVerticalSeekBar extends SeekBar
{

    private android.widget.SeekBar.OnSeekBarChangeListener a;
    private int b;

    public CustomVerticalSeekBar(Context context)
    {
        super(context);
        a = null;
        b = 0;
    }

    public CustomVerticalSeekBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        b = 0;
    }

    public CustomVerticalSeekBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = null;
        b = 0;
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
        if (!isEnabled())
        {
            return false;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 44
    //                   0 46
    //                   1 257
    //                   2 141
    //                   3 287;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        int k = getMax() - (int)(((float)getMax() * motionevent.getY()) / (float)getHeight());
        int i = k;
        if (k < 0)
        {
            i = 0;
        }
        k = i;
        if (i > getMax())
        {
            k = getMax();
        }
        setProgress(k);
        if (a != null)
        {
            a.onStartTrackingTouch(this);
        }
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        setPressed(true);
        setSelected(true);
        continue; /* Loop/switch isn't completed */
_L4:
        super.onTouchEvent(motionevent);
        int l = getMax() - (int)(((float)getMax() * motionevent.getY()) / (float)getHeight());
        int j = l;
        if (l < 0)
        {
            j = 0;
        }
        l = j;
        if (j > getMax())
        {
            l = getMax();
        }
        setProgress(l);
        if (l != b)
        {
            b = l;
            if (a != null)
            {
                a.onProgressChanged(this, l, true);
            }
        }
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        setPressed(true);
        setSelected(true);
        continue; /* Loop/switch isn't completed */
_L3:
        if (a != null)
        {
            a.onStopTrackingTouch(this);
        }
        setPressed(false);
        setSelected(false);
        continue; /* Loop/switch isn't completed */
_L5:
        super.onTouchEvent(motionevent);
        setPressed(false);
        setSelected(false);
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void setMaximum(int i)
    {
        this;
        JVM INSTR monitorenter ;
        setMax(i);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setOnSeekBarChangeListener(android.widget.SeekBar.OnSeekBarChangeListener onseekbarchangelistener)
    {
        a = onseekbarchangelistener;
    }

    public void setProgressAndThumb(int i)
    {
        this;
        JVM INSTR monitorenter ;
        b = getMax() - (getMax() - i);
        setProgress(b);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
