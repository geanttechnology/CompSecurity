// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AmazonOOUserIdentifier, MobileAdsLoggerFactory, WebRequest, MobileAdsLogger, 
//            ResponseReader, JSONUtils, AdvertisingIdentifier, Configuration, 
//            Settings, TrustedPackageManager, SystemTime, DebugProperties

abstract class BasicUserIdentifier extends AmazonOOUserIdentifier
{

    private final String LOGTAG;
    private final String PATH;
    private final MobileAdsLogger logger;
    private final WebRequest.WebRequestFactory webRequestFactory;

    BasicUserIdentifier(AdvertisingIdentifier advertisingidentifier, Configuration configuration, Settings settings, TrustedPackageManager trustedpackagemanager, SystemTime systemtime, DebugProperties debugproperties, String s, 
            String s1, WebRequest.WebRequestFactory webrequestfactory, MobileAdsLoggerFactory mobileadsloggerfactory)
    {
        super(advertisingidentifier, configuration, settings, trustedpackagemanager, systemtime, debugproperties);
        LOGTAG = s;
        PATH = s1;
        webRequestFactory = webrequestfactory;
        logger = mobileadsloggerfactory.createMobileAdsLogger(LOGTAG);
    }

    private WebRequest createWebRequest()
    {
        WebRequest webrequest = initializeWebRequest();
        if (webrequest == null)
        {
            return null;
        } else
        {
            webrequest.setExternalLogTag(LOGTAG);
            webrequest.convertToJSONPostRequest();
            webrequest.enableLog(true);
            webrequest.setPath(PATH);
            setParametersAndHost(webrequest);
            return webrequest;
        }
    }

    public boolean identifyUser()
    {
        boolean flag = true;
        Object obj = createWebRequest();
        if (obj != null)
        {
            try
            {
                obj = ((WebRequest) (obj)).makeCall();
            }
            catch (WebRequest.WebRequestException webrequestexception)
            {
                return false;
            }
            logger.d("Service call result: %d", new Object[] {
                Integer.valueOf(((WebRequest.WebResponse) (obj)).getHttpStatusCode())
            });
            if (((WebRequest.WebResponse) (obj)).isHttpStatusCodeOK())
            {
                Object obj1 = ((WebRequest.WebResponse) (obj)).getResponseReader().readAsJSON();
                if (obj1 != null)
                {
                    String s = JSONUtils.getStringFromJSON(((org.json.JSONObject) (obj1)), "code", null);
                    obj1 = JSONUtils.getStringFromJSON(((org.json.JSONObject) (obj1)), "status", null);
                    logger.d("Service result - code: %s, status: %s", new Object[] {
                        s, obj1
                    });
                    if (s == null || !s.equals("200"))
                    {
                        flag = false;
                    }
                    return flag;
                }
            }
        }
        return false;
    }

    WebRequest initializeWebRequest()
    {
        return webRequestFactory.createWebRequest();
    }
}
