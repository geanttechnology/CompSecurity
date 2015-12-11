// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.favseller:
//            GetFavoriteSellers

public static class isConvertedToAlternateHttpFaultStatus extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.tBuilder
{

    private static final String MAX_ALLOWED_SAVED_SELLERS = "200";
    private static final String operationName = "getFavoriteSellers";

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.ption
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        xmlserializer.setPrefix("ser", "http://www.ebay.com/marketplace/mobile/v1/services");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "getFavoriteSellersRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "pagination");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "entriesPerPage", "200");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "pageNumber", "1");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "pagination");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "sortOrder", "Ascending");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "getFavoriteSellersRequest");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.myEbaySvcApi);
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (String s, EbaySite ebaysite, String s1)
    {
        super("MyEbayApplicationService", true, "getFavoriteSellers");
        super.iafToken = s;
        super.soaGlobalId = ebaysite.idString;
        super.soaMessageProtocol = "SOAP12";
        super.dataFormat = "XML";
        super.soaContentType = "text/xml";
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.bUseSoaServiceVersion = false;
        isConvertedToAlternateHttpFaultStatus = true;
    }
}
