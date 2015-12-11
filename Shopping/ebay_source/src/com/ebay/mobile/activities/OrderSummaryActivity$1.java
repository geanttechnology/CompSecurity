// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.view.View;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.OrderItemTransaction;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ItemViewActivity;

// Referenced classes of package com.ebay.mobile.activities:
//            OrderSummaryActivity

class val.row
    implements android.view.aryActivity._cls1
{

    final OrderSummaryActivity this$0;
    final View val$row;

    public void onClick(View view)
    {
        if (Util.hasNetwork())
        {
            if ((view = ((View) (val$row.getTag()))) instanceof OrderItemTransaction)
            {
                view = (OrderItemTransaction)view;
                InventoryInfo inventoryinfo = new InventoryInfo();
                inventoryinfo.setSelectedStore(new StoreAvailability(OrderSummaryActivity.access$000(OrderSummaryActivity.this)));
                inventoryinfo.setSellerUserId(OrderSummaryActivity.access$100(OrderSummaryActivity.this).sellerUserId);
                inventoryinfo.setItemSku(((OrderItemTransaction) (view)).sku);
                ItemViewActivity.StartActivity(OrderSummaryActivity.this, Long.parseLong(((OrderItemTransaction) (view)).itemId), ((OrderItemTransaction) (view)).transactionId, com.ebay.common.d.Won, inventoryinfo);
                return;
            }
        }
    }

    ()
    {
        this$0 = final_ordersummaryactivity;
        val$row = View.this;
        super();
    }
}
