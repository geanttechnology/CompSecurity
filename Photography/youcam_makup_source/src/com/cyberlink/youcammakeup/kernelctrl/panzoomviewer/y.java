// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import java.util.HashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer, c, q, t, 
//            ak, aj, n

class y extends android.view.GestureDetector.SimpleOnGestureListener
{

    final PanZoomViewer a;
    private float b;
    private float c;
    private int d;
    private float e;
    private MotionEvent f;

    y(PanZoomViewer panzoomviewer)
    {
        a = panzoomviewer;
        super();
        b = 0.0F;
        c = 0.0F;
        d = 0;
        e = 0.0F;
        f = null;
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
                    float f1 = motionevent.getX(i);
                    float f2 = motionevent.getY(i);
                    b = f1;
                    c = f2;
                    PanZoomViewer.a(a, (new StringBuilder()).append("onPointerUp focus X: ").append(b).append(" focus Y: ").append(c).toString());
                }
            }

        }
    }

    public void b(MotionEvent motionevent)
    {
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        float f3 = f1 - b;
        float f4 = f2 - c;
        PanZoomViewer.a(a, (new StringBuilder()).append("onActionUp focus x: ").append(f1).append(" focux y: ").append(f2).append(" translate x: ").append(f3).append(" translate y: ").append(f4).append(" scale: ").append(1.0F).toString());
        if (a.E && VenusHelper.a().b())
        {
            motionevent = a.a(f1, f2, false);
            VenusHelper.a().b(((c) (motionevent)).a * (float)a.m.b, ((c) (motionevent)).b * (float)a.m.c);
            VenusHelper.a().c();
        }
        motionevent = new PointF((float)a.getWidth() / 2.0F - f1, (float)a.getHeight() / 2.0F - f2);
        PointF pointf = new PointF(f3, f4);
        PanZoomViewer.b(a, motionevent, pointf, 1.0F);
        b = 0.0F;
        c = 0.0F;
    }

    public void c(MotionEvent motionevent)
    {
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        if (a.E && !PanZoomViewer.d(a).booleanValue())
        {
            float f3;
            float f4;
            float f5;
            float f6;
            PointF pointf;
            if (!VenusHelper.a().b() && f != null)
            {
                c c1 = a.a(f.getX(), f.getY(), false);
                VenusHelper.a().a(c1.a * (float)a.m.b, c1.b * (float)a.m.c);
                f.recycle();
                f = null;
            } else
            {
                c c2 = a.a(f1, f2, false);
                VenusHelper.a().b(c2.a * (float)a.m.b, c2.b * (float)a.m.c);
            }
            f3 = motionevent.getX();
            f4 = b;
            f5 = motionevent.getY();
            f6 = c;
            motionevent = new PointF((float)a.getWidth() / 2.0F - f1, (float)a.getHeight() / 2.0F - f2);
            pointf = new PointF(f3 - f4, f5 - f6);
            PanZoomViewer.a(a, motionevent, pointf, 1.0F);
            b = f1;
            c = f2;
        }
    }

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        PanZoomViewer.a(a, "onDoubleTap");
        if (!a.j())
        {
            return false;
        }
        if (PanZoomViewer.f(a) == PanZoomViewer.ViewerMode.c)
        {
            return false;
        }
        BeautyMode beautymode = StatusManager.j().s();
        if (beautymode == BeautyMode.x || beautymode == BeautyMode.z || beautymode == BeautyMode.A || beautymode == BeautyMode.B || beautymode == BeautyMode.C)
        {
            return false;
        }
        if (PanZoomViewer.g(a))
        {
            return false;
        }
        if (PanZoomViewer.b(a).containsKey(PanZoomViewer.c(a)) && StatusManager.j().B())
        {
            return false;
        }
        PanZoomViewer.a(a, true);
        float f1;
        float f2;
        float f3;
        if (PanZoomViewer.f(a) == PanZoomViewer.ViewerMode.a)
        {
            PanZoomViewer.a(a, PanZoomViewer.ViewerMode.f);
        } else
        if (PanZoomViewer.f(a) == PanZoomViewer.ViewerMode.d)
        {
            PanZoomViewer.h(a);
        }
        f2 = motionevent.getX();
        f3 = motionevent.getY();
        motionevent = new PointF();
        if (a.m.q.d < 0.9999F)
        {
            f1 = 1.0F;
            c c1 = a.a(f2, f3, false);
            motionevent.set(c1.a * (float)a.m.e, c1.b * (float)a.m.f);
        } else
        {
            f1 = a.m.q.c;
            motionevent.set((float)a.m.e / 2.0F, (float)a.m.f / 2.0F);
        }
        motionevent = (new ak()).a(aj.b).b(motionevent).a(-1F).b(f1).a(true).b(true).a(300L).a();
        a.a(motionevent, null);
        return true;
    }

    public boolean onDown(MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() > 1)
        {
            return true;
        }
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        b = f1;
        c = f2;
        d = motionevent.getPointerId(0);
        e = a.m.q.d;
        if (motionevent.getActionMasked() == 0)
        {
            f = MotionEvent.obtain(motionevent);
        }
        PanZoomViewer.a(a, (new StringBuilder()).append("onDown focus X: ").append(b).append(" focus Y: ").append(c).toString());
        return true;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
    {
        boolean flag1 = true;
        if (!a.w.c) goto _L2; else goto _L1
_L1:
        boolean flag = super.onFling(motionevent, motionevent1, f1, f2);
_L4:
        return flag;
_L2:
        if (!PanZoomViewer.b(a).containsKey(PanZoomViewer.c(a)))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (motionevent == null) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (motionevent1 == null) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (motionevent.getPointerCount() <= 1) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if (motionevent1.getPointerCount() <= 1) goto _L4; else goto _L7
_L7:
        if (PanZoomViewer.f(a) == PanZoomViewer.ViewerMode.c)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (PanZoomViewer.f(a) != PanZoomViewer.ViewerMode.b) goto _L4; else goto _L8
_L8:
        motionevent = new PointF(motionevent1.getX() + f1 * 0.3F, motionevent1.getY() + 0.3F * f2);
        PanZoomViewer.a(a, motionevent, f1, f2);
        return true;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
    {
        if (motionevent != null && motionevent1 != null) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        float f3;
        float f4;
        float f5;
        float f6;
        if (PanZoomViewer.b(a).containsKey(PanZoomViewer.c(a)) && !PanZoomViewer.d(a).booleanValue())
        {
            PanZoomViewer.a(a, "block onScroll for single touch in behavior mode");
            return true;
        }
        f2 = motionevent1.getX();
        f1 = motionevent1.getY();
        float f7 = motionevent1.getX() - b;
        float f8 = motionevent1.getY() - c;
        if (motionevent.getPointerCount() <= 1)
        {
            f4 = f8;
            f3 = f7;
            f5 = f1;
            f6 = f2;
            if (motionevent1.getPointerCount() <= 1)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        int i = motionevent1.findPointerIndex(d);
        f4 = f8;
        f3 = f7;
        if (i > 0)
        {
            f2 = motionevent1.getX(i);
            f1 = motionevent1.getY(i);
            f3 = f2 - b;
            f4 = f1 - c;
        }
        f5 = f1;
        f6 = f2;
        if (Math.abs(e - a.m.q.d) > 0.0F)
        {
            e = a.m.q.d;
            b = f2;
            c = f1;
            return true;
        }
        if ((a.E || a.F) && !PanZoomViewer.d(a).booleanValue()) goto _L1; else goto _L3
_L3:
        PanZoomViewer.a(a, (new StringBuilder()).append("onScroll focus x: ").append(f6).append(" focux y: ").append(f5).append(" translate x: ").append(f3).append(" translate y: ").append(f4).append(" scale: ").append(1.0F).toString());
        motionevent = new PointF((float)a.getWidth() / 2.0F - f6, (float)a.getHeight() / 2.0F - f5);
        motionevent1 = new PointF(f3, f4);
        PanZoomViewer.a(a, motionevent, motionevent1, 1.0F);
        b = f6;
        c = f5;
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        return PanZoomViewer.f(a) == PanZoomViewer.ViewerMode.a;
    }
}
