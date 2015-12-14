// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.util.Utils;
import myobfuscated.dc.b;

public class ZoomCommonView extends View
{

    private static float a = 5F;
    private static float b = 0.7F;
    private static int c = 3;
    private static int d = 5;
    private float e;
    private Bitmap f;
    private int g;
    private int h;
    private Paint i;
    private RectF j;
    private RectF k;
    private boolean l;
    private boolean m;
    private float n;
    private float o;

    public ZoomCommonView(Context context)
    {
        super(context);
        e = 2.0F;
        g = 0;
        h = 0;
        j = new RectF();
        k = new RectF();
        m = false;
        a(context);
    }

    public ZoomCommonView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = 2.0F;
        g = 0;
        h = 0;
        j = new RectF();
        k = new RectF();
        m = false;
        a(context);
    }

    public ZoomCommonView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        e = 2.0F;
        g = 0;
        h = 0;
        j = new RectF();
        k = new RectF();
        m = false;
        a(context);
    }

    private void a(Context context)
    {
        e = Utils.a(c, context);
        Utils.a(d, context);
        i = new Paint();
        i.setFilterBitmap(true);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (f != null && !f.isRecycled())
        {
            canvas.drawBitmap(f, null, j, i);
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        m = false;
        myobfuscated.dc.b.a().a = 0;
        super.onSizeChanged(i1, j1, k1, l1);
        setWithOrientationDefaultSize(i1, j1);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1;
        flag1 = false;
        if (!l)
        {
            return false;
        }
        if (myobfuscated.dc.b.a().a(motionevent, j, k, a, b))
        {
            if (m)
            {
                m = false;
            }
            int i1 = motionevent.getAction() & 0xff;
            if (i1 == 6 || i1 == 1)
            {
                motionevent.getPointerCount();
            }
            invalidate();
            return true;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 116
    //                   0 118
    //                   1 296
    //                   2 142
    //                   3 296;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        return true;
_L2:
        m = true;
        n = motionevent.getX();
        o = motionevent.getY();
        continue; /* Loop/switch isn't completed */
_L4:
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        boolean flag = flag1;
        if (m)
        {
            float f3 = f1 - n;
            float f4 = f2 - o;
            flag = flag1;
            if (Math.sqrt(f3 * f3 + f4 * f4) >= (double)e)
            {
                motionevent = j;
                motionevent.left = ((RectF) (motionevent)).left + f3;
                motionevent = j;
                motionevent.right = f3 + ((RectF) (motionevent)).right;
                motionevent = j;
                motionevent.top = ((RectF) (motionevent)).top + f4;
                motionevent = j;
                motionevent.bottom = f4 + ((RectF) (motionevent)).bottom;
                n = f1;
                o = f2;
                flag = true;
            }
        }
        if (flag)
        {
            invalidate();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        m = false;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setOriginalBitmap(Bitmap bitmap)
    {
        f = bitmap;
        if (f != null && !f.isRecycled())
        {
            g = bitmap.getWidth();
            h = bitmap.getHeight();
            setWithOrientationDefaultSize(getWidth(), getHeight());
        }
    }

    public void setWithOrientationDefaultSize(int i1, int j1)
    {
        int l1 = (int)((float)j1 - 0.0F);
        if (f != null && !f.isRecycled() && i1 > 0 && l1 > 0)
        {
            float f1 = Math.min((float)i1 / (float)g, (float)l1 / (float)h);
            j1 = Math.round((float)g * f1);
            int k1 = Math.round(f1 * (float)h);
            i1 = (i1 - j1) / 2;
            l1 = (l1 - k1) / 2;
            j.set(i1, l1, j1 + i1, l1 + k1);
            k.set(j);
            l = true;
            invalidate();
        }
    }

}
