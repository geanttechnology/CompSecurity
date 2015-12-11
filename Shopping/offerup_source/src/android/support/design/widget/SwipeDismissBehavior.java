// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.support.v4.view.at;
import android.support.v4.widget.bo;
import android.support.v4.widget.br;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            r, bh, CoordinatorLayout, bi

public class SwipeDismissBehavior extends r
{

    private bo a;
    private bi b;
    private boolean c;
    private float d;
    private int e;
    private float f;
    private float g;
    private float h;
    private final br i = new bh(this);

    public SwipeDismissBehavior()
    {
        d = 0.0F;
        e = 2;
        f = 0.5F;
        g = 0.0F;
        h = 0.5F;
    }

    static float a(float f1, float f2, float f3)
    {
        return (f3 - f1) / (f2 - f1);
    }

    static int a(int j, int k, int l)
    {
        return Math.min(Math.max(j, k), l);
    }

    static bi a(SwipeDismissBehavior swipedismissbehavior)
    {
        return swipedismissbehavior.b;
    }

    static float b(float f1, float f2, float f3)
    {
        return c(0.0F, f2, 1.0F);
    }

    static bo b(SwipeDismissBehavior swipedismissbehavior)
    {
        return swipedismissbehavior.a;
    }

    private static float c(float f1, float f2, float f3)
    {
        return Math.min(Math.max(f1, f2), f3);
    }

    static int c(SwipeDismissBehavior swipedismissbehavior)
    {
        return swipedismissbehavior.e;
    }

    static float d(SwipeDismissBehavior swipedismissbehavior)
    {
        return swipedismissbehavior.f;
    }

    static float e(SwipeDismissBehavior swipedismissbehavior)
    {
        return swipedismissbehavior.g;
    }

    static float f(SwipeDismissBehavior swipedismissbehavior)
    {
        return swipedismissbehavior.h;
    }

    public final int a()
    {
        if (a != null)
        {
            return a.a();
        } else
        {
            return 0;
        }
    }

    public final void a(float f1)
    {
        g = c(0.0F, 0.1F, 1.0F);
    }

    public final void a(int j)
    {
        e = 0;
    }

    public final void a(bi bi)
    {
        b = bi;
    }

    public final boolean a(CoordinatorLayout coordinatorlayout, View view, MotionEvent motionevent)
    {
        if (a != null)
        {
            a.b(motionevent);
            return true;
        } else
        {
            return false;
        }
    }

    public final void b(float f1)
    {
        h = c(0.0F, 0.6F, 1.0F);
    }

    public boolean b(CoordinatorLayout coordinatorlayout, View view, MotionEvent motionevent)
    {
        at.a(motionevent);
        JVM INSTR tableswitch 1 3: default 32
    //                   1 68
    //                   2 32
    //                   3 68;
           goto _L1 _L2 _L1 _L2
_L1:
        boolean flag;
        if (!coordinatorlayout.a(view, (int)motionevent.getX(), (int)motionevent.getY()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
_L4:
        if (c)
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (c)
        {
            c = false;
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (a == null)
        {
            a = bo.a(coordinatorlayout, i);
        }
        return a.a(motionevent);
    }
}
