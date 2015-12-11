// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            WebRequest, AndroidBuildInfo, AndroidTargetUtils, HttpClientWebRequest, 
//            HttpURLConnectionWebRequest

public static class androidBuildInfo
{

    private final AndroidBuildInfo androidBuildInfo;

    public WebRequest createJSONGetWebRequest()
    {
        WebRequest webrequest = createWebRequest();
        webrequest.setHttpMethod(createWebRequest);
        webrequest.putHeader("Accept", "application/json");
        return webrequest;
    }

    public WebRequest createJSONPostWebRequest()
    {
        WebRequest webrequest = createWebRequest();
        webrequest.convertToJSONPostRequest();
        return webrequest;
    }

    public WebRequest createWebRequest()
    {
        if (AndroidTargetUtils.isAtOrBelowAndroidAPI(androidBuildInfo, 7))
        {
            return new HttpClientWebRequest();
        } else
        {
            return new HttpURLConnectionWebRequest();
        }
    }

    public ()
    {
        this(new AndroidBuildInfo());
    }

    <init>(AndroidBuildInfo androidbuildinfo)
    {
        androidBuildInfo = androidbuildinfo;
    }
}
