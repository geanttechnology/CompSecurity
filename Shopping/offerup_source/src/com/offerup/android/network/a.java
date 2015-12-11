// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.b.a.a.g;
import com.offerup.android.dto.geocode.GoogleMapsGeocodeResponse;
import java.util.concurrent.Executors;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.network:
//            o, GoogleMapsService

public class a
{

    public a()
    {
    }

    public static GoogleMapsGeocodeResponse a(double d, double d1)
    {
        Object obj = o.n(o.b(Executors.newSingleThreadExecutor()));
        String s = (new StringBuilder()).append(d).append(",").append(d1).toString();
        try
        {
            obj = ((GoogleMapsService) (obj)).getReverseLookupLocation(s);
        }
        catch (RetrofitError retrofiterror)
        {
            if (retrofiterror.getResponse() != null && retrofiterror.getResponse().getStatus() != 0)
            {
                g.a(com/offerup/android/network/a, new Throwable((new StringBuilder("ErrorCodeException at userIdRequest() with code ")).append(retrofiterror.getResponse().getStatus()).append("  at url=").append(retrofiterror.getUrl()).toString()));
            } else
            {
                g.a(com/offerup/android/network/a, new Throwable((new StringBuilder("Exception thrown at url=")).append(retrofiterror.getUrl()).toString(), retrofiterror));
            }
            return null;
        }
        return ((GoogleMapsGeocodeResponse) (obj));
    }

    public static GoogleMapsGeocodeResponse a(String s)
    {
        GoogleMapsService googlemapsservice = o.n(o.b(Executors.newSingleThreadExecutor()));
        s = (new StringBuilder("postal_code:")).append(s).append("|country:US").toString();
        try
        {
            s = googlemapsservice.getGoogleMapsGeocodeFromZip(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (s.getResponse() != null && s.getResponse().getStatus() != 0)
            {
                g.a(com/offerup/android/network/a, new Throwable((new StringBuilder("ErrorCodeException at userIdRequest() with code ")).append(s.getResponse().getStatus()).append("  at url=").append(s.getUrl()).toString()));
            } else
            {
                g.a(com/offerup/android/network/a, new Throwable((new StringBuilder("Exception thrown at url=")).append(s.getUrl()).toString(), s));
            }
            return null;
        }
        return s;
    }
}
