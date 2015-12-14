// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherTileClicksEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.LauncherGotoEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.g;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;

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
            com.cyberlink.youcammakeup.flurry.a.a(new LauncherGotoEvent(com.cyberlink.youcammakeup.flurry.estName.c));
            b.a(new YMKLauncherTileClicksEvent(com.cyberlink.youcammakeup.clflurry.ksEvent.LauncherTileName.c));
            b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.leType.b, com.cyberlink.youcammakeup.clflurry.eration.b));
            YMKSavingPageEvent.b(com.cyberlink.youcammakeup.clflurry.Source.c.a());
            YMKFeatureRoomLookEvent.b(com.cyberlink.youcammakeup.clflurry.vent.Source.c.a());
            com.cyberlink.youcammakeup.activity.LauncherActivity.a(a, true);
            com.cyberlink.youcammakeup.activity.LauncherActivity.b(a, false);
            StatusManager.j().b(-1L);
            StatusManager.j().a(null, com.cyberlink.youcammakeup.activity.LauncherActivity.a);
            Globals.d().a(false);
            view = new ty.State("editView");
            g.a(a, view, null, null, null, null);
            return;
        }
    }

    ty.State(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}
