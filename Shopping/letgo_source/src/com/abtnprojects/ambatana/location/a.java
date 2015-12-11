// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.location;

import android.location.Location;
import android.support.v7.aqo;
import com.abtnprojects.ambatana.datasource.api.GeoReverseService;
import com.abtnprojects.ambatana.datasource.api.b;
import com.abtnprojects.ambatana.datasource.entities.address.GoogleAddressResponse;
import com.abtnprojects.ambatana.datasource.entities.address.Result;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.models.LetgoAddress;
import java.util.List;
import retrofit.RetrofitError;

// Referenced classes of package com.abtnprojects.ambatana.location:
//            c

public class a extends c
{

    private GeoReverseService a;
    private AddressMapper b;

    public a(AddressMapper addressmapper)
    {
        a = com.abtnprojects.ambatana.datasource.api.b.a();
        b = addressmapper;
    }

    private LetgoAddress b(Location location)
    {
        Object obj = (new StringBuilder()).append(location.getLatitude()).append(",").append(location.getLongitude()).toString();
        List list;
        try
        {
            obj = a.fetch(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Location location)
        {
            aqo.b(location, "Error fetching data from google reverse geocoder", new Object[0]);
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        obj = ((GoogleAddressResponse) (obj)).getResults();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (((List) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_99;
        }
        obj = (Result)((List) (obj)).get(0);
        list = ((Result) (obj)).getAddressComponents();
        location = b.fromGoogleAddress(list, ((Result) (obj)).getGeometry(), location, ((Result) (obj)).getFormattedAddress());
        return location;
        return null;
        return null;
    }

    public LetgoAddress a(Location location)
    {
        if (location == null)
        {
            return null;
        } else
        {
            return b(location);
        }
    }
}
