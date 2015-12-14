// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import android.graphics.PointF;
import android.view.MotionEvent;

// Referenced classes of package w.panzoomview:
//            PanZoomView, b, a

class k extends android.view.GestureDetector.SimpleOnGestureListener
{

    final PanZoomView a;
    private float b;
    private float c;
    private int d;
    private float e;

    k(PanZoomView panzoomview)
    {
        a = panzoomview;
        super();
        b = 0.0F;
        c = 0.0F;
        d = 0;
        e = 0.0F;
    }

    public void a(MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() == 2)
        {
            int j = motionevent.getActionIndex();
            for (int i = 0; i < motionevent.getPointerCount(); i++)
            {
                if (i != j)
                {
                    float f = motionevent.getX(i);
                    float f1 = motionevent.getY(i);
                    b = f;
                    c = f1;
                }
            }

        }
    }

    public void b(MotionEvent motionevent)
    {
        float f = motionevent.getX();
        float f1 = motionevent.getY();
        float f2 = b;
        float f3 = c;
        motionevent = new PointF((float)a.getWidth() / 2.0F - f, (float)a.getHeight() / 2.0F - f1);
        PointF pointf = new PointF(f - f2, f1 - f3);
        PanZoomView.b(a, motionevent, pointf, 1.0F);
        b = 0.0F;
        c = 0.0F;
    }

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        while (!a.b() || PanZoomView.c(a)) 
        {
            return false;
        }
        PanZoomView.a(a, true);
        float f;
        float f1;
        float f2;
        if (PanZoomView.b(a) == PanZoomView.ViewerMode.a)
        {
            PanZoomView.a(a, PanZoomView.ViewerMode.d);
        } else
        if (PanZoomView.b(a) == PanZoomView.ViewerMode.c)
        {
            PanZoomView.d(a);
        }
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        if (a.b.i < 0.9999F)
        {
            f = 1.0F;
        } else
        {
            f = a.b.h;
        }
        a.a(PanZoomView.ScaleMode.a, f1, f2, f);
        return true;
    }

    public boolean onDown(MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() > 1)
        {
            return true;
        } else
        {
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            b = f;
            c = f1;
            d = motionevent.getPointerId(0);
            e = a.b.i;
            return true;
        }
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        boolean flag = true;
        if (a.c.c)
        {
            flag = super.onFling(motionevent, motionevent1, f, f1);
        } else
        if (PanZoomView.b(a) == PanZoomView.ViewerMode.b)
        {
            motionevent = new PointF(motionevent1.getX() + f * 0.3F, motionevent1.getY() + 0.3F * f1);
            PanZoomView.a(a, motionevent, f, f1);
            return true;
        }
        return flag;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (motionevent != null && motionevent1 != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        float f2;
        float f3;
        float f4;
        float f5;
        f1 = motionevent1.getX();
        f = motionevent1.getY();
        float f6 = motionevent1.getX() - b;
        float f7 = motionevent1.getY() - c;
        if (motionevent.getPointerCount() <= 1)
        {
            f3 = f7;
            f2 = f6;
            f4 = f;
            f5 = f1;
            if (motionevent1.getPointerCount() <= 1)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        int i = motionevent1.findPointerIndex(d);
        f3 = f7;
        f2 = f6;
        if (i > 0)
        {
            f1 = motionevent1.getX(i);
            f = motionevent1.getY(i);
            f2 = f1 - b;
            f3 = f - c;
        }
        f4 = f;
        f5 = f1;
        if (Math.abs(e - a.b.i) > 0.0F)
        {
            e = a.b.i;
            b = f1;
            c = f;
            return true;
        }
        if (PanZoomView.a(a).booleanValue()) goto _L1; else goto _L3
_L3:
        motionevent = new PointF((float)a.getWidth() / 2.0F - f5, (float)a.getHeight() / 2.0F - f4);
        motionevent1 = new PointF(f2, f3);
        PanZoomView.a(a, motionevent, motionevent1, 1.0F);
        b = f5;
        c = f4;
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        return PanZoomView.b(a) == PanZoomView.ViewerMode.a;
    }
}
