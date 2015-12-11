// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDMapActivity

class val.locationManager
    implements LocationListener
{

    final CVSDMapActivity this$0;
    final LocationManager val$locationManager;

    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            CVSDMapActivity.access$200(CVSDMapActivity.this, location);
            CVSDMapActivity.access$600(CVSDMapActivity.this, (new StringBuilder()).append(location.getLatitude()).append("").toString(), (new StringBuilder()).append(location.getLongitude()).append("").toString());
            val$locationManager.removeUpdates(CVSDMapActivity.access$700(CVSDMapActivity.this));
        }
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

    ()
    {
        this$0 = final_cvsdmapactivity;
        val$locationManager = LocationManager.this;
        super();
    }
}
