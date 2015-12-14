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

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, RecommendationActivity

class a
    implements android.view.
{

    final LauncherActivity a;

    public void onClick(View view)
    {
        com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
        com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.stName.j));
        b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.sEvent.LauncherTileName.j));
        b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.eType.j, com.cyberlink.youcammakeup.clflurry.ration.b));
        view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/RecommendationActivity);
        view.putExtra("previousActivity", "launcher");
        view.putExtra("title", a.getString(0x7f070528));
        com.cyberlink.youcammakeup.activity.ty.Groups.a.a(view);
        a.startActivity(view);
        a.finish();
        a.overridePendingTransition(0x7f040001, 0x7f040008);
    }

    ty.Groups(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}
