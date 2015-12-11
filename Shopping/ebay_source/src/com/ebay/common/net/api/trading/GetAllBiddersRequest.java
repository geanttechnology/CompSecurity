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
//            GetAllBiddersResponse

public final class GetAllBiddersRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{
    public static final class RequestParams
    {

        public final long itemId;
        public final EbayTradingApi tradingApi;

        public String toString()
        {
            return (new StringBuilder()).append("ItemId: ").append(itemId).toString();
        }

        public RequestParams(long l, EbayTradingApi ebaytradingapi)
        {
            itemId = l;
            tradingApi = ebaytradingapi;
        }
    }


    public static final String OPERATION_NAME = "GetAllBidders";
    public final String callMode = "ViewAll";
    public final boolean includeBiddingSummary = true;
    public final long itemId;

    public GetAllBiddersRequest(RequestParams requestparams)
    {
        super(requestparams.tradingApi, "GetAllBidders");
        itemId = requestparams.itemId;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetAllBidders");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "CallMode", "ViewAll");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeBiddingSummary", Boolean.toString(true));
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", Long.toString(itemId));
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetAllBidders");
    }

    public GetAllBiddersResponse getResponse()
    {
        return new GetAllBiddersResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
