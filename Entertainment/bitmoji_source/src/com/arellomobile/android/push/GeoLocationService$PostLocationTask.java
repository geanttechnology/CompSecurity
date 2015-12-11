// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Context;
import android.location.Location;
import android.util.Log;
import com.arellomobile.android.push.data.PushZoneLocation;
import com.arellomobile.android.push.utils.WorkerTask;

// Referenced classes of package com.arellomobile.android.push:
//            GeoLocationService, DeviceFeature2_5

private class mLocation extends WorkerTask
{

    protected Location mLocation;
    protected PushZoneLocation mZoneLocation;
    final GeoLocationService this$0;

    protected void doWork(Context context)
        throws Exception
    {
        Log.d("LocationUpdateService", "Executing PostLocationTask#doInBackground");
        mZoneLocation = DeviceFeature2_5.getNearestZone(context, mLocation);
        if (mZoneLocation != null)
        {
            long l = mZoneLocation.getDistanceTo();
            GeoLocationService.access$702((GeoLocationService)context, Integer.valueOf((int)(l / 2L)));
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        Log.d("LocationUpdateService", "PostLocationTask#onPostExecture");
        super.onPostExecute(void1);
    }

    protected (GeoLocationService geolocationservice1, Location location)
    {
        this$0 = GeoLocationService.this;
        super(geolocationservice1);
        mLocation = location;
    }
}
