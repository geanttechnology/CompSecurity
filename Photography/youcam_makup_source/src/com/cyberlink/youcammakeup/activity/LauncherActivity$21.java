// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKLauncherEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.a.c;
import com.cyberlink.youcammakeup.database.a.d;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.banner.BannerRequest;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity, WeekStarActivity

class b
    implements android.view.
{

    final c a;
    final String b;
    final LauncherActivity c;

    public void onClick(View view)
    {
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKLauncherEvent(com.cyberlink.youcammakeup.clflurry.eType.n, com.cyberlink.youcammakeup.clflurry.ration.b));
        view = new Intent(c.getApplicationContext(), com/cyberlink/youcammakeup/activity/WeekStarActivity);
        view.putStringArrayListExtra("Guid", a.g().a());
        view.putExtra("Button", a.g().b());
        view.putExtra("ImageURI", (new File(b, BannerRequest.a())).toString());
        c.startActivity(view);
        c.finish();
    }

    ner.BannerRequest(LauncherActivity launcheractivity, c c1, String s)
    {
        c = launcheractivity;
        a = c1;
        b = s;
        super();
    }
}
