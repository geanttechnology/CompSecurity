// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.location;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
import android.location.Location;
import android.support.v7.ajx;
import android.support.v7.aqo;
import android.support.v7.at;
import android.support.v7.dy;
import android.support.v7.dz;
import android.support.v7.gh;
import android.support.v7.gi;
import android.support.v7.io;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.parse.ParseUser;
import java.util.Map;

// Referenced classes of package com.abtnprojects.ambatana.location:
//            d, c, b, a

public class GeocodeIntentService extends IntentService
{

    public GeocodeIntentService()
    {
        super("GeocodeIntentService");
    }

    private LetgoAddress a(Location location, AddressMapper addressmapper)
    {
        c c1 = d.a(this, addressmapper, Geocoder.isPresent());
        LetgoAddress letgoaddress1 = c1.a(location);
        gh gh1 = new gh();
        at at1 = new at(1);
        String s1 = "android-geocode";
        String s = s1;
        LetgoAddress letgoaddress = letgoaddress1;
        if (letgoaddress1 == null)
        {
            s = s1;
            letgoaddress = letgoaddress1;
            if (c1 instanceof b)
            {
                letgoaddress = (new a(addressmapper)).a(location);
                s = "google-maps-geocode";
            }
        }
        at1.put("system", s);
        gh1.a(this, "reverse_location", at1, ParseUser.getCurrentUser());
        return letgoaddress;
    }

    public static void a(Context context, Location location, boolean flag)
    {
        Intent intent = new Intent(context, com/abtnprojects/ambatana/location/GeocodeIntentService);
        intent.setAction("com.abtnprojects.ambatana.location.action.GEOCODE");
        intent.putExtra("com.abtnprojects.ambatana.location.extra.LOCATION", location);
        intent.putExtra("com.abtnprojects.ambatana.location.extra.LOCATION_MANUAL", flag);
        context.startService(intent);
    }

    protected void a(LetgoAddress letgoaddress)
    {
        dz.a().a(new dy(letgoaddress));
        aqo.a("Posting api address event", new Object[0]);
    }

    protected void a(LetgoAddress letgoaddress, boolean flag)
    {
        if (!flag && letgoaddress != null)
        {
            io.a(letgoaddress);
        }
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent != null && "com.abtnprojects.ambatana.location.action.GEOCODE".equals(intent.getAction()))
        {
            LetgoAddress letgoaddress = a((Location)intent.getParcelableExtra("com.abtnprojects.ambatana.location.extra.LOCATION"), new AddressMapper());
            a(letgoaddress, intent.getBooleanExtra("com.abtnprojects.ambatana.location.extra.LOCATION_MANUAL", false));
            a(letgoaddress);
        }
    }
}
