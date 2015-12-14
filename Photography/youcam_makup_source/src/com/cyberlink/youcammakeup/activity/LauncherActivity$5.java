// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, MoreMakeupActivity

class a
    implements android.view.r
{

    final LauncherActivity a;

    public void onClick(View view)
    {
        if (LauncherActivity.e(a))
        {
            return;
        }
        com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
        com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
        com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.estName.f));
        b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.ksEvent.LauncherTileName.f));
        view = Globals.d().w();
        if (view != null && view.K().a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.ItemType.c))
        {
            YMKLauncherEvent.b(true);
        }
        b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.leType.c, com.cyberlink.youcammakeup.clflurry.eration.b));
        Globals.d().a(true);
        view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/MoreMakeupActivity);
        a.startActivity(view);
        a.finish();
        a.overridePendingTransition(0x7f040001, 0x7f040008);
    }

    eration(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}
