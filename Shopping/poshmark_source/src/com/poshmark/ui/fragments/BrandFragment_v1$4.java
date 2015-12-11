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
//            BrandFragment_v1

class this._cls0
    implements android.view.r
{

    final BrandFragment_v1 this$0;

    public void onClick(View view)
    {
        BrandFragment_v1.access$500(BrandFragment_v1.this).shareTriggerLayout.setVisibility(8);
        view = PMTriggerManager.getGlobalTriggerManager().getBrandShareTrigger();
        if (view != null)
        {
            view.setNewState(com.poshmark.triggers.ate.DISMISSED);
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "brand_share_banner_close_button_tapped", BrandFragment_v1.access$200(BrandFragment_v1.this));
        }
    }

    ewHolder()
    {
        this$0 = BrandFragment_v1.this;
        super();
    }
}
