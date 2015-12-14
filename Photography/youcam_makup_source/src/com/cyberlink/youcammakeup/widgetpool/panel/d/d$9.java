// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.view.MotionEvent;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

class er extends android.view.ureDetector.SimpleOnGestureListener
{

    final d a;

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (Math.abs(f) > Math.abs(f1))
        {
            return false;
        }
        if (f1 < 0.0F)
        {
            if (a.z() != 0)
            {
                a.b(true);
                a.a(0);
                a.c(true);
                return true;
            }
        } else
        if (a.z() == 0)
        {
            a.b(false);
            a.a(4);
            a.c(false);
            return true;
        }
        return true;
    }

    er(d d1)
    {
        a = d1;
        super();
    }
}
