// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippingrecs;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingRecommendationResponse

public class GetShippingRecommendationRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final String REQUEST_NAME = "getShippingRecommendation";
    static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/shipping/v10/services";
    private static final String SERVICE_NAME = "ShippingRecommendationService";
    private final String categoryId;
    private final String country;
    private final String draftId;
    private final String postalCode;
    private final EbaySite site;
    private final String title;

    public GetShippingRecommendationRequest(String s, EbaySite ebaysite, String s1, String s2, String s3, String s4, String s5)
    {
        super("ShippingRecommendationService", true, "getShippingRecommendation");
        super.iafToken = s;
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.soaMessageProtocol = "SOAP11";
        super.soaContentType = "text/xml; charset=UTF-8";
        super.soaGlobalId = ebaysite.idString;
        super.dataFormat = "XML";
        categoryId = s2;
        postalCode = s4;
        site = ebaysite;
        title = s1;
        country = s3;
        draftId = s5;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        xmlserializer.setPrefix("ser", "http://www.ebay.com/marketplace/shipping/v10/services");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v10/services", "getShippingRecommendationRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v10/services", "shippingRecommendationRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v10/services", "categoryIdentifier");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "id", categoryId);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "categoryType", "PRIMARY");
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v10/services", "categoryIdentifier");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v10/services", "sourceAddress");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "country", country);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "postalCode", postalCode);
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v10/services", "sourceAddress");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "title", title);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "siteID", site.id);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "correlationID", "0");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "draftID", draftId);
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v10/services", "shippingRecommendationRequest");
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v10/services", "getShippingRecommendationRequest");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.shippingRecsApi);
    }

    public GetShippingRecommendationResponse getResponse()
    {
        return new GetShippingRecommendationResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
