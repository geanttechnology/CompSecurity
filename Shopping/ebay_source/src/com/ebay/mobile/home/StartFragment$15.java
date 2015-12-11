// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.ScheduledListingViewModel;
import com.ebay.mobile.viewitem.ItemViewActivity;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.Listener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (!(viewmodel instanceof ScheduledListingViewModel))
        {
            break MISSING_BLOCK_LABEL_63;
        }
        view = (ScheduledListingViewModel)viewmodel;
        long l = Long.parseLong(((ScheduledListingViewModel) (view)).listingId);
        view = new Intent();
        view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "scheduled", "sell"));
        ItemViewActivity.StartActivity(getActivity(), l, com.ebay.common.temKind.Scheduled, view);
_L1:
        return;
        view;
        if (StartFragment.access$900().oggable)
        {
            StartFragment.access$900().AsError("Scheduled item id could not be parsed");
            return;
        }
          goto _L1
    }

    gInfo()
    {
        this$0 = StartFragment.this;
        super();
    }
}
