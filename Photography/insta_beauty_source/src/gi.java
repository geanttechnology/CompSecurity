// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

public class gi extends gh
{

    private static final PointF h = new PointF();
    private final gj i;
    private PointF j;
    private PointF k;
    private PointF l;
    private PointF m;

    public gi(Context context, gj gj1)
    {
        super(context);
        l = new PointF();
        m = new PointF();
        i = gj1;
    }

    private PointF c(MotionEvent motionevent)
    {
        float f = 0.0F;
        int j1 = motionevent.getPointerCount();
        int i1 = 0;
        float f1 = 0.0F;
        for (; i1 < j1; i1++)
        {
            f1 += motionevent.getX(i1);
            f += motionevent.getY(i1);
        }

        return new PointF(f1 / (float)j1, f / (float)j1);
    }

    protected void a(int i1, MotionEvent motionevent)
    {
        switch (i1)
        {
        case 1: // '\001'
        default:
            return;

        case 0: // '\0'
            a();
            c = MotionEvent.obtain(motionevent);
            g = 0L;
            b(motionevent);
            return;

        case 2: // '\002'
            b = i.b(this);
            break;
        }
    }

    public PointF b()
    {
        return m;
    }

    protected void b(int i1, MotionEvent motionevent)
    {
        i1;
        JVM INSTR tableswitch 1 3: default 28
    //                   1 29
    //                   2 44
    //                   3 29;
           goto _L1 _L2 _L3 _L2
_L1:
        return;
_L2:
        i.c(this);
        a();
        return;
_L3:
        b(motionevent);
        if (e / f > 0.67F && i.a(this))
        {
            c.recycle();
            c = MotionEvent.obtain(motionevent);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void b(MotionEvent motionevent)
    {
        super.b(motionevent);
        MotionEvent motionevent1 = c;
        j = c(motionevent);
        k = c(motionevent1);
        boolean flag;
        if (motionevent1.getPointerCount() != motionevent.getPointerCount())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            motionevent = h;
        } else
        {
            motionevent = new PointF(j.x - k.x, j.y - k.y);
        }
        m = motionevent;
        motionevent = l;
        motionevent.x = ((PointF) (motionevent)).x + m.x;
        motionevent = l;
        motionevent.y = ((PointF) (motionevent)).y + m.y;
    }

}
