// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            c

class a
    implements android.view..OnTouchListener
{

    final c a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (c.q(a))
        {
            return true;
        } else
        {
            c.k(a, view);
            return c.r(a).onTouchEvent(motionevent);
        }
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
