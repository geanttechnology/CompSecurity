// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKADFromFeatureRoomUsageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.h;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SponsorConsultActivity, WebViewerExActivity

class a
    implements android.view.onsorConsultActivity._cls4
{

    final SponsorConsultActivity a;

    public void onClick(View view)
    {
        if (!view.isClickable() || !view.isEnabled() || SponsorConsultActivity.e(a) == null)
        {
            return;
        }
        SponsorConsultActivity.a(a, false);
        if (SponsorConsultActivity.c(a) != null)
        {
            view = SponsorConsultActivity.c(a).type;
            String s = SponsorConsultActivity.c(a).skuGuid;
            String s1 = SponsorConsultActivity.c(a).itemGuid;
            b.a(new h(view, s, s1));
            b.a(new YMKADFromFeatureRoomUsageEvent(s, s1, com.cyberlink.youcammakeup.clflurry.Event.ButtonName.a));
        }
        view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
        view.putExtra("RedirectUrl", SponsorConsultActivity.e(a).toString());
        a.startActivity(view);
    }

    Event.ButtonName(SponsorConsultActivity sponsorconsultactivity)
    {
        a = sponsorconsultactivity;
        super();
    }
}
