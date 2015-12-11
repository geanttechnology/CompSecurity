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
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.mobile.Item;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.PickupUtil;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class it> extends it>
{

    public void doUpdate(ActionsFactory actionsfactory, ViewItemDataManager viewitemdatamanager, Item item, LayoutInflater layoutinflater, Resources resources, ViewGroup viewgroup)
    {
        int i = 0;
        viewitemdatamanager = actionsfactory.fragment.getActivity();
        headerText.append(PickupUtil.getOrderStatusText(viewitemdatamanager, item.iTransaction, null));
        if (item.iTransaction.pickupStatus == OrderPickupStatus.PendingMerchantConfirmation && item.iTransaction.orderShippingInfo != null && item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate != null)
        {
            subHeaderText = resources.getString(0x7f070181, new Object[] {
                DateFormat.getMediumDateFormat(viewitemdatamanager).format(item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate)
            });
        }
        String s = PickupUtil.getPickupCode(item.iTransaction.merchantPickupCode);
        if (!TextUtils.isEmpty(s))
        {
            statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070794), s));
        }
        if (item.inventoryInfo != null)
        {
            StoreAvailability storeavailability = item.inventoryInfo.getSelectedStore();
            if (storeavailability != null)
            {
                if (storeavailability.address != null)
                {
                    statsContainer.add(Util.createViewItemStatCopiable(viewitemdatamanager, layoutinflater, viewgroup, resources.getString(0x7f070796), PickupUtil.formatStoreAddress(storeavailability.address)));
                }
                if (!TextUtils.isEmpty(storeavailability.phone))
                {
                    statsContainer.add(Util.createViewItemStatPhone(viewitemdatamanager, layoutinflater, viewgroup, resources.getString(0x7f070773), storeavailability.phone));
                }
                if (storeavailability.hours != null)
                {
                    if (item.iTransaction.orderShippingInfo != null)
                    {
                        i = ActionsFactory.access$1700(item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate);
                    }
                    viewitemdatamanager = PickupUtil.formatStoreHours(viewitemdatamanager, storeavailability.hours, i);
                    if (!TextUtils.isEmpty(viewitemdatamanager))
                    {
                        statsContainer.add(Util.createViewItemStat(layoutinflater, viewgroup, resources.getString(0x7f070193), viewitemdatamanager));
                    }
                }
            }
        }
        buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0704d5), _STORE_PICKUP_ORDER_DETAILS));
        if (item.isShowLeaveFeedback)
        {
            buttonsContainer.add(ActionsFactory.access$400(actionsfactory, resources.getString(0x7f0705d8), AVE_FEEDBACK));
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
