// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.common.model.RemindersList;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            ApsGetReminders, GetUserActivitySummary, UserActivitySummary

public final class ApplicationProcessServiceApi
{

    public static final int PDS_RETRIES = 1;
    public static final int PDS_TIMEOUT = 5000;
    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobileor/v1/services";
    public static final String SERVICE_NAME = "IPhoneApplicationProcessService";
    public static final String SOAP_DOMAIN = "http://schemas.xmlsoap.org/soap/envelope/";
    private final EbayContext context;
    private final EbaySite site;

    public ApplicationProcessServiceApi(EbayContext ebaycontext, EbaySite ebaysite)
    {
        context = ebaycontext;
        site = ebaysite;
    }

    public final RemindersList getReminderItems(String s, String s1, int i, int j, String s2)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ApsGetReminders.getReminderItems(context, s, site, s1, i, j, s2);
    }

    public final UserActivitySummary getUserActivitySummary(String s, String s1)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return GetUserActivitySummary.getUserActivitySummary(context, s, site, s1);
    }
}
