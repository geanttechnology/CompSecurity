// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.WatchingViewHolder;
import com.ebay.mobile.home.cards.WatchingViewModel;
import com.ebay.mobile.viewitem.ItemViewActivity;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.kListener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof WatchingViewModel)
        {
            WatchingViewModel watchingviewmodel = (WatchingViewModel)viewmodel;
            viewmodel = new SourceIdentification("HomePage", "watching", "activity");
            if (view.getId() == 0x7f100229)
            {
                view = MyEbayLandingActivity.getWatchingActivityIntent(getActivity(), com.ebay.mobile.activities.ivity.WatchingTarget.ALL);
                view.setFlags(0x24000000);
                view.putExtra("com.ebay.mobile.analytics.sid", viewmodel);
                StartFragment.access$700(StartFragment.this, getActivity(), view, true);
                return;
            }
            int i = 0;
            while (i < WatchingViewHolder.idList.length) 
            {
                if (view.getId() == WatchingViewHolder.idList[i] && watchingviewmodel.contentRecords != null && watchingviewmodel.contentRecords.get(i) != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord)watchingviewmodel.contentRecords.get(i)).listings != null)
                {
                    com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Listing listing = (com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord.Listing)((com.ebay.nautilus.domain.data.UnifiedStream.Group.ContentRecord)watchingviewmodel.contentRecords.get(i)).listings.get(0);
                    if (listing != null)
                    {
                        Intent intent = new Intent();
                        intent.putExtra("com.ebay.mobile.analytics.sid", viewmodel);
                        ItemViewActivity.StartActivity(getActivity(), Long.valueOf(listing.listingId).longValue(), com.ebay.common.ItemKind.Watched, intent);
                    }
                }
                i++;
            }
        }
    }

    ()
    {
        this$0 = StartFragment.this;
        super();
    }
}
