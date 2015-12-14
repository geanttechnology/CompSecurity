// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input.gesture;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.socialin.android.util.Geom;

// Referenced classes of package com.socialin.android.brushlib.input.gesture:
//            c, GestureResponse, j

public class i
    implements c
{

    private static boolean g;
    public long a;
    public float b;
    private int c;
    private PointF d;
    private long e;
    private final j f;

    public i(j j1)
    {
        this(j1, 100L);
    }

    public i(j j1, long l)
    {
        d = new PointF();
        if (!g && j1 == null)
        {
            throw new AssertionError();
        } else
        {
            f = j1;
            a = l;
            b = 20F;
            return;
        }
    }

    public final GestureResponse a(MotionEvent motionevent)
    {
        float f1;
        float f2;
        int l;
        int k = motionevent.getActionIndex();
        l = motionevent.getPointerId(k);
        f1 = motionevent.getX(k);
        f2 = motionevent.getY(k);
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 76
    //                   0 80
    //                   1 105
    //                   2 76
    //                   3 76
    //                   4 76
    //                   5 80
    //                   6 105;
           goto _L1 _L2 _L3 _L1 _L1 _L1 _L2 _L3
_L1:
        return GestureResponse.REJECT;
_L2:
        c = l;
        d.set(f1, f2);
        e = System.currentTimeMillis();
        continue; /* Loop/switch isn't completed */
_L3:
        if (l == c)
        {
            motionevent = new PointF(f1, f2);
            long l1 = System.currentTimeMillis();
            if (Geom.a(motionevent, d) <= b && l1 - e <= a)
            {
                f.a_(d.x, d.y);
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    static 
    {
        boolean flag;
        if (!com/socialin/android/brushlib/input/gesture/i.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g = flag;
    }
}
