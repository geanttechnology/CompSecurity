// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.catalogcontent;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.catalogcontent:
//            GetProductDetailsResponse

public class GetProductDetailsRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final String REQUEST_DOMAIN = "http://www.ebay.com/marketplace/marketplacecatalog/v1/services";
    private static final String REQUEST_NAME = "getProductDetails";
    private static final String SERVICE_NAME = "MarketplacecatalogCatalogContentServiceV1";
    private final String epid;

    public GetProductDetailsRequest(String s, EbaySite ebaysite, String s1)
    {
        super("MarketplacecatalogCatalogContentServiceV1", true, "getProductDetails");
        super.iafToken = s;
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.soaContentType = "text/xml; charset=UTF-8";
        super.soaGlobalId = ebaysite.idString;
        dataFormat = "XML";
        responseDataFormat = "XML";
        epid = s1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/marketplacecatalog/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "getProductDetailsRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "productDetailsRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "productIdentifier");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "ePID", epid);
        xmlserializer.endTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "productIdentifier");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "descriptionType", "SHORT");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "imageSize", "300x300");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "site", "EBAY_MAIN");
        xmlserializer.endTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "productDetailsRequest");
        xmlserializer.endTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "getProductDetailsRequest");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.catalogContentApi);
    }

    public GetProductDetailsResponse getResponse()
    {
        return new GetProductDetailsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
