// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorShareFragment

class this._cls0
    implements android.view.reFragment._cls2
{

    final ListingEditorShareFragment this$0;

    public void onClick(View view)
    {
        showProgressDialogWithMessage(getResources().getString(0x7f060190));
        share_banner_image.setVisibility(8);
        showBanner = false;
        Analytics.getInstance().trackEvent(getViewNameForAnalytics(), "user", "connect_pinterest_initiated", PMApplicationSession.GetPMSession().getUserId());
        ExtServiceConnectManager.getGlobalConnectManager().pinterestLink(ListingEditorShareFragment.this);
    }

    ()
    {
        this$0 = ListingEditorShareFragment.this;
        super();
    }
}
