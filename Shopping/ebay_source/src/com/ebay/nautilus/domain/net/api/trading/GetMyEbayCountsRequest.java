// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            EbayTradingRequest, GetMyEbayCountsResponse, EbayTradingApi

public class GetMyEbayCountsRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    protected final HashSet lists = new HashSet();

    protected GetMyEbayCountsRequest(EbayTradingApi ebaytradingapi, String s)
    {
        super(ebaytradingapi, s);
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
        String s1;
        for (Iterator iterator = lists.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", (new StringBuilder()).append(s1).append(".PaginationResult").toString()))
        {
            s1 = (String)iterator.next();
        }

        for (Iterator iterator1 = lists.iterator(); iterator1.hasNext(); writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", (String)iterator1.next())) { }
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "HideVariations", "true");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", s);
    }

    public GetMyEbayCountsResponse getResponse()
    {
        return new GetMyEbayCountsResponse(lists);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected final void writeInclude(XmlSerializer xmlserializer, String s, String s1)
        throws IOException
    {
        xmlserializer.startTag(s, s1);
        if (s1.equals("UnsoldList") || s1.equals("SoldList") || s1.equals("WonList"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, s, "DurationInDays", "60");
        }
        XmlSerializerHelper.writePagination(xmlserializer, s, 1, 1);
        xmlserializer.endTag(s, s1);
    }
}
