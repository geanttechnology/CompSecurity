// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.marketrate;

import com.groupon.models.hotel.Destination;
import com.groupon.models.hotel.DestinationListWrapper;
import com.groupon.models.hotel.HotelSearchResponse;
import com.groupon.util.Function1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.service.marketrate:
//            HotelsService

protected class onSuccess
    implements Function1
{

    protected final Function1 onSuccess;
    final HotelsService this$0;

    public void execute(HotelSearchResponse hotelsearchresponse)
    {
        if (onSuccess != null)
        {
            ArrayList arraylist = new ArrayList();
            hotelsearchresponse = hotelsearchresponse.destinationList;
            if (hotelsearchresponse != null)
            {
                for (hotelsearchresponse = hotelsearchresponse.iterator(); hotelsearchresponse.hasNext();)
                {
                    Iterator iterator = ((DestinationListWrapper)hotelsearchresponse.next()).destinations.iterator();
                    while (iterator.hasNext()) 
                    {
                        arraylist.add((Destination)iterator.next());
                    }
                }

            }
            onSuccess.execute(arraylist);
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((HotelSearchResponse)obj);
    }

    public (Function1 function1)
    {
        this$0 = HotelsService.this;
        super();
        onSuccess = function1;
    }
}
