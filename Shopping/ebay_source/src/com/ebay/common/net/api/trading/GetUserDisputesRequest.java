// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserDisputesResponse

public final class GetUserDisputesRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final int pageNumber;

    public GetUserDisputesRequest(EbayTradingApi ebaytradingapi, int i)
    {
        super(ebaytradingapi, "GetUserDisputes");
        pageNumber = i;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetUserDisputes");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DisputeFilterType", "AllInvolvedDisputes");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "Pagination");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "PageNumber", (new StringBuilder()).append("").append(pageNumber).toString());
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "Pagination");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetUserDisputes");
    }

    public GetUserDisputesResponse getResponse()
    {
        return new GetUserDisputesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
