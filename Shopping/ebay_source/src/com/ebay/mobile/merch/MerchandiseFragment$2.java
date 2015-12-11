// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.merch;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.data.CompactListing;
import com.ebay.nautilus.kernel.util.NumberUtil;

// Referenced classes of package com.ebay.mobile.merch:
//            MerchandiseFragment

class 
    implements android.view.agment._cls2
{

    final MerchandiseFragment this$0;
    final CompactListing val$item;

    public void onClick(View view)
    {
        view = new TrackingData("MerchItemSelected", TrackingType.EVENT);
        view.addKeyValuePair("svcdata", val$item.serverSideTrackingInfo);
        view.send(getActivity());
        long l = NumberUtil.safeParseLong(val$item.listingId, -1L);
        if (l != -1L)
        {
            view = new SourceIdentification("MerchItemSelected");
            Intent intent = new Intent();
            intent.putExtra("com.ebay.mobile.analytics.sid", view);
            ItemViewActivity.StartActivity(getActivity(), l, com.ebay.common.nd.Deals, intent);
        }
    }

    ()
    {
        this$0 = final_merchandisefragment;
        val$item = CompactListing.this;
        super();
    }
}
