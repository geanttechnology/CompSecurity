// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.activities.RecentlyViewedItemsActivity;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.RecentlyViewedItemsHolder;
import com.ebay.mobile.home.cards.RecentlyViewedItemsModel;
import com.ebay.mobile.viewitem.ItemViewActivity;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.Listener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof RecentlyViewedItemsModel)
        {
            RecentlyViewedItemsModel recentlyvieweditemsmodel = (RecentlyViewedItemsModel)viewmodel;
            viewmodel = new SourceIdentification("HomePage", "recents", "activity");
            if (view.getId() == 0x7f100294)
            {
                view = new Intent(getActivity(), com/ebay/mobile/activities/RecentlyViewedItemsActivity);
                view.putExtra("com.ebay.mobile.analytics.sid", viewmodel);
                StartFragment.access$700(StartFragment.this, getActivity(), view, false);
                return;
            }
            int i = 0;
            while (i < RecentlyViewedItemsHolder.idList.length) 
            {
                if (view.getId() == RecentlyViewedItemsHolder.idList[i] && recentlyvieweditemsmodel.contentRecords != null && recentlyvieweditemsmodel.contentRecords.get(i) != null && ((com.ebay.nautilus.domain.data.UnifiedStream.roup.ContentRecord)recentlyvieweditemsmodel.contentRecords.get(i)).listings != null)
                {
                    com.ebay.nautilus.domain.data.UnifiedStream.roup.ContentRecord.Listing listing = (com.ebay.nautilus.domain.data.UnifiedStream.roup.ContentRecord.Listing)((com.ebay.nautilus.domain.data.UnifiedStream.roup.ContentRecord)recentlyvieweditemsmodel.contentRecords.get(i)).listings.get(0);
                    if (listing != null)
                    {
                        Intent intent = new Intent();
                        intent.putExtra("com.ebay.mobile.analytics.sid", viewmodel);
                        ItemViewActivity.StartActivity(getActivity(), Long.valueOf(listing.listingId).longValue(), com.ebay.common.temKind.RecentlyViewed, intent);
                    }
                }
                i++;
            }
        }
    }

    ity()
    {
        this$0 = StartFragment.this;
        super();
    }
}
