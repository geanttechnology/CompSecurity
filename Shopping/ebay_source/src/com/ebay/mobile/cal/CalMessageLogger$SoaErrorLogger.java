// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.cal;

import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponseError;

// Referenced classes of package com.ebay.mobile.cal:
//            CalMessageLogger

private static class it> extends it>
{

    protected String getErrorDescription(EbayResponseError ebayresponseerror)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (ebayresponseerror != null && (ebayresponseerror instanceof com.ebay.nautilus.domain.net.))
        {
            com.ebay.nautilus.domain.net.  = (com.ebay.nautilus.domain.net.)ebayresponseerror;
            stringbuilder.append("SOA");
            StringBuilder stringbuilder1 = stringbuilder.append('.');
            if (.main == null)
            {
                ebayresponseerror = "Unknown";
            } else
            {
                ebayresponseerror = .main;
            }
            stringbuilder1.append(ebayresponseerror);
            stringbuilder1 = stringbuilder.append('.');
            if (.bdomain == null)
            {
                ebayresponseerror = "Unknown";
            } else
            {
                ebayresponseerror = .bdomain;
            }
            stringbuilder1.append(ebayresponseerror);
            stringbuilder1 = stringbuilder.append('.');
            if (.tegoryDescription() == null)
            {
                ebayresponseerror = "Unknown";
            } else
            {
                ebayresponseerror = .tegoryDescription();
            }
            stringbuilder1.append(ebayresponseerror);
            stringbuilder1 = stringbuilder.append('.');
            if (.de == null)
            {
                ebayresponseerror = "Unknown";
            } else
            {
                ebayresponseerror = .de;
            }
            stringbuilder1.append(ebayresponseerror);
        } else
        {
            stringbuilder.append("SOA").append('.').append("Unknown");
        }
        return stringbuilder.toString();
    }

    public etails(EbayRequest ebayrequest, CalMessageLogger calmessagelogger)
    {
        super(ebayrequest, calmessagelogger);
    }
}
