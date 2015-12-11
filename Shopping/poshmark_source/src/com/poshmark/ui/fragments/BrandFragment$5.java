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
//            BrandFragment, ShareFragment

class this._cls0
    implements android.view.ener
{

    final BrandFragment this$0;

    public void onClick(View view)
    {
        view = (PMActivity)getActivity();
        if (isAdded() && BrandFragment.access$100(BrandFragment.this) != null)
        {
            Object obj = PMTriggerManager.getGlobalTriggerManager().getBrandShareTrigger();
            if (obj != null)
            {
                ((BrandShareTrigger) (obj)).setNewState(com.poshmark.triggers.rState.INTERACTED);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "brand_share_banner_invite_friends_button_tapped", BrandFragment.access$200(BrandFragment.this));
            }
            obj = new Bundle();
            ((Bundle) (obj)).putString("MODE", com.poshmark.utils.RE_MODE.SHARE_MODE_BRAND.name());
            view.launchFragment(((Bundle) (obj)), com/poshmark/ui/fragments/ShareFragment, BrandFragment.access$100(BrandFragment.this));
        }
    }

    ()
    {
        this$0 = BrandFragment.this;
        super();
    }
}
