// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Request;
import java.io.IOException;

// Referenced classes of package com.ebay.mobile.notifications:
//            PushService

private static final class 
{

    public static EbayResponse sendRequest(EbayContext ebaycontext, Request request)
        throws com.ebay.nautilus.kernel.net., com.ebay.nautilus.kernel.net.n, com.ebay.common.net.xception, com.ebay.nautilus.kernel.net.n, IOException, InterruptedException
    {
        ebaycontext = (EbayResponse)com.ebay.nautilus.kernel.net.n(ebaycontext, request);
        verify(ebaycontext);
        return ebaycontext;
    }

    public static void verify(EbayResponse ebayresponse)
        throws com.ebay.common.net.xception, com.ebay.nautilus.kernel.net..verify
    {
        if (!ebayresponse.hasSuccessResponseCode())
        {
            throw new com.ebay.nautilus.kernel.net.(ebayresponse.responseCode, ebayresponse.responseMessage);
        } else
        {
            return;
        }
    }

    private ()
    {
    }
}
