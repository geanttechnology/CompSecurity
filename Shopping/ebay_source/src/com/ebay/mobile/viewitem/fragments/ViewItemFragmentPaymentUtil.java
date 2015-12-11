// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.Intent;
import com.ebay.common.model.ItemTransaction;
import com.ebay.mobile.CheckoutItem;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.checkout.CheckoutActivity;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.viewitem.ViewItemViewData;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemBaseFragment

public class ViewItemFragmentPaymentUtil
{

    private ViewItemFragmentPaymentUtil()
    {
    }

    public static void payForItems(ViewItemBaseFragment viewitembasefragment, Item item, ViewItemViewData viewitemviewdata, int i, Boolean boolean1, int j, String s, String s1)
    {
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        if (dcshelper.isMecOrMec2Enabled(item.site))
        {
            viewitembasefragment.activityRefreshListener.deleteCachedItem();
            Intent intent = new Intent(viewitembasefragment.getActivity(), com/ebay/mobile/checkout/CheckoutActivity);
            intent.putExtra("remember_me", dcshelper.isMec2Enabled(item.site));
            intent.putExtra("item", new CheckoutItem(item));
            intent.putExtra("refined_postal_code", viewitemviewdata.searchRefinedPostalCode);
            intent.putExtra("com.ebay.mobile.tracking.BidSource", s);
            intent.putExtra("com.ebay.mobile.tracking.Referrer", s1);
            s = new ItemTransaction();
            if (item.iTransaction != null && !boolean1.booleanValue())
            {
                s = item.iTransaction;
            } else
            {
                if (!boolean1.booleanValue())
                {
                    s.transactionId = Long.toString(item.transactionId.longValue());
                }
                s.quantityPurchased = i;
            }
            intent.putExtra("transaction", s);
            item = item.getVariationId(viewitemviewdata.nameValueList);
            if (boolean1.booleanValue())
            {
                intent.putExtra("variation_id", item);
            }
            intent.putParcelableArrayListExtra("variation_options", viewitemviewdata.nameValueList);
            viewitembasefragment.startActivityForResult(intent, j);
        }
    }
}
