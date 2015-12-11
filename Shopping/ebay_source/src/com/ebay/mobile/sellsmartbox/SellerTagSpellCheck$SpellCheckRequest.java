// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import android.net.Uri;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.mobile.sellsmartbox:
//            SellerTagSpellCheck

private static final class country extends Request
{

    private final EbayCountry country;
    private final String query;

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = new URL(Uri.parse((new StringBuilder("http://cgi5.")).append(country.getSiteDomain()).append("/").append("ws/eBayISAPI.dll?MfcISAPICommand=Syi3GetSellerTags").toString()).buildUpon().("siteId", (new StringBuilder()).append("").append(country.getSiteId()).toString()).country("catId", "0").country("actionId", "4").country("originalValue", query).query().toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            return null;
        }
        return url;
    }

    public  getResponse()
    {
        return new (null);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public String getUserAgent()
    {
        return EbayAppCredentials.get(getEbayContext()).userAgent;
    }

    public (EbayCountry ebaycountry, String s)
    {
        query = s;
        country = ebaycountry;
    }
}
