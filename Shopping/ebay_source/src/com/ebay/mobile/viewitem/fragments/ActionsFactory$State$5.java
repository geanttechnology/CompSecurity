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
        BestOffer bestoffer;
        int i;
        boolean flag;
        bestoffer = item.newestBestOffer(MyApp.getPrefs().getCurrentUser());
        android.app.Activity activity = actionsfactory.fragment.getActivity();
        String s;
        Object obj;
        String s1;
        String s2;
        com.ebay.nautilus.domain.data.ItemCurrency itemcurrency;
        if (item.remainingBestOffersForBuyer(bestoffer.buyerId) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = 0x7f070722;
        if (flag)
        {
            i = 0x7f070723;
        }
        if (!item.isSeller) goto _L2; else goto _L1
_L1:
        i = 0x7f070707;
        if (!"BuyerBestOffer".equals(bestoffer.codeType)) goto _L4; else goto _L3
_L3:
        i = 0x7f07070b;
_L2:
        headerText.append(resources.getString(i));
        s1 = EbayCurrencyUtil.formatDisplay(bestoffer.currentOffer, 0);
        s = null;
        viewitemdatamanager = s;
        if (item.isDisplayPriceCurrencyCode)
        {
            obj = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), bestoffer.currentOffer.toItemCurrency());
            viewitemdatamanager = s;
            if (obj != null)
            {
                viewitemdatamanager = Item.getApproximateString(activity, ((com.ebay.nautilus.domain.data.ItemCurrency) (obj))).toString();
            }
        }
        s2 = item.displayPriceShipping;
        obj = null;
        s = ((String) (obj));
        if (item.isDisplayPriceCurrencyCode)
        {
            itemcurrency = Item.convertCurrency(actionsfactory.fragment.getFwActivity().getEbayContext(), item.displayPriceShippingCurrency);
            s = ((String) (obj));
            if (itemcurrency != null)
            {
                s = (new StringBuilder()).append("+ ").append(EbayCurrencyUtil.formatDisplay(itemcurrency, 0)).toString();
            }
        }
        obj = null;
        if (item.isDisplayPriceCurrencyCode)
        {
            obj = ActionsFactory.getConvertedPriceAndShipping(activity, viewitemdatamanager, s);
        }
        statsContainer.add(Util.createViewItemStatPrice(layoutinflater, viewgroup, s1, s2, ((String) (obj)), false));
        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f0708c4), Integer.toString(bestoffer.quantity)));
        if (item.endDate != null)
        {
            statsContainer.add(Util.createViewItemStatCountDown(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f070b5a), item.endDate, true));
        }
        if (!TextUtils.isEmpty(bestoffer.sellerMessage))
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f070733), bestoffer.sellerMessage));
        }
        if (!TextUtils.isEmpty(bestoffer.buyerMessage))
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, actionsfactory.fragment.getString(0x7f070733), bestoffer.buyerMessage));
        }
        buttonsContainer.add(ActionsFactory.access$200(actionsfactory, resources.getString(0x7f0701af), EVIEW_OFFER, true));
        if (item.isSeller)
        {
            if (item.isShowRevise)
            {
                buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f070939), EVISE_LISTING));
            }
            if (item.isShowSellSimilar)
            {
                cess._mth600(actionsfactory, resources, buttonsContainer);
            }
        }
        return;
_L4:
        if ("SellerCounterOffer".equals(bestoffer.codeType))
        {
            i = 0x7f07070e;
        } else
        if (flag)
        {
            i = 0x7f070708;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
