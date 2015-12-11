// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.triggers.PMTrigger;

// Referenced classes of package com.poshmark.utils:
//            PMLoveDialog, PMSendFeedbackAlert

class this._cls0
    implements android.view.tener
{

    final PMLoveDialog this$0;

    public void onClick(View view)
    {
        trigger.setNewState(com.poshmark.triggers.erState.DISMISSED);
        dismiss();
        (new PMSendFeedbackAlert()).show(getFragmentManager(), "feedbackAlert");
        Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_love_alert_no_button_tapped", null);
        Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_rating_send_feedback_alert_displayed", null);
    }

    lert()
    {
        this$0 = PMLoveDialog.this;
        super();
    }
}
