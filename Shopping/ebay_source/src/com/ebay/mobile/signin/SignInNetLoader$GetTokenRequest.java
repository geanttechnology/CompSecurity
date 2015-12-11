// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.signin;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.mobile.signin:
//            SignInNetLoader

private static final class dataFormat extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.uilder
{

    private final String password;
    private final boolean signInWithEmailOrUsername;
    private final URL url;
    private final String username;

    public void appendErrorData(LogTrackError logtrackerror,  , IOException ioexception)
    {
        super.appendErrorData(logtrackerror, , ioexception);
        logtrackerror = logtrackerror.getUserData();
        logtrackerror.put("requestBody", "*** HIDDEN ***");
        logtrackerror.put("responseBody", "*** HIDDEN ***");
    }

    public volatile void appendErrorData(LogTrackError logtrackerror, EbayResponse ebayresponse, IOException ioexception)
    {
        appendErrorData(logtrackerror, ()ebayresponse, ioexception);
    }

    public volatile void appendErrorData(LogTrackError logtrackerror, Response response, IOException ioexception)
    {
        appendErrorData(logtrackerror, ()response, ioexception);
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.ion
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
        xmlserializer.startTag("http://www.ebay.com/marketplace/security/v1/services", "authenticateRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/security/v1/services", "credentials");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/security/v1/services", "userId", username);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/security/v1/services", "password", password);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/security/v1/services", "type", "PASSWORD");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/security/v1/services", "domain", "EBAYUSER");
        if (signInWithEmailOrUsername)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/security/v1/services", "format", "USERNAME_OR_EMAIL");
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/security/v1/services", "credentials");
        xmlserializer.startTag("http://www.ebay.com/marketplace/security/v1/services", "options");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/security/v1/services", "tokenType", "SHORT");
        xmlserializer.startTag("http://www.ebay.com/marketplace/security/v1/services", "responseProperties");
        xmlserializer.startTag("http://www.ebay.com/marketplace/security/v1/services", "property");
        xmlserializer.attribute(null, "name", "actorId");
        xmlserializer.endTag("http://www.ebay.com/marketplace/security/v1/services", "property");
        xmlserializer.endTag("http://www.ebay.com/marketplace/security/v1/services", "responseProperties");
        xmlserializer.endTag("http://www.ebay.com/marketplace/security/v1/services", "options");
        xmlserializer.endTag("http://www.ebay.com/marketplace/security/v1/services", "authenticateRequest");
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

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("x-ebay3pp-device-id", EbayIdentity.get3ppFingerprint(getContext()));
    }

    public (String s, String s1, EbaySite ebaysite, boolean flag, String s2)
    {
        super("UserAuthenticationService", true, "authenticate");
        url = ApiSettings.getUrl(ApiSettings.userAuthenticationApi);
        username = s;
        password = s1;
        signInWithEmailOrUsername = flag;
        tmxSessionId = s2;
        isAuthenticateRequest = true;
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
        soaMessageProtocol = "SOAP12";
        soaGlobalId = ebaysite.idString;
        dataFormat = "XML";
    }
}
