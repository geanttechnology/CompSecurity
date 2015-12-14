// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StreamUtils;
import com.amazon.identity.kcpsdk.auth.register.PandaTokenExchangeResponse;
import com.amazon.identity.kcpsdk.common.FIRSError;
import com.amazon.identity.kcpsdk.common.FIRSErrorParser;
import com.amazon.identity.kcpsdk.common.FIRSErrorType;
import com.amazon.identity.kcpsdk.common.KindleWebserviceError;
import com.amazon.identity.kcpsdk.common.KindleWebserviceErrorParser;
import com.amazon.identity.kcpsdk.common.KindleWebserviceErrorType;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.WebResponseHeaders;
import com.amazon.identity.kcpsdk.common.WebResponseParser;
import com.amazon.identity.kcpsdk.common.XMLElement;
import com.amazon.identity.kcpsdk.common.XMLParser;
import com.amazon.identity.kcpsdk.common.XMLParserHelpers;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            AmazonWebserviceCallResponseParser, CookieParser, ParseErrorException, RegisterDeviceResponse, 
//            BatchCredentialsParser, RegisterDeviceErrorType, RegisterDeviceError

public class RegisterDeviceResponseParser extends WebResponseParser
    implements AmazonWebserviceCallResponseParser
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser.getName();
    private final CookieParser mCookieParser = new CookieParser();
    private final XMLParser mParser = new XMLParser();
    private RegisterDeviceResponse mResponse;

    public RegisterDeviceResponseParser()
    {
        super(com/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser.getName());
        mResponse = null;
    }

    private void logAndThrowParseError(ParseError parseerror)
        throws ParseErrorException
    {
        MAPLog.formattedError(TAG, "Seeing parse error  %s:%s!", new Object[] {
            getParserName(), parseerror.name()
        });
        throw new ParseErrorException(parseerror);
    }

    private RegisterDeviceResponse walk(Document document)
    {
        Object obj3 = document.getDocumentElement();
        if (obj3 != null && ((Element) (obj3)).getTagName().equals("response")) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L8:
        RegisterDeviceResponse registerdeviceresponse = ((RegisterDeviceResponse) (obj));
        if (obj == null)
        {
            registerdeviceresponse = parseErrorResponse(document);
        }
        return registerdeviceresponse;
_L2:
        obj = XMLParserHelpers.getTextContent(XMLParserHelpers.getNextChildElementWithTag(((Element) (obj3)), "serverTime"));
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = new RegisterDeviceResponse(((String) (obj)));
          goto _L5
_L4:
        Object obj1;
        Element element;
        Element element1;
        Object obj2;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        obj8 = XMLParserHelpers.getNextChildElementWithTag(((Element) (obj3)), "adp_token");
        obj10 = XMLParserHelpers.getNextChildElementWithTag(((Element) (obj3)), "device_private_key");
        obj12 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "name");
        obj13 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "user_device_name");
        obj14 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "alias");
        obj1 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "kindle_email_address");
        element = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "cookies");
        element1 = XMLParserHelpers.getNextChildElementWithTag(((Element) (obj3)), "store_authentication_cookie");
        obj11 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "user_directed_id");
        obj9 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "account_pool");
        obj7 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "home_region");
        obj6 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "country_of_residence");
        obj5 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj6)), "source_of_cor");
        obj4 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "preferred_marketplace");
        obj2 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "identityTokenResponse");
        obj15 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "device_info");
        if (obj15 != null) goto _L7; else goto _L6
_L6:
        obj = null;
_L9:
        obj8 = XMLParserHelpers.getTextContent(((Element) (obj8)));
        obj10 = XMLParserHelpers.getTextContent(((Element) (obj10)));
        obj12 = XMLParserHelpers.getTextContent(((Element) (obj12)));
        obj13 = XMLParserHelpers.getTextContent(((Element) (obj13)));
        obj14 = XMLParserHelpers.getTextContent(((Element) (obj14)));
        obj1 = XMLParserHelpers.getTextContent(((Element) (obj1)));
        obj11 = XMLParserHelpers.getTextContent(((Element) (obj11)));
        obj9 = XMLParserHelpers.getTextContent(((Element) (obj9)));
        obj7 = XMLParserHelpers.getTextContent(((Element) (obj7)));
        obj6 = XMLParserHelpers.getFirstTextElementValue(((Element) (obj6)));
        obj5 = XMLParserHelpers.getTextContent(((Element) (obj5)));
        obj4 = XMLParserHelpers.getTextContent(((Element) (obj4)));
        Element element2;
        int i;
        if (obj1 == null || ((String) (obj1)).equals(""))
        {
            if (obj14 != null && !((String) (obj14)).equals(""))
            {
                obj1 = (new StringBuilder()).append(((String) (obj14))).append("@kindle.com").toString();
            } else
            {
                obj1 = null;
            }
        }
        if (obj10 == null && obj12 == null && obj13 == null && obj8 == null)
        {
            obj = null;
        } else
        {
            obj3 = BatchCredentialsParser.parseBatchCredentialsResponse(XMLParserHelpers.getFirstElementWithTag(((Element) (obj3)), "deviceCredentials"));
            obj1 = new RegisterDeviceResponse(((String) (obj8)), ((String) (obj13)), ((String) (obj10)), ((String) (obj12)), ((String) (obj1)), null);
            obj2 = XMLParserHelpers.getTextContent(((Element) (obj2)));
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                String s = TAG;
                (new StringBuilder("Received embedded Panda response: ")).append(((String) (obj2))).toString();
                obj2 = PandaTokenExchangeResponse.parse(((String) (obj2)));
                if (obj2 != null)
                {
                    ((RegisterDeviceResponse) (obj1)).setAccessTokenExpiresIn(((PandaTokenExchangeResponse) (obj2)).getExpirySeconds());
                    ((RegisterDeviceResponse) (obj1)).setAccessToken(((PandaTokenExchangeResponse) (obj2)).getAccessToken());
                    ((RegisterDeviceResponse) (obj1)).setRefreshToken(((PandaTokenExchangeResponse) (obj2)).getRefreshToken());
                    ((RegisterDeviceResponse) (obj1)).setPandaCookies(((PandaTokenExchangeResponse) (obj2)).getCookies());
                }
            }
            ((RegisterDeviceResponse) (obj1)).setStoreAuthenticationCookie(XMLParserHelpers.getTextContent(element1));
            ((RegisterDeviceResponse) (obj1)).setDirectedId(((String) (obj11)));
            ((RegisterDeviceResponse) (obj1)).setAccountPool(((String) (obj9)));
            ((RegisterDeviceResponse) (obj1)).setCustomerRegion(((String) (obj7)));
            ((RegisterDeviceResponse) (obj1)).setCor(((String) (obj6)));
            ((RegisterDeviceResponse) (obj1)).setSourceOfCor(((String) (obj5)));
            ((RegisterDeviceResponse) (obj1)).setPfm(((String) (obj4)));
            ((RegisterDeviceResponse) (obj1)).setDeviceInfo(((Map) (obj)));
            ((RegisterDeviceResponse) (obj1)).addAllFIRSCookies(mCookieParser.parseStandardKindleCookieResponse(element));
            ((RegisterDeviceResponse) (obj1)).setCredentialsReceived(((Map) (obj3)));
            obj = obj1;
        }
_L5:
        if (true) goto _L8; else goto _L7
_L7:
        obj = new HashMap();
        obj15 = ((Element) (obj15)).getChildNodes();
        for (i = 0; i < ((NodeList) (obj15)).getLength(); i++)
        {
            element2 = (Element)((NodeList) (obj15)).item(i);
            if (element2 != null)
            {
                ((Map) (obj)).put(element2.getTagName(), XMLParserHelpers.getTextContent(element2));
            }
        }

        if (((Map) (obj)).isEmpty())
        {
            obj = null;
        }
          goto _L9
    }

    public String getErrorCode(HttpURLConnection httpurlconnection)
    {
        Object obj = httpurlconnection.getInputStream();
        httpurlconnection = ((HttpURLConnection) (obj));
_L1:
        obj = null;
        if (httpurlconnection != null)
        {
            try
            {
                obj = StreamUtils.readInputStream(httpurlconnection);
            }
            // Misplaced declaration of an exception variable
            catch (HttpURLConnection httpurlconnection)
            {
                return "CannotGetError";
            }
        }
        if (obj == null)
        {
            return "CannotGetError";
        }
        break MISSING_BLOCK_LABEL_40;
        obj;
        httpurlconnection = httpurlconnection.getErrorStream();
          goto _L1
        httpurlconnection = new XMLParser();
        httpurlconnection.parseChunk(((byte []) (obj)), obj.length);
        httpurlconnection = httpurlconnection.parseEndOfDocument();
        if (httpurlconnection == null)
        {
            return "CannotGetError";
        }
        httpurlconnection = FIRSErrorParser.parseError(httpurlconnection);
        if (httpurlconnection == null)
        {
            return null;
        } else
        {
            return httpurlconnection.getErrorType().getErrorCode();
        }
    }

    public RegisterDeviceResponse getParsedResponse()
    {
        return mResponse;
    }

    public volatile Object getParsedResponse()
    {
        return getParsedResponse();
    }

    protected void internalEndParse()
    {
        Document document = mParser.parseEndOfDocument();
        if (document == null)
        {
            setParseError(ParseError.ParseErrorMalformedBody);
            return;
        } else
        {
            mResponse = walk(document);
            return;
        }
    }

    protected void internalParseBodyChunk(byte abyte0[], long l)
    {
        mParser.parseChunk(abyte0, l);
    }

    public Object parse(WebResponseHeaders webresponseheaders, byte abyte0[])
        throws ParseErrorException, IOException
    {
        long l = webresponseheaders.getStatusCode();
        if (l == 412L || l >= 200L && l < 300L)
        {
            if (abyte0 != null)
            {
                mParser.parseChunk(abyte0, abyte0.length);
            }
            MAPLog.i(TAG, "Request complete");
            webresponseheaders = mParser.parseEndOfDocument();
            if (webresponseheaders == null)
            {
                logAndThrowParseError(ParseError.ParseErrorMalformedBody);
            } else
            {
                mResponse = walk(webresponseheaders);
            }
        } else
        {
            webresponseheaders = com/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser.getName();
            MAPLog.formattedError(TAG, "%s: HTTP Error: %d", new Object[] {
                webresponseheaders, Long.valueOf(l)
            });
            logAndThrowParseError(ParseError.ParseErrorHttpError);
        }
        return mResponse;
    }

    RegisterDeviceResponse parseErrorResponse(Document document)
    {
        RegisterDeviceErrorType registerdeviceerrortype;
        Object obj;
        FIRSError firserror;
        registerdeviceerrortype = RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognized;
        firserror = FIRSErrorParser.parseError(document);
        obj = KindleWebserviceErrorParser.parseError(document);
        if (firserror == null) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[];
            static final int $SwitchMap$com$amazon$identity$kcpsdk$common$KindleWebserviceErrorType[];

            static 
            {
                $SwitchMap$com$amazon$identity$kcpsdk$common$KindleWebserviceErrorType = new int[KindleWebserviceErrorType.values().length];
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$common$KindleWebserviceErrorType[KindleWebserviceErrorType.KindleWebserviceErrorTypeDeviceAlreadyRegistered.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$common$KindleWebserviceErrorType[KindleWebserviceErrorType.KindleWebserviceErrorTypeDuplicateDeviceName.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$common$KindleWebserviceErrorType[KindleWebserviceErrorType.KindleWebserviceErrorTypeInternalError.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType = new int[FIRSErrorType.values().length];
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[FIRSErrorType.FIRSErrorTypeCustomerNotFound.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[FIRSErrorType.FIRSErrorTypeDeviceAlreadyRegistered.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[FIRSErrorType.FIRSErrorTypeDuplicateAccountName.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[FIRSErrorType.FIRSErrorTypeInternalError.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType[FIRSErrorType.FIRSErrorTypeInvalidAccountFound.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.identity.kcpsdk.common.FIRSErrorType[firserror.getErrorType().ordinal()];
        JVM INSTR tableswitch 1 5: default 68
    //                   1 138
    //                   2 145
    //                   3 152
    //                   4 159
    //                   5 166;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        registerdeviceerrortype = RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognizedFirs;
_L9:
        MAPLog.formattedInfo(TAG, "RegisterDeviceResponseParser: response received a %s error.", new Object[] {
            registerdeviceerrortype.getErrorString()
        });
        obj = TAG;
        (new StringBuilder("FIRS returned error: ")).append(XMLElement.convertElementToString(document)).toString();
        return new RegisterDeviceResponse(null, null, null, null, null, new RegisterDeviceError(registerdeviceerrortype));
_L4:
        registerdeviceerrortype = RegisterDeviceErrorType.RegisterDeviceErrorTypeCustomerNotFound;
        continue; /* Loop/switch isn't completed */
_L5:
        registerdeviceerrortype = RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceAlreadyRegistered;
        continue; /* Loop/switch isn't completed */
_L6:
        registerdeviceerrortype = RegisterDeviceErrorType.RegisterDeviceErrorTypeDuplicateDeviceName;
        continue; /* Loop/switch isn't completed */
_L7:
        registerdeviceerrortype = RegisterDeviceErrorType.RegisterDeviceErrorTypeInternal;
        continue; /* Loop/switch isn't completed */
_L8:
        MetricsHelper.incrementCounter("PrimaryAccountDeregisteredWhenRegisterSecondary", new String[0]);
        registerdeviceerrortype = RegisterDeviceErrorType.RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary;
        if (true) goto _L9; else goto _L2
_L2:
        if (obj == null) goto _L9; else goto _L10
_L10:
        switch (_cls1..SwitchMap.com.amazon.identity.kcpsdk.common.KindleWebserviceErrorType[((KindleWebserviceError) (obj)).getErrorType().ordinal()])
        {
        default:
            registerdeviceerrortype = RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognizedKindle;
            break;

        case 1: // '\001'
            registerdeviceerrortype = RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceAlreadyRegistered;
            break;

        case 2: // '\002'
            registerdeviceerrortype = RegisterDeviceErrorType.RegisterDeviceErrorTypeDuplicateDeviceName;
            break;

        case 3: // '\003'
            registerdeviceerrortype = RegisterDeviceErrorType.RegisterDeviceErrorTypeInternal;
            break;
        }
        if (true) goto _L9; else goto _L11
_L11:
    }

}
