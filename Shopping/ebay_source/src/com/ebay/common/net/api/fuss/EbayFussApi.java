// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.fuss;

import android.text.TextUtils;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.fuss:
//            RemoveFavoriteSearch, RetrieveFavoriteSearch, SaveFavoriteSearch

public final class EbayFussApi
{

    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/search/v1/services";
    public static final String SERVICE_NAME = "FindingUserSettingsService";
    public static final String SOAP_DOMAIN = "http://schemas.xmlsoap.org/soap/envelope/";
    private final EbayContext context;
    private final EbayCountry country;

    public EbayFussApi(EbayContext ebaycontext, EbayCountry ebaycountry)
    {
        context = ebaycontext;
        country = ebaycountry;
    }

    public boolean removeFavoriteSearch(String s, String s1, String s2)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        if (TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2))
        {
            throw new NullPointerException("null search ID and name, must fix");
        } else
        {
            return (new RemoveFavoriteSearch(country)).removeFavoriteSearch(context, s, s1, s2);
        }
    }

    public List retrieveFavoriteSearch(String s)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return (new RetrieveFavoriteSearch(country)).retrieveFavoriteSearch(context, s);
    }

    public String saveFavoriteSearch(String s, SearchParameters searchparameters, String s1)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return SaveFavoriteSearch.saveFavoriteSearch(context, s, searchparameters, s1);
    }
}
