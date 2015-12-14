// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.MotionEvent;
import com.cyberlink.you.utility.d;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectUsersActivity

class ner extends android.view.OnGestureListener
{

    final SelectUsersActivity a;

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        d.a(SelectUsersActivity.m(a), false);
        return false;
    }

    ner(SelectUsersActivity selectusersactivity)
    {
        a = selectusersactivity;
        super();
    }
}
