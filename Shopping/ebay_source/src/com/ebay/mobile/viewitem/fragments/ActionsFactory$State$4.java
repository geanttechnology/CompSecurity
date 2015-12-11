// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
        BestOffer bestoffer = item.newestBestOffer(MyApp.getPrefs().getCurrentUser());
        android.app.Activity activity = actionsfactory.fragment.getActivity();
        int i;
        boolean flag;
        boolean flag1;
        int j;
        if (item.remainingBestOffersForBuyer(bestoffer.buyerId) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (item.remainingBestOffersForBuyer(bestoffer.buyerId) == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        j = 0x7f070281;
        if (item.isSeller)
        {
            i = j;
            if (!bestoffer.codeType.equals("BuyerBestOffer"))
            {
                i = j;
                if (!bestoffer.codeType.equals("BuyerCounterOffer"))
                {
                    i = 0x7f070709;
                }
            }
        } else
        {
            i = j;
            if (!bestoffer.codeType.equals("SellerCounterOffer"))
            {
                i = 0x7f070712;
                if (flag1)
                {
                    i = 0x7f070713;
                } else
                if (flag)
                {
                    i = 0x7f070711;
                    if (item.isSeller)
                    {
                        i = 0x7f07070a;
                    }
                }
            }
        }
        headerText.append(resources.getString(i));
        if (item.isSeller)
        {
            String s1 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, item.getCurrencyUtilFlag());
            Object obj = null;
            viewitemdatamanager = obj;
            if (item.isDisplayPriceCurrencyCode)
            {
                com.ebay.nautilus.domain.data.ItemCurrency itemcurrency = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
                viewitemdatamanager = obj;
                if (itemcurrency != null)
                {
                    viewitemdatamanager = Item.getApproximateString(activity, itemcurrency).toString();
                }
            }
            statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f07044d), s1, viewitemdatamanager));
        } else
        if (!flag)
        {
            viewitemdatamanager = null;
            String s;
            String s3;
            if (item.isBinOnly)
            {
                String s2 = item.displayPrice;
                s = s2;
                if (item.isDisplayPriceCurrencyCode)
                {
                    viewitemdatamanager = Item.getApproximateString(activity, item.convertedBuyItNowPrice).toString();
                    s = s2;
                }
            } else
            {
                String s4 = item.displayCurrentPrice;
                s = s4;
                if (item.isDisplayPriceCurrencyCode)
                {
                    viewitemdatamanager = Item.getApproximateString(activity, item.convertedCurrentPrice).toString();
                    s = s4;
                }
            }
            statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f0707b1), s, viewitemdatamanager));
            s3 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, item.getCurrencyUtilFlag());
            s = null;
            viewitemdatamanager = s;
            if (item.isDisplayPriceCurrencyCode)
            {
                com.ebay.nautilus.domain.data.ItemCurrency itemcurrency1 = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
                viewitemdatamanager = s;
                if (itemcurrency1 != null)
                {
                    viewitemdatamanager = Item.getApproximateString(activity, itemcurrency1).toString();
                }
            }
            statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f07071a), s3, viewitemdatamanager));
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f0708c4), Integer.toString(bestoffer.quantity)));
        }
        if (!TextUtils.isEmpty(bestoffer.sellerMessage))
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f07018a), bestoffer.sellerMessage));
        }
        if (!TextUtils.isEmpty(bestoffer.buyerMessage))
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f070733), bestoffer.buyerMessage));
        }
        if (item.isSeller)
        {
            if (item.isShowRevise)
            {
                buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f070939), EVISE_LISTING));
            }
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0703c1), ND_LISTING));
        } else
        if (!flag)
        {
            viewitemdatamanager = ActionsFactory.access$500(actionsfactory, null, resources.getString(0x7f070721), AKE_OFFER, true);
            buttonsContainer.add(viewitemdatamanager);
        }
        if (item.isSeller && item.isShowSellSimilar)
        {
            cess._mth600(actionsfactory, resources, buttonsContainer);
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
