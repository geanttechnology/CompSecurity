// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.autocomplete;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.net.api.autocomplete:
//            AutoSuggestionSearch, AutoCompleteKeywordSearch

public final class AutoCompleteApi
{

    static final String SERVICE_NAME = "AutoCompleteQueryService";
    private final EbayContext context;
    private final EbayCountry country;

    public AutoCompleteApi(EbayContext ebaycontext, EbayCountry ebaycountry)
    {
        context = ebaycontext;
        country = ebaycountry;
    }

    protected static String getKeywordDictionaryForSiteId(int i)
    {
        switch (i)
        {
        default:
            return "USKeywords";

        case 3: // '\003'
            return "UKKeywords";

        case 16: // '\020'
        case 77: // 'M'
            return "DEKeywords";

        case 15: // '\017'
            return "AUKeywords";

        case 71: // 'G'
            return "FRKeywords";

        case 210: 
            return "CAFRKeywords";

        case 101: // 'e'
            return "ITKeywords";

        case 203: 
            return "INKeywords";

        case 100: // 'd'
            return "USPartsProductKeywords";

        case 186: 
            return "ESKeywords";
        }
    }

    protected static String getProductDictionaryForSiteId(int i)
    {
        switch (i)
        {
        default:
            return "USProducts";

        case 3: // '\003'
            return "UKProducts";

        case 16: // '\020'
        case 77: // 'M'
            return "DEProducts";

        case 15: // '\017'
            return "AUProducts";

        case 71: // 'G'
            return "FRProductCat";

        case 210: 
            return "CAFRProductCat";

        case 101: // 'e'
            return "ITProductCat";

        case 203: 
            return "INProductCat";

        case 100: // 'd'
            return "USPartsProductCat";

        case 186: 
            return "ESProductCat";
        }
    }

    protected static boolean useChildSiteForSiteId(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 2: // '\002'
        case 16: // '\020'
            return true;
        }
    }

    public final ArrayList autoFillSuggestions(String s)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return AutoSuggestionSearch.execute(context, country, s);
    }

    public final ArrayList keywordSearch(String s)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return AutoCompleteKeywordSearch.execute(context, country, s);
    }
}
