// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.ca;

import com.ebay.common.model.ClientAlertsSession;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.net.api.ca:
//            GetUserAlerts, CaLogin

public final class ClientAlerts
{

    public ClientAlerts()
    {
    }

    public static ArrayList getUserAlerts(EbayContext ebaycontext, ClientAlertsSession clientalertssession)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return GetUserAlerts.getUserAlerts(ebaycontext, clientalertssession);
    }

    public static ClientAlertsSession login(EbayContext ebaycontext, String s)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return CaLogin.login(ebaycontext, s);
    }
}
