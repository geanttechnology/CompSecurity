// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.ca;

import com.ebay.common.model.ClientAlertsSession;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.ca:
//            GetUserAlerts

private static class session extends EbayRequest
{

    private final ClientAlertsSession session;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.
    {
        return null;
    }

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = new URL(EbaySettings.getClientAlertGetAlerts(session.id, session.data));
        }
        catch (MalformedURLException malformedurlexception)
        {
            return null;
        }
        return url;
    }

    public  getResponse()
    {
        return new (null);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public (ClientAlertsSession clientalertssession)
    {
        session = clientalertssession;
    }
}
