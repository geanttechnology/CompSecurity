// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class VerticalSeekBar extends SeekBar
{

    private static final int APPEAR_ENABLED_STATE_SET[];
    private boolean appearEnabled;
    private android.widget.SeekBar.OnSeekBarChangeListener onVerticalSeekBarChangeListener;
    private int w;
    private int x;
    private int y;
    private int z;

    public VerticalSeekBar(Context context)
    {
        super(context);
        appearEnabled = true;
    }

    public VerticalSeekBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        appearEnabled = true;
    }

    public VerticalSeekBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        appearEnabled = true;
    }

    private void trackTouchEvent(MotionEvent motionevent)
    {
        int j = getPaddingTop();
        int i = getPaddingBottom();
        int k = getHeight() - j - i;
        int l = (int)motionevent.getY();
        float f;
        float f1;
        if (l < j)
        {
            i = j;
        } else
        {
            i = l;
            if (l > k)
            {
                i = k;
            }
        }
        f = (float)(i - j) / (float)k;
        i = getMax();
        f1 = 0.0F + (float)i * (1.0F - f);
        if (f1 < 0.0F)
        {
            f = 0.0F;
        } else
        {
            f = f1;
            if (f1 > (float)i)
            {
                f = i;
            }
        }
        setProgress((int)f);
    }

    public boolean appearEnabled()
    {
        return appearEnabled;
    }

    protected int[] onCreateDrawableState(int i)
    {
        int ai[] = super.onCreateDrawableState(i + 1);
        if (appearEnabled())
        {
            mergeDrawableStates(ai, APPEAR_ENABLED_STATE_SET);
        }
        return ai;
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
        x = i;
        y = j;
        z = k;
        w = l;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!isEnabled())
        {
            return false;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 40
    //                   0 42
    //                   1 94
    //                   2 72;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        setSelected(true);
        setPressed(true);
        if (onVerticalSeekBarChangeListener != null)
        {
            onVerticalSeekBarChangeListener.onStartTrackingTouch(this);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        trackTouchEvent(motionevent);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        continue; /* Loop/switch isn't completed */
_L3:
        setSelected(false);
        setPressed(false);
        if (onVerticalSeekBarChangeListener != null)
        {
            onVerticalSeekBarChangeListener.onStopTrackingTouch(this);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setAppearEnabled(boolean flag)
    {
        appearEnabled = flag;
        refreshDrawableState();
        invalidate();
    }

    public void setOnVerticalSeekBarChangeListener(android.widget.SeekBar.OnSeekBarChangeListener onseekbarchangelistener)
    {
        onVerticalSeekBarChangeListener = onseekbarchangelistener;
    }

    public void setProgress(int i)
    {
        this;
        JVM INSTR monitorenter ;
        super.setProgress(Math.max(i, 0));
        onSizeChanged(x, y, z, w);
        if (onVerticalSeekBarChangeListener != null)
        {
            onVerticalSeekBarChangeListener.onProgressChanged(this, i, true);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        APPEAR_ENABLED_STATE_SET = (new int[] {
            com.xfinity.playerlib.R.attr.state_appear_enabled
        });
    }
}
