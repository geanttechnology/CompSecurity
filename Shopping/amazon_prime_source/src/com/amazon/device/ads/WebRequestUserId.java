// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            Settings, AdIdParameter, UserIdParameter, WebRequest

class WebRequestUserId
{

    private final AdIdParameter adIdParam;
    private final Settings settings;
    private UserIdParameter userIdParam;

    public WebRequestUserId()
    {
        this(Settings.getInstance(), new AdIdParameter());
    }

    WebRequestUserId(Settings settings1, AdIdParameter adidparameter)
    {
        settings = settings1;
        adIdParam = adidparameter;
    }

    private void setupUserIdParam()
    {
        if (userIdParam == null)
        {
            userIdParam = (UserIdParameter)settings.getObject("userIdParam", adIdParam, com/amazon/device/ads/UserIdParameter);
        }
    }

    public boolean populateWebRequestUserId(WebRequest webrequest)
    {
        setupUserIdParam();
        boolean flag1 = userIdParam.evaluate(webrequest);
        boolean flag = flag1;
        if (!flag1)
        {
            flag = flag1;
            if (userIdParam != adIdParam)
            {
                flag = adIdParam.evaluate(webrequest);
            }
        }
        return flag;
    }
}
