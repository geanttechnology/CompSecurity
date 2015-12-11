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
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemShippingInfo;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class it> extends it>
{

    public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
    {
        Object obj = null;
        ArrayList arraylist = obj;
        if (item.tracking != null)
        {
            arraylist = obj;
            if (item.tracking.details != null)
            {
                arraylist = obj;
                if (!item.tracking.details.isEmpty())
                {
                    arraylist = item.tracking.details;
                }
            }
        }
        int i = 0x7f0704f3;
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
        if (!item.isDelivered)
        {
            statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f07093b), item.iTransaction.createdDate));
            if (item.iTransaction.paidTime != null)
            {
                statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f0704d6), item.iTransaction.paidTime));
                com.ebay.nautilus.domain.content.il.PaymentReminderStorageParams paymentreminderstorageparams = new com.ebay.nautilus.domain.content.il.PaymentReminderStorageParams();
                paymentreminderstorageparams.id = item.id;
                long l;
                if (item.iTransaction != null && item.iTransaction.createdDate != null)
                {
                    l = item.iTransaction.createdDate.getTime();
                } else
                {
                    l = 0L;
                }
                paymentreminderstorageparams.transactionCreationDate = l;
                paymentreminderstorageparams.variationSpecifics = ActionsFactory.access$100(actionsfactory).nameValueList;
                viewitemdatamanager.deleteItemFromPaymentReminderStorage(paymentreminderstorageparams);
            }
            if (item.iTransaction.orderShippingInfo != null && item.iTransaction.orderShippingInfo.shippedDate != null)
            {
                statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f0704ee), item.iTransaction.orderShippingInfo.shippedDate));
            }
            viewitemdatamanager = ActionsFactory.access$1400(item);
            if (!TextUtils.isEmpty(viewitemdatamanager))
            {
                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070a6e), ViewItemShippingInfo.getPrettyShippingServiceName(item.site, viewitemdatamanager)));
            }
        } else
        {
            viewitemdatamanager = (String)DateFormat.format(Util.getDeliveryDateFormat(actionsfactory.fragment.getActivity(), true), item.iTransaction.orderShippingInfo.actualDeliveryDate);
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070288), viewitemdatamanager));
        }
        if (!TextUtils.isEmpty(item.buyerAddress))
        {
            viewitemdatamanager = ActionsFactory.access$1500(actionsfactory, viewgroup, item);
            if (viewitemdatamanager != null)
            {
                statsContainer.add(viewitemdatamanager);
            }
        }
        if (item.isShipped && item.iTransaction.shipmentTrackingDetails != null && item.iTransaction.shipmentTrackingDetails.size() > 0 && ((com.ebay.common.model.TrackingDetails)item.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber != null)
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070b7e), ((com.ebay.common.model.TrackingDetails)item.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber));
        }
        if (arraylist != null)
        {
            viewitemdatamanager = ess._mth900(actionsfactory.fragment.getActivity(), arraylist);
            if (!TextUtils.isEmpty(viewitemdatamanager))
            {
                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, "", viewitemdatamanager));
            }
        }
        if (ActionsFactory.access$700(item.iTransaction))
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, ActionsFactory.access$800(item, resources.getString(0x7f07088a), resources), TER_SALES));
        }
        if (item.isShowTrackPackage && arraylist != null)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f070ab8), ACK_PACKAGE));
        }
        ess._mth1600(actionsfactory, resources, buttonsContainer, item);
        ess._mth1100(actionsfactory, resources, buttonsContainer, item);
        ess._mth1200(actionsfactory, resources, buttonsContainer, item);
        buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0704de), LIST_ITEM));
        if (item.isShowSellSimilar)
        {
            ess._mth600(actionsfactory, resources, buttonsContainer);
        }
    }

    ls(String s, int i)
    {
        super(s, i, null);
    }
}
