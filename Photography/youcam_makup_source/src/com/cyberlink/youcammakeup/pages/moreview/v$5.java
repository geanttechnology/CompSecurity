// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            v

class a
    implements android.view..OnTouchListener
{

    final v a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 || motionevent.getAction() == 5)
        {
            float f = motionevent.getRawX();
            float f1 = motionevent.getRawY();
            if (!v.a(a, Math.round(f), Math.round(f1)))
            {
                v.e(a).setVisibility(4);
            }
        }
        if (motionevent.getAction() == 2 || motionevent.getAction() == 8)
        {
            v.e(a).setVisibility(4);
        }
        v.h(a).dispatchTouchEvent(motionevent);
        return true;
    }

    (v v1)
    {
        a = v1;
        super();
    }
}
