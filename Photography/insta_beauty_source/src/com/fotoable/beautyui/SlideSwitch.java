// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import ki;
import kj;
import kk;

public class SlideSwitch extends View
{

    private static int RIM_SIZE = 0;
    public static final int SHAPE_CIRCLE = 2;
    public static final int SHAPE_RECT = 1;
    private int COLOR_THEME;
    private int alpha;
    private Rect backRect;
    private int color_theme;
    private int diffX;
    private int eventLastX;
    private int eventStartX;
    private Rect frontRect;
    private int frontRect_left;
    private int frontRect_left_begin;
    private boolean isOpen;
    private kk listener;
    private int max_left;
    private int min_left;
    private Paint paint;
    private int shape;

    public SlideSwitch(Context context)
    {
        this(context, null);
    }

    public SlideSwitch(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SlideSwitch(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        COLOR_THEME = 0;
        frontRect_left_begin = RIM_SIZE;
        diffX = 0;
        listener = null;
        paint = new Paint();
        paint.setAntiAlias(true);
        COLOR_THEME = getResources().getColor(0x7f0c009d);
        color_theme = COLOR_THEME;
        isOpen = false;
        shape = 2;
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

    public void initDrawingVal()
    {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        backRect = new Rect(0, 0, i, j);
        min_left = RIM_SIZE;
        if (shape == 1)
        {
            max_left = i / 2;
        } else
        {
            max_left = i - (j - RIM_SIZE * 2) - RIM_SIZE;
        }
        if (isOpen)
        {
            frontRect_left = max_left;
            alpha = 255;
        } else
        {
            frontRect_left = RIM_SIZE;
            alpha = 0;
        }
        frontRect_left_begin = frontRect_left;
    }

    public void initState(boolean flag)
    {
        isOpen = flag;
        initDrawingVal();
        invalidateView();
    }

    public int measureDimension(int i, int j)
    {
        int l = android.view.View.MeasureSpec.getMode(j);
        int k = android.view.View.MeasureSpec.getSize(j);
        if (l == 0x40000000)
        {
            j = k;
        } else
        {
            j = i;
            if (l == 0x80000000)
            {
                return Math.min(i, k);
            }
        }
        return j;
    }

    public void moveToDest(boolean flag)
    {
        (new Thread(new kj(this, flag, new ki(this)))).start();
    }

    protected void onDraw(Canvas canvas)
    {
        if (shape == 1)
        {
            paint.setAntiAlias(true);
            paint.setColor(0xff888888);
            canvas.drawRect(backRect, paint);
            paint.setColor(color_theme);
            paint.setAlpha(alpha);
            canvas.drawRect(backRect, paint);
            frontRect = new Rect(frontRect_left, RIM_SIZE, (frontRect_left + getMeasuredWidth() / 2) - RIM_SIZE, getMeasuredHeight() - RIM_SIZE);
            paint.setColor(-1);
            canvas.drawRect(frontRect, paint);
            return;
        } else
        {
            int i = backRect.height() / 2 - RIM_SIZE;
            paint.setColor(0xff888888);
            canvas.drawRoundRect(new RectF(backRect), i, i, paint);
            paint.setColor(color_theme);
            paint.setAlpha(alpha);
            canvas.drawRoundRect(new RectF(backRect), i, i, paint);
            frontRect = new Rect(frontRect_left, RIM_SIZE, (frontRect_left + backRect.height()) - RIM_SIZE * 2, backRect.height() - RIM_SIZE);
            paint.setColor(-1);
            canvas.drawRoundRect(new RectF(frontRect), i, i, paint);
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        int k = measureDimension(280, i);
        j = measureDimension(140, j);
        i = k;
        if (shape == 2)
        {
            i = k;
            if (k < j)
            {
                i = (int)((double)j * 1.6659999999999999D);
            }
        }
        setMeasuredDimension(i, j);
        initDrawingVal();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1 = false;
        MotionEventCompat.getActionMasked(motionevent);
        JVM INSTR tableswitch 0 2: default 32
    //                   0 92
    //                   1 32
    //                   2 103;
           goto _L1 _L2 _L1 _L3
_L1:
        int i = (int)(motionevent.getRawX() - (float)eventStartX);
        frontRect_left_begin = frontRect_left;
        int j;
        boolean flag;
        if (frontRect_left_begin > max_left / 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (Math.abs(i) < 3)
        {
            if (!flag)
            {
                flag1 = true;
            }
        } else
        {
            flag1 = flag;
        }
        moveToDest(flag1);
_L5:
        return true;
_L2:
        eventStartX = (int)motionevent.getRawX();
        return true;
_L3:
        eventLastX = (int)motionevent.getRawX();
        diffX = eventLastX - eventStartX;
        j = diffX + frontRect_left_begin;
        i = j;
        if (j > max_left)
        {
            i = max_left;
        }
        j = i;
        if (i < min_left)
        {
            j = min_left;
        }
        if (j >= min_left && j <= max_left)
        {
            frontRect_left = j;
            alpha = (int)(((float)j * 255F) / (float)max_left);
            invalidateView();
            return true;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void setShapeType(int i)
    {
        shape = i;
    }

    public void setSlideListener(kk kk1)
    {
        listener = kk1;
    }

    public void setState(boolean flag, boolean flag1)
    {
label0:
        {
            isOpen = flag;
            initDrawingVal();
            invalidateView();
            if (flag1 && listener != null)
            {
                if (!flag)
                {
                    break label0;
                }
                listener.a();
            }
            return;
        }
        listener.b();
    }

    static 
    {
        RIM_SIZE = 1;
    }




/*
    public static int access$102(SlideSwitch slideswitch, int i)
    {
        slideswitch.frontRect_left = i;
        return i;
    }

*/



/*
    public static int access$302(SlideSwitch slideswitch, int i)
    {
        slideswitch.alpha = i;
        return i;
    }

*/



/*
    public static int access$502(SlideSwitch slideswitch, int i)
    {
        slideswitch.frontRect_left_begin = i;
        return i;
    }

*/



/*
    public static boolean access$602(SlideSwitch slideswitch, boolean flag)
    {
        slideswitch.isOpen = flag;
        return flag;
    }

*/

}
