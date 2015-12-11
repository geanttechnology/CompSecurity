// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Fragment;
import com.ebay.mobile.Item;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ItemViewBiddingUpdater;
import com.ebay.mobile.viewitem.ItemViewPlaceOfferActivity;
import com.ebay.mobile.viewitem.ViewItemConfirmActivity;
import com.ebay.mobile.viewitem.ViewItemPlaceBidActivity;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.util.FwLog;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemFragmentUtil

public class ViewItemFragmentBiddingUtil
{

    private ViewItemFragmentBiddingUtil()
    {
    }

    public static CurrencyAmount getBidForConfirm(Item item, PriceView priceview)
    {
        return new CurrencyAmount(priceview.getPrice(), item.currentPrice.code);
    }

    public static void placeBid(Fragment fragment, Item item, ViewItemViewData viewitemviewdata, ItemCurrency itemcurrency, int i, String s, String s1)
    {
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[] {
                itemcurrency
            });
        }
        if (!item.isAuctionEnded)
        {
            ItemCurrency itemcurrency1 = itemcurrency;
            if (itemcurrency == null)
            {
                itemcurrency1 = new ItemCurrency(item.minimumToBid.lowerBound.getCurrencyCode(), Double.toString(item.minimumToBid.lowerBound.getValueAsDouble()));
            }
            startConfirmation(fragment, item, viewitemviewdata, false, itemcurrency1, i, s, s1);
            return;
        } else
        {
            ViewItemFragmentUtil.showDialogOk(fragment, fragment.getString(0x7f07049d));
            return;
        }
    }

    public static void placeBidAmount(Fragment fragment, Item item, ViewItemViewData viewitemviewdata, Double double1, int i, String s, String s1)
    {
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[] {
                double1
            });
        }
        if (!item.isAuctionEnded)
        {
            if (DeviceConfiguration.getAsync().get(DcsBoolean.VI_featureNewBidFlow))
            {
                ViewItemPlaceBidActivity.startActivity(null, fragment, viewitemviewdata, s1, s, i, false);
                return;
            } else
            {
                ItemViewPlaceOfferActivity.startActivity(null, fragment, viewitemviewdata, s1, String.valueOf(double1), s, i, false);
                return;
            }
        } else
        {
            ViewItemFragmentUtil.showDialogOk(fragment, fragment.getString(0x7f07049d));
            return;
        }
    }

    private static void startConfirmation(Fragment fragment, Item item, ViewItemViewData viewitemviewdata, boolean flag, ItemCurrency itemcurrency, int i, String s, String s1)
    {
        if (ItemViewBiddingUpdater.fwLogItemViewBidding.isLoggable)
        {
            FwLog.logMethod(ItemViewBiddingUpdater.fwLogItemViewBidding, new Object[] {
                itemcurrency
            });
        }
        itemcurrency = new CurrencyAmount(itemcurrency);
        com.ebay.mobile.Item.BidBounds bidbounds = item.minimumToBid;
        boolean flag2 = false;
        boolean flag1 = flag2;
        if (bidbounds != null)
        {
            flag1 = flag2;
            if (bidbounds.lowerBound != null)
            {
                flag1 = bidbounds.lowerBound.equals(itemcurrency);
            }
        }
        ViewItemConfirmActivity.StartActivity(null, fragment, ItemViewActivity.isUseNewUi(item, flag), viewitemviewdata, 1, itemcurrency, flag, s1, s, flag1, false, i);
    }
}
