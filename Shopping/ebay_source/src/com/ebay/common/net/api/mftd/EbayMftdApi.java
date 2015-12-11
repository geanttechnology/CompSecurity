// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mftd;

import com.ebay.common.model.mftd.MessageListResult;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;

// Referenced classes of package com.ebay.common.net.api.mftd:
//            GetMFTD

public final class EbayMftdApi
{

    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
    public static final String SERVICE_NAME = "MessagesForTheDayService";
    public static final String SOAP_DOMAIN = "http://schemas.xmlsoap.org/soap/envelope/";
    public static String ServiceUrlString;
    private final EbayContext context;
    private final EbaySite site;

    public EbayMftdApi(EbayContext ebaycontext, EbaySite ebaysite)
    {
        context = ebaycontext;
        site = ebaysite;
    }

    public MessageListResult getMOTDResponse(String s, String s1)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return GetMFTD.go(context, s, s1, site);
    }
}
