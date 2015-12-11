// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.google.android.gms.maps.model.LatLng;
import com.groupon.models.Place;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.groupon.util:
//            GrouponSafeAsyncTask

public abstract class GetPlaceByCoordinates extends GrouponSafeAsyncTask
{

    private Context context;
    private LatLng coordinates;
    private final Locale locale;

    public GetPlaceByCoordinates(Context context1, Locale locale1, LatLng latlng)
    {
        context = context1;
        coordinates = new LatLng(0.0D, 0.0D);
        locale = locale1;
        coordinates = latlng;
    }

    public Place call()
        throws Exception
    {
        Object obj = (new Geocoder(context, locale)).getFromLocation(coordinates.latitude, coordinates.longitude, 1);
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = (Address)((List) (obj)).get(0);
            if (((Address) (obj)).getLocality() != null)
            {
                obj = ((Address) (obj)).getLocality();
            } else
            {
                obj = ((Address) (obj)).getSubLocality();
            }
            if (obj != null)
            {
                return new Place(((String) (obj)), ((String) (obj)), coordinates.latitude, coordinates.longitude);
            }
        }
        throw new RuntimeException((new StringBuilder()).append("No city found for ").append(coordinates).toString());
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }
}
