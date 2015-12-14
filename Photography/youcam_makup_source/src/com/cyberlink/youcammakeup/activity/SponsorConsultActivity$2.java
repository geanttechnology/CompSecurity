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
    implements android.view.onsorConsultActivity._cls2
{

    final SponsorConsultActivity a;

    public void onClick(View view)
    {
        if (!view.isClickable() || !view.isEnabled() || com.cyberlink.youcammakeup.activity.SponsorConsultActivity.b(a) == null)
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
            if (a.b != null)
            {
                b.a(new YMKADFromFeatureRoomUsageEvent(s, s1, a.b));
            }
        }
        view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
        view.putExtra("RedirectUrl", com.cyberlink.youcammakeup.activity.SponsorConsultActivity.b(a).toString());
        a.startActivity(view);
    }

    Event(SponsorConsultActivity sponsorconsultactivity)
    {
        a = sponsorconsultactivity;
        super();
    }
}
