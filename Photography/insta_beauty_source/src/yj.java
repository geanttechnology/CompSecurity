// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.MotionEvent;

class yj extends yi
{

    private int f;
    private int g;

    public yj(Context context)
    {
        super(context);
        f = -1;
        g = 0;
    }

    public boolean a(MotionEvent motionevent)
    {
        boolean flag = false;
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 6: default 52
    //                   0 82
    //                   1 94
    //                   2 52
    //                   3 94
    //                   4 52
    //                   5 52
    //                   6 102;
           goto _L1 _L2 _L3 _L1 _L3 _L1 _L1 _L4
_L1:
        int i = ((flag) ? 1 : 0);
        if (f != -1)
        {
            i = f;
        }
        g = motionevent.findPointerIndex(i);
        return super.a(motionevent);
_L2:
        f = motionevent.getPointerId(0);
        continue; /* Loop/switch isn't completed */
_L3:
        f = -1;
        continue; /* Loop/switch isn't completed */
_L4:
        int j = (motionevent.getAction() & 0xff00) >> 8;
        if (motionevent.getPointerId(j) == f)
        {
            if (j == 0)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            f = motionevent.getPointerId(j);
            b = motionevent.getX(j);
            c = motionevent.getY(j);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    float b(MotionEvent motionevent)
    {
        float f1;
        try
        {
            f1 = motionevent.getX(g);
        }
        catch (Exception exception)
        {
            return motionevent.getX();
        }
        return f1;
    }

    float c(MotionEvent motionevent)
    {
        float f1;
        try
        {
            f1 = motionevent.getY(g);
        }
        catch (Exception exception)
        {
            return motionevent.getY();
        }
        return f1;
    }
}
