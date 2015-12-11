// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.events;

import android.net.Uri;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.events:
//            EventDetailsResponse

public class EventDetailsRequest extends EbayCosRequest
{

    public static final String ENDS_AFTER = "endsAfter";
    public static final String OPERATION_NAME = "event";
    public static final String SEO_NAME = "seoName";
    public static final String SERVICE_NAME = "deals_and_events";
    public static final String STARTS_BEFORE = "startsBefore";
    private String eventName;

    public EventDetailsRequest(String s, EbayCountry ebaycountry, String s1)
    {
        super("deals_and_events", "event", CosVersionType.V2);
        if (ebaycountry == null || TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("Country or event name is NULL");
        }
        iafToken = s;
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        if (ebaycountry != null)
        {
            territory = ebaycountry.getCountryCode();
            marketPlaceId = ebaycountry.getSiteGlobalId();
        }
        eventName = s1;
    }

    public String getHttpMethod()
    {
        return "GET";
    }

    public URL getRequestUrl()
    {
        if (TextUtils.isEmpty(eventName))
        {
            throw new IllegalArgumentException("Event request is null or event name is null");
        }
        Object obj = ApiSettings.getUrl(ApiSettings.eventDetailsService);
        String s = (new StringBuilder()).append(System.currentTimeMillis()).append("").toString();
        obj = Uri.parse(((URL) (obj)).toString()).buildUpon().appendQueryParameter("seoName", eventName).appendQueryParameter("startsBefore", s).appendQueryParameter("endsAfter", s).build();
        try
        {
            obj = new URL(((Uri) (obj)).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException(malformedurlexception);
        }
        return ((URL) (obj));
    }

    public EventDetailsResponse getResponse()
    {
        return new EventDetailsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected boolean isIdempotent()
    {
        return true;
    }
}
