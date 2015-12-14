// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.cyberlink.youcammakeup.activity.VideoPlaybackActivity;
import com.cyberlink.youcammakeup.clflurry.t;
import com.cyberlink.youcammakeup.database.more.a.b;
import com.cyberlink.youcammakeup.flurry.PopularityOfAllVideosEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bm;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import java.net.URI;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            d, g

class a
    implements android.view..OnClickListener
{

    final d a;

    public void onClick(View view)
    {
        Long long1 = Long.valueOf(((g)view).getFilmId());
        if (!d.c(a).containsKey(long1)) goto _L2; else goto _L1
_L1:
        view = (b)d.c(a).get(long1);
        if (view == null) goto _L2; else goto _L3
_L3:
        com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfAllVideosEvent(String.valueOf(long1.longValue())));
        d.i(a).a(new bm(d.i(a), long1.longValue()));
        if (view.b() == null || !view.b().equals("Youtube")) goto _L5; else goto _L4
_L4:
        StatusManager.j().a(d.d(a));
        StatusManager.j().a(view);
        Intent intent = new Intent(d.g(a), com/cyberlink/youcammakeup/activity/VideoPlaybackActivity);
        d.g(a).startActivity(intent);
_L8:
        com.cyberlink.youcammakeup.clflurry.b.a(new t(Long.toString(d.h(a)), Long.toString(view.a())));
        a.b();
_L2:
        return;
_L5:
        if (view == null || view.e() == null || view.e().getPath() == null) goto _L2; else goto _L6
_L6:
        Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse(view.e().toString()));
        d.g(a).startActivity(intent1);
        if (true) goto _L8; else goto _L7
_L7:
    }

    ackActivity(d d1)
    {
        a = d1;
        super();
    }
}
