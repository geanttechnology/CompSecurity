// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ebay.common.Preferences;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.nautilus.domain.data.BestOffer;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.shell.app.FwActivity;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class nit> extends nit>
{

    public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
    {
        String s;
        android.app.Activity activity;
        BestOffer bestoffer = item.newestBestOffer(MyApp.getPrefs().getCurrentUser());
        activity = actionsfactory.fragment.getActivity();
        String s1;
        int i;
        boolean flag;
        int j;
        if (item.remainingBestOffersForBuyer(bestoffer.buyerId) == 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (item.remainingBestOffersForBuyer(bestoffer.buyerId) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = 0x7f070513;
        if (i != 0)
        {
            j = 0x7f070512;
        }
        headerText.append(resources.getString(j));
        if (i != 0) goto _L2; else goto _L1
_L1:
        viewitemdatamanager = null;
        if (!item.isBinOnly) goto _L4; else goto _L3
_L3:
        s1 = item.displayPrice;
        s = s1;
        if (item.isDisplayPriceCurrencyCode)
        {
            viewitemdatamanager = Item.getApproximateString(activity, item.convertedBuyItNowPrice).toString();
            s = s1;
        }
_L6:
        statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f0707b1), s, viewitemdatamanager));
_L2:
        s1 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, item.getCurrencyUtilFlag());
        s = null;
        viewitemdatamanager = s;
        if (item.isDisplayPriceCurrencyCode)
        {
            item = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
            viewitemdatamanager = s;
            if (item != null)
            {
                viewitemdatamanager = Item.getApproximateString(activity, item).toString();
            }
        }
        statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f07071a), s1, viewitemdatamanager));
        if (bestoffer.quantity > 1)
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f0708c4), Integer.toString(bestoffer.quantity)));
        }
        if (bestoffer.expirationDate != null)
        {
            viewitemdatamanager = Util.getFormattedDateTimeStringFromDate(activity, bestoffer.expirationDate);
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0704d4), viewitemdatamanager));
        }
        if (i == 0)
        {
            i = 0x7f0701a7;
            if (flag)
            {
                i = 0x7f0701a9;
            }
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(i), AKE_OFFER));
        }
        return;
_L4:
        String s2 = item.displayCurrentPrice;
        s = s2;
        if (item.isDisplayPriceCurrencyCode)
        {
            viewitemdatamanager = Item.getApproximateString(activity, item.convertedCurrentPrice).toString();
            s = s2;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
