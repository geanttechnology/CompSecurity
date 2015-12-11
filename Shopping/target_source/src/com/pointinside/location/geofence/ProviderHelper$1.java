// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.pointinside.internal.utils.LogUtils;
import java.util.List;

// Referenced classes of package com.pointinside.location.geofence:
//            ProviderHelper, SortableLocation

class this._cls0
    implements LocationListener
{

    private final String LOG_TAG = (new StringBuilder()).append("(").append(com/pointinside/location/geofence/VenueProximityManager$LocationListener.getSimpleName()).append(") ").toString();
    final ProviderHelper this$0;

    private String statusToString(int i)
    {
        switch (i)
        {
        default:
            return "none";

        case 2: // '\002'
            return "available";

        case 0: // '\0'
            return "out of service";

        case 1: // '\001'
            return "temp unavailable";
        }
    }

    public void onLocationChanged(Location location)
    {
        ProviderHelper.access$000(ProviderHelper.this).add(new SortableLocation(location));
        LogUtils.logD(LOG_TAG, (new StringBuilder()).append(location.getProvider()).append(" resolved new location (").append(location.getLatitude()).append(" ").append(location.getLongitude()).append(")").toString());
    }

    public void onProviderDisabled(String s)
    {
        LogUtils.logD(LOG_TAG, (new StringBuilder()).append(ProviderHelper.access$100()).append(s).append(" disabled").toString());
    }

    public void onProviderEnabled(String s)
    {
        LogUtils.logD(LOG_TAG, (new StringBuilder()).append(ProviderHelper.access$100()).append(s).append(" enabled").toString());
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
        LogUtils.logD(LOG_TAG, (new StringBuilder()).append(ProviderHelper.access$100()).append(s).append(" status changed ").append(statusToString(i)).toString());
    }

    ager.LocationListener()
    {
        this$0 = ProviderHelper.this;
        super();
    }
}
