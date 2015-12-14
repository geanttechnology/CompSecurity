// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input.gesture;

import android.view.MotionEvent;
import com.socialin.android.util.Geom;
import junit.framework.Assert;

// Referenced classes of package com.socialin.android.brushlib.input.gesture:
//            c, GestureResponse, h

public final class g
    implements c
{

    public float a;
    public boolean b;
    private h c;
    private boolean d;
    private boolean e;
    private float f;
    private float g;

    public g(h h1)
    {
        a = 20F;
        b = true;
        Assert.assertNotNull(h1);
        c = h1;
    }

    public final GestureResponse a(MotionEvent motionevent)
    {
        float f1;
        float f2;
        int i;
        int j;
        int l;
        int i1;
        i = 0;
        if (!b)
        {
            return GestureResponse.REJECT;
        }
        j = motionevent.getActionMasked();
        l = motionevent.getPointerCount();
        i1 = motionevent.getActionIndex();
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        j;
        JVM INSTR tableswitch 0 6: default 88
    //                   0 106
    //                   1 255
    //                   2 129
    //                   3 88
    //                   4 88
    //                   5 255
    //                   6 286;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L3 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_286;
_L6:
        if (d || e)
        {
            return GestureResponse.ACCEPT;
        } else
        {
            return GestureResponse.REJECT;
        }
_L2:
        f = f1;
        g = f2;
        d = false;
        e = true;
          goto _L6
_L4:
        if (d)
        {
            int k = motionevent.getHistorySize();
            if (k > 0)
            {
                for (; i < k; i++)
                {
                    motionevent.getHistoricalX(i);
                    motionevent.getHistoricalY(i);
                }

            }
            c.c(f1, f2);
        } else
        if (e && Geom.b(f, g, f1, f2) >= a)
        {
            d = true;
            c.a(f, g);
            c.c(f1, f2);
        }
          goto _L6
_L3:
        if (d)
        {
            d = false;
            c.b(f1, f2);
        }
        e = false;
          goto _L6
        if (l == 2)
        {
            f = motionevent.getX(1 - i1);
            g = motionevent.getY(1 - i1);
            d = false;
            e = true;
        }
          goto _L6
    }
}
