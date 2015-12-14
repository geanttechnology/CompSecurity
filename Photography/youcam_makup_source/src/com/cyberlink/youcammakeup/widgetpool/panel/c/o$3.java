// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            o

class a
    implements android.view..OnTouchListener
{

    final o a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag = o.c(a).dispatchTouchEvent(motionevent);
        if (a.c != null)
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

    (o o1)
    {
        a = o1;
        super();
    }
}
