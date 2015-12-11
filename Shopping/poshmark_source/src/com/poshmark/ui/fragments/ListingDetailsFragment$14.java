// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment, CommentFragment

class this._cls0
    implements android.view.sFragment._cls14
{

    final ListingDetailsFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "comment_button_tapped", null);
        view = (PMActivity)view.getContext();
        Bundle bundle = new Bundle();
        bundle.putString("ID", listingId);
        view.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/CommentFragment, listingDetails);
    }

    _cls9()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
