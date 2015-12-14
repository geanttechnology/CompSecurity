// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.compose.MagComposeActivity;

public class azw
    implements LocationListener
{

    final MagComposeActivity a;

    public azw(MagComposeActivity magcomposeactivity)
    {
        a = magcomposeactivity;
        super();
    }

    public void onLocationChanged(Location location)
    {
        Log.v(MagComposeActivity.b(a), (new StringBuilder()).append(MagComposeActivity.b(a)).append(" : ").append("onLocationChanged").toString());
        if (location != null)
        {
            InstaBeautyApplication.d.a(location.getLatitude());
            InstaBeautyApplication.d.b(location.getLongitude());
            InstaBeautyApplication.f = true;
        }
        MagComposeActivity.h.removeUpdates(a.p);
    }

    public void onProviderDisabled(String s)
    {
        Log.v("InstaBeautyApplication", (new StringBuilder()).append("InstaBeautyApplication").append(" : ").append("onProviderDisabled").toString());
    }

    public void onProviderEnabled(String s)
    {
        Log.v("InstaBeautyApplication", (new StringBuilder()).append("InstaBeautyApplication").append(" : ").append("onProviderEnabled").toString());
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }
}
