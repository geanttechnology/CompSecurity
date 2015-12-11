// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.location.Location;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.DealsResponse;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DivisionUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            DealIntentService, LocationService

private class d extends SyncHttp
{

    final DealIntentService this$0;

    public DealsResponse call()
        throws Exception
    {
        ArrayList arraylist = divisionUtil.getDivisionNameValuePairs(knownLocation);
        Location location = locationService.getLocation();
        arraylist.addAll(Arrays.asList(new String[] {
            "source", "widget"
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "lang", ((DeviceInfoUtil)deviceInfoUtil.get()).getLanguageFromLocale()
        }));
        if (location != null)
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "lat", Double.valueOf(location.getLatitude()), "lng", Double.valueOf(location.getLongitude())
            }));
        }
        if (Strings.notEmpty(referrer))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referrer", referrer
            }));
        }
        nvps(arraylist.toArray());
        Ln.i("Loading deal for uri %s", new Object[] {
            getFullURI()
        });
        return (DealsResponse)super.call();
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public ()
    {
        this$0 = DealIntentService.this;
        String s;
        if (isRtrOnFeaturedEnabled)
        {
            s = "https:/deals/search";
        } else
        {
            s = "https:/deals";
        }
        super(DealIntentService.this, com/groupon/models/DealsResponse, s);
    }
}
