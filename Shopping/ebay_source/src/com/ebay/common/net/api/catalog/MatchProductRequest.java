// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.catalog;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.catalog:
//            CatalogMatchProductService, MatchProductResponse

public class MatchProductRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final String namespace = "http://www.ebay.com/marketplace/catalog/v1/services";
    private static final String soaOperationName = "getMatchProduct";
    private final String categoryId;
    private final String siteId;
    private final String title;

    public MatchProductRequest(CatalogMatchProductService catalogmatchproductservice, String s, String s1)
    {
        super("CatalogMatchProductService", true, "getMatchProduct");
        soaServiceVersion = "1.4.0";
        dataFormat = "XML";
        responseDataFormat = "XML";
        siteId = catalogmatchproductservice.site.id;
        categoryId = s;
        title = s1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/catalog/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/catalog/v1/services", "matchProductBatchRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/catalog/v1/services", "matchProductRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/catalog/v1/services", "invocationId", "AEAPP");
        xmlserializer.startTag("http://www.ebay.com/marketplace/catalog/v1/services", "requestMetadata");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/catalog/v1/services", "maxNumberOfProducts", "50");
        xmlserializer.endTag("http://www.ebay.com/marketplace/catalog/v1/services", "requestMetadata");
        xmlserializer.startTag("http://www.ebay.com/marketplace/catalog/v1/services", "catalogMetadata");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/catalog/v1/services", "site", siteId);
        xmlserializer.startTag("http://www.ebay.com/marketplace/catalog/v1/services", "category");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/catalog/v1/services", "id", categoryId);
        xmlserializer.endTag("http://www.ebay.com/marketplace/catalog/v1/services", "category");
        xmlserializer.endTag("http://www.ebay.com/marketplace/catalog/v1/services", "catalogMetadata");
        xmlserializer.startTag("http://www.ebay.com/marketplace/catalog/v1/services", "entityInfo");
        xmlserializer.startTag("http://www.ebay.com/marketplace/catalog/v1/services", "property");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/catalog/v1/services", "name", "title");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/catalog/v1/services", "value", title);
        xmlserializer.endTag("http://www.ebay.com/marketplace/catalog/v1/services", "property");
        xmlserializer.startTag("http://www.ebay.com/marketplace/catalog/v1/services", "property");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/catalog/v1/services", "name", "accumulate");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/catalog/v1/services", "value", "true");
        xmlserializer.endTag("http://www.ebay.com/marketplace/catalog/v1/services", "property");
        xmlserializer.startTag("http://www.ebay.com/marketplace/catalog/v1/services", "property");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/catalog/v1/services", "name", "excludeStealth");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/catalog/v1/services", "value", "true");
        xmlserializer.endTag("http://www.ebay.com/marketplace/catalog/v1/services", "property");
        xmlserializer.endTag("http://www.ebay.com/marketplace/catalog/v1/services", "entityInfo");
        xmlserializer.endTag("http://www.ebay.com/marketplace/catalog/v1/services", "matchProductRequest");
        xmlserializer.endTag("http://www.ebay.com/marketplace/catalog/v1/services", "matchProductBatchRequest");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.catalogMatchProductService);
    }

    public MatchProductResponse getResponse()
    {
        return new MatchProductResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
