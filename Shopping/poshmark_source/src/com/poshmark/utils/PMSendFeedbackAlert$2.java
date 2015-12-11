// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.utils:
//            PMSendFeedbackAlert

class this._cls0
    implements android.view.ert._cls2
{

    final PMSendFeedbackAlert this$0;

    public void onClick(View view)
    {
        dismiss();
        view = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "support@poshmark.com", null));
        startActivity(view);
        Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_rating_send_feedback", null);
    }

    ()
    {
        this$0 = PMSendFeedbackAlert.this;
        super();
    }
}
