// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.attribute;

import android.net.Uri;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.attribute:
//            ForeignLanguageStemming, GetAttributesResponse

public final class GetAttributesRequest extends EbayRequest
{

    private final String categoryId;
    private final int siteId;
    private final String title;

    public GetAttributesRequest(int i, String s, String s1)
    {
        super("attributes", "getAttributes");
        siteId = i;
        categoryId = s;
        title = s1;
    }

    private static String cleanTitle(String s)
    {
        return ForeignLanguageStemming.replaceForeignLanguageStemming(s).replaceAll("[^\\w\\s\\&\\.\"\\,]", " ");
    }

    private static String createTitle(String s)
    {
        s = cleanTitle(s);
        try
        {
            s = (new URI(null, null, null, s, null)).getRawQuery();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = new URL(Uri.parse(ApiSettings.get(ApiSettings.attributeExtractionApi)).buildUpon().appendEncodedPath("v2/extract/bySiteCategoryAndTitle/json").appendEncodedPath(String.valueOf(siteId)).appendEncodedPath(categoryId).appendEncodedPath(createTitle(title)).build().toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            return null;
        }
        return url;
    }

    public GetAttributesResponse getResponse()
    {
        return new GetAttributesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
