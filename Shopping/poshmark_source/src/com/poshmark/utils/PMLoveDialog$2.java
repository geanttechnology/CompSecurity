// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.view.View;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.utils:
//            PMLoveDialog, PMAppRateDialog

class this._cls0
    implements android.view.tener
{

    final PMLoveDialog this$0;

    public void onClick(View view)
    {
        (new PMAppRateDialog(trigger)).show(getFragmentManager(), "appRateDlg");
        dismiss();
        Analytics.getInstance().trackEvent("listings_feed_screen", "app", "app_love_alert_yes_button_tapped", null);
    }

    ()
    {
        this$0 = PMLoveDialog.this;
        super();
    }
}
