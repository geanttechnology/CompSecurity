// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bc;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;

public final class b
{

    private static b a;
    private static int b = 1;
    private static int c = 2;
    private int d;
    private RectF e;
    private RectF f;
    private PointF g;
    private PointF h;
    private PointF i;
    private float j;
    private float k;
    private float l;

    private b()
    {
        e = new RectF();
        f = new RectF();
        g = new PointF();
        h = new PointF();
        i = new PointF();
        k = 20F;
        l = 0.2F;
    }

    private static float a(MotionEvent motionevent)
    {
        if (motionevent.getPointerCount() < 2)
        {
            return -1F;
        } else
        {
            float f1 = motionevent.getX(0) - motionevent.getX(1);
            float f2 = motionevent.getY(0) - motionevent.getY(1);
            return (float)Math.sqrt(f1 * f1 + f2 * f2);
        }
    }

    public static b a()
    {
        if (a == null)
        {
            a = new b();
        }
        return a;
    }

    private static void a(PointF pointf, MotionEvent motionevent)
    {
        float f1 = motionevent.getX(0);
        float f2 = motionevent.getX(1);
        float f3 = motionevent.getY(0);
        float f4 = motionevent.getY(1);
        pointf.set((f1 + f2) / 2.0F, (f3 + f4) / 2.0F);
    }

    public final boolean a(MotionEvent motionevent, RectF rectf, RectF rectf1, float f1, float f2)
    {
        int i1;
        int k1;
        k = f1;
        l = f2;
        i1 = motionevent.getAction() & 0xff;
        k1 = (motionevent.getAction() & 0xff00) >> 8;
        i1;
        JVM INSTR tableswitch 1 6: default 76
    //                   1 597
    //                   2 150
    //                   3 76
    //                   4 76
    //                   5 78
    //                   6 582;
           goto _L1 _L2 _L3 _L1 _L1 _L4 _L5
_L1:
        return false;
_L4:
        j = a(motionevent);
        if (j > 10F)
        {
            f.set(rectf1);
            e.set(rectf);
            a(g, motionevent);
            h.set(g.x, g.y);
            d = b;
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (d == b || d == c)
        {
            f2 = a(motionevent);
            if (f2 > 10F && d == b)
            {
                if (motionevent.getPointerCount() >= 2)
                {
                    a(g, motionevent);
                    float f3 = (f2 / j) * e.width();
                    f1 = f3 / rectf.width();
                    rectf.offset(g.x - h.x, g.y - h.y);
                    h.set(g);
                    if (f1 != 1.0F && l * f.width() <= f3 && k * f.width() >= f3 && f2 > 10F)
                    {
                        motionevent = g;
                        float f4 = 0.0F;
                        f2 = 0.0F;
                        float f9 = rectf.left;
                        float f8 = rectf.top;
                        float f13 = rectf.width();
                        float f12 = rectf.height();
                        float f10 = f13 * f1;
                        float f11 = f1 * f12;
                        float f6 = f8;
                        f1 = f9;
                        if (rectf.contains(((PointF) (motionevent)).x, ((PointF) (motionevent)).y))
                        {
                            f2 = ((PointF) (motionevent)).x;
                            f1 = ((PointF) (motionevent)).y;
                            f4 = (f2 - f9) / f13;
                            f2 = (f1 - f8) / f12;
                            f1 = ((PointF) (motionevent)).x;
                            f6 = ((PointF) (motionevent)).y;
                        }
                        rectf.left = f1 - f10 * f4;
                        rectf.top = f6 - f11 * f2;
                        rectf.right = f1 + (1.0F - f4) * f10;
                        rectf.bottom = f6 + (1.0F - f2) * f11;
                    }
                }
            } else
            if (d == c)
            {
                f1 = motionevent.getX(k1);
                f2 = i.x;
                float f5 = motionevent.getY(k1);
                float f7 = i.y;
                i.set(motionevent.getX(k1), motionevent.getY(k1));
                rectf.offset(f1 - f2, f5 - f7);
            }
            return true;
        }
        if (true) goto _L1; else goto _L5
_L5:
        if (motionevent.getPointerCount() == 1)
        {
            d = 0;
            return false;
        }
_L2:
        if (d != c && d != b) goto _L1; else goto _L6
_L6:
        if (motionevent.getPointerCount() != 1) goto _L8; else goto _L7
_L7:
        d = 0;
_L10:
        return true;
_L8:
        if (motionevent.getPointerCount() == 2)
        {
            d = c;
            if (i1 == 1)
            {
                i.set(motionevent.getX(), motionevent.getY());
            } else
            {
                int j1;
                if (k1 == 1)
                {
                    j1 = 0;
                } else
                {
                    j1 = 1;
                }
                i.set(motionevent.getX(j1), motionevent.getY(j1));
            }
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

}
