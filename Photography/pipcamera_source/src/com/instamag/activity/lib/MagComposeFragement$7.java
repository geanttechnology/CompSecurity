// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.util.Log;
import com.flurry.android.FlurryAgent;
import com.fotoable.geocoderlib.enums.GeocodingStatus;
import jl;
import jm;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeFragement

class a
    implements jm
{

    final MagComposeFragement a;

    public void a()
    {
        Log.v(MagComposeFragement.e(a), (new StringBuilder()).append(MagComposeFragement.e(a)).append(" onAddressZeroResult").toString());
    }

    public void a(GeocodingStatus geocodingstatus)
    {
        Log.v(MagComposeFragement.e(a), (new StringBuilder()).append(MagComposeFragement.e(a)).append(" onAddressGotStatus").toString());
        if (geocodingstatus == GeocodingStatus.OVER_QUERY_LIMIT)
        {
            FlurryAgent.logEvent("requestLocationByGeometry_OVER_QUERY_LIMIT");
        }
        if (geocodingstatus == GeocodingStatus.INVALID_REQUEST)
        {
            FlurryAgent.logEvent("requestLocationByGeometry_INVALID_REQUEST");
        }
        if (geocodingstatus == GeocodingStatus.REQUEST_DENIED)
        {
            FlurryAgent.logEvent("requestLocationByGeometry_REQUEST_DENIED");
        }
    }

    public void a(String s)
    {
    }

    public void a(jl jl)
    {
        Log.v(MagComposeFragement.e(a), (new StringBuilder()).append(MagComposeFragement.e(a)).append(" onAddressGotResult").toString());
        if (jl != null)
        {
            MagComposeFragement.a(a, jl);
            MagComposeFragement.b(a, jl);
        }
    }

    public void b()
    {
        Log.v(MagComposeFragement.e(a), (new StringBuilder()).append(MagComposeFragement.e(a)).append(" onConnectionFailed").toString());
    }

    (MagComposeFragement magcomposefragement)
    {
        a = magcomposefragement;
        super();
    }
}
