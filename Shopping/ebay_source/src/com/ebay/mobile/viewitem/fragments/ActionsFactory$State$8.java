// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.ItemTransactionVariation;
import com.ebay.common.model.OrderShippingInfo;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemShippingInfo;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
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
        android.app.Activity activity;
        activity = actionsfactory.fragment.getActivity();
        Object obj = null;
        viewitemdatamanager = obj;
        if (item.tracking != null)
        {
            viewitemdatamanager = obj;
            if (item.tracking.details != null)
            {
                viewitemdatamanager = obj;
                if (!item.tracking.details.isEmpty())
                {
                    viewitemdatamanager = item.tracking.details;
                }
            }
        }
        int i = 0x7f07075d;
        if (item.isShipped)
        {
            i = 0x7f07028a;
        }
        if (item.isDelivered)
        {
            i = 0x7f070cd8;
        }
        int j = i;
        if (ActionsFactory.access$700(item.iTransaction))
        {
            j = Util.getAfterSalesHeaderResId(item.iTransaction, item.isSeller, i, actionsfactory.fragment.overrideStatus);
        }
        headerText.append(resources.getString(j));
        if (item.iTransaction != null && item.iTransaction.createdDate != null)
        {
            statsContainer.add(Util.createViewItemStatFormattedDate(activity, layoutinflater, viewgroup, resources.getString(0x7f07093b), item.iTransaction.createdDate));
        }
        if (!item.isShipped && item.iTransaction != null && item.iTransaction.paidTime != null)
        {
            String s = (String)DateFormat.format(Util.getDeliveryDateFormat(activity, false), item.iTransaction.paidTime);
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070495), s));
        }
        if (item.quantityPurchased > 1)
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0708c4), Integer.toString(item.quantityPurchased)));
        }
        if (item.iTransaction != null && item.iTransaction.variation != null && item.iTransaction.variation.nameValueList != null && !item.iTransaction.variation.nameValueList.isEmpty())
        {
            DelimitedStringBuilder delimitedstringbuilder = new DelimitedStringBuilder(",");
            for (Iterator iterator = item.iTransaction.variation.nameValueList.iterator(); iterator.hasNext(); delimitedstringbuilder.append(((NameValue)iterator.next()).getValue())) { }
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070740), delimitedstringbuilder.toString()));
        }
        if (item.iTransaction == null || item.iTransaction.orderShippingInfo == null || !item.isDelivered) goto _L2; else goto _L1
_L1:
        String s1 = Util.getFormattedDateTimeStringFromDate(activity, item.iTransaction.orderShippingInfo.actualDeliveryDate);
        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070288), s1));
_L4:
        if (item.iTransaction != null && item.iTransaction.selectedShippingOption != null && item.isShipped && item.iTransaction.selectedShippingOption.shippingServiceName != null)
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070a6e), ViewItemShippingInfo.getPrettyShippingServiceName(item.site, item.iTransaction.selectedShippingOption.shippingServiceName)));
        }
        if (item.buyerAddress != null)
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070b6b), item.buyerAddress));
        }
        if (item.isShipped && item.iTransaction != null && item.iTransaction.shipmentTrackingDetails != null && item.iTransaction.shipmentTrackingDetails.size() > 0 && ((com.ebay.common.model.tTrackingDetails)item.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber != null)
        {
            statsContainer.add(Util.createViewItemStatCopiable(activity, layoutinflater, viewgroup, resources.getString(0x7f070b7e), ((com.ebay.common.model.tTrackingDetails)item.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber));
        }
        if (viewitemdatamanager != null)
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, "", cess._mth900(activity, viewitemdatamanager)));
        }
        if (item.isShowBuyAnother && item.quantity > 1 && item.getQuantityAvailable(null) > 0 && (activity instanceof ItemViewActivity))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0701b6), UY_ANOTHER));
        }
        if (ActionsFactory.access$700(item.iTransaction))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, ActionsFactory.access$800(item, resources.getString(0x7f07088a), resources), FTER_SALES));
        }
        if (item.isShowTrackPackage && viewitemdatamanager != null)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f070ab8), RACK_PACKAGE));
        }
        if (item.isShowLeaveFeedback)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0705d8), EAVE_FEEDBACK));
        }
        if (DeviceConfiguration.getAsync().get(DcsBoolean.ContactSeller))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f07070c), ONTACT_USER));
        }
        if (item.isShowSellLike)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0704e4), ELL_ONE_LIKE_THIS));
        }
        if (MyApp.getDeviceConfiguration().isAfterSalesEnabled())
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f07088a), ORE_OPTIONS));
        }
        return;
_L2:
        if (item.iTransaction != null && item.iTransaction.orderShippingInfo != null && item.iTransaction.orderShippingInfo.estimatedMinDeliveryDate != null && item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate != null)
        {
            String s2 = Util.getDeliveryDateString(activity, item.iTransaction.orderShippingInfo.estimatedMinDeliveryDate, item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate);
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0703eb), s2));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ils(String s, int i)
    {
        super(s, i, null);
    }
}
