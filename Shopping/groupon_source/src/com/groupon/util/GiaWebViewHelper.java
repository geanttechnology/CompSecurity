// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.groupon.util:
//            WebViewHelper, GeoPoint

public class GiaWebViewHelper extends WebViewHelper
{

    private static final String URL_FORMAT = "%s/live/checkout/booking/%s?lat=%f&lng=%f";
    private GeoPoint currentLocation;
    private String dealId;
    private String xCookie;

    public GiaWebViewHelper(Context context, String s, GeoPoint geopoint, String s1)
    {
        super(context);
        dealId = s;
        currentLocation = geopoint;
        xCookie = s1;
    }

    public Map createWebViewHeaders(String s, String s1)
    {
        s1 = super.createWebViewHeaders(s, s1);
        s1.put("x-cookies", xCookie);
        s1.put("x-auth-token", s);
        return s1;
    }

    public String getUrl()
    {
        String s;
        if (currentCountryManager.getCurrentCountry().url != null)
        {
            s = currentCountryManager.getCurrentCountry().url.replace("http", "https");
        } else
        {
            s = prefs.getString("web_base_url_gdt", "https://www.groupon.com");
        }
        return String.format(Locale.US, "%s/live/checkout/booking/%s?lat=%f&lng=%f", new Object[] {
            s, dealId, Float.valueOf(currentLocation.getLatitudeDegrees()), Float.valueOf(currentLocation.getLongitudeDegrees())
        });
    }

    public boolean isCheckoutComplete(String s)
    {
        return s.contains("live/receipt");
    }
}
