// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.ListingSocial;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.CommentFragment;

// Referenced classes of package com.poshmark.data_model.adapters:
//            HetroFeedListAdapter

class this._cls0
    implements android.view.roFeedListAdapter._cls1
{

    final HetroFeedListAdapter this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent("listings_feed_screen", "listing", "comment_button_tapped", null);
        ListingSocial listingsocial = (ListingSocial)view.getTag();
        view = (PMActivity)view.getContext();
        Bundle bundle = new Bundle();
        bundle.putString("ID", listingsocial.getIdAsString());
        view.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/CommentFragment, listingsocial);
    }

    ()
    {
        this$0 = HetroFeedListAdapter.this;
        super();
    }
}
