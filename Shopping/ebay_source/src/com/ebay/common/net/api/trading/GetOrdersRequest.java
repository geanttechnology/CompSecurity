// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

public class GetOrdersRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    static final String REQUEST_NAME = "GetOrdersRequest";
    private final Locale locale;
    private final String orderId;

    public GetOrdersRequest(EbayTradingApi ebaytradingapi, String s, Locale locale1, String s1)
    {
        super(ebaytradingapi, "GetOrders");
        orderId = s1;
        locale = locale1;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetOrdersRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ErrorLanguage", locale.toString());
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "OrderIDArray");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OrderID", orderId);
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "OrderIDArray");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnAll");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetOrdersRequest");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.tradingApiUrl);
    }

    public GetOrdersResponse getResponse()
    {
        return new GetOrdersResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
