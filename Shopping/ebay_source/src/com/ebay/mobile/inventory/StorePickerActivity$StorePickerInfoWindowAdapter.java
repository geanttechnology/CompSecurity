// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.StoreAvailability;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.PickupUtil;
import com.google.android.gms.maps.model.Marker;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.inventory:
//            StorePickerActivity

private class logisticsPlanType
    implements com.google.android.gms.maps.gisticsPlanType
{

    private final com.ebay.common.model.cart.his._cls0 logisticsPlanType;
    final StorePickerActivity this$0;

    public View getInfoContents(Marker marker)
    {
        Object obj = (StoreAvailability)StorePickerActivity.access$400(StorePickerActivity.this).get(marker);
        marker = getLayoutInflater().inflate(0x7f030260, null);
        if (com.ebay.common.model.cart.his._fld0 != logisticsPlanType)
        {
            TextView textview = (TextView)marker.findViewById(0x7f10081b);
            textview.setText(((StoreAvailability) (obj)).name);
            textview.setVisibility(0);
        }
        ((TextView)marker.findViewById(0x7f100352)).setText(((StoreAvailability) (obj)).address.address1);
        ((TextView)marker.findViewById(0x7f10081c)).setText(StorePickerActivity.access$1100(((StoreAvailability) (obj))));
        obj = PickupUtil.formatStoreHours(StorePickerActivity.this, ((StoreAvailability) (obj)));
        ((TextView)marker.findViewById(0x7f10081f)).setText(((String) (obj)).toString());
        obj = StorePickerActivity.access$000(StorePickerActivity.this).getEstimatedDeliveryDate();
        if (obj != null)
        {
            marker.findViewById(0x7f10081d).setVisibility(0);
            obj = Util.getEstimatedPickupDateString(StorePickerActivity.this, ((java.util.Date) (obj)), false);
            TextView textview1 = (TextView)marker.findViewById(0x7f10081e);
            textview1.setVisibility(0);
            textview1.setText(((CharSequence) (obj)));
        }
        return marker;
    }

    public View getInfoWindow(Marker marker)
    {
        return null;
    }

    public (com.ebay.common.model.cart.Q q)
    {
        this$0 = StorePickerActivity.this;
        super();
        logisticsPlanType = q;
    }
}
