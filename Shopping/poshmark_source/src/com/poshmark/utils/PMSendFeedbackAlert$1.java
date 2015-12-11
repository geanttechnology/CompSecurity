// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.view.View;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.utils:
//            PMSendFeedbackAlert

class this._cls0
    implements android.view.ert._cls1
{

    final PMSendFeedbackAlert this$0;

    public void onClick(View view)
    {
        dismiss();
        Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_rating_send_feedback_dismissed", null);
    }

    ()
    {
        this$0 = PMSendFeedbackAlert.this;
        super();
    }
}
