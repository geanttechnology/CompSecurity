// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;

// Referenced classes of package com.socialin.android.util:
//            ad, l

public final class ScaleRotateGestureDetector
{

    private static boolean y;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public Matrix f;
    public ad g;
    private float h;
    private float i;
    private boolean j;
    private float k;
    private int l;
    private int m;
    private PointF n;
    private PointF o;
    private PointF p;
    private PointF q;
    private PointF r;
    private PointF s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;

    public ScaleRotateGestureDetector(Resources resources)
    {
        this(resources, 5F, 0.5F, true);
    }

    public ScaleRotateGestureDetector(Resources resources, float f1, float f2, boolean flag)
    {
        f = new Matrix();
        n = new PointF();
        o = new PointF();
        p = new PointF();
        q = new PointF();
        r = new PointF();
        s = new PointF();
        a(f1, f2);
        a = flag;
        d = true;
        b = true;
        c = true;
        x = TouchToleranceLevel.access._mth000(TouchToleranceLevel.MEDIUM, resources);
    }

    public final void a(float f1, float f2)
    {
        if (!y && f1 < f2)
        {
            throw new AssertionError("Max should be bigger then min, but is less");
        }
        if (!y && (f1 <= 0.0F || f2 <= 0.0F))
        {
            throw new AssertionError("Max and min should be bigger then 0");
        } else
        {
            h = f1;
            i = f2;
            return;
        }
    }

    public final void a(Matrix matrix)
    {
        f.set(matrix);
    }

    public final void a(MotionEvent motionevent)
    {
        int i1;
        int l2;
        int i3;
        i1 = 0;
        l2 = motionevent.getPointerCount();
        i3 = motionevent.getActionIndex();
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 60
    //                   0 61
    //                   1 1354
    //                   2 557
    //                   3 60
    //                   4 60
    //                   5 131
    //                   6 286;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        return;
_L2:
        float f1 = motionevent.getX(0);
        float f8 = motionevent.getY(0);
        l = motionevent.getPointerId(0);
        n.set(f1, f8);
        p.set(n);
        t = f1;
        u = f8;
        if (g != null)
        {
            motionevent.getEventTime();
            motionevent.getPressure(0);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (l2 == 2)
        {
            t = motionevent.getX(1 - i3);
            u = motionevent.getY(1 - i3);
            v = motionevent.getX(i3);
            w = motionevent.getY(i3);
            n.set(t, u);
            p.set(n);
            m = motionevent.getPointerId(i3);
            o.set(v, w);
            q.set(o);
            k = 0.0F;
            j = false;
            if (g != null)
            {
                g.a(t, u, v, w);
                return;
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
        if (l2 != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = 1 - i3;
        l = motionevent.getPointerId(i1);
        n.set(motionevent.getX(i1), motionevent.getY(i1));
        p.set(n);
        if (g != null)
        {
            float f2 = n.x;
            f2 = n.y;
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (l2 <= 2) goto _L1; else goto _L7
_L7:
        int l1;
        byte byte0;
        byte0 = -1;
        l1 = -1;
_L9:
        int j2;
        int k2;
        if (i1 >= l2)
        {
            break MISSING_BLOCK_LABEL_444;
        }
        j2 = byte0;
        k2 = l1;
        if (i1 != i3)
        {
            if (l1 != -1)
            {
                break; /* Loop/switch isn't completed */
            }
            k2 = i1;
            j2 = byte0;
        }
_L10:
        i1++;
        byte0 = j2;
        l1 = k2;
        if (true) goto _L9; else goto _L8
_L8:
        if (byte0 != -1)
        {
            break MISSING_BLOCK_LABEL_444;
        }
        j2 = i1;
        k2 = l1;
          goto _L10
        if (true) goto _L9; else goto _L11
_L11:
        t = motionevent.getX(l1);
        u = motionevent.getY(l1);
        v = motionevent.getX(byte0);
        w = motionevent.getY(byte0);
        l = motionevent.getPointerId(l1);
        n.set(t, u);
        p.set(n);
        m = motionevent.getPointerId(byte0);
        o.set(v, w);
        q.set(o);
        return;
_L4:
        if (l2 != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (b)
        {
            int j1 = motionevent.findPointerIndex(l);
            n.set(motionevent.getX(j1), motionevent.getY(j1));
            float f3 = n.x;
            float f9 = p.x;
            float f12 = n.y;
            float f14 = p.y;
            if (e)
            {
                f.postTranslate(f3 - f9, f12 - f14);
            }
            p.set(n);
            if (g != null)
            {
                if (e)
                {
                    g.b();
                }
                float f4 = n.x;
                f4 = n.y;
                motionevent.getEventTime();
                motionevent.getPressure(j1);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (l2 <= 1) goto _L1; else goto _L12
_L12:
        int k1 = motionevent.findPointerIndex(l);
        int i2 = motionevent.findPointerIndex(m);
        float f5 = motionevent.getX(k1);
        float f10 = motionevent.getY(k1);
        float f13 = motionevent.getX(i2);
        float f15 = motionevent.getY(i2);
        n.set(f5, f10);
        o.set(f13, f15);
        f13 = Math.max(com.socialin.android.util.l.a(n, o), 1.0F);
        if (f13 >= x)
        {
            if (c)
            {
                float f11 = f13 / Math.max(com.socialin.android.util.l.a(p, q), 1.0F);
                float f6 = f11;
                if (d)
                {
                    float f16 = com.socialin.android.util.l.b(f);
                    f11 *= f16;
                    if (f11 > h)
                    {
                        f6 = h;
                    } else
                    {
                        f6 = f11;
                        if (f11 < i)
                        {
                            f6 = i;
                        }
                    }
                    f6 /= f16;
                }
                com.socialin.android.util.l.a(n, o, r);
                f.postScale(f6, f6, r.x, r.y);
                if (g != null)
                {
                    f11 = p.x;
                    f11 = q.x;
                    f11 = p.y;
                    f11 = q.y;
                    f11 = n.x;
                    f11 = o.x;
                    f11 = n.y;
                    f11 = o.y;
                    motionevent = g;
                    f11 = r.x;
                    f11 = r.y;
                    motionevent.a(f6);
                }
            }
            if (a)
            {
                f6 = com.socialin.android.util.l.a(p, q, n, o);
                k = k + f6;
                if (Math.abs(k) >= 15F || j)
                {
                    f.postRotate(f6, r.x, r.y);
                    j = true;
                }
                if (g != null)
                {
                    motionevent = g;
                    f6 = r.x;
                    f6 = r.y;
                    motionevent.c();
                }
            }
        }
        if (b)
        {
            if (f13 < x)
            {
                f6 = n.x;
                f11 = p.x;
                f13 = n.y;
                f16 = p.y;
                f.postTranslate(f6 - f11, f13 - f16);
                if (g != null)
                {
                    g.b();
                }
            } else
            {
                com.socialin.android.util.l.a(p, q, n, o, s);
                f.postTranslate(s.x, s.y);
                if (g != null)
                {
                    motionevent = g;
                    float f7 = s.x;
                    f7 = s.y;
                    motionevent.b();
                }
            }
        }
        p.set(n);
        q.set(o);
        return;
_L3:
        if (g != null)
        {
            motionevent.getX();
            motionevent.getY();
            motionevent.getEventTime();
            motionevent.getPressure();
            return;
        }
        if (true) goto _L1; else goto _L13
_L13:
    }

    static 
    {
        boolean flag;
        if (!com/socialin/android/util/ScaleRotateGestureDetector.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        y = flag;
        com/socialin/android/util/ScaleRotateGestureDetector.getSimpleName();
    }

    /* member class not found */
    class TouchToleranceLevel {}

}
