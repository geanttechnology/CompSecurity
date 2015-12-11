// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experience.deals;

import android.net.Uri;
import android.util.Log;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayCosExpRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experience.deals:
//            DealsApiContext, DealsApiResponse

public abstract class DealsApiRequest extends EbayCosExpRequest
{

    private DealsApiContext dealsApiContext;

    DealsApiRequest(DealsApiContext dealsapicontext, String s)
    {
        super("dealsExperienceService", s, dealsapicontext.authentication);
        dealsApiContext = dealsapicontext;
        marketPlaceId = dealsapicontext.country.getSite().idString;
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.get(ApiSettings.dealsExperienceService)).buildUpon();
        if (dealsApiContext.useHub)
        {
            ((android.net.Uri.Builder) (obj)).appendPath("hub");
        }
        obj = ((android.net.Uri.Builder) (obj)).build().toString();
        URL url;
        try
        {
            url = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(getClass().getSimpleName(), (new StringBuilder()).append("failed encoding URL ").append(((String) (obj))).toString());
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public DealsApiResponse getResponse()
    {
        return new DealsApiResponse();
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
