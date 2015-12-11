// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.content.Intent;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.OrderShippingInfo;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.LocationDetails;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.mobile.Item;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.OrderSummaryActivity;
import com.ebay.mobile.analytics.model.SourceIdentification;
import java.util.Date;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ActionsFactory, ViewItemActionsFragment

static final class it> extends it>
{

    public void execute(ActionsFactory actionsfactory, Object obj)
    {
        if (ViewItemActionsFragment.verboseLogger.verboseLogger)
        {
            ViewItemActionsFragment.verboseLogger.verboseLogger((new StringBuilder()).append("Handled: ").append(toString()).toString());
        }
        Item item = ActionsFactory.access$1900(actionsfactory);
        BaseActivity baseactivity = (BaseActivity)actionsfactory.fragment.getActivity();
        Intent intent = new Intent(baseactivity, com/ebay/mobile/activities/OrderSummaryActivity);
        intent.putExtra("order_id", item.orderId);
        intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(baseactivity.getTrackingEventName()));
        obj = null;
        actionsfactory = ((ActionsFactory) (obj));
        if (item.iTransaction.orderShippingInfo != null)
        {
            actionsfactory = ((ActionsFactory) (obj));
            if (item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate != null)
            {
                actionsfactory = item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate;
            }
        }
        if (actionsfactory != null)
        {
            intent.putExtra("est_delivery_date", actionsfactory.getTime());
        }
        if (item.inventoryInfo != null)
        {
            actionsfactory = item.inventoryInfo.getSelectedStore();
            if (actionsfactory != null)
            {
                obj = new LocationDetails();
                obj.name = ((StoreAvailability) (actionsfactory)).name;
                obj.address = ((StoreAvailability) (actionsfactory)).address;
                obj.pickupInstructions = ((StoreAvailability) (actionsfactory)).pickupInstructions;
                obj.hours = ((StoreAvailability) (actionsfactory)).hours;
                obj.utcHours = ((StoreAvailability) (actionsfactory)).utcHours;
                obj.phone = ((StoreAvailability) (actionsfactory)).phone;
                obj.url = ((StoreAvailability) (actionsfactory)).url;
                obj.utcOffset = ((StoreAvailability) (actionsfactory)).utcOffset;
                intent.putExtra("store_details", ((android.os.Parcelable) (obj)));
                int i;
                if (item.iTransaction.orderShippingInfo == null)
                {
                    i = 0;
                } else
                {
                    i = ActionsFactory.access$1700(item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate);
                }
                intent.putExtra("hours_offset", i);
            }
        }
        intent.setFlags(0x4000000);
        baseactivity.startActivity(intent);
    }

    A(String s, int i)
    {
        super(s, i, null);
    }
}
