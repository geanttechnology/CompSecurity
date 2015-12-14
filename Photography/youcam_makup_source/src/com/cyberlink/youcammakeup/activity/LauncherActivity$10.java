// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKCostumeMakeupEvent;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.flurry.a;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, CostumeLooksPagerActivity

class a
    implements android.view.
{

    final LauncherActivity a;

    public void onClick(View view)
    {
        if (LauncherActivity.e(a))
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.stName.d));
            b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.sEvent.LauncherTileName.d));
            b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.eType.d, com.cyberlink.youcammakeup.clflurry.ration.b));
            YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.ource.d.a());
            YMKCostumeMakeupEvent.b(com.cyberlink.youcammakeup.clflurry.t.Source.a.a());
            YMKFeatureRoomLookEvent.b(com.cyberlink.youcammakeup.clflurry.ent.Source.d.a());
            com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
            com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
            view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/CostumeLooksPagerActivity);
            a.startActivity(view);
            a.finish();
            return;
        }
    }

    ivity(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}
