// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetOrderShippingInfoResponse

public class GetOrderShippingInfoRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    static final String REQUEST_NAME = "getOrderShippingInfoRequest";
    String itemId;
    String transactionId;

    public GetOrderShippingInfoRequest(String s, EbaySite ebaysite, String s1, String s2)
    {
        super("CoreShippingService", true, "getOrderShippingInfo");
        super.iafToken = s;
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.soaMessageProtocol = "SOAP12";
        super.soaContentType = "text/xml; charset=UTF-8";
        super.soaGlobalId = ebaysite.idString;
        super.dataFormat = "XML";
        itemId = s1;
        transactionId = s2;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/shipping/v1/services");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v1/services", "getOrderShippingInfoRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v1/services", "orderShippingInfo");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v1/services", "transactionIdentity");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v1/services", "itemId", itemId);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v1/services", "transactionId", transactionId);
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v1/services", "transactionIdentity");
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v1/services", "orderShippingInfo");
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v1/services", "getOrderShippingInfoRequest");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.shippingApi);
    }

    public GetOrderShippingInfoResponse getResponse()
    {
        return new GetOrderShippingInfoResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
