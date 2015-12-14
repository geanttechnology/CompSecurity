// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.g;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SponsorAdActivity, WebViewerExActivity

class a
    implements android.view.
{

    final SponsorAdActivity a;

    public void onClick(View view)
    {
        while (SponsorAdActivity.e(a).getVisibility() != 8 || SponsorAdActivity.f(a) || !view.isClickable() || !view.isEnabled() || SponsorAdActivity.i(a) == null) 
        {
            return;
        }
        if (SponsorAdActivity.a(a) != null)
        {
            view = SponsorAdActivity.a(a).type;
            String s = SponsorAdActivity.a(a).skuGuid;
            String s1 = SponsorAdActivity.a(a).itemGuid;
            b.a(new g(view, s, s1));
            if (SponsorAdActivity.j(a) != null)
            {
                b.a(new YMKClicksADFromLauncherBannerEvent(s, s1, SponsorAdActivity.j(a)));
            }
        }
        SponsorAdActivity.a(a, false);
        view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/WebViewerExActivity);
        view.putExtra("RedirectUrl", SponsorAdActivity.i(a).toString());
        a.startActivity(view);
    }

    herBannerEvent(SponsorAdActivity sponsoradactivity)
    {
        a = sponsoradactivity;
        super();
    }
}
