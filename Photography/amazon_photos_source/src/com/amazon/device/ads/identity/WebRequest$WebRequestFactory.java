// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;


// Referenced classes of package com.amazon.device.ads.identity:
//            WebRequest, AndroidTargetUtils, HttpClientWebRequest, HttpURLConnectionWebRequest

public static class A
{

    public WebRequest createWebRequest()
    {
        if (AndroidTargetUtils.isAtOrBelowAndroidAPI$134632())
        {
            return new HttpClientWebRequest();
        } else
        {
            return new HttpURLConnectionWebRequest();
        }
    }

    public A()
    {
    }
}
