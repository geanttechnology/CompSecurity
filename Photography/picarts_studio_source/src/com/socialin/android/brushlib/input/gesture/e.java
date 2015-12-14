// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input.gesture;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;

// Referenced classes of package com.socialin.android.brushlib.input.gesture:
//            c, GestureResponse, f

public class e
    implements c
{

    private PointF a;
    private final f b;
    private Handler c;
    private Runnable d;

    public e(f f)
    {
        a = new PointF();
        c = null;
        d = null;
        b = f;
        c = new Handler(Looper.getMainLooper());
        d = new Runnable() {

            private e a;

            public final void run()
            {
                if (e.a(a) != null)
                {
                    e.a(a).a(e.b(a).x, e.b(a).y);
                }
            }

            
            {
                a = e.this;
                super();
            }
        };
    }

    static f a(e e1)
    {
        return e1.b;
    }

    private void a()
    {
        c.removeCallbacks(d);
    }

    static PointF b(e e1)
    {
        return e1.a;
    }

    public final GestureResponse a(MotionEvent motionevent)
    {
        int i = motionevent.getActionIndex();
        float f1 = motionevent.getX(i);
        float f = motionevent.getY(i);
        switch (motionevent.getActionMasked())
        {
        case 1: // '\001'
        default:
            a();
            return GestureResponse.REJECT;

        case 0: // '\0'
            a.set(f1, f);
            c.postDelayed(d, 500L);
            return GestureResponse.ACCEPT;

        case 2: // '\002'
            f1 = Math.abs(f1 - a.x);
            break;
        }
        f = Math.abs(f - a.y);
        if (f * f + f1 * f1 > 400F)
        {
            a();
            return GestureResponse.REJECT;
        } else
        {
            return GestureResponse.ACCEPT;
        }
    }

    static 
    {
        com/socialin/android/brushlib/input/gesture/e.desiredAssertionStatus();
    }
}
