// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.utility.bd;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class a
    implements android.view.r
{

    final LauncherActivity a;

    public void onClick(View view)
    {
        if (LauncherActivity.e(a))
        {
            return;
        } else
        {
            b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.leType.f, com.cyberlink.youcammakeup.clflurry.eration.b));
            LauncherActivity.a(a, true);
            com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
            bd.a(a, "com.perfectcorp.ycn", "ymk", "launcher");
            return;
        }
    }

    eration(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}
