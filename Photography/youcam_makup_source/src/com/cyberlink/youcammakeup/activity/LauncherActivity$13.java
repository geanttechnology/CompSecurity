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
//            LauncherActivity, SettingActivity

class a
    implements android.view.
{

    final LauncherActivity a;

    public void onClick(View view)
    {
        com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.stName.h));
        b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.sEvent.LauncherTileName.h));
        view = Globals.d().w();
        if (view != null && view.K().a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.temType.e))
        {
            YMKLauncherEvent.b(true);
        }
        b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.eType.k, com.cyberlink.youcammakeup.clflurry.ration.b));
        view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/SettingActivity);
        a.startActivity(view);
        a.finish();
        a.overridePendingTransition(0x7f040001, 0x7f040008);
    }

    ration(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}
