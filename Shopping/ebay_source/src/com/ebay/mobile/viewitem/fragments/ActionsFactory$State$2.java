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
        boolean flag = "Accepted".equals(bestoffer.status);
        int i = 0x7f070732;
        if (flag)
        {
            i = 0x7f070705;
        }
        if (item.isSeller)
        {
            i = 0x7f07070e;
        }
        headerText.append(resources.getString(i));
        if (flag)
        {
            String s3 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, 0);
            String s = null;
            viewitemdatamanager = s;
            if (item.isDisplayPriceCurrencyCode)
            {
                com.ebay.nautilus.domain.data.ItemCurrency itemcurrency = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
                viewitemdatamanager = s;
                if (itemcurrency != null)
                {
                    viewitemdatamanager = Item.getApproximateString(activity, itemcurrency).toString();
                }
            }
            String s4 = item.displayPriceShipping;
            String s1 = null;
            s = s1;
            if (item.isDisplayPriceCurrencyCode)
            {
                com.ebay.nautilus.domain.data.ItemCurrency itemcurrency2 = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), item.displayPriceShippingCurrency);
                s = s1;
                if (itemcurrency2 != null)
                {
                    s = (new StringBuilder()).append("+ ").append(EbayCurrencyUtil.formatDisplay(itemcurrency2, 0)).toString();
                }
            }
            s1 = null;
            if (item.isDisplayPriceCurrencyCode)
            {
                s1 = ActionsFactory.getConvertedPriceAndShipping(activity, viewitemdatamanager, s);
            }
            statsContainer.add(Util.createViewItemStatPrice(layoutinflater, viewgroup, s3, s4, s1, false));
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f0708c4), Integer.toString(bestoffer.quantity)));
        } else
        {
            String s2 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, item.getCurrencyUtilFlag());
            Object obj = null;
            viewitemdatamanager = obj;
            if (item.isDisplayPriceCurrencyCode)
            {
                com.ebay.nautilus.domain.data.ItemCurrency itemcurrency1 = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
                viewitemdatamanager = obj;
                if (itemcurrency1 != null)
                {
                    viewitemdatamanager = Item.getApproximateString(activity, itemcurrency1).toString();
                }
            }
            statsContainer.add(Util.createViewItemStatCurrency(layoutinflater, viewgroup, resources.getString(0x7f07044d), s2, viewitemdatamanager));
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f0708c4), Integer.toString(bestoffer.quantity)));
            statsContainer.add(Util.createViewItemStatCountDown(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f07057c), bestoffer.expirationDate, true));
        }
        if (!TextUtils.isEmpty(bestoffer.sellerMessage))
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f070733), bestoffer.sellerMessage));
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
        } else
        if (flag)
        {
            if (item.isTransacted)
            {
                buttonsContainer.add(ActionsFactory.access$200(actionsfactory, resources.getString(0x7f070764), AY_NOW, true));
            }
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f07070c), ONTACT_USER));
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
