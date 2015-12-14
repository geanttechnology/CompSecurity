// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

// Referenced classes of package com.socialin.android.activity:
//            WhatsNewActivity

final class a
    implements android.view.r
{

    private View a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (view.getId() == a.getId())
        {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if ((motionevent.getAction() & 0xff) == 1)
            {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return false;
    }

    (View view)
    {
        a = view;
        super();
    }
}
