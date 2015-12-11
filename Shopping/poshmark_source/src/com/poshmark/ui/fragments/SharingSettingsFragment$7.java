// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.widget.CompoundButton;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;

// Referenced classes of package com.poshmark.ui.fragments:
//            SharingSettingsFragment

class this._cls0
    implements android.widget.angeListener
{

    final SharingSettingsFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "update_search_visibility_setting", PMApplicationSession.GetPMSession().getUserId());
        SharingSettingsFragment.access$800(SharingSettingsFragment.this, flag);
    }

    r()
    {
        this$0 = SharingSettingsFragment.this;
        super();
    }
}
