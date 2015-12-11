// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.kernel.net.Request;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common:
//            DevLogicException

public abstract class SsoRequest extends Request
{

    public int responseCode;
    private final URL url;

    protected SsoRequest(String s, String s1)
    {
        responseCode = -1;
        try
        {
            url = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new DevLogicException(s);
        }
        setServiceName("Sso");
        setOperationName(s1);
    }

    public URL getRequestUrl()
    {
        return url;
    }

    public String getUserAgent()
    {
        return EbayAppCredentials.get(getEbayContext()).userAgent;
    }
}
