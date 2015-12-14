// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKCostumeMakeupEvent;
import com.cyberlink.youcammakeup.clflurry.YMKLooksStoreEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            CostumeLooksPagerActivity, ExtraDownloadCategoryActivity

class a
    implements android.view.meLooksPagerActivity._cls4
{

    final CostumeLooksPagerActivity a;

    public void onClick(View view)
    {
        if (!StatusManager.j().E().booleanValue())
        {
            return;
        } else
        {
            YMKLooksStoreEvent.b(com.cyberlink.youcammakeup.clflurry.ion.ion());
            b.a(new YMKCostumeMakeupEvent(com.cyberlink.youcammakeup.clflurry.ion.c, null));
            view = new Intent(a, com/cyberlink/youcammakeup/activity/ExtraDownloadCategoryActivity);
            view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_ID", 0x15ab1cL);
            view.putExtra("KEY_EXTRA_DOWNLOAD_CATEGORY_NAME", a.getString(0x7f070502));
            a.startActivity(view);
            return;
        }
    }

    y(CostumeLooksPagerActivity costumelookspageractivity)
    {
        a = costumelookspageractivity;
        super();
    }
}
