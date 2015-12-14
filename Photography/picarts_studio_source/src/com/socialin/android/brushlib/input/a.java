// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.socialin.android.util.Geom;

// Referenced classes of package com.socialin.android.brushlib.input:
//            c, b

public final class a
{

    b a;
    boolean b;
    private int c;
    private int d;
    private long e;
    private long f;
    private Handler g;
    private boolean h;
    private boolean i;
    private PointF j;
    private PointF k;
    private boolean l;
    private PointF m;
    private final c n = new c(this, (byte)0);

    public a(b b1)
    {
        g = new Handler(Looper.getMainLooper());
        j = new PointF();
        k = new PointF();
        m = new PointF();
        a = b1;
        e = 300L;
        f = 100L;
    }

    private static PointF a(MotionEvent motionevent, int i1)
    {
        i1 = motionevent.findPointerIndex(i1);
        if (i1 >= 0 && i1 < motionevent.getPointerCount())
        {
            return new PointF(motionevent.getX(i1), motionevent.getY(i1));
        } else
        {
            return null;
        }
    }

    private void a(MotionEvent motionevent, int i1, int j1)
    {
        int k1;
        int l1;
        byte byte0;
        k1 = 0;
        if (motionevent.getPointerCount() < 2)
        {
            c = motionevent.getPointerId(0);
            return;
        }
        byte0 = -1;
        l1 = -1;
_L2:
        int i2;
        int j2;
        if (k1 >= i1)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        i2 = byte0;
        j2 = l1;
        if (k1 != j1)
        {
            if (l1 != -1)
            {
                break; /* Loop/switch isn't completed */
            }
            j2 = k1;
            i2 = byte0;
        }
_L3:
        k1++;
        byte0 = i2;
        l1 = j2;
        if (true) goto _L2; else goto _L1
_L1:
        if (byte0 != -1)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        i2 = k1;
        j2 = l1;
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        c = motionevent.getPointerId(l1);
        d = motionevent.getPointerId(byte0);
        return;
    }

    private static boolean a(MotionEvent motionevent, int i1, PointF pointf)
    {
        i1 = motionevent.findPointerIndex(i1);
        if (i1 >= 0 && i1 < motionevent.getPointerCount())
        {
            pointf.set(motionevent.getX(i1), motionevent.getY(i1));
            return true;
        } else
        {
            return false;
        }
    }

    public final void a(MotionEvent motionevent)
    {
        int i1;
        int j1;
        i1 = motionevent.getPointerCount();
        j1 = motionevent.getActionIndex();
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 60
    //                   0 61
    //                   1 527
    //                   2 311
    //                   3 60
    //                   4 60
    //                   5 155
    //                   6 237;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        return;
_L2:
        float f1 = motionevent.getX(0);
        float f3 = motionevent.getY(0);
        m.set(f1, f3);
        c = motionevent.getPointerId(0);
        h = true;
        i = false;
        b = true;
        g.removeCallbacks(n);
        n.a = new PointF(f1, f3);
        g.postDelayed(n, e);
        l = false;
        return;
_L5:
        h = false;
        b = false;
        if (i1 == 2)
        {
            d = motionevent.getPointerId(1);
            PointF pointf = a(motionevent, c);
            motionevent = a(motionevent, d);
            if (pointf != null && motionevent != null)
            {
                a.onPanEnd(pointf);
                a.onPinchStart(pointf, motionevent);
                i = false;
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (i1 == 2)
        {
            a.onPinchEnd(null, null);
            if (j1 == 0)
            {
                m.set(motionevent.getX(1), motionevent.getY(1));
                return;
            } else
            {
                m.set(motionevent.getX(0), motionevent.getY(0));
                return;
            }
        }
        if (i1 > 2)
        {
            a(motionevent, i1, j1);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (i1 != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        float f2 = motionevent.getX();
        float f4 = motionevent.getY();
        if (Geom.b(f2, f4, m.x, m.y) >= 20F)
        {
            b = false;
        }
        if (motionevent.getEventTime() - motionevent.getDownTime() >= f)
        {
            i = true;
        }
        if (i)
        {
            j.set(f2, f4);
            if (l)
            {
                a.onPan(j);
                return;
            }
            if (Geom.a(j, m) >= 20F)
            {
                l = true;
                a.onPanStart(m);
                a.onPan(j);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (i1 <= 1) goto _L1; else goto _L7
_L7:
        boolean flag = a(motionevent, c, j);
        boolean flag1 = a(motionevent, d, k);
        if (flag && flag1)
        {
            a.onPinch(j, k);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        b = false;
        if (h && motionevent.getEventTime() - motionevent.getDownTime() <= f)
        {
            a.onTap(new PointF(motionevent.getX(), motionevent.getY()));
            return;
        }
        if (i)
        {
            a.onPanEnd(new PointF(motionevent.getX(), motionevent.getY()));
            i = false;
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }
}
