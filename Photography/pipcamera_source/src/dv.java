// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public abstract class dv extends ds
{

    protected float h;
    protected float i;
    protected float j;
    protected float k;
    private final float l;
    private float m;
    private float n;
    private float o;
    private float p;

    public dv(Context context)
    {
        super(context);
        l = ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    protected static float a(MotionEvent motionevent, int i1)
    {
        float f = motionevent.getX();
        float f1 = motionevent.getRawX();
        if (i1 < motionevent.getPointerCount())
        {
            return (f - f1) + motionevent.getX(i1);
        } else
        {
            return 0.0F;
        }
    }

    protected static float b(MotionEvent motionevent, int i1)
    {
        float f = motionevent.getY();
        float f1 = motionevent.getRawY();
        if (i1 < motionevent.getPointerCount())
        {
            return (f - f1) + motionevent.getY(i1);
        } else
        {
            return 0.0F;
        }
    }

    protected abstract void a(int i1, MotionEvent motionevent);

    protected abstract void b(int i1, MotionEvent motionevent);

    protected void b(MotionEvent motionevent)
    {
        super.b(motionevent);
        MotionEvent motionevent1 = c;
        o = -1F;
        p = -1F;
        float f = motionevent1.getX(0);
        float f1 = motionevent1.getY(0);
        float f2 = motionevent1.getX(1);
        float f3 = motionevent1.getY(1);
        h = f2 - f;
        i = f3 - f1;
        f = motionevent.getX(0);
        f1 = motionevent.getY(0);
        f2 = motionevent.getX(1);
        f3 = motionevent.getY(1);
        j = f2 - f;
        k = f3 - f1;
    }

    protected boolean c(MotionEvent motionevent)
    {
        DisplayMetrics displaymetrics = a.getResources().getDisplayMetrics();
        m = (float)displaymetrics.widthPixels - l;
        n = (float)displaymetrics.heightPixels - l;
        float f = l;
        float f1 = m;
        float f2 = n;
        float f3 = motionevent.getRawX();
        float f4 = motionevent.getRawY();
        float f5 = a(motionevent, 1);
        float f6 = b(motionevent, 1);
        boolean flag;
        boolean flag1;
        if (f3 < f || f4 < f || f3 > f1 || f4 > f2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (f5 < f || f6 < f || f5 > f1 || f6 > f2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        while (flag && flag1 || flag || flag1) 
        {
            return true;
        }
        return false;
    }
}
