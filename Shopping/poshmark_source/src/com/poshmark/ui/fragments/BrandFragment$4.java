// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import android.widget.RelativeLayout;
import com.poshmark.analytics.Analytics;
import com.poshmark.triggers.BrandShareTrigger;
import com.poshmark.triggers.PMTriggerManager;
import com.poshmark.utils.view_holders.BrandHeaderViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            BrandFragment

class this._cls0
    implements android.view.ener
{

    final BrandFragment this$0;

    public void onClick(View view)
    {
        BrandFragment.access$500(BrandFragment.this).shareTriggerLayout.setVisibility(8);
        view = PMTriggerManager.getGlobalTriggerManager().getBrandShareTrigger();
        if (view != null)
        {
            view.setNewState(com.poshmark.triggers.rState.DISMISSED);
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "brand_share_banner_close_button_tapped", BrandFragment.access$200(BrandFragment.this));
        }
    }

    te()
    {
        this$0 = BrandFragment.this;
        super();
    }
}
