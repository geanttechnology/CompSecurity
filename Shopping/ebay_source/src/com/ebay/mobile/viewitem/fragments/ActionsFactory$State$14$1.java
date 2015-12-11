// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.ItemTransactionVariation;
import com.ebay.mobile.Item;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.dcs.DcsString;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayPhoneNumberUtil;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemShippingInfo;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

class val.shipToFunInfoTitle
    implements android.view.onsFactory.State._cls14._cls1
{

    final val.shipToFunInfoTitle this$0;
    final Activity val$activity;
    final String val$shipToFunInfoTitle;

    public void onClick(View view)
    {
        view = DeviceConfiguration.getAsync().get(DcsString.ShipToFundInfoUrl);
        if (!TextUtils.isEmpty(view))
        {
            ShowWebViewActivity.start(val$activity, view, val$shipToFunInfoTitle, "ShipToFundInfo");
        }
    }

    ()
    {
        this$0 = final_;
        val$activity = activity1;
        val$shipToFunInfoTitle = String.this;
        super();
    }

    // Unreferenced inner class com/ebay/mobile/viewitem/fragments/ActionsFactory$State$14

/* anonymous class */
    static final class ActionsFactory.State._cls14 extends ActionsFactory.State
    {

        public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
        {
            int i = 0x7f070507;
            if (item.isShipToFundItem)
            {
                i = 0x7f0704bd;
                if (item.isShipped)
                {
                    i = 0x7f070491;
                }
                subHeaderText = resources.getString(0x7f0704be);
                subHeaderButtonResource = Integer.valueOf(0x7f02024a);
                subHeaderButtonListener = resources.getString(0x7f0704f2). new ActionsFactory.State._cls14._cls1();
            }
            int k = i;
            if (ActionsFactory.access$700(item.iTransaction))
            {
                k = Util.getAfterSalesHeaderResId(item.iTransaction, item.isSeller, i, actionsfactory.fragment.overrideStatus);
            }
            headerText.append(resources.getString(k));
            Object obj = Util.getDeliveryDateFormat(actionsfactory.fragment.getActivity(), false);
            statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f07093b), item.iTransaction.createdDate));
            if (item.iTransaction.paidTime != null)
            {
                statsContainer.add(Util.createViewItemStatFormattedDate(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f0704d6), item.iTransaction.paidTime));
                com.ebay.nautilus.domain.content.PaymentReminderStorageUtil.PaymentReminderStorageParams paymentreminderstorageparams = new com.ebay.nautilus.domain.content.PaymentReminderStorageUtil.PaymentReminderStorageParams();
                paymentreminderstorageparams.id = item.id;
                int j;
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
            if (item.isShipToFundItem && item.iTransaction.expectedReleaseDate != null)
            {
                viewitemdatamanager = (String)DateFormat.format(((CharSequence) (obj)), item.iTransaction.expectedReleaseDate);
                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0704bb), viewitemdatamanager));
            }
            viewitemdatamanager = ActionsFactory.access$1400(item);
            if (!TextUtils.isEmpty(viewitemdatamanager))
            {
                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070a6e), ViewItemShippingInfo.getPrettyShippingServiceName(item.site, viewitemdatamanager)));
            }
            if (!TextUtils.isEmpty(item.buyerAddress))
            {
                viewitemdatamanager = ActionsFactory.access$1500(actionsfactory, viewgroup, item);
                if (viewitemdatamanager != null)
                {
                    statsContainer.add(viewitemdatamanager);
                }
            }
            if (item.isShipped && item.iTransaction.shipmentTrackingDetails != null && item.iTransaction.shipmentTrackingDetails.size() > 0 && ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)item.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber != null)
            {
                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070b7e), ((com.ebay.common.model.ItemTransaction.ShipmentTrackingDetails)item.iTransaction.shipmentTrackingDetails.get(0)).shipmentTrackingNumber, null, true, null));
            }
            if (!TextUtils.isEmpty(item.iTransaction.buyerCheckoutMessage))
            {
                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0701be), item.iTransaction.buyerCheckoutMessage));
            }
            if (!TextUtils.isEmpty(item.iTransaction.buyerPhone))
            {
                viewitemdatamanager = EbayPhoneNumberUtil.formatPhoneNumber(item.iTransaction.buyerPhone, item.iTransaction.buyerCountry);
                if (!TextUtils.isEmpty(viewitemdatamanager))
                {
                    statsContainer.add(Util.createViewItemStatPhone(actionsfactory.fragment.getActivity(), layoutinflater, viewgroup, resources.getString(0x7f0704d7), viewitemdatamanager));
                }
            }
            j = item.quantitySold;
            if (item.isTransacted)
            {
                j = item.quantityPurchased;
            }
            if (j > 1)
            {
                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f0708c4), Integer.toString(j)));
            }
            if (!item.iTransaction.variation.nameValueList.isEmpty())
            {
                viewitemdatamanager = new DelimitedStringBuilder(",");
                for (obj = item.iTransaction.variation.nameValueList.iterator(); ((Iterator) (obj)).hasNext(); viewitemdatamanager.append(((NameValue)((Iterator) (obj)).next()).getValue())) { }
                statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070740), viewitemdatamanager.toString()));
            }
            if (ActionsFactory.access$700(item.iTransaction))
            {
                buttonsContainer.add(ActionsFactory.access$400(actionsfactory, ActionsFactory.access$800(item, resources.getString(0x7f07088a), resources), ActionsFactory.Action.AFTER_SALES));
            }
            if (item.isShipped)
            {
                ActionsFactory.State.access$1600(actionsfactory, resources, buttonsContainer, item);
            } else
            {
                if (item.isShowLeaveFeedback)
                {
                    buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0705d8), ActionsFactory.Action.LEAVE_FEEDBACK));
                }
                ActionsFactory.State.access$1100(actionsfactory, resources, buttonsContainer, item);
                ActionsFactory.State.access$1200(actionsfactory, resources, buttonsContainer, item);
                buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f070267), ActionsFactory.Action.CONTACT_USER));
            }
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0704de), ActionsFactory.Action.RELIST_ITEM));
            if (item.isShowSellSimilar)
            {
                ActionsFactory.State.access$600(actionsfactory, resources, buttonsContainer);
            }
            if (item.isShowCreateShippingLabel)
            {
                viewitemdatamanager = new Intent("android.intent.action.SEND");
                viewitemdatamanager.setType("message/rfc822");
                boolean flag;
                if (actionsfactory.fragment.getActivity().getPackageManager().queryIntentActivities(viewitemdatamanager, 0).size() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0707c2), ActionsFactory.Action.PRINT_SHIPPING_LABEL));
                }
            }
            if (ActionsFactory.access$1300(item) && !ActionsFactory.access$700(item.iTransaction))
            {
                buttonsContainer.add(ActionsFactory.access$400(actionsfactory, ActionsFactory.access$800(item, resources.getString(0x7f070885), resources), ActionsFactory.Action.CANCEL));
            }
        }

    }

}
