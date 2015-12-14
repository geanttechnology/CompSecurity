// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            AmazonOOUserIdentifier, AuthenticationPlatformAdapter, WebRequest, Log, 
//            ResponseReader, JSONUtils, AdvertisingIdentifier, Configuration, 
//            Settings, TrustedPackageManager, SystemTime, DebugProperties

class AmazonOOMAPUserIdentifier extends AmazonOOUserIdentifier
{

    private static final String LOGTAG = com/amazon/device/ads/identity/AmazonOOMAPUserIdentifier.getSimpleName();
    private final AuthenticationPlatformAdapter authenticationPlatform;

    public AmazonOOMAPUserIdentifier(AuthenticationPlatformAdapter authenticationplatformadapter, AdvertisingIdentifier advertisingidentifier, Configuration configuration, Settings settings, TrustedPackageManager trustedpackagemanager, SystemTime systemtime, DebugProperties debugproperties)
    {
        super(advertisingidentifier, configuration, settings, trustedpackagemanager, systemtime, debugproperties);
        authenticationPlatform = authenticationplatformadapter;
    }

    public String getAccount()
    {
        return authenticationPlatform.getAccountName();
    }

    protected boolean identifyUser()
    {
        Object obj = getAccount();
        if (obj != null)
        {
            obj = makeWebRequest(((String) (obj)));
            try
            {
                obj = ((WebRequest) (obj)).makeCall();
            }
            catch (WebRequest.WebRequestException webrequestexception)
            {
                return false;
            }
            Log.d(LOGTAG, "Service call result: %d", new Object[] {
                Integer.valueOf(((WebRequest.WebResponse) (obj)).getHttpStatusCode())
            });
            if (((WebRequest.WebResponse) (obj)).isHttpStatusCodeOK())
            {
                Object obj1 = ((WebRequest.WebResponse) (obj)).getResponseReader().readAsJSON();
                if (obj1 != null)
                {
                    String s = JSONUtils.getStringFromJSON$3d0ad843(((org.json.JSONObject) (obj1)), "code");
                    obj1 = JSONUtils.getStringFromJSON$3d0ad843(((org.json.JSONObject) (obj1)), "status");
                    Log.d(LOGTAG, "Service result - code: %s, status: %s", new Object[] {
                        s, obj1
                    });
                    if (s != null && s.equals("200"))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected WebRequest makeAuthenticatedWebRequest(String s)
    {
        return authenticationPlatform.makeAuthenticatedWebRequest(s);
    }

    protected WebRequest makeWebRequest(String s)
    {
        s = makeAuthenticatedWebRequest(s);
        s.setExternalLogTag(LOGTAG);
        s.convertToJSONPostRequest();
        s.enableLog$1385ff();
        s.setPath("/RegisterOAuth");
        setParametersAndHost(s);
        return s;
    }

}
