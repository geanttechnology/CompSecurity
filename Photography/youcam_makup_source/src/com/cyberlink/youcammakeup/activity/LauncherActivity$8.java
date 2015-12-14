// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.pages.moreview.af;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, BeautyTipCategoryActivity

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
        com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.estName.g));
        b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.ksEvent.LauncherTileName.g));
        if (af.a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.ItemType.d))
        {
            YMKLauncherEvent.b(true);
        }
        b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.leType.g, com.cyberlink.youcammakeup.clflurry.eration.b));
        com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
        com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
        view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/BeautyTipCategoryActivity);
        a.startActivity(view);
        a.finish();
    }

    tivity(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}
