// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            d

class a
    implements android.view..OnTouchListener
{

    final d a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag = d.d(a).dispatchTouchEvent(motionevent);
        if (d.e(a) != null)
        {
            if (motionevent.getAction() == 0 || motionevent.getAction() == 5)
            {
                if (!flag);
            } else
            if (motionevent.getAction() != 1 && motionevent.getAction() == 6)
            {
                return true;
            }
        }
        return true;
    }

    (d d1)
    {
        a = d1;
        super();
    }
}
