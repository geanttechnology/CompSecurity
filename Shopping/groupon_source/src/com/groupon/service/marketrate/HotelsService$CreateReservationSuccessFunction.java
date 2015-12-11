// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.marketrate;

import com.groupon.models.hotel.HotelSearchResponse;
import com.groupon.util.Function1;
import java.util.ArrayList;

// Referenced classes of package com.groupon.service.marketrate:
//            HotelsService

protected static class onSuccess
    implements Function1
{

    protected final Function1 onSuccess;

    public void execute(HotelSearchResponse hotelsearchresponse)
    {
        if (onSuccess != null)
        {
            java.util.List list = hotelsearchresponse.reservations;
            hotelsearchresponse = list;
            if (list == null)
            {
                hotelsearchresponse = new ArrayList();
            }
            onSuccess.execute(hotelsearchresponse);
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((HotelSearchResponse)obj);
    }

    public (Function1 function1)
    {
        onSuccess = function1;
    }
}
