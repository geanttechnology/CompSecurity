// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experience.checkout;

import android.net.Uri;
import android.util.Log;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayCosExpRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experience.checkout:
//            CheckoutApiResponse

public class CheckoutApiRequest extends EbayCosExpRequest
{

    CheckoutApiRequest(EbaySite ebaysite, Authentication authentication, String s)
    {
        super("xoExperienceService", s, authentication);
        marketPlaceId = ebaysite.idString;
    }

    public URL getRequestUrl()
    {
        String s = Uri.parse(ApiSettings.get(ApiSettings.xoExperienceService)).buildUpon().build().toString();
        URL url;
        try
        {
            url = new URL(s);
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e(getClass().getSimpleName(), (new StringBuilder()).append("failed encoding URL ").append(s).toString());
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public CheckoutApiResponse getResponse()
    {
        return new CheckoutApiResponse();
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
