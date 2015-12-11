// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.OrderShippingInfo;
import com.ebay.mobile.Item;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayNowUtil;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemShippingInfo;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class it> extends it>
{

    public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
    {
        android.app.Activity activity;
        activity = actionsfactory.fragment.getActivity();
        headerText.append(EbayNowUtil.getDeliveryStatusText(activity, item.iTransaction, item.tracking));
        if (!"Cancelled".equals(item.iTransaction.orderStatus)) goto _L2; else goto _L1
_L1:
        String s1 = EbayCurrencyUtil.formatDisplay(item.iTransaction.transactionPrice, 0);
        String s = item.displayPriceShippingConverted;
        viewitemdatamanager = s;
        if (TextUtils.isEmpty(s))
        {
            viewitemdatamanager = item.displayPriceShipping;
        }
        statsContainer.add(Util.createViewItemStatPrice(layoutinflater, viewgroup, s1, viewitemdatamanager));
        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0703eb), EbayNowUtil.getCancelledReason(activity, item.iTransaction)));
_L4:
        if (item.iTransaction.shipmentTrackingDetails != null && item.iTransaction.shipmentTrackingDetails.size() > 0 && ((com.ebay.common.model.TrackingDetails)item.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber != null)
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070b7e), ((com.ebay.common.model.TrackingDetails)item.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber));
        }
        buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0704d5), AY_NOW_ORDER_DETAILS));
        buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f07070c), NTACT_USER));
        if (item.isShowLeaveFeedback)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0705d8), AVE_FEEDBACK));
        }
        return;
_L2:
        boolean flag;
        if (EbayNowUtil.getOrderState(item.iTransaction, item.tracking) == com.ebay.mobile.util.e.PENDING)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && item.iTransaction.paidTime != null)
        {
            viewitemdatamanager = (String)DateFormat.format(Util.getDeliveryDateFormat(activity, false), item.iTransaction.paidTime);
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070495), viewitemdatamanager));
        }
        if (item.isDelivered)
        {
            viewitemdatamanager = (String)DateFormat.format(Util.getDeliveryDateFormat(activity, true), item.iTransaction.orderShippingInfo.actualDeliveryDate);
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070288), viewitemdatamanager));
        }
        if (!item.isDelivered)
        {
            java.util.Date date = item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate;
            viewitemdatamanager = date;
            if (item.tracking != null)
            {
                viewitemdatamanager = date;
                if (item.tracking.estimatedDeliveryDate != null)
                {
                    viewitemdatamanager = item.tracking.estimatedDeliveryDate;
                }
            }
            if (viewitemdatamanager != null)
            {
                viewitemdatamanager = Util.formattedTimeAndDate(resources.getString(0x7f07038d), viewitemdatamanager);
                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0703eb), viewitemdatamanager));
            }
        }
        if (!flag && item.iTransaction.selectedShippingOption.shippingServiceName != null)
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070a6e), ViewItemShippingInfo.getPrettyShippingServiceName(item.site, item.iTransaction.selectedShippingOption.shippingServiceName)));
        }
        if (item.buyerAddress != null)
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070b6b), item.buyerAddress));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ls(String s, int i)
    {
        super(s, i, null);
    }
}
