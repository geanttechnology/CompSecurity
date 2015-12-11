// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import com.amazon.geo.mapsv2.AmazonMap;
import com.amazon.geo.mapsv2.CameraUpdateFactory;
import com.amazon.geo.mapsv2.OnMapReadyCallback;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.Marker;
import com.amazon.now.location.Location;

// Referenced classes of package com.amazon.now.map:
//            MapWebActivity

class this._cls0
    implements OnMapReadyCallback
{

    final MapWebActivity this$0;

    public void onMapReady(AmazonMap amazonmap)
    {
        amazonmap.moveCamera(CameraUpdateFactory.newLatLngZoom(Location.getMapCenter(), 12F));
        amazonmap.setOnMarkerClickListener(new com.amazon.geo.mapsv2.AmazonMap.OnMarkerClickListener() {

            final MapWebActivity._cls1 this$1;

            public boolean onMarkerClick(Marker marker)
            {
                if (MapWebActivity.access$000(this$0) != null)
                {
                    MapWebActivity.access$000(this$0).hideInfoWindow();
                    if (MapWebActivity.access$000(this$0).equals(marker))
                    {
                        MapWebActivity.access$002(this$0, null);
                        return true;
                    }
                }
                marker.showInfoWindow();
                MapWebActivity.access$002(this$0, marker);
                return true;
            }

            
            {
                this$1 = MapWebActivity._cls1.this;
                super();
            }
        });
        amazonmap.setOnMapClickListener(new com.amazon.geo.mapsv2.AmazonMap.OnMapClickListener() {

            final MapWebActivity._cls1 this$1;

            public void onMapClick(LatLng latlng)
            {
                MapWebActivity.access$002(this$0, null);
            }

            
            {
                this$1 = MapWebActivity._cls1.this;
                super();
            }
        });
    }

    _cls2.this._cls1()
    {
        this$0 = MapWebActivity.this;
        super();
    }
}
