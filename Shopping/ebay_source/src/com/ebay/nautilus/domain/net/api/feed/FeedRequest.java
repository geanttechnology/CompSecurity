// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.feed;

import android.net.Uri;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.feed:
//            FeedResponse

public class FeedRequest extends EbayCosRequest
{

    public static final String OPERATION_NAME = "following";
    public static final String SERVICE_NAME = "feed";

    public FeedRequest(String s, EbayCountry ebaycountry)
    {
        super("feed", "following", CosVersionType.V2);
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        territory = ebaycountry.getCountryCode();
        marketPlaceId = ebaycountry.getSiteGlobalId();
        iafToken = s;
    }

    public URL getRequestUrl()
    {
        URL url = ApiSettings.getUrl(ApiSettings.feedUrl);
        Object obj = Uri.parse(url.toString()).buildUpon().appendQueryParameter("maxEvents", "0").build();
        try
        {
            obj = new URL(((Uri) (obj)).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            return url;
        }
        return ((URL) (obj));
    }

    public FeedResponse getResponse()
    {
        return new FeedResponse();
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
