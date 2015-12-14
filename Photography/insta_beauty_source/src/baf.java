// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.flurry.android.FlurryAgent;
import com.fotoable.geocoderlib.enums.GeocodingStatus;
import com.instamag.activity.compose.MagComposeFragement;

public class baf
    implements aor
{

    final MagComposeFragement a;

    public baf(MagComposeFragement magcomposefragement)
    {
        a = magcomposefragement;
        super();
    }

    public void a()
    {
        Log.v(MagComposeFragement.access$300(a), (new StringBuilder()).append(MagComposeFragement.access$300(a)).append(" onAddressZeroResult").toString());
    }

    public void a(aoq aoq)
    {
        Log.v(MagComposeFragement.access$300(a), (new StringBuilder()).append(MagComposeFragement.access$300(a)).append(" onAddressGotResult").toString());
        if (aoq != null)
        {
            MagComposeFragement.access$1102(a, aoq);
            a.updateDecorateLocation(aoq);
        }
    }

    public void a(GeocodingStatus geocodingstatus)
    {
        Log.v(MagComposeFragement.access$300(a), (new StringBuilder()).append(MagComposeFragement.access$300(a)).append(" onAddressGotStatus").toString());
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

    public void b()
    {
        Log.v(MagComposeFragement.access$300(a), (new StringBuilder()).append(MagComposeFragement.access$300(a)).append(" onConnectionFailed").toString());
    }
}
