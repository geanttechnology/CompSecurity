// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.analytics.Analytics;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            SharingSettingsFragment

class val.bSearchVisibility
    implements PMApiResponseHandler
{

    final SharingSettingsFragment this$0;
    final boolean val$bSearchVisibility;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        SharingSettingsFragment.access$900(SharingSettingsFragment.this, pmapiresponse);
        if (!val$bSearchVisibility)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "turn_off_search_visibility", null);
        }
        hideProgressDialog();
    }

    _cls9()
    {
        this$0 = final_sharingsettingsfragment;
        val$bSearchVisibility = Z.this;
        super();
    }
}
