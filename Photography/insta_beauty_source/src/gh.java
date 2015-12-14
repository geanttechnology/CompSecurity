// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.MotionEvent;

public abstract class gh
{

    protected final Context a;
    protected boolean b;
    protected MotionEvent c;
    protected MotionEvent d;
    protected float e;
    protected float f;
    protected long g;

    public gh(Context context)
    {
        a = context;
    }

    protected void a()
    {
        if (c != null)
        {
            c.recycle();
            c = null;
        }
        if (d != null)
        {
            d.recycle();
            d = null;
        }
        b = false;
    }

    protected abstract void a(int i, MotionEvent motionevent);

    public boolean a(MotionEvent motionevent)
    {
        int i = motionevent.getAction() & 0xff;
        if (!b)
        {
            a(i, motionevent);
        } else
        {
            b(i, motionevent);
        }
        return true;
    }

    protected abstract void b(int i, MotionEvent motionevent);

    protected void b(MotionEvent motionevent)
    {
        if (motionevent == null)
        {
            return;
        }
        if (c == null)
        {
            c = MotionEvent.obtain(motionevent);
        }
        MotionEvent motionevent1 = c;
        if (d != null)
        {
            d.recycle();
            d = null;
        }
        d = MotionEvent.obtain(motionevent);
        g = motionevent.getEventTime() - motionevent1.getEventTime();
        e = motionevent.getPressure(motionevent.getActionIndex());
        f = motionevent1.getPressure(motionevent1.getActionIndex());
    }
}
