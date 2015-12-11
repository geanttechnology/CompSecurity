// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.Item;
import com.ebay.mobile.activities.AddEditTrackingInfoActivity;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewShipmentTrackingDetails

class val.index
    implements android.view.ngDetails._cls3
{

    final ItemViewShipmentTrackingDetails this$0;
    final int val$index;

    public void onClick(View view)
    {
        boolean flag = true;
        view = (ShipmentTrackingDetail)item.tracking.details.get(val$index);
        Intent intent = new Intent(ItemViewShipmentTrackingDetails.this, com/ebay/mobile/activities/AddEditTrackingInfoActivity);
        intent.putExtra("number", ((ShipmentTrackingDetail) (view)).trackingNumber);
        intent.putExtra("carrier", ((ShipmentTrackingDetail) (view)).carrier);
        intent.putExtra("index", val$index);
        intent.putExtra("enter_vs_edit", false);
        if (1 < item.tracking.details.size())
        {
            flag = false;
        }
        intent.putExtra("showRemoveWarning", flag);
        startActivityForResult(intent, 0);
    }

    ()
    {
        this$0 = final_itemviewshipmenttrackingdetails;
        val$index = I.this;
        super();
    }
}
