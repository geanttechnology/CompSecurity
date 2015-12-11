// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.product;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.product:
//            GetProductDetailsReponse

final class GetProductDetailsRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final String barcode;
    private final String barcodeType;

    public GetProductDetailsRequest(EbaySite ebaysite, String s, String s1)
    {
        super("ProductService", false, "getProductDetails");
        barcode = s;
        barcodeType = s1;
        soaGlobalId = ebaysite.idString;
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
        soaContentType = "application/soap+xml; charset=UTF-8";
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soap", "http://www.w3.org/2003/05/soap-envelope");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Body");
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/marketplacecatalog/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "getProductDetailsRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "productDetailsRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "productIdentifier");
        if (!barcodeType.equals("EAN")) goto _L2; else goto _L1
_L1:
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "EAN", barcode);
_L4:
        xmlserializer.endTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "productIdentifier");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "dataset", "DisplayableProductDetails");
        xmlserializer.endTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "productDetailsRequest");
        xmlserializer.endTag("http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "getProductDetailsRequest");
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Body");
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
        return;
_L2:
        if (barcodeType.equals("UPC"))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/marketplacecatalog/v1/services", "UPC", barcode);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.productApi);
    }

    public GetProductDetailsReponse getResponse()
    {
        return new GetProductDetailsReponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
