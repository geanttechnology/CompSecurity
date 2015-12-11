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
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.ItemTransactionVariation;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.nautilus.domain.data.BestOffer;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class nit> extends nit>
{

    public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
    {
        android.app.Activity activity = actionsfactory.fragment.getActivity();
        int i = 0x7f070262;
        int k = 0;
        viewitemdatamanager = item.newestBestOffer(MyApp.getPrefs().getCurrentUser());
        Object obj;
        String s1;
        int j;
        boolean flag;
        if (viewitemdatamanager != null && ((BestOffer) (viewitemdatamanager)).status != null && ((BestOffer) (viewitemdatamanager)).status.equals("Accepted"))
        {
            i = 0x7f070705;
            j = k;
        } else
        if ("PaymentPending".equals(item.paidStatus))
        {
            i = 0x7f070767;
            j = 1;
        } else
        {
            j = k;
            if (item.isTransactedAsBin)
            {
                i = 0x7f070cdf;
                j = k;
            }
        }
        k = i;
        if (ActionsFactory.access$700(item.iTransaction))
        {
            k = Util.getAfterSalesHeaderResId(item.iTransaction, item.isSeller, i, actionsfactory.fragment.overrideStatus);
        }
        headerText.append(resources.getString(k));
        obj = null;
        s1 = null;
        viewitemdatamanager = s1;
        if (item.isTransacted)
        {
            String s = item.displayPrice;
            obj = s;
            viewitemdatamanager = s1;
            String s2;
            if (item.isDisplayPriceCurrencyCode)
            {
                if (!TextUtils.isEmpty(item.displayPriceConverted))
                {
                    viewitemdatamanager = item.displayPriceConverted;
                    obj = s;
                } else
                {
                    viewitemdatamanager = EbayCurrencyUtil.formatDisplay(ActionsFactory.getTotalConvertedCurrency(item.iTransaction), 0);
                    obj = s;
                }
            }
        }
        s2 = item.displayPriceShipping;
        s = null;
        if (item.isDisplayPriceCurrencyCode)
        {
            s = item.displayPriceShippingConverted;
        }
        s1 = null;
        if (item.isDisplayPriceCurrencyCode)
        {
            s1 = ActionsFactory.getConvertedPriceAndShipping(activity, viewitemdatamanager, s);
        }
        viewitemdatamanager = statsContainer;
        if (!TextUtils.isEmpty(s2) && item.isVatIncluded())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewitemdatamanager.add(Util.createViewItemStatPrice(layoutinflater, viewgroup, ((String) (obj)), s2, s1, flag));
        if (item.iTransaction != null)
        {
            statsContainer.add(Util.createViewItemStatFormattedDate(activity, layoutinflater, viewgroup, resources.getString(0x7f07093b), item.iTransaction.createdDate));
        }
        if (item.quantityPurchased > 1)
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0708c4), Integer.toString(item.quantityPurchased)));
        }
        if (item.iTransaction != null && item.iTransaction.variation != null && item.iTransaction.variation.nameValueList != null && !item.iTransaction.variation.nameValueList.isEmpty())
        {
            viewitemdatamanager = new DelimitedStringBuilder(",");
            for (obj = item.iTransaction.variation.nameValueList.iterator(); ((Iterator) (obj)).hasNext(); viewitemdatamanager.append(((NameValue)((Iterator) (obj)).next()).getValue())) { }
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070740), viewitemdatamanager.toString()));
        }
        if (j == 0)
        {
            if (item.isShowPaymentOptions)
            {
                buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f070766), AYMENT_OPTIONS));
            } else
            {
                buttonsContainer.add(ActionsFactory.access$200(actionsfactory, resources.getString(0x7f070764), AY_NOW, true));
            }
        }
        if (item.isShowBuyAnother && item.quantity > 1 && item.getQuantityAvailable(null) > 0 && (activity instanceof ItemViewActivity))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0701b6), UY_ANOTHER));
        }
        if (ActionsFactory.access$700(item.iTransaction))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, ActionsFactory.access$800(item, resources.getString(0x7f07088a), resources), FTER_SALES));
        }
        if (DeviceConfiguration.getAsync().get(DcsBoolean.ContactSeller))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f07070c), ONTACT_USER));
        }
        if (item.isShowLeaveFeedback)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0705d8), EAVE_FEEDBACK));
        }
        if (item.isShowSellLike)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0704e4), ELL_ONE_LIKE_THIS));
        }
        if (MyApp.getDeviceConfiguration().isAfterSalesEnabled())
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f07088a), ORE_OPTIONS));
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
