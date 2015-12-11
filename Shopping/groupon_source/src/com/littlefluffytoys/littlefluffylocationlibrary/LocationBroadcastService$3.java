// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.littlefluffytoys.littlefluffylocationlibrary;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

// Referenced classes of package com.littlefluffytoys.littlefluffylocationlibrary:
//            LocationBroadcastService, LocationLibrary, LocationLibraryConstants, PassiveLocationChangedReceiver

class this._cls0
    implements LocationListener
{

    final LocationBroadcastService this$0;

    public void onLocationChanged(Location location)
    {
        if (LocationLibrary.showDebugOutput)
        {
            Log.d("LittleFluffyLocationLibrary", (new StringBuilder()).append("LocationBroadcastService: Single Location Update Received: ").append(location.getLatitude()).append(",").append(location.getLongitude()).toString());
        }
        ((LocationManager)getApplicationContext().getSystemService("location")).removeUpdates(preGingerbreadUpdatesListener);
        if (!LocationLibraryConstants.SUPPORTS_FROYO)
        {
            PassiveLocationChangedReceiver.processLocation(LocationBroadcastService.this, location);
        }
        LocationBroadcastService.forceDelayedServiceCall(getApplicationContext(), 1);
        stopSelf();
    }

    public void onProviderDisabled(String s)
    {
    }

    public void onProviderEnabled(String s)
    {
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }

    ver()
    {
        this$0 = LocationBroadcastService.this;
        super();
    }
}
