// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.location;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.aqo;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.models.LetgoAddress;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.location:
//            c

public class b extends c
{

    final Geocoder a;
    final AddressMapper b;

    public b(Geocoder geocoder, AddressMapper addressmapper)
    {
        a = geocoder;
        b = addressmapper;
    }

    private LetgoAddress a(Location location, int i)
        throws IOException
    {
        Object obj = a(location.getLatitude(), location.getLongitude(), i);
        if (obj == null || ((List) (obj)).isEmpty())
        {
            return null;
        } else
        {
            obj = (Address)((List) (obj)).get(0);
            return b.fromAddress(((Address) (obj)), location);
        }
    }

    private List a(double d, double d1, int i)
        throws IOException
    {
        return a.getFromLocation(d, d1, i);
    }

    public LetgoAddress a(Location location)
    {
        if (location == null)
        {
            return null;
        }
        try
        {
            location = a(location, 2);
        }
        // Misplaced declaration of an exception variable
        catch (Location location)
        {
            aqo.a(location, "Built in Geocoder is not working", new Object[0]);
            return null;
        }
        return location;
    }
}
