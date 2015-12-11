// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            FundRaisingRequest, FindNonProfitResponse

public final class FindNonProfitByIdRequest extends FundRaisingRequest
{
    private static final class PaginationInput
    {

        private final int pageNumber;
        private final int pageSize;



        public PaginationInput(int i, int j)
        {
            pageSize = i;
            pageNumber = j;
        }
    }

    private static final class SearchFilter
    {

        private final String nonProfitId;


        public SearchFilter(String s)
        {
            nonProfitId = s;
        }
    }


    public static final String OPERATION_NAME = "findNonprofit";
    private final transient String errorLanguage = null;
    private final List outputSelector = Arrays.asList(new String[] {
        "LargeLogoURL"
    });
    private final PaginationInput paginationInput = new PaginationInput(1, 1);
    private final SearchFilter searchFilter;

    public FindNonProfitByIdRequest(EbaySite ebaysite, String s)
    {
        super(ebaysite, false, "findNonprofit");
        searchFilter = new SearchFilter(s);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("", "http://www.ebay.com/marketplace/fundraising/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/fundraising/v1/services", "findNonprofit");
        if (searchFilter != null)
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/fundraising/v1/services", "searchFilter");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v1/services", "nonprofitId", searchFilter.nonProfitId);
            xmlserializer.endTag("http://www.ebay.com/marketplace/fundraising/v1/services", "searchFilter");
        }
        if (paginationInput != null)
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/fundraising/v1/services", "paginationInput");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v1/services", "pageNumber", Integer.toString(paginationInput.pageNumber));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v1/services", "pageSize", Integer.toString(paginationInput.pageSize));
            xmlserializer.endTag("http://www.ebay.com/marketplace/fundraising/v1/services", "paginationInput");
        }
        if (outputSelector != null)
        {
            for (Iterator iterator = outputSelector.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v1/services", "outputSelector", (String)iterator.next())) { }
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/fundraising/v1/services", "findNonprofit");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.fundRaisingFindingUrl);
    }

    public FindNonProfitResponse getResponse()
    {
        return new FindNonProfitResponse("http://www.ebay.com/marketplace/fundraising/v1/services");
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
