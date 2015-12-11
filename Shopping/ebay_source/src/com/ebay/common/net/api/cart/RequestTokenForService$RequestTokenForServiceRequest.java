// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.cart:
//            RequestTokenForService, EbayCartApi

public static final class dataFormat extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.dataFormat
{

    private final URL url;
    private final String username;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.dataFormat
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("soap", "http://www.w3.org/2003/05/soap-envelope");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
        xmlserializer.startTag("http://www.w3.org/2003/05/soap-envelope", "Body");
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/security/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/security/v1/services", "requestTokenForServiceProviderRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/security/v1/services", "userId", username);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/security/v1/services", "serviceProvider", "PAYPAL");
        xmlserializer.endTag("http://www.ebay.com/marketplace/security/v1/services", "requestTokenForServiceProviderRequest");
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Body");
        xmlserializer.endTag("http://www.w3.org/2003/05/soap-envelope", "Envelope");
    }

    public URL getRequestUrl()
    {
        return url;
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (EbayCartApi ebaycartapi, String s, String s1)
    {
        super("UserAuthenticationService", true, "requestTokenForServiceProvider");
        url = ApiSettings.getUrl(ApiSettings.userAuthenticationApi);
        username = s1;
        super.iafToken = ebaycartapi.iafToken;
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
        soaMessageProtocol = "SOAP12";
        soaGlobalId = s;
        dataFormat = "XML";
    }
}
