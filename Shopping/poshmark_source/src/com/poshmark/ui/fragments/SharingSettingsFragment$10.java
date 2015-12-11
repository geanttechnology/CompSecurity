// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.widget.CompoundButton;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.fb_tmblr_twitter.FBPermissionStates;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.http.api.PMApi;

// Referenced classes of package com.poshmark.ui.fragments:
//            SharingSettingsFragment

class this._cls0
    implements android.widget.ngeListener
{

    final SharingSettingsFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            compoundbutton = (new StringBuilder()).append("fbsettings/").append("on").toString();
            if (FbHelper.getInstance().isPermissionEnabled(FBPermissionStates.PUBLISH_PERMISSION))
            {
                PMApplicationSession.GetPMSession().setFacebookPostToTimelineFlag(true);
                PMApi.postFacebookTimelineFlag(true, null);
            } else
            {
                FbHelper.getInstance().link(SharingSettingsFragment.this, 8, 8, FbHelper.FB_CONNECT_AUTO_TIMELINE_REQUEST);
            }
        } else
        {
            PMApplicationSession.GetPMSession().setFacebookPostToTimelineFlag(false);
            PMApi.postFacebookTimelineFlag(false, null);
            compoundbutton = (new StringBuilder()).append("fbsettings/").append("off").toString();
        }
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "timeline_toggled", compoundbutton);
    }

    ()
    {
        this$0 = SharingSettingsFragment.this;
        super();
    }
}
