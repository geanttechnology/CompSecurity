// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.view.MotionEvent;

// Referenced classes of package com.socialin.picsin.camera.view:
//            Panel

final class d
    implements android.view.GestureDetector.OnGestureListener
{

    float a;
    float b;
    private Panel c;

    d(Panel panel)
    {
        c = panel;
        super();
    }

    public final boolean onDown(MotionEvent motionevent)
    {
        a = 0.0F;
        b = 0.0F;
        c.a();
        return true;
    }

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        Panel.a(c, Panel.State.FLYING);
        motionevent = c;
        if (Panel.d(c) != 1)
        {
            f1 = f;
        }
        Panel.c(motionevent, f1);
        c.post(c.a);
        return true;
    }

    public final void onLongPress(MotionEvent motionevent)
    {
    }

    public final boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        float f2 = 0.0F;
        Panel.a(c, Panel.State.TRACKING);
        if (Panel.d(c) == 1)
        {
            a = a - f1;
            if (Panel.e(c) == 0)
            {
                f = Panel.a(a, -Panel.g(c), 0);
                f1 = f2;
            } else
            {
                f = Panel.a(a, 0, Panel.g(c));
                f1 = f2;
            }
        } else
        {
            b = b - f;
            if (Panel.e(c) == 2)
            {
                f1 = Panel.a(b, -Panel.f(c), 0);
                f = 0.0F;
            } else
            {
                f1 = Panel.a(b, 0, Panel.f(c));
                f = 0.0F;
            }
        }
        if (f1 != Panel.o(c) || f != Panel.l(c))
        {
            Panel.a(c, f1);
            Panel.b(c, f);
            c.invalidate();
        }
        return true;
    }

    public final void onShowPress(MotionEvent motionevent)
    {
    }

    public final boolean onSingleTapUp(MotionEvent motionevent)
    {
        return false;
    }
}
