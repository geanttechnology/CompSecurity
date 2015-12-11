// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

// Referenced classes of package com.tapjoy.internal:
//            aq

public class ap extends aq
{

    private int a;
    private final Matrix b = new Matrix();
    private final float c[] = new float[2];

    public ap(Context context)
    {
        super(context);
        a = 0;
    }

    protected void dispatchDraw(Canvas canvas)
    {
        int i;
        int j;
        if (a == 0)
        {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        i = getWidth();
        j = getHeight();
        canvas.clipRect(0.0F, 0.0F, i, j, android.graphics.Region.Op.REPLACE);
        ViewGroup viewgroup = (ViewGroup)getParent();
        ViewGroup viewgroup1;
        boolean flag;
        viewgroup1 = (ViewGroup)viewgroup.getParent();
        if (viewgroup1 instanceof ScrollView)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        flag = viewgroup1 instanceof HorizontalScrollView;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        viewgroup = viewgroup1;
_L13:
        try
        {
            int k = getLeft() - viewgroup.getScrollX();
            int l = getTop() - viewgroup.getScrollY();
            canvas.clipRect(0 - k, 0 - l, viewgroup.getWidth() - k, viewgroup.getHeight() - l, android.graphics.Region.Op.INTERSECT);
        }
        catch (Exception exception) { }
        canvas.rotate(a * 90);
        a;
        JVM INSTR tableswitch 1 3: default 180
    //                   1 188
    //                   2 252
    //                   3 267;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalStateException();
_L2:
        canvas.translate(0.0F, -i);
_L9:
        b.setRotate(a * -90);
        a;
        JVM INSTR tableswitch 1 3: default 244
    //                   1 279
    //                   2 303
    //                   3 324;
           goto _L5 _L6 _L7 _L8
_L5:
        throw new IllegalStateException();
_L3:
        canvas.translate(-i, -j);
          goto _L9
_L4:
        canvas.translate(-j, 0.0F);
          goto _L9
_L6:
        b.postTranslate(0.0F, i - 1);
_L11:
        super.dispatchDraw(canvas);
        canvas.restore();
        return;
_L7:
        b.postTranslate(i - 1, j - 1);
        continue; /* Loop/switch isn't completed */
_L8:
        b.postTranslate(j - 1, 0.0F);
        if (true) goto _L11; else goto _L10
_L10:
        Exception exception1;
        exception1;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (a == 0)
        {
            return super.dispatchTouchEvent(motionevent);
        } else
        {
            float af[] = c;
            af[0] = motionevent.getX();
            af[1] = motionevent.getY();
            b.mapPoints(af);
            motionevent.setLocation(af[0], af[1]);
            return super.dispatchTouchEvent(motionevent);
        }
    }

    public int getRotationCount()
    {
        return a;
    }

    public void onMeasure(int i, int j)
    {
        if (a % 2 == 0)
        {
            super.onMeasure(i, j);
            return;
        } else
        {
            super.onMeasure(j, i);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    public void setRotationCount(int i)
    {
        a = i & 3;
    }
}
