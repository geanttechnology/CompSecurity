// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.arellomobile.android.push:
//            GeoLocationService

class this._cls0 extends BroadcastReceiver
{

    final GeoLocationService this$0;

    public void onReceive(Context context, Intent intent)
    {
        Log.i("LocationUpdateService", "stationaryRegionReceiver");
        if (Boolean.valueOf(intent.getBooleanExtra("entering", false)).booleanValue())
        {
            Log.d("LocationUpdateService", "- ENTER");
            if (GeoLocationService.access$600(GeoLocationService.this).booleanValue())
            {
                GeoLocationService.access$000(GeoLocationService.this, Boolean.valueOf(false));
            }
        } else
        {
            Log.d("LocationUpdateService", "- EXIT");
            context = getLastBestLocation();
            if (context != null)
            {
                onExitStationaryRegion(context);
                return;
            }
        }
    }

    ()
    {
        this$0 = GeoLocationService.this;
        super();
    }
}
