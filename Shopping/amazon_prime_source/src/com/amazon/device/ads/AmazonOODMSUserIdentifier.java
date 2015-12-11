// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import com.AmazonDevice.Authentication.AmazonWebserviceCall;
import com.AmazonDevice.Authentication.AmazonWebserviceCaller;
import com.AmazonDevice.Authentication.DefaultAmazonWebserviceCallListener;
import com.AmazonDevice.Authentication.ITokenAuthProvider;
import com.AmazonDevice.Identity.Common.HttpVerb;
import com.AmazonDevice.Identity.Common.ILogOutput;
import com.AmazonDevice.Identity.Common.IWebResponseParser;
import com.AmazonDevice.Identity.Common.Log;
import com.AmazonDevice.Identity.Common.LogType;
import com.AmazonDevice.Identity.Common.ParseError;
import com.AmazonDevice.Identity.Common.SdkLogLevel;
import com.AmazonDevice.Identity.Common.WebProtocol;
import com.AmazonDevice.Identity.Common.WebRequest;
import com.AmazonDevice.Identity.Common.WebResponseHeaders;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            BasicUserIdentifier, AccountBasedUserIdentifier, MobileAdsLoggerFactory, MobileAdsInfoStore, 
//            DebugProperties, MobileAdsLogger, AndroidTargetUtils, AdvertisingIdentifier, 
//            Configuration, Settings, TrustedPackageManager, SystemTime, 
//            WebRequest

class AmazonOODMSUserIdentifier extends BasicUserIdentifier
    implements AccountBasedUserIdentifier
{
    protected static class GenericWebResponseParser
        implements IWebResponseParser
    {

        private Long httpCode;
        private ParseError parseError;
        private final ByteArrayOutputStream stream = new ByteArrayOutputStream();

        public void beginParse(WebResponseHeaders webresponseheaders)
        {
            httpCode = Long.valueOf(webresponseheaders.getStatusCode());
            if (httpCode.longValue() < 200L || httpCode.longValue() >= 300L)
            {
                parseError = ParseError.ParseErrorHttpError;
            }
        }

        public ParseError endParse()
        {
            return parseError;
        }

        public ParseError getParseError()
        {
            return parseError;
        }

        public ResponseInfo getParsedResponse()
        {
            Object obj;
            try
            {
                obj = stream.toString("UTF-8");
                obj = new ResponseInfo(httpCode.longValue(), ((String) (obj)));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                return new ResponseInfo(500L, (new StringBuilder()).append("Error decoding response ").append(unsupportedencodingexception.getMessage()).toString());
            }
            return ((ResponseInfo) (obj));
        }

        public volatile Object getParsedResponse()
        {
            return getParsedResponse();
        }

        public ParseError parseBodyChunk(byte abyte0[], int i)
        {
            stream.write(abyte0, 0, i);
            return parseError;
        }

        public boolean shouldParseBody()
        {
            return true;
        }

        protected GenericWebResponseParser()
        {
            parseError = ParseError.ParseErrorNoError;
        }
    }

    protected static class GenericWebResponseParser.ResponseInfo
    {

        public final long httpCode;
        public final String response;

        public GenericWebResponseParser.ResponseInfo(long l, String s)
        {
            httpCode = l;
            response = s;
        }
    }

    protected static class KCPAuthLogInterceptor extends ILogOutput
    {

        private static final String LOGTAG = "DMSAuth";
        private final MobileAdsLogger logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger("DMSAuth");

        public void printOutput(String s, SdkLogLevel sdkloglevel, LogType logtype)
        {
            static class _cls3
            {

                static final int $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel[];

                static 
                {
                    $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel = new int[SdkLogLevel.values().length];
                    try
                    {
                        $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel[SdkLogLevel.SdkLogLevelDebug.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel[SdkLogLevel.SdkLogLevelError.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel[SdkLogLevel.SdkLogLevelInfo.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel[SdkLogLevel.SdkLogLevelWarn.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls3..SwitchMap.com.AmazonDevice.Identity.Common.SdkLogLevel[sdkloglevel.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                logger.d(s);
                return;

            case 2: // '\002'
                logger.e(s);
                return;

            case 3: // '\003'
                logger.i(s);
                return;

            case 4: // '\004'
                logger.w(s);
                break;
            }
        }

        protected KCPAuthLogInterceptor()
        {
        }
    }

    class WebRequestAdapter extends com.amazon.device.ads.WebRequest
    {

        final AmazonOODMSUserIdentifier this$0;
        private final WebRequest webRequest;

        protected void addQueryParameter(String s, String s1)
        {
            if (s1 != null)
            {
                webRequest.addQueryParameter(s, s1);
            }
        }

        protected void closeConnection()
        {
        }

        protected WebRequest.WebResponse doHttpNetworkCall(URL url)
            throws WebRequest.WebRequestException
        {
            return null;
        }

        protected String getSubLogTag()
        {
            return null;
        }

        public String putUnencodedQueryParameter(String s, String s1)
        {
            addQueryParameter(s, s1);
            return s1;
        }

        public void putUrlEncodedQueryParameter(String s, String s1)
        {
            addQueryParameter(s, s1);
        }

        public void setHost(String s)
        {
            webRequest.setHost(s);
        }

        public void setRequestBodyString(String s)
        {
            webRequest.setBody(s);
        }

        public void setUseSecure(boolean flag)
        {
            webRequest.setAuthenticationRequired(flag);
        }

        WebRequestAdapter(WebRequest webrequest)
        {
            this$0 = AmazonOODMSUserIdentifier.this;
            super();
            webRequest = webrequest;
        }
    }


    private static final String LOGTAG = com/amazon/device/ads/AmazonOODMSUserIdentifier.getSimpleName();
    private static final String PATH = "/RegisterDMS";
    private static AtomicBoolean commonObjectsInitialized = new AtomicBoolean(false);
    private final MobileAdsLogger logger;
    private ITokenAuthProvider tokenAuthProvider;
    private WebRequest webRequest;

    public AmazonOODMSUserIdentifier(String s, String s1, AdvertisingIdentifier advertisingidentifier, Configuration configuration, Settings settings, TrustedPackageManager trustedpackagemanager, SystemTime systemtime, 
            DebugProperties debugproperties, MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        super(advertisingidentifier, configuration, settings, trustedpackagemanager, systemtime, debugproperties, LOGTAG, "/RegisterDMS", null, mobileadsloggerfactory);
        tokenAuthProvider = null;
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
        setMobileAdsInfoStore(MobileAdsInfoStore.getInstance());
        if (!commonObjectsInitialized.getAndSet(true))
        {
            Log.setLogOutput(new KCPAuthLogInterceptor());
            Log.setLogLevel(SdkLogLevel.SdkLogLevelDebug);
        }
        tokenAuthProvider = makeITokenAuth(s, s1);
    }

    private void buildWebRequest()
    {
        webRequest = new WebRequest();
        webRequest.setProtocol(getProtocol());
        webRequest.setPath("/RegisterDMS");
        webRequest.setVerb(HttpVerb.HttpVerbPost);
        setParametersAndHost(createWebRequestAdapter());
        webRequest.setHeader("Content-Type", "application/json");
        webRequest.setHeader("Accept", "application/json");
    }

    private MobileAdsLogger getLogger()
    {
        return logger;
    }

    private WebProtocol getProtocol()
    {
        if (DebugProperties.getInstance().getDebugPropertyAsBoolean("debug.madsUseSecure", Boolean.valueOf(true)).booleanValue())
        {
            return WebProtocol.WebProtocolHttps;
        } else
        {
            return WebProtocol.WebProtocolHttp;
        }
    }

    private static ITokenAuthProvider makeITokenAuth(String s, String s1)
    {
        return new ITokenAuthProvider(s, s1) {

            final String val$adpToken;
            final String val$privateKey;

            public String getPrivateKey()
            {
                return privateKey;
            }

            public String getToken()
            {
                return adpToken;
            }

            
            {
                adpToken = s;
                privateKey = s1;
                super();
            }
        };
    }

    protected boolean callWebService()
    {
        buildWebRequest();
        final AtomicBoolean callSuccessful = new AtomicBoolean(false);
        final CountDownLatch latch = new CountDownLatch(1);
        AmazonWebserviceCall amazonwebservicecall = (new AmazonWebserviceCaller(tokenAuthProvider)).createCall(webRequest, new GenericWebResponseParser(), new DefaultAmazonWebserviceCallListener() {

            final AmazonOODMSUserIdentifier this$0;
            final AtomicBoolean val$callSuccessful;
            final CountDownLatch val$latch;

            public void onAuthenticationFailed()
            {
                getLogger().w("Authentication failure calling MobileAdsService");
                latch.countDown();
            }

            public void onNetworkFailure()
            {
                getLogger().w("Network failure calling MobileAdsService");
                latch.countDown();
            }

            public void onParseError(ParseError parseerror)
            {
                getLogger().w("Parse error getting response from MobileAdsService");
                latch.countDown();
            }

            public void onResponseComplete(Object obj)
            {
                obj = (GenericWebResponseParser.ResponseInfo)obj;
                if (((GenericWebResponseParser.ResponseInfo) (obj)).httpCode == 200L) goto _L2; else goto _L1
_L1:
                getLogger().w("Calling MobileAdsService was not successful: %s", new Object[] {
                    ((GenericWebResponseParser.ResponseInfo) (obj)).response
                });
_L4:
                latch.countDown();
                return;
_L2:
                callSuccessful.set(true);
                if (true) goto _L4; else goto _L3
_L3:
                obj;
                latch.countDown();
                throw obj;
            }

            
            {
                this$0 = AmazonOODMSUserIdentifier.this;
                latch = countdownlatch;
                callSuccessful = atomicboolean;
                super();
            }
        });
        try
        {
            amazonwebservicecall.call();
        }
        catch (SecurityException securityexception)
        {
            getLogger().w("Calling MobileAdsService was not successful due to a SecurityException");
            latch.countDown();
        }
        try
        {
            latch.await();
        }
        catch (InterruptedException interruptedexception) { }
        return callSuccessful.get();
    }

    protected WebRequestAdapter createWebRequestAdapter()
    {
        return new WebRequestAdapter(webRequest);
    }

    public void executeRequest()
    {
        if (AndroidTargetUtils.isAtOrBelowAndroidAPI(8))
        {
            logger.w("This functionality is only supported with Android SDK v9 and higher.");
            return;
        } else
        {
            super.executeRequest();
            return;
        }
    }

    public String getAccount()
    {
        if (tokenAuthProvider == null)
        {
            return null;
        } else
        {
            return tokenAuthProvider.getToken();
        }
    }

    WebRequest getWebRequest()
    {
        return webRequest;
    }

    public boolean identifyUser()
    {
        return callWebService();
    }

    void processExtraParameters(JSONObject jsonobject)
    {
    }


}
