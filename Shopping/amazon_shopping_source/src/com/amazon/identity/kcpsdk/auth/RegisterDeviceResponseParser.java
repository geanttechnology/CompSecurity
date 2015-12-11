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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            AmazonWebserviceCallResponseParser, CookieParser, ParseErrorException, RegisterDeviceResponse, 
//            BatchCredentialsParser, RegisterDeviceErrorType, RegisterDeviceError

public class RegisterDeviceResponseParser extends WebResponseParser
    implements AmazonWebserviceCallResponseParser
{

    public static final String FIRS_KEY_ACCOUNT_POOL = "account_pool";
    public static final String FIRS_KEY_ADP_TOKEN = "adp_token";
    public static final String FIRS_KEY_ALIAS = "alias";
    public static final String FIRS_KEY_COOKIES = "cookies";
    public static final String FIRS_KEY_COR = "country_of_residence";
    public static final String FIRS_KEY_DEVICE_EMAIL = "kindle_email_address";
    public static final String FIRS_KEY_DEVICE_INFO = "device_info";
    public static final String FIRS_KEY_DEVICE_NAME = "user_device_name";
    public static final String FIRS_KEY_DIRECTEDID = "user_directed_id";
    public static final String FIRS_KEY_HOME_REGION = "home_region";
    public static final String FIRS_KEY_IDENTITY_TOKEN = "identityTokenResponse";
    public static final String FIRS_KEY_NAME = "name";
    public static final String FIRS_KEY_PFM = "preferred_marketplace";
    public static final String FIRS_KEY_PRIVATE_KEY = "device_private_key";
    public static final String FIRS_KEY_SOURCE_COR = "source_of_cor";
    public static final String FIRS_KEY_STORE_COOKIE = "store_authentication_cookie";
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
        MAPLog.e(TAG, "Seeing parse error  %s:%s!", new Object[] {
            getParserName(), parseerror.name()
        });
        throw new ParseErrorException(parseerror);
    }

    private RegisterDeviceResponse walk(Document document)
    {
        Object obj2 = document.getDocumentElement();
        Object obj;
        RegisterDeviceResponse registerdeviceresponse;
        if (obj2 == null || !((Element) (obj2)).getTagName().equals("response"))
        {
            obj = null;
        } else
        {
            obj = XMLParserHelpers.getTextContent(XMLParserHelpers.getNextChildElementWithTag(((Element) (obj2)), "serverTime"));
            if (obj != null)
            {
                obj = new RegisterDeviceResponse(((String) (obj)));
            } else
            {
                Object obj3 = XMLParserHelpers.getNextChildElementWithTag(((Element) (obj2)), "adp_token");
                Object obj4 = XMLParserHelpers.getNextChildElementWithTag(((Element) (obj2)), "device_private_key");
                Object obj5 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "name");
                Object obj7 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "user_device_name");
                Object obj13 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "alias");
                obj = XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "kindle_email_address");
                Element element = XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "cookies");
                Element element1 = XMLParserHelpers.getNextChildElementWithTag(((Element) (obj2)), "store_authentication_cookie");
                Object obj6 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "user_directed_id");
                Object obj8 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "account_pool");
                Object obj10 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "home_region");
                Object obj12 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "country_of_residence");
                Object obj11 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj12)), "source_of_cor");
                Object obj9 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "preferred_marketplace");
                Object obj1 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "identityTokenResponse");
                java.util.Map map = XMLParserHelpers.getMapOfChildElements(XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "device_info"));
                obj3 = XMLParserHelpers.getTextContent(((Element) (obj3)));
                obj4 = XMLParserHelpers.getTextContent(((Element) (obj4)));
                obj5 = XMLParserHelpers.getTextContent(((Element) (obj5)));
                obj7 = XMLParserHelpers.getTextContent(((Element) (obj7)));
                obj13 = XMLParserHelpers.getTextContent(((Element) (obj13)));
                obj = XMLParserHelpers.getTextContent(((Element) (obj)));
                obj6 = XMLParserHelpers.getTextContent(((Element) (obj6)));
                obj8 = XMLParserHelpers.getTextContent(((Element) (obj8)));
                obj10 = XMLParserHelpers.getTextContent(((Element) (obj10)));
                obj12 = XMLParserHelpers.getFirstTextElementValue(((Element) (obj12)));
                obj11 = XMLParserHelpers.getTextContent(((Element) (obj11)));
                obj9 = XMLParserHelpers.getTextContent(((Element) (obj9)));
                if (obj == null || ((String) (obj)).equals(""))
                {
                    if (obj13 != null && !((String) (obj13)).equals(""))
                    {
                        obj = (new StringBuilder()).append(((String) (obj13))).append("@kindle.com").toString();
                    } else
                    {
                        obj = null;
                    }
                }
                if (obj4 == null && obj5 == null && obj7 == null && obj3 == null)
                {
                    obj = null;
                } else
                {
                    obj2 = BatchCredentialsParser.parseBatchCredentialsResponse(XMLParserHelpers.getFirstElementWithTag(((Element) (obj2)), "deviceCredentials"));
                    obj = new RegisterDeviceResponse(((String) (obj3)), ((String) (obj7)), ((String) (obj4)), ((String) (obj5)), ((String) (obj)), null);
                    obj1 = XMLParserHelpers.getTextContent(((Element) (obj1)));
                    if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                    {
                        String s = TAG;
                        (new StringBuilder("Received embedded Panda response: ")).append(((String) (obj1))).toString();
                        obj1 = PandaTokenExchangeResponse.parse(((String) (obj1)));
                        if (obj1 != null)
                        {
                            ((RegisterDeviceResponse) (obj)).setAccessTokenExpiresIn(((PandaTokenExchangeResponse) (obj1)).getExpirySeconds());
                            ((RegisterDeviceResponse) (obj)).setAccessToken(((PandaTokenExchangeResponse) (obj1)).getAccessToken());
                            ((RegisterDeviceResponse) (obj)).setRefreshToken(((PandaTokenExchangeResponse) (obj1)).getRefreshToken());
                            ((RegisterDeviceResponse) (obj)).setPandaCookies(((PandaTokenExchangeResponse) (obj1)).getCookies());
                        }
                    }
                    ((RegisterDeviceResponse) (obj)).setStoreAuthenticationCookie(XMLParserHelpers.getTextContent(element1));
                    ((RegisterDeviceResponse) (obj)).setDirectedId(((String) (obj6)));
                    ((RegisterDeviceResponse) (obj)).setAccountPool(((String) (obj8)));
                    ((RegisterDeviceResponse) (obj)).setCustomerRegion(((String) (obj10)));
                    ((RegisterDeviceResponse) (obj)).setCor(((String) (obj12)));
                    ((RegisterDeviceResponse) (obj)).setSourceOfCor(((String) (obj11)));
                    ((RegisterDeviceResponse) (obj)).setPfm(((String) (obj9)));
                    ((RegisterDeviceResponse) (obj)).setDeviceInfo(map);
                    ((RegisterDeviceResponse) (obj)).addAllFIRSCookies(mCookieParser.parseStandardKindleCookieResponse(element));
                    ((RegisterDeviceResponse) (obj)).setCredentialsReceived(((java.util.Map) (obj2)));
                }
            }
        }
        registerdeviceresponse = ((RegisterDeviceResponse) (obj));
        if (obj == null)
        {
            registerdeviceresponse = parseErrorResponse(document);
        }
        return registerdeviceresponse;
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
        if (!httpurlconnection.parseChunk(((byte []) (obj)), obj.length))
        {
            return "CannotGetError";
        }
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
        if (!mParser.parseChunk(abyte0, l))
        {
            setParseError(ParseError.ParseErrorMalformedBody);
        }
    }

    public Object parse(WebResponseHeaders webresponseheaders, byte abyte0[])
        throws ParseErrorException, IOException
    {
        long l = webresponseheaders.getStatusCode();
        if (l == 412L || l >= 200L && l < 300L)
        {
            if (abyte0 != null && !mParser.parseChunk(abyte0, abyte0.length))
            {
                logAndThrowParseError(ParseError.ParseErrorMalformedBody);
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
            MAPLog.e(TAG, "%s: HTTP Error: %d", new Object[] {
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
        MAPLog.i(TAG, "RegisterDeviceResponseParser: response received a %s error.", new Object[] {
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
        MetricsHelper.increasePeriodicCounter("PrimaryAccountDeregisteredWhenRegisterSecondary", new String[0]);
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
