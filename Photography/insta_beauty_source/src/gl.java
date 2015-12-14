// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.MotionEvent;

public class gl extends go
{

    private final gm l;
    private boolean m;

    public gl(Context context, gm gm1)
    {
        super(context);
        l = gm1;
    }

    protected void a()
    {
        super.a();
        m = false;
    }

    protected void a(int i, MotionEvent motionevent)
    {
        i;
        JVM INSTR tableswitch 2 6: default 36
    //                   2 90
    //                   3 36
    //                   4 36
    //                   5 37
    //                   6 128;
           goto _L1 _L2 _L1 _L1 _L3 _L4
_L1:
        return;
_L3:
        a();
        c = MotionEvent.obtain(motionevent);
        g = 0L;
        b(motionevent);
        m = c(motionevent);
        if (!m)
        {
            b = l.b(this);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (m)
        {
            m = c(motionevent);
            if (!m)
            {
                b = l.b(this);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!m)
        {
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public float b()
    {
        return (float)(((Math.atan2(i, h) - Math.atan2(k, j)) * 180D) / 3.1415926535897931D);
    }

    protected void b(int i, MotionEvent motionevent)
    {
        i;
        JVM INSTR tableswitch 2 6: default 36
    //                   2 86
    //                   3 64
    //                   4 36
    //                   5 36
    //                   6 37;
           goto _L1 _L2 _L3 _L1 _L1 _L4
_L1:
        return;
_L4:
        b(motionevent);
        if (!m)
        {
            l.c(this);
        }
        a();
        return;
_L3:
        if (!m)
        {
            l.c(this);
        }
        a();
        return;
_L2:
        b(motionevent);
        if (e / f > 0.67F && l.a(this))
        {
            c.recycle();
            c = MotionEvent.obtain(motionevent);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}
