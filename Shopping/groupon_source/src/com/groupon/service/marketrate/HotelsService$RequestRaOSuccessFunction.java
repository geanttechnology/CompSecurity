// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.marketrate;

import com.groupon.callbacks.RaORequestCallback;
import com.groupon.models.hotel.HotelSearchResponse;
import com.groupon.models.hotel.RaoResponseWrapper;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service.marketrate:
//            HotelsService

protected static class callback
    implements Function1
{

    protected final RaORequestCallback callback;

    public void execute(HotelSearchResponse hotelsearchresponse)
    {
        if (callback != null)
        {
            RaoResponseWrapper raoresponsewrapper = new RaoResponseWrapper();
            raoresponsewrapper.waitTimeSecond = hotelsearchresponse.waitTimeMsec / 1000;
            raoresponsewrapper.attemptsLeft = hotelsearchresponse.attemptsLeft;
            callback.onRequestRaOSuccess(raoresponsewrapper);
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((HotelSearchResponse)obj);
    }

    public (RaORequestCallback raorequestcallback)
    {
        callback = raorequestcallback;
    }
}
