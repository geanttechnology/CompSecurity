// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class yi extends yh
{

    float b;
    float c;
    final float d;
    final float e;
    private VelocityTracker f;
    private boolean g;

    public yi(Context context)
    {
        context = ViewConfiguration.get(context);
        e = context.getScaledMinimumFlingVelocity();
        d = context.getScaledTouchSlop();
    }

    public boolean a()
    {
        return false;
    }

    public boolean a(MotionEvent motionevent)
    {
        boolean flag = false;
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 36
    //                   0 38
    //                   1 212
    //                   2 78
    //                   3 191;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        f = VelocityTracker.obtain();
        f.addMovement(motionevent);
        b = b(motionevent);
        c = c(motionevent);
        g = false;
        return true;
_L4:
        float f1 = b(motionevent);
        float f3 = c(motionevent);
        float f5 = f1 - b;
        float f6 = f3 - c;
        if (!g)
        {
            if (FloatMath.sqrt(f5 * f5 + f6 * f6) >= d)
            {
                flag = true;
            }
            g = flag;
        }
        if (g)
        {
            a.a(f5, f6);
            b = f1;
            c = f3;
            if (f != null)
            {
                f.addMovement(motionevent);
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (f != null)
        {
            f.recycle();
            f = null;
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (g && f != null)
        {
            b = b(motionevent);
            c = c(motionevent);
            f.addMovement(motionevent);
            f.computeCurrentVelocity(1000);
            float f2 = f.getXVelocity();
            float f4 = f.getYVelocity();
            if (Math.max(Math.abs(f2), Math.abs(f4)) >= e)
            {
                a.a(b, c, -f2, -f4);
            }
        }
        if (f != null)
        {
            f.recycle();
            f = null;
            return true;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    float b(MotionEvent motionevent)
    {
        return motionevent.getX();
    }

    float c(MotionEvent motionevent)
    {
        return motionevent.getY();
    }
}
