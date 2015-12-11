// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mftd;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.mftd:
//            GetMFTD

private static class HeaderName extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.lRequestBuilder
{

    private static final String CID_TAG = "clientId";
    private static final String CLIENT_ID = "AEAPP";
    private static final String CLIENT_VERSION_TAG = "clientVersion";
    private static final String LANGUAGE_TAG = "language";
    private static final String operationName = "getMessagesForTheDay";

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.ataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soap", "http://schemas.xmlsoap.org/soap/envelope/");
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/mobile/v1/services");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "getMessagesForTheDayRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "clientId", "AEAPP");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "clientVersion", GetMFTD.access$400());
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "language", Locale.getDefault().getLanguage());
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "getMessagesForTheDayRequest");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
        xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.appListApi);
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (String s, EbaySite ebaysite)
    {
        super("MessagesForTheDayService", true, "getMessagesForTheDay");
        super.iafToken = null;
        super.soaGlobalId = ebaysite.idString;
        super.soaMessageProtocol = "SOAP12";
        super.dataFormat = "XML";
        super.soaContentType = "text/xml";
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
    }
}
