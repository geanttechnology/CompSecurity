// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

public class finalized
{

    boolean changed;
    boolean ended;
    boolean finalized;
    final ViewItemDataManager this$0;
    boolean vibrate;

    public (Item item, String s, int i, ItemCurrency itemcurrency, ItemCurrency itemcurrency1, boolean flag, 
            boolean flag1, CurrencyConversionRate currencyconversionrate)
    {
        this$0 = ViewItemDataManager.this;
        super();
        ended = false;
        finalized = false;
        changed = false;
        vibrate = false;
        s = ViewItemDataManager.access$2700(ViewItemDataManager.this, item, s, new CurrencyAmount(itemcurrency));
        CurrencyAmount currencyamount = new CurrencyAmount(item.currentPrice);
        CurrencyAmount currencyamount1 = new CurrencyAmount(itemcurrency);
        boolean flag2;
        if (!currencyamount.equals(currencyamount1))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        changed = flag2;
        if (!item.isAuctionEnded && ViewItemDataManager.access$2800(0x493e0L, item) && (!currencyamount.equals(currencyamount1) || item.bidCount == 0 && i > 0))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        vibrate = flag2;
        item.bidCount = i;
        if (currencyconversionrate != null)
        {
            setCurrentAndConvertedPrice(new CurrencyAmount(itemcurrency), currencyconversionrate, item);
        }
        item.minimumToBid = ViewItemDataManager.access$2000(ViewItemDataManager.this, item, itemcurrency1);
        if (changed)
        {
            item.highBidderUserId = s;
        }
        ended = flag;
        finalized = flag1;
    }
}
