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
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippingrecs:
//            GetShippingEstimatesResponse

public class GetShippingEstimatesRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final String REQUEST_NAME = "getShippingEstimates";
    static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/shipping/v10/services";
    private static final String SERVICE_NAME = "ShippingRecommendationService";
    private final double depth;
    private final String dimensionUnitType;
    private final double length;
    private final String packageType;
    private final String postalCode;
    private final List serviceCodes;
    private final EbaySite site;
    private final String unitType;
    private final double weight;
    private final double width;

    public GetShippingEstimatesRequest(String s, EbaySite ebaysite, List list, String s1, String s2, String s3, double d, String s4, double d1, double d2, double d3)
    {
        super("ShippingRecommendationService", true, "getShippingEstimates");
        super.iafToken = s;
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.soaMessageProtocol = "SOAP11";
        super.soaContentType = "text/xml; charset=UTF-8";
        super.soaGlobalId = ebaysite.idString;
        super.dataFormat = "XML";
        postalCode = s1;
        packageType = s2;
        serviceCodes = list;
        unitType = s3;
        weight = d;
        dimensionUnitType = s4;
        length = d1;
        width = d2;
        depth = d3;
        site = ebaysite;
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
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v10/services", "GetShippingEstimatesRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v10/services", "shippingEstimatesRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v10/services", "weight");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "weight", String.valueOf(weight));
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "unitType", unitType);
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v10/services", "weight");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v10/services", "dimension");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "width", String.valueOf(width));
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "length", String.valueOf(length));
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "height", String.valueOf(depth));
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "dimensionUnitType", dimensionUnitType);
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v10/services", "dimension");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "packageType", packageType);
        for (Iterator iterator = serviceCodes.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "serviceCode", (String)iterator.next())) { }
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "siteID", site.id);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "correlationID", "0");
        xmlserializer.startTag("http://www.ebay.com/marketplace/shipping/v10/services", "sourceAddress");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "country", site.localeCountry);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/shipping/v10/services", "postalCode", postalCode);
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v10/services", "sourceAddress");
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v10/services", "shippingEstimatesRequest");
        xmlserializer.endTag("http://www.ebay.com/marketplace/shipping/v10/services", "GetShippingEstimatesRequest");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.shippingRecsApi);
    }

    public GetShippingEstimatesResponse getResponse()
    {
        return new GetShippingEstimatesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
