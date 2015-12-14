// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;
import android.view.MotionEvent;
import wantu.sephiroth.android.library.imagezoom.RotateZoomMoveImageViewTouch;

public class aiv
{

    final RotateZoomMoveImageViewTouch a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;
    private int i;

    public aiv(RotateZoomMoveImageViewTouch rotatezoommoveimageviewtouch)
    {
        a = rotatezoommoveimageviewtouch;
        super();
        h = -1;
        i = -1;
    }

    private float a(float f1, float f2, float f3, float f4, float f5, float f6, float f7, 
            float f8)
    {
        f1 = (float)Math.atan2(f2 - f4, f1 - f3);
        f2 = (float)Math.atan2(f6 - f8, f5 - f7);
        return a((float)Math.toDegrees(f1), (float)Math.toDegrees(f2));
    }

    private void a(float f1, float f2, float f3)
    {
        a.matrix.postRotate(f1, f2, f3);
    }

    private float b(float f1, float f2)
    {
        return (f1 + f2) / 2.0F;
    }

    float a(float f1)
    {
        float f2 = f1;
        float f3;
        do
        {
            f3 = f2;
            if (f2 >= 0.0F)
            {
                break;
            }
            f2 = (float)((double)f2 + 360D);
        } while (true);
        for (; (double)f3 >= 360D; f3 = (float)((double)f3 - 360D)) { }
        return f1;
    }

    float a(float f1, float f2)
    {
        f2 = a(f2);
        f2 = a(f1) - f2;
        if (f2 < -180F)
        {
            f1 = f2 + 360F;
        } else
        {
            f1 = f2;
            if (f2 > 180F)
            {
                return f2 - 360F;
            }
        }
        return f1;
    }

    public boolean a(MotionEvent motionevent)
    {
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 48
    //                   0 50
    //                   1 269
    //                   2 139
    //                   3 48
    //                   4 48
    //                   5 77
    //                   6 276;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        return false;
_L2:
        d = motionevent.getX();
        e = motionevent.getY();
        h = motionevent.getPointerId(0);
        return false;
_L5:
        b = motionevent.getX();
        c = motionevent.getY();
        f = b(b, d);
        g = b(c, e);
        i = motionevent.getPointerId(motionevent.getActionIndex());
        return false;
_L4:
        if (h != -1 && i != -1)
        {
            float f1 = motionevent.getX(motionevent.findPointerIndex(h));
            float f2 = motionevent.getY(motionevent.findPointerIndex(h));
            float f3 = motionevent.getX(motionevent.findPointerIndex(i));
            float f4 = motionevent.getY(motionevent.findPointerIndex(i));
            a(a(b, c, d, e, f1, f2, f3, f4), f, g);
            b = f1;
            c = f2;
            d = f1;
            e = f2;
            return false;
        }
          goto _L1
_L3:
        h = -1;
        return false;
_L6:
        i = -1;
        return false;
    }
}
