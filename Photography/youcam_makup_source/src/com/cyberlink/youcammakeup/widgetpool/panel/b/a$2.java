// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.b;

import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.b:
//            a

class a
    implements android.view..OnTouchListener
{

    final a a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        view = com.cyberlink.youcammakeup.widgetpool.panel.b.a.a(a).t();
        if (view != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        switch (motionevent.getActionMasked())
        {
        case 2: // '\002'
        case 4: // '\004'
        default:
            return false;

        case 0: // '\0'
            view.b(Boolean.valueOf(false));
            // fall through

        case 5: // '\005'
            if (!com.cyberlink.youcammakeup.widgetpool.panel.b.a.b(a))
            {
                com.cyberlink.youcammakeup.widgetpool.panel.b.a.a(a, motionevent.getPointerId(motionevent.getActionIndex()));
                com.cyberlink.youcammakeup.widgetpool.panel.b.a.b(a, true);
                view.K();
                return false;
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
        case 6: // '\006'
            int i = motionevent.getPointerId(motionevent.getActionIndex());
            if (com.cyberlink.youcammakeup.widgetpool.panel.b.a.b(a) && i == com.cyberlink.youcammakeup.widgetpool.panel.b.a.c(a))
            {
                com.cyberlink.youcammakeup.widgetpool.panel.b.a.b(a, false);
                view.L();
                return false;
            }
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    ty(a a1)
    {
        a = a1;
        super();
    }
}
