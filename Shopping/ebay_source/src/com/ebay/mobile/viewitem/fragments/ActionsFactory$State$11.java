// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ebay.common.model.AllBiddersData;
import com.ebay.mobile.Item;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class it> extends it>
{

    public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
    {
        android.app.Activity activity = actionsfactory.fragment.getActivity();
        int k = 0x7f070125;
        int i = k;
        if (item.endDate != null)
        {
            i = k;
            if (!item.isGTC)
            {
                i = k;
                if (item.endDate.getTime() - System.currentTimeMillis() <= 0x36ee80L)
                {
                    i = 0x7f0703c6;
                }
            }
        }
        headerText.append(resources.getString(i));
        if (item.isScheduled)
        {
            headerText.clear();
            viewitemdatamanager = Util.getFormattedDateTimeStringFromDate(activity, item.startDate).replace(' ', '\240');
            headerText.append(resources.getString(0x7f070950, new Object[] {
                viewitemdatamanager
            }));
        }
        if (!item.isScheduled && item.isActive)
        {
            if (item.endDate != null && !item.isGTC)
            {
                statsContainer.add(Util.createViewItemStatCountDown(activity, layoutinflater, viewgroup, resources.getString(0x7f070b5a), item.endDate, true));
            }
            if (!item.isBinOnly)
            {
                int j = 0x7f070278;
                if (item.bidCount < 1)
                {
                    j = 0x7f070b2c;
                }
                String s1 = item.displayCurrentPrice;
                String s = null;
                viewitemdatamanager = s;
                if (item.isDisplayPriceCurrencyCode)
                {
                    viewitemdatamanager = s;
                    if (item.convertedCurrentPrice != null)
                    {
                        viewitemdatamanager = Item.getApproximateString(activity, item.convertedCurrentPrice).toString();
                    }
                }
                List list = statsContainer;
                String s2 = resources.getString(j);
                long l;
                if (item.isReserveMet)
                {
                    s = null;
                } else
                {
                    s = resources.getString(0x7f07091b);
                }
                list.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, s2, s1, viewitemdatamanager, s));
                if (item.isBidWithBin)
                {
                    s = item.displayPrice;
                    viewitemdatamanager = null;
                    if (item.isDisplayPriceCurrencyCode)
                    {
                        viewitemdatamanager = Item.getApproximateString(activity, item.convertedBuyItNowPrice).toString();
                    }
                    statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f0701b7), s, viewitemdatamanager));
                }
                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070190), Integer.toString(item.bidCount)));
                if (item.allBidders != null)
                {
                    statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0704a0), Integer.toString(item.allBidders.countBidders())));
                }
            }
            if (item.isBinOnly)
            {
                s = item.displayPrice;
                viewitemdatamanager = null;
                if (item.isDisplayPriceCurrencyCode)
                {
                    viewitemdatamanager = Item.getApproximateString(activity, item.convertedBuyItNowPrice).toString();
                }
                statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f0701b7), s, viewitemdatamanager));
                if (item.quantitySold > 1)
                {
                    statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0708c6), Integer.toString(item.quantitySold)));
                }
                if (item.quantity - item.quantitySold > 0)
                {
                    statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070911), Integer.toString(item.quantity - item.quantitySold)));
                }
            }
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070702), Integer.toString(item.watchCount)));
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070701), Integer.toString(item.hitCount)));
            if (item.endDate != null && !item.isGTC)
            {
                l = (item.endDate.getTime() - item.startDate.getTime()) / 0x5265c00L;
                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f07029e), (new com.ebay.nautilus.domain.data.ion(com.ebay.nautilus.domain.data.ionUnitEnum.CALENDAR_DAY, l)).toString(resources)));
            }
            statsContainer.add(Util.createViewItemStatFormattedDate(activity, layoutinflater, viewgroup, resources.getString(0x7f070b29), item.startDate));
        }
        if (item.offers != null && item.offers.size() > 0)
        {
            buttonsContainer.add(ActionsFactory.access$200(actionsfactory, resources.getString(0x7f070936), EW_OFFERS, true));
        }
        if (item.isShowRevise)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f070939), VISE_LISTING));
        }
        buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0703c1), D_LISTING));
        if (item.isShowSellSimilar)
        {
            ess._mth600(actionsfactory, resources, buttonsContainer);
        }
    }

    itEnum(String s, int i)
    {
        super(s, i, null);
    }
}
