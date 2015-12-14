// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKClicksADFromLauncherBannerEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.clflurry.c;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            SponsorAdActivity, LibraryPickerActivity

class a
    implements android.view.
{

    final SponsorAdActivity a;

    public void onClick(View view)
    {
        while (SponsorAdActivity.e(a).getVisibility() != 8 || SponsorAdActivity.f(a) || !view.isClickable() || !view.isEnabled() || SponsorAdActivity.h(a).getVisibility() != 0) 
        {
            return;
        }
        if (SponsorAdActivity.a(a) != null)
        {
            view = SponsorAdActivity.a(a).type;
            String s = SponsorAdActivity.a(a).skuGuid;
            String s1 = SponsorAdActivity.a(a).itemGuid;
            b.a(new c(view, s, s1));
            b.a(new YMKClicksADFromLauncherBannerEvent(s, s1, com.cyberlink.youcammakeup.clflurry.herBannerEvent.ButtonName.f));
        }
        SponsorAdActivity.a(a, false);
        StatusManager.j().b(-1L);
        StatusManager.j().a(null, SponsorAdActivity.a);
        Globals.d().a(false);
        view = new y.State("editView");
        Intent intent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
        intent.putExtra("LibraryPickerActivity_STATE", view);
        intent.putExtra("EXTRA_KEY_SKU_TRY_IT_URL", SponsorAdActivity.a(a));
        a.startActivity(intent);
    }

    y(SponsorAdActivity sponsoradactivity)
    {
        a = sponsoradactivity;
        super();
    }
}
