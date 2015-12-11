// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.cal;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;

// Referenced classes of package com.ebay.mobile.cal:
//            CalMessageLogger

private static class lder extends lder
{

    protected String getErrorDescription(EbayResponseError ebayresponseerror)
    {
        if (ebayresponseerror != null)
        {
            return (new StringBuilder()).append("T").append(ebayresponseerror.code).toString();
        } else
        {
            return "";
        }
    }

    protected void logCal(com.ebay.common.net.api.cal.q q)
    {
        q.SiteID(((EbayTradingRequest)request).site.id);
    }

    public lder(EbayTradingRequest ebaytradingrequest, CalMessageLogger calmessagelogger)
    {
        super(ebaytradingrequest, calmessagelogger);
    }
}
