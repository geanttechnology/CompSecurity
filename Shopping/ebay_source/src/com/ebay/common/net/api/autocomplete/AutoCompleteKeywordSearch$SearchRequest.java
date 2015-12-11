// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.autocomplete;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.autocomplete:
//            AutoCompleteKeywordSearch, AutoCompleteApi

private static final class setOperationName extends Request
{

    private static final String FETCH_SIZE = "20";
    private final String dictionaryName;
    private final String query;
    private boolean useChildSite;

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = new URL(EbaySettings.getAutoCompleteQuery("20", dictionaryName, query, false, useChildSite));
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

    public (int i, String s)
    {
        useChildSite = false;
        query = s;
        dictionaryName = AutoCompleteApi.getKeywordDictionaryForSiteId(i);
        useChildSite = AutoCompleteApi.useChildSiteForSiteId(i);
        setServiceName("AutoCompleteQueryService");
        setOperationName("KeywordSearch");
    }
}
