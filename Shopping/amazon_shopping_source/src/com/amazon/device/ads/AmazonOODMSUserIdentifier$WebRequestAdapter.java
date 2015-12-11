// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import com.AmazonDevice.Identity.Common.WebRequest;
import java.net.URL;

// Referenced classes of package com.amazon.device.ads:
//            WebRequest, AmazonOODMSUserIdentifier

class webRequest extends com.amazon.device.ads.WebRequest
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

    protected webRequest doHttpNetworkCall(URL url)
        throws webRequest
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

    public void setUseSecure(boolean flag)
    {
        webRequest.setAuthenticationRequired(flag);
    }

    (WebRequest webrequest)
    {
        this$0 = AmazonOODMSUserIdentifier.this;
        super();
        webRequest = webrequest;
    }
}
