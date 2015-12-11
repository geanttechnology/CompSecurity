// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ListView;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.inventory.LocationAddress;
import com.ebay.common.model.inventory.StoreAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.inventory:
//            StorePickerActivity

class val.availabilities
    implements android.view.balLayoutListener
{

    final StorePickerActivity this$0;
    final List val$availabilities;

    public void onGlobalLayout()
    {
        findViewById(0x7f100037).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        StoreAvailability storeavailability = StorePickerActivity.access$000(StorePickerActivity.this).getSelectedStore();
        if (storeavailability != null && val$availabilities.contains(storeavailability))
        {
            StorePickerActivity.access$100(StorePickerActivity.this).setSelectionFromTop(val$availabilities.indexOf(storeavailability), 0);
        }
        if (StorePickerActivity.access$200(StorePickerActivity.this) > 0)
        {
            int i = 0;
            Object obj = new com.google.android.gms.maps.model.init>();
            LatLng latlng = StorePickerActivity.access$000(StorePickerActivity.this).getUserLocation();
            boolean flag = false;
            if (latlng != null)
            {
                ((com.google.android.gms.maps.model.ation) (obj)).nclude(latlng);
                flag = true;
            }
            for (Iterator iterator = val$availabilities.iterator(); iterator.hasNext();)
            {
                StoreAvailability storeavailability1 = (StoreAvailability)iterator.next();
                int j = 0x7f0202db;
                if (com.ebay.common.model.inventory.labilityType.OUT_OF_STOCK.equals(storeavailability1.availability))
                {
                    j = 0x7f0202dc;
                }
                int k = i;
                if (i < StorePickerActivity.access$200(StorePickerActivity.this))
                {
                    k = i + 1;
                    ((com.google.android.gms.maps.model.) (obj)).nclude(new LatLng(storeavailability1.address.latitude, storeavailability1.address.longitude));
                }
                Marker marker = StorePickerActivity.access$300(StorePickerActivity.this).addMarker((new MarkerOptions()).position(new LatLng(storeavailability1.address.latitude, storeavailability1.address.longitude)).icon(BitmapDescriptorFactory.fromResource(j)));
                StorePickerActivity.access$400(StorePickerActivity.this).put(marker, storeavailability1);
                StorePickerActivity.access$500(StorePickerActivity.this).put(storeavailability1, marker);
                i = k;
            }

            obj = ((com.google.android.gms.maps.model.) (obj)).uild();
            if (!flag && (val$availabilities.size() == 1 || StorePickerActivity.access$200(StorePickerActivity.this) == 1))
            {
                obj = (StoreAvailability)val$availabilities.get(0);
                obj = CameraUpdateFactory.newLatLngZoom(new LatLng(((StoreAvailability) (obj)).address.latitude, ((StoreAvailability) (obj)).address.longitude), 11F);
            } else
            {
                obj = CameraUpdateFactory.newLatLngBounds(((com.google.android.gms.maps.model.LatLngBounds) (obj)), 30);
            }
            StorePickerActivity.access$300(StorePickerActivity.this).moveCamera(((com.google.android.gms.maps.CameraUpdate) (obj)));
            obj = StorePickerActivity.access$300(StorePickerActivity.this).getUiSettings();
            ((UiSettings) (obj)).setZoomGesturesEnabled(true);
            ((UiSettings) (obj)).setScrollGesturesEnabled(true);
            obj = StorePickerActivity.access$000(StorePickerActivity.this).getSelectedStore();
            if (obj != null)
            {
                obj = (Marker)StorePickerActivity.access$500(StorePickerActivity.this).get(obj);
                if (obj != null)
                {
                    StorePickerActivity.access$600(StorePickerActivity.this, ((Marker) (obj)));
                }
            }
        }
        findViewById(0x7f100142).setVisibility(8);
    }

    orFactory()
    {
        this$0 = final_storepickeractivity;
        val$availabilities = List.this;
        super();
    }
}
