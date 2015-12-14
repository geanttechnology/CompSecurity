// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import com.pipcamera.application.PIPCameraApplication;
import ju;

// Referenced classes of package com.instamag.activity.lib:
//            MagLibActivity

class a
    implements LocationListener
{

    final MagLibActivity a;

    public void onLocationChanged(Location location)
    {
        Log.v("WantuApplication", (new StringBuilder()).append("WantuApplication").append(" : ").append("onLocationChanged").toString());
        if (location != null)
        {
            PIPCameraApplication.d.a(location.getLatitude());
            PIPCameraApplication.d.b(location.getLongitude());
            PIPCameraApplication.f = true;
        }
        MagLibActivity.a.removeUpdates(a.b);
    }

    public void onProviderDisabled(String s)
    {
        Log.v("WantuApplication", (new StringBuilder()).append("WantuApplication").append(" : ").append("onProviderDisabled").toString());
    }

    public void onProviderEnabled(String s)
    {
        Log.v("WantuApplication", (new StringBuilder()).append("WantuApplication").append(" : ").append("onProviderEnabled").toString());
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }

    ion(MagLibActivity maglibactivity)
    {
        a = maglibactivity;
        super();
    }
}
