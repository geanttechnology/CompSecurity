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
//            GetShipmentTrackingResponse

public class GetShipmentTrackingRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    static final String REQUEST_NAME = "shipmentTrackingRequest";
    long itemId;
    boolean realTime;
    long transactionId;
    boolean useEventTimeHack;

    public GetShipmentTrackingRequest(String s, EbaySite ebaysite, long l, long l1, boolean flag, 
            boolean flag1)
    {
        super("CoreShippingService", true, "getShipmentTracking");
        useEventTimeHack = false;
        super.iafToken = s;
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.soaMessageProtocol = "SOAP12";
        super.soaContentType = "text/xml; charset=UTF-8";
        super.soaGlobalId = ebaysite.idString;
        super.dataFormat = "XML";
        itemId = l;
        transactionId = l1;
        realTime = flag;
        useEventTimeHack = flag1;
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
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v1/services", "shipmentTrackingRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v1/services", "shipmentTrackingRequestInfo");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v1/services", "shipmentTrackingTransactionalInfo");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v1/services", "transactionInformation");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v1/services", "itemId", String.valueOf(itemId));
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v1/services", "transactionId", String.valueOf(transactionId));
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v1/services", "transactionInformation");
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v1/services", "shipmentTrackingTransactionalInfo");
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v1/services", "shipmentTrackingRequestInfo");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v1/services", "level", "1");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v1/services", "realTime", Boolean.toString(realTime));
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v1/services", "shipmentTrackingRequest");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.shippingApi);
    }

    public GetShipmentTrackingResponse getResponse()
    {
        return new GetShipmentTrackingResponse(useEventTimeHack);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
