// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectUsersActivity

class a
    implements android.view.ersActivity._cls9
{

    final SelectUsersActivity a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (SelectUsersActivity.q(a) == null)
        {
            return false;
        } else
        {
            return SelectUsersActivity.q(a).onTouchEvent(motionevent);
        }
    }

    (SelectUsersActivity selectusersactivity)
    {
        a = selectusersactivity;
        super();
    }
}
