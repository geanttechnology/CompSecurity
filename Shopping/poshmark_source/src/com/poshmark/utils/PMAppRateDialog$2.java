// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.triggers.PMTrigger;

// Referenced classes of package com.poshmark.utils:
//            PMAppRateDialog

class this._cls0
    implements android.view.er
{

    final PMAppRateDialog this$0;

    public void onClick(View view)
    {
        trigger.setNewState(com.poshmark.triggers.tate.IGNORED);
        dismiss();
        Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_rating_alert_remind_later_button_tapped", null);
    }

    erState()
    {
        this$0 = PMAppRateDialog.this;
        super();
    }
}
