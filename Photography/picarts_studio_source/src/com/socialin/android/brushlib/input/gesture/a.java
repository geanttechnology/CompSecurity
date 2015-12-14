// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input.gesture;

import android.graphics.PointF;
import android.view.MotionEvent;

// Referenced classes of package com.socialin.android.brushlib.input.gesture:
//            c, GestureResponse, b

public class a
    implements c
{

    private static boolean h;
    public boolean a;
    private b b;
    private PointF c;
    private PointF d;
    private int e;
    private int f;
    private boolean g;

    public a(b b1)
    {
        c = new PointF();
        d = new PointF();
        a = true;
        if (!h && b1 == null)
        {
            throw new AssertionError();
        } else
        {
            b = b1;
            return;
        }
    }

    private static transient int a(MotionEvent motionevent, int ai[])
    {
        int i = -1;
        int i1 = motionevent.getPointerCount();
        int j = 0;
label0:
        do
        {
            if (j < i1)
            {
                int l = motionevent.getPointerId(j);
                boolean flag1 = true;
                int j1 = ai.length;
                int k = 0;
                do
                {
label1:
                    {
                        boolean flag = flag1;
                        if (k < j1)
                        {
                            if (l != ai[k])
                            {
                                break label1;
                            }
                            flag = false;
                        }
                        if (flag)
                        {
                            i = l;
                        }
                        j++;
                        continue label0;
                    }
                    k++;
                } while (true);
            }
            return i;
        } while (true);
    }

    private void b(MotionEvent motionevent)
    {
        if (e == -1 || motionevent.findPointerIndex(e) == -1)
        {
            e = a(motionevent, new int[0]);
        }
        if (f == -1 || motionevent.findPointerIndex(f) == -1 || f == e)
        {
            f = a(motionevent, new int[] {
                e
            });
        }
        int i = motionevent.findPointerIndex(e);
        int j = motionevent.findPointerIndex(f);
        c.set(motionevent.getX(i), motionevent.getY(i));
        d.set(motionevent.getX(j), motionevent.getY(j));
    }

    public final GestureResponse a(MotionEvent motionevent)
    {
        int i;
        int j;
        int k;
        if (!a)
        {
            return GestureResponse.REJECT;
        }
        i = motionevent.getActionMasked();
        j = motionevent.getPointerCount();
        k = motionevent.findPointerIndex(motionevent.getActionIndex());
        i;
        JVM INSTR tableswitch 0 6: default 76
    //                   0 87
    //                   1 76
    //                   2 166
    //                   3 76
    //                   4 76
    //                   5 102
    //                   6 218;
           goto _L1 _L2 _L1 _L3 _L1 _L1 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_218;
_L6:
        if (g)
        {
            return GestureResponse.ACCEPT;
        } else
        {
            return GestureResponse.REJECT;
        }
_L2:
        e = k;
        f = -1;
        return GestureResponse.REJECT;
_L4:
        if (f == -1)
        {
            f = k;
        }
        b(motionevent);
        b.a(c.x, c.y, d.x, d.y);
        g = true;
          goto _L6
_L3:
        if (g)
        {
            b(motionevent);
            b.b(c.x, c.y, d.x, d.y);
        }
          goto _L6
        if (j == 2)
        {
            b(motionevent);
            if (g)
            {
                g = false;
                motionevent = b;
                float f1 = c.x;
                f1 = c.y;
                f1 = d.x;
                f1 = d.y;
                motionevent.a();
            }
            f = -1;
            return GestureResponse.REJECT;
        }
        if (e == k)
        {
            b(motionevent);
            b b1 = b;
            float f2 = c.x;
            f2 = c.y;
            f2 = d.x;
            f2 = d.y;
            b1.a();
            e = a(motionevent, new int[] {
                e, f
            });
            b(motionevent);
            b.a(c.x, c.y, d.x, d.y);
        } else
        if (f == k)
        {
            b(motionevent);
            b b2 = b;
            float f3 = c.x;
            f3 = c.y;
            f3 = d.x;
            f3 = d.y;
            b2.a();
            f = a(motionevent, new int[] {
                e, f
            });
            b(motionevent);
            b.a(c.x, c.y, d.x, d.y);
        }
          goto _L6
    }

    static 
    {
        boolean flag;
        if (!com/socialin/android/brushlib/input/gesture/a.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        h = flag;
    }
}
