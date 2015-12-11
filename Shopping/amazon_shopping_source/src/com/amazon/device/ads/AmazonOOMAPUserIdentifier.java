// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AmazonOOUserIdentifier, AmazonOOMAPAdapter, AmazonOOAuthenticationPlatformAdapter, WebRequest, 
//            Log, JSONUtils

class AmazonOOMAPUserIdentifier extends AmazonOOUserIdentifier
{

    private static final String LOGTAG = com/amazon/device/ads/AmazonOOMAPUserIdentifier.getSimpleName();
    private static final String PATH = "/RegisterOAuth";
    private AmazonOOAuthenticationPlatformAdapter authenticationPlatform;

    public AmazonOOMAPUserIdentifier()
    {
        authenticationPlatform = createAuthenticationPlatform();
    }

    protected AmazonOOAuthenticationPlatformAdapter createAuthenticationPlatform()
    {
        return new AmazonOOMAPAdapter();
    }

    protected String getAccount()
    {
        return authenticationPlatform.getAccountName();
    }

    protected boolean identifyUser()
    {
        boolean flag = true;
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
                Object obj1 = ((WebRequest.WebResponse) (obj)).getJSONObjectBody();
                if (obj1 != null)
                {
                    String s = JSONUtils.getStringFromJSON(((org.json.JSONObject) (obj1)), "code", null);
                    obj1 = JSONUtils.getStringFromJSON(((org.json.JSONObject) (obj1)), "status", null);
                    Log.d(LOGTAG, "Service result - code: %s, status: %s", new Object[] {
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

    protected WebRequest makeAuthenticatedWebRequest(String s)
    {
        return authenticationPlatform.makeAuthenticatedWebRequest(s);
    }

    protected WebRequest makeWebRequest(String s)
    {
        s = makeAuthenticatedWebRequest(s);
        s.setExternalLogTag(LOGTAG);
        s.convertToJSONPostRequest();
        s.enableLogUrl(true);
        s.setPath("/RegisterOAuth");
        setParametersAndHost(s);
        return s;
    }

}
