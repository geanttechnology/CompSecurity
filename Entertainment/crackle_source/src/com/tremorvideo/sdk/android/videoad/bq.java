// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.location.LocationClient;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, bo

public class bq
    implements com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener
{

    Context a;
    private LocationClient b;

    public bq(Context context)
    {
        a = context;
        b = new LocationClient(a, this, this);
    }

    public void a()
    {
        b.connect();
    }

    public void onConnected(Bundle bundle)
    {
        bundle = b.getLastLocation();
        if (bundle != null)
        {
            ad.d((new StringBuilder()).append("Location from playservices : lat=").append(bundle.getLatitude()).append(" longi=").append(bundle.getLongitude()).toString());
        }
        bo.a(bundle);
        b.disconnect();
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        b.disconnect();
        bo.a(a, false);
    }

    public void onDisconnected()
    {
    }
}
