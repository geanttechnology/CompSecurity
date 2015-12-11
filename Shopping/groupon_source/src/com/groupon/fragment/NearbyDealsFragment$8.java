// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import com.google.android.gms.maps.model.LatLng;
import com.groupon.models.Place;
import com.groupon.util.GetPlaceByCoordinates;
import java.util.Locale;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

class t> extends GetPlaceByCoordinates
{

    final NearbyDealsFragment this$0;
    final LatLng val$coordinates;
    final loadReason val$reason;

    protected void onException(Exception exception)
        throws RuntimeException
    {
        Ln.w(exception, (new StringBuilder()).append("Unable to get city for ").append(val$coordinates).toString(), new Object[0]);
        exception = new Place(MAP_LOCATION, MAP_LOCATION, val$coordinates.latitude, val$coordinates.longitude);
        setLocationAndReload(exception, val$reason);
    }

    protected void onSuccess(Place place)
        throws Exception
    {
        setLocationAndReload(place, val$reason);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((Place)obj);
    }

    loadReason(LatLng latlng, loadReason loadreason, LatLng latlng1)
    {
        this$0 = final_nearbydealsfragment;
        val$reason = loadreason;
        val$coordinates = latlng1;
        super(final_context, Locale.this, latlng);
    }
}
