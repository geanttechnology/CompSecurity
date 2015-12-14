// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d, c

class a
    implements android.view.OnTouchListener
{

    final GestureDetector a;
    final d b;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        view = d.e(b);
        if (b.o() && !view.g(view.f()) && a.onTouchEvent(motionevent))
        {
            motionevent.setAction(3);
        }
        return false;
    }

    (d d1, GestureDetector gesturedetector)
    {
        b = d1;
        a = gesturedetector;
        super();
    }
}
