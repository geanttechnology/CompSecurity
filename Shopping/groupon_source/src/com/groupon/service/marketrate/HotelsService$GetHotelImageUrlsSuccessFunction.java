// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.marketrate;

import com.groupon.models.hotel.HotelSearchResponse;
import com.groupon.models.hotel.ImageFormat;
import com.groupon.models.hotel.Original;
import com.groupon.models.hotel.Sizes;
import com.groupon.util.Function1;
import com.groupon.util.ImageUrl;
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
            hotelsearchresponse = hotelsearchresponse.images;
            if (hotelsearchresponse != null)
            {
                Iterator iterator = hotelsearchresponse.iterator();
                while (iterator.hasNext()) 
                {
                    hotelsearchresponse = ((ImageFormat)iterator.next()).sizes.original.url;
                    if (!hotelsearchresponse.startsWith("http"))
                    {
                        hotelsearchresponse = (new StringBuilder()).append("http://").append(hotelsearchresponse).toString();
                    }
                    arraylist.add(new ImageUrl(hotelsearchresponse));
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
