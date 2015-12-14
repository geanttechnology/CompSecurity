// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.profile;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.picsart.studio.profile:
//            ProfileActivity

final class a
    implements android.view.er
{

    private ProfileActivity a;

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        ProfileActivity.c(a, (int)motionevent.getX());
        ProfileActivity.d(a, (int)motionevent.getY());
        return false;
    }

    (ProfileActivity profileactivity)
    {
        a = profileactivity;
        super();
    }
}
