// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.view.View;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            HomeActivity

class this._cls0
    implements android.view.ener
{

    final HomeActivity this$0;

    public void onClick(View view)
    {
        BackgroundSoundsBinder.sharedInstance().playBip();
        if (!AkConfigFactory.sharedInstance().isFreemium())
        {
            if (AkConfigFactory.sharedInstance().isPaid())
            {
                goToStore();
                MetricsSetAdapter.sharedInstance().incMetricCompteur("shop_click");
            }
            return;
        } else
        {
            goToStoreItems();
            return;
        }
    }

    SoundsBinder()
    {
        this$0 = HomeActivity.this;
        super();
    }
}
