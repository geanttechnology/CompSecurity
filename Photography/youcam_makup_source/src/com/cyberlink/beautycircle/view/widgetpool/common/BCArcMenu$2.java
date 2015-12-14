// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            BCArcMenu, ArcLayout

class a
    implements android.view.Listener
{

    final BCArcMenu a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            BCArcMenu.b(a).set(f, f1);
            BCArcMenu.c(a);
        } else
        {
            if (motionevent.getAction() == 1)
            {
                BCArcMenu.a(a).dispatchTouchEvent(motionevent);
                BCArcMenu.d(a);
                a.requestDisallowInterceptTouchEvent(false);
                return true;
            }
            if (motionevent.getAction() == 2)
            {
                BCArcMenu.a(a).dispatchTouchEvent(motionevent);
                return true;
            }
        }
        return true;
    }

    (BCArcMenu bcarcmenu)
    {
        a = bcarcmenu;
        super();
    }
}
