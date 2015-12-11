// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.Item;
import com.ebay.mobile.activities.AddEditTrackingInfoActivity;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewShipmentTrackingDetails

class this._cls0
    implements android.view.ngDetails._cls4
{

    final ItemViewShipmentTrackingDetails this$0;

    public void onClick(View view)
    {
        view = new Intent(ItemViewShipmentTrackingDetails.this, com/ebay/mobile/activities/AddEditTrackingInfoActivity);
        view.putExtra("index", item.tracking.details.size());
        view.putExtra("enter_vs_edit", true);
        startActivityForResult(view, 0);
    }

    ()
    {
        this$0 = ItemViewShipmentTrackingDetails.this;
        super();
    }
}
