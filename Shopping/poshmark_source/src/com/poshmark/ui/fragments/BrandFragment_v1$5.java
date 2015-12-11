// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.triggers.BrandShareTrigger;
import com.poshmark.triggers.PMTriggerManager;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            BrandFragment_v1, ShareFragment

class this._cls0
    implements android.view.r
{

    final BrandFragment_v1 this$0;

    public void onClick(View view)
    {
        view = (PMActivity)getActivity();
        if (isAdded() && BrandFragment_v1.access$100(BrandFragment_v1.this) != null)
        {
            Object obj = PMTriggerManager.getGlobalTriggerManager().getBrandShareTrigger();
            if (obj != null)
            {
                ((BrandShareTrigger) (obj)).setNewState(com.poshmark.triggers.ate.INTERACTED);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "brand_share_banner_invite_friends_button_tapped", BrandFragment_v1.access$200(BrandFragment_v1.this));
            }
            obj = new Bundle();
            ((Bundle) (obj)).putString("MODE", com.poshmark.utils.MODE.SHARE_MODE_BRAND.name());
            view.launchFragment(((Bundle) (obj)), com/poshmark/ui/fragments/ShareFragment, BrandFragment_v1.access$100(BrandFragment_v1.this));
        }
    }

    ()
    {
        this$0 = BrandFragment_v1.this;
        super();
    }
}
