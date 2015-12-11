// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.geo.mapsv2.AmazonMap;
import com.amazon.geo.mapsv2.MapFragment;
import com.amazon.geo.mapsv2.OnMapReadyCallback;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.now.platform.AndroidPlatform;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.now.map:
//            MapWebActivity, MarkerInfo

public class DebugMapWebActivity extends MapWebActivity
{

    private static final LatLng destLoc = new LatLng(40.782894134521484D, -73.974800109863281D);
    private static final LatLng originLoc = new LatLng(40.749000549316406D, -73.985389709472656D);
    private volatile boolean running;

    public DebugMapWebActivity()
    {
    }

    private void loadDummyData()
    {
        this;
        JVM INSTR monitorenter ;
        running = true;
        displayMapBar("Delivery Window", "#888888", "6:00 PM - 8:00 PM", "#FF7817");
        final ArrayList markers = new ArrayList(3);
        MarkerInfo markerinfo = new MarkerInfo("Origin", originLoc.latitude, originLoc.longitude, null);
        MarkerInfo markerinfo1 = new MarkerInfo("Destination", destLoc.latitude, destLoc.longitude);
        MarkerInfo markerinfo2 = new MarkerInfo("Courier", originLoc.latitude, originLoc.longitude, null, null);
        markers.add(markerinfo);
        markers.add(markerinfo1);
        markers.add(markerinfo2);
        getMapFragment().getMapAsync(new OnMapReadyCallback() {

            final DebugMapWebActivity this$0;
            final List val$markers;

            public void onMapReady(AmazonMap amazonmap)
            {
                recurringPlot(markers);
            }

            
            {
                this$0 = DebugMapWebActivity.this;
                markers = list;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void recurringPlot(final List markers)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = running;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        LatLng latlng;
        plotMarkers(markers);
        latlng = ((MarkerInfo)markers.get(2)).getCoords();
        if (latlng == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        double d1;
        double d2;
        d1 = latlng.latitude;
        d2 = latlng.longitude;
        markers.remove(2);
        double d = d1;
        if (d1 < destLoc.latitude)
        {
            d = d1 + 0.0010000000474974513D;
        }
        d1 = d2;
        if (d2 < destLoc.longitude)
        {
            d1 = d2 + 0.0010000000474974513D;
        }
        markers.add(new MarkerInfo("Courier", d, d1, null, null));
        AndroidPlatform.getInstance().invokeLater(new Runnable() {

            final DebugMapWebActivity this$0;
            final List val$markers;

            public void run()
            {
                recurringPlot(markers);
            }

            
            {
                this$0 = DebugMapWebActivity.this;
                markers = list;
                super();
            }
        }, 3000L);
        if (true) goto _L1; else goto _L3
_L3:
        markers;
        throw markers;
    }

    public static void startActivity(Context context)
    {
        Intent intent = new Intent(context, com/amazon/now/map/DebugMapWebActivity);
        intent.addFlags(0x20000);
        context.startActivity(intent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        loadDummyData();
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        loadDummyData();
    }

    public void onPause()
    {
        super.onPause();
        running = false;
    }


}
