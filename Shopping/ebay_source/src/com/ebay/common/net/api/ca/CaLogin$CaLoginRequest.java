// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.ca;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.ca:
//            CaLogin

private static class setOperationName extends EbayRequest
{

    private final String caAuthToken;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.ataException
    {
        return null;
    }

    public URL getRequestUrl()
    {
        Object obj = EbaySettings.getClientAlertLogin(caAuthToken);
        try
        {
            obj = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            return null;
        }
        return ((URL) (obj));
    }

    public  getResponse()
    {
        return new (null);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected (String s)
    {
        caAuthToken = s;
        setServiceName("ClientAlerts");
        setOperationName("login");
    }
}
