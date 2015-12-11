// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.unifiedstream;

import android.net.Uri;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.unifiedstream:
//            UssDealsHistogramResponse

public class UssDealsHistogramRequest extends EbayCosRequest
{

    public UssDealsHistogramRequest(EbayCountry ebaycountry)
    {
        super("unifiedstream", "deal", CosVersionType.V3);
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        territory = ebaycountry.getCountryCode();
        marketPlaceId = ebaycountry.getSiteGlobalId();
    }

    public String getHttpMethod()
    {
        return "GET";
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.getUrl(ApiSettings.ussDealsUrl).toString()).buildUpon().appendQueryParameter("limit", "1").appendQueryParameter("outputSelector", "HISTOGRAM");
        try
        {
            obj = new URL(((android.net.Uri.Builder) (obj)).build().toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new IllegalStateException("Error constructing USS Deals Histogram URL");
        }
        return ((URL) (obj));
    }

    public UssDealsHistogramResponse getResponse()
    {
        return new UssDealsHistogramResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected void initialize(ResultStatusOwner resultstatusowner)
        throws InterruptedException
    {
        super.initialize(resultstatusowner);
        endUserContext = buildEndUserContext(territory, null, null, null, true);
    }

    protected boolean isIdempotent()
    {
        return true;
    }
}
