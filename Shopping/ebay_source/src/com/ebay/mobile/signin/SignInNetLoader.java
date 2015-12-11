// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.signin;

import android.content.Context;
import android.text.TextUtils;
import com.ebay.common.model.UserDetail;
import com.ebay.common.net.api.coupon.IssueIncentiveRequest;
import com.ebay.common.net.api.coupon.IssueIncentiveResponse;
import com.ebay.common.net.api.trading.EbayTradingApiHelper;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.SaxHandler;
import com.ebay.nautilus.shell.content.FwNetLoader;
import com.ebay.server_requests.InstallTracking;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

public class SignInNetLoader extends FwNetLoader
{
    private static final class GetTokenRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private final String password;
        private final boolean signInWithEmailOrUsername;
        private final URL url;
        private final String username;

        public void appendErrorData(LogTrackError logtrackerror, GetTokenResponse gettokenresponse, IOException ioexception)
        {
            super.appendErrorData(logtrackerror, gettokenresponse, ioexception);
            logtrackerror = logtrackerror.getUserData();
            logtrackerror.put("requestBody", "*** HIDDEN ***");
            logtrackerror.put("responseBody", "*** HIDDEN ***");
        }

        public volatile void appendErrorData(LogTrackError logtrackerror, EbayResponse ebayresponse, IOException ioexception)
        {
            appendErrorData(logtrackerror, (GetTokenResponse)ebayresponse, ioexception);
        }

        public volatile void appendErrorData(LogTrackError logtrackerror, Response response1, IOException ioexception)
        {
            appendErrorData(logtrackerror, (GetTokenResponse)response1, ioexception);
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

        public GetTokenResponse getResponse()
        {
            return new GetTokenResponse();
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

        public GetTokenRequest(String s, String s1, EbaySite ebaysite, boolean flag, String s2)
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

    public static final class GetTokenResponse extends EbayResponse
    {

        public String actorId;
        public String email;
        public String machineGroupId;
        public String token;
        public String userId;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            GetTokenResponseParser gettokenresponseparser = new GetTokenResponseParser(this);
            SaxHandler.parseXml(inputstream, gettokenresponseparser);
            if (gettokenresponseparser.response.ackCode == 1 && TextUtils.isEmpty(token))
            {
                setAckCode(-1);
                inputstream = new EbayResponseError();
                inputstream.longMessage = "Missing IAF token";
                inputstream.category = 1;
                inputstream.severity = 1;
                inputstream.userDisplay = false;
                ArrayList arraylist = new ArrayList(1);
                arraylist.add(inputstream);
                setErrors(arraylist);
            }
        }

        public GetTokenResponse()
        {
        }
    }

    private static final class GetTokenResponseParser extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public final GetTokenResponse response;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.w3.org/2003/05/soap-envelope".equals(s) && "Body".equals(s1))
            {
                return new Body(response);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        protected GetTokenResponseParser(GetTokenResponse gettokenresponse)
        {
            response = gettokenresponse;
        }
    }

    static final class GetTokenResponseParser.AuthResponse extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        GetTokenResponse owner;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (s1.equals("token"))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetTokenResponseParser.AuthResponse this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        owner.token = s;
                    }

            
            {
                this$0 = GetTokenResponseParser.AuthResponse.this;
                super();
            }
                };
            }
            if (!s1.equals("properties")) goto _L2; else goto _L1
_L1:
            String s3;
            String s4;
            s3 = null;
            s4 = null;
            int j = attributes.getLength();
            int i = 0;
            while (i < j) 
            {
                String s6 = attributes.getLocalName(i);
                String s5;
                if (s6.equals("name"))
                {
                    s5 = attributes.getValue(i);
                } else
                {
                    s5 = s3;
                    if (s6.equals("value"))
                    {
                        s4 = attributes.getValue(i);
                        s5 = s3;
                    }
                }
                i++;
                s3 = s5;
            }
            if (!"email".equals(s3)) goto _L4; else goto _L3
_L3:
            owner.email = s4;
_L5:
            return super.get(s, s1, s2, attributes);
_L4:
            if ("username".equals(s3))
            {
                owner.userId = s4;
            } else
            if ("MgIdRef".equals(s3))
            {
                owner.machineGroupId = s4;
            } else
            if ("actorId".equals(s3))
            {
                owner.actorId = s4;
            }
            if (true) goto _L5; else goto _L2
_L2:
            if (s1.equals("ack"))
            {
                return new AckElement(owner);
            }
            if (s1.equals("timestamp"))
            {
                return new TimestampElement(owner);
            }
            if (s1.equals("errorMessage"))
            {
                return new ErrorMessageElement(owner, "http://www.ebay.com/marketplace/security/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        protected GetTokenResponseParser.AuthResponse(GetTokenResponse gettokenresponse)
        {
            owner = gettokenresponse;
        }
    }

    static final class GetTokenResponseParser.Body extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        GetTokenResponse owner;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (s1.equals("authenticateResponse"))
            {
                return new GetTokenResponseParser.AuthResponse(owner);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        protected GetTokenResponseParser.Body(GetTokenResponse gettokenresponse)
        {
            owner = gettokenresponse;
        }
    }


    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/security/v1/services";
    private volatile boolean addressUpdateSucceeded;
    private IssueIncentiveResponse incentive;
    private final String password;
    private GetTokenResponse response;
    private final boolean signInWithEmailOrUsername;
    private final EbaySite site;
    private final String tmxSessionId;
    private UserDetail userDetail;
    public final String username;

    public SignInNetLoader(EbayContext ebaycontext, EbaySite ebaysite, String s, String s1, boolean flag, String s2)
    {
        super(ebaycontext);
        addressUpdateSucceeded = false;
        response = null;
        userDetail = null;
        incentive = null;
        site = ebaysite;
        username = s;
        password = s1;
        signInWithEmailOrUsername = flag;
        tmxSessionId = s2;
        if (s == null)
        {
            throw new IllegalArgumentException("username");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("password");
        } else
        {
            return;
        }
    }

    public final boolean addressUpdateSucceeded()
    {
        return addressUpdateSucceeded;
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        response = (GetTokenResponse)sendRequest(new GetTokenRequest(username, password, site, signInWithEmailOrUsername, tmxSessionId));
        if (response != null)
        {
            setResultStatus(response.getResultStatus());
        }
        if (isError() || getCoreToken() == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        Object obj = new EbayTradingApi(site, getCoreToken());
        Object obj1;
        DeviceConfiguration deviceconfiguration;
        try
        {
            userDetail = EbayTradingApiHelper.getUser(getEbayContext(), ((EbayTradingApi) (obj)));
        }
        catch (Exception exception)
        {
            userDetail = null;
        }
        obj1 = getContext();
        obj = InstallTracking.getCoupon(((Context) (obj1)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        obj1 = android.provider.Settings.Secure.getString(((Context) (obj1)).getContentResolver(), "android_id");
        deviceconfiguration = DeviceConfiguration.getAsync();
        incentive = (IssueIncentiveResponse)sendRequest(new IssueIncentiveRequest(site, deviceconfiguration.get(DcsBoolean.IncentiveServiceV1), getCoreToken(), ((String) (obj1)), ((android.net.Uri) (obj))));
        return;
        Exception exception1;
        exception1;
    }

    public final String getActorId()
    {
        if (response != null && response.isSuccessful())
        {
            return response.actorId;
        } else
        {
            return null;
        }
    }

    public final String getCoreToken()
    {
        if (response != null && response.isSuccessful())
        {
            return response.token;
        } else
        {
            return null;
        }
    }

    public final IssueIncentiveResponse getIncentive()
    {
        return incentive;
    }

    public final String getMachineGroupId()
    {
        if (response != null && response.isSuccessful())
        {
            return response.machineGroupId;
        } else
        {
            return null;
        }
    }

    public final List getServiceErrorsAndWarnings()
    {
        ArrayList arraylist1 = null;
        ArrayList arraylist = null;
        List list = getResultStatus().getMessages();
        if (list != null)
        {
            Iterator iterator = list.iterator();
            do
            {
                arraylist1 = arraylist;
                if (!iterator.hasNext())
                {
                    break;
                }
                com.ebay.nautilus.kernel.content.ResultStatus.Message message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)iterator.next();
                if (message instanceof EbayResponseError)
                {
                    arraylist1 = arraylist;
                    if (arraylist == null)
                    {
                        arraylist1 = new ArrayList(list.size());
                    }
                    arraylist1.add((EbayResponseError)message);
                    arraylist = arraylist1;
                }
            } while (true);
        }
        return arraylist1;
    }

    public final UserDetail getUserDetail()
    {
        return userDetail;
    }

    public final String getUserId()
    {
label0:
        {
            Object obj = null;
            String s = obj;
            if (response != null)
            {
                s = obj;
                if (response.isSuccessful())
                {
                    if (response.userId != null)
                    {
                        break label0;
                    }
                    s = username;
                }
            }
            return s;
        }
        return response.userId;
    }

    public boolean isServiceError()
    {
        return response != null && !response.isSuccessful();
    }

    public final boolean isWarning()
    {
        return !isError() && response != null && response.ackCode == 2;
    }
}
