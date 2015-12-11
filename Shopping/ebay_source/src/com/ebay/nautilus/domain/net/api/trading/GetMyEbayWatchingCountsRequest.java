// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            EbayTradingRequest, GetMyEbayWatchingCountsResponse, EbayTradingApi

public final class GetMyEbayWatchingCountsRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public GetMyEbayWatchingCountsRequest(EbayTradingApi ebaytradingapi)
    {
        super(ebaytradingapi, "GetMyeBayBuying");
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        String s = (new StringBuilder()).append(getOperationName()).append("Request").toString();
        xmlserializer.setPrefix("", "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", s);
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnSummary");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Version", apiVersion);
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "WatchList.PaginationResult");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "UserDefinedList");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "WatchList");
        XmlSerializerHelper.writePagination(xmlserializer, "urn:ebay:apis:eBLBaseComponents", 1, 1);
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "WatchList");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "UserDefinedLists");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeItemCount", "true");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "UserDefinedLists");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "HideVariations", "true");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", s);
    }

    public GetMyEbayWatchingCountsResponse getResponse()
    {
        return new GetMyEbayWatchingCountsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
