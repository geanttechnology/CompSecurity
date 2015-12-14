// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.flurry.a;

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
            com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.estName.e));
            b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.ksEvent.LauncherTileName.e));
            b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.leType.h, com.cyberlink.youcammakeup.clflurry.eration.b));
            com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
            com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
            com.cyberlink.beautycircle.Globals.a(Globals.O());
            c.a(a, "ymk");
            return;
        }
    }

    eration(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}
