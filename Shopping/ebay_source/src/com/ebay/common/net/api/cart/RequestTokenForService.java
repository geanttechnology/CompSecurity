// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import android.util.Log;
import android.util.Xml;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class RequestTokenForService
{
    public static final class RequestTokenForServiceRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private final URL url;
        private final String username;

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

        public RequestTokenForServiceResponse getResponse()
        {
            return new RequestTokenForServiceResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public RequestTokenForServiceRequest(EbayCartApi ebaycartapi, String s, String s1)
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

    public static final class RequestTokenForServiceResponse extends EbayResponse
    {

        private String token;

        public final String getToken()
        {
            return token;
        }

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            XmlPullParser xmlpullparser;
            int i;
            xmlpullparser = Xml.newPullParser();
            int j;
            try
            {
                xmlpullparser.setInput(new InputStreamReader(inputstream));
                i = xmlpullparser.getEventType();
                ackCode = 1;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                Log.e(getClass().getSimpleName(), "Error parsing XML", inputstream);
                addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    new EbayResponseError()
                });
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
            }
              goto _L1
_L2:
            j = xmlpullparser.next();
            i = j;
            if (j == 1)
            {
                return;
            }
              goto _L1
_L3:
            inputstream = xmlpullparser.getName();
            if (inputstream.equals("Ack"))
            {
                if (xmlpullparser.nextText().equalsIgnoreCase("success"))
                {
                    break; /* Loop/switch isn't completed */
                }
                ackCode = -1;
                setResultStatus(ResultStatus.create(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                    new EbayResponseError()
                }));
                break; /* Loop/switch isn't completed */
            }
            if (inputstream.equals("ShortMessage"))
            {
                ((EbayResponseError)getResultStatus().getFirstMessage()).shortMessage = xmlpullparser.nextText();
                break; /* Loop/switch isn't completed */
            }
            if (inputstream.equals("LongMessage"))
            {
                ((EbayResponseError)getResultStatus().getFirstMessage()).longMessage = xmlpullparser.nextText();
                break; /* Loop/switch isn't completed */
            }
            if (inputstream.equals("ErrorCode"))
            {
                ((EbayResponseError)getResultStatus().getFirstMessage()).code = xmlpullparser.nextText();
                break; /* Loop/switch isn't completed */
            }
            if (!inputstream.equals("token"))
            {
                break; /* Loop/switch isn't completed */
            }
            token = xmlpullparser.nextText();
            break; /* Loop/switch isn't completed */
_L1:
            if (i == 2) goto _L3; else goto _L2
        }

        public RequestTokenForServiceResponse()
        {
            token = null;
        }
    }


    private static final String serviceDomain = "http://www.ebay.com/marketplace/security/v1/services";

    public RequestTokenForService()
    {
    }
}
