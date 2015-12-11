// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            EbayTradingRequest, GetUserDefinedListsResponse, EbayTradingApi

public final class GetUserDefinedListsRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final boolean includeAll;
    private final String list;
    private final String outputSelector;

    public GetUserDefinedListsRequest(EbayTradingApi ebaytradingapi, String s, boolean flag)
    {
        this(ebaytradingapi, s, flag, null);
    }

    public GetUserDefinedListsRequest(EbayTradingApi ebaytradingapi, String s, boolean flag, String s1)
    {
        super(ebaytradingapi, "GetMyeBayBuying");
        list = s1;
        outputSelector = s;
        includeAll = flag;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("", "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetMyeBayBuyingRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnSummary");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "UserDefinedLists");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeItemCount", "true");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Include", "true");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "UserDefinedList");
        if (outputSelector != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", outputSelector);
        }
        if (includeAll)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeListContents", "true");
        }
        if (list != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "UserDefinedListName", list);
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "UserDefinedLists");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetMyeBayBuyingRequest");
    }

    public GetUserDefinedListsResponse getResponse()
    {
        return new GetUserDefinedListsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
