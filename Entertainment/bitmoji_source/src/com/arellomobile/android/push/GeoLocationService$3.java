// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.util.Log;

// Referenced classes of package com.arellomobile.android.push:
//            GeoLocationService

class this._cls0 extends BroadcastReceiver
{

    final GeoLocationService this$0;

    public void onReceive(Context context, Intent intent)
    {
        Log.i("LocationUpdateService", "- stationaryLocationMonitorReceiver fired");
        if (GeoLocationService.access$100(GeoLocationService.this).booleanValue())
        {
            GeoLocationService.access$200(GeoLocationService.this, "dialtone");
        }
        GeoLocationService.access$300(GeoLocationService.this).setAccuracy(1);
        GeoLocationService.access$300(GeoLocationService.this).setHorizontalAccuracy(3);
        GeoLocationService.access$300(GeoLocationService.this).setPowerRequirement(3);
        GeoLocationService.access$500(GeoLocationService.this).requestSingleUpdate(GeoLocationService.access$300(GeoLocationService.this), GeoLocationService.access$400(GeoLocationService.this));
    }

    ()
    {
        this$0 = GeoLocationService.this;
        super();
    }
}
