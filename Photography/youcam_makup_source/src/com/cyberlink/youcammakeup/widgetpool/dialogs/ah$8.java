// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.youcammakeup.widgetpool.touchview.TouchImageView;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ah

class a
    implements android.view.OnTouchListener
{

    final ah a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (ah.c(a).a())
        {
            ah.b(a).a(motionevent, false);
        }
        return true;
    }

    chImageView(ah ah1)
    {
        a = ah1;
        super();
    }
}
