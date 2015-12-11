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
//            AutoSuggestionSearch

private static final class setOperationName extends Request
{

    private final String query;
    private final int siteId;

    private static String cleanQuery(String s)
    {
        return s.replace("\"", "").replace("\\", "");
    }

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = new URL(EbaySettings.getAutoSuggestionQuery(siteId, query));
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
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
        query = cleanQuery(s);
        siteId = i;
        setServiceName("SearchAutoSuggestionService");
        setOperationName("autoSuggestion");
    }
}
