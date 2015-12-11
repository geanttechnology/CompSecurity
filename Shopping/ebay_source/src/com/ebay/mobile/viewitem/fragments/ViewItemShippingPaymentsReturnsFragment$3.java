// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.view.View;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ShowFileWebViewActivity;
import com.ebay.mobile.dcs.DcsHelper;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemShippingPaymentsReturnsFragment

class this._cls0
    implements android.view.entsReturnsFragment._cls3
{

    final ViewItemShippingPaymentsReturnsFragment this$0;

    public void onClick(View view)
    {
        ShowFileWebViewActivity.startActivity(getActivity(), MyApp.getDeviceConfiguration().buyerProtectionUrl(item.topRatedListing), Integer.valueOf(EbayCountryManager.getBuyerProtectionPageTitle()), "");
    }

    ()
    {
        this$0 = ViewItemShippingPaymentsReturnsFragment.this;
        super();
    }
}
