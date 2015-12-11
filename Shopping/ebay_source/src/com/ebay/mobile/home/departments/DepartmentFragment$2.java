// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.ListingViewModel;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.kernel.util.NumberUtil;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

class this._cls0
    implements com.ebay.mobile.common.view.ener
{

    final DepartmentFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof ListingViewModel)
        {
            long l = NumberUtil.safeParseLong(((ListingViewModel)viewmodel).listingId, -1L);
            if (l > 0L)
            {
                view = TrackingData.sanitize(departmentId);
                ItemViewActivity.invalidateCache(l, (Long)null);
                viewmodel = new Intent(getActivity(), com/ebay/mobile/viewitem/ItemViewActivity);
                viewmodel.putExtra("item_view_id", l);
                viewmodel.putExtra("item_view_kind", com.ebay.common.ind.Deals.toString());
                viewmodel.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "deals", view));
                getActivity().startActivity(viewmodel);
            }
        }
    }

    ()
    {
        this$0 = DepartmentFragment.this;
        super();
    }
}
