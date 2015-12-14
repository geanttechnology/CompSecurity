// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a
    implements android.view.r
{

    final GestureDetector a;
    final BeautyToolPanel b;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (a.onTouchEvent(motionevent))
        {
            motionevent.setAction(3);
        }
        return false;
    }

    (BeautyToolPanel beautytoolpanel, GestureDetector gesturedetector)
    {
        b = beautytoolpanel;
        a = gesturedetector;
        super();
    }
}
