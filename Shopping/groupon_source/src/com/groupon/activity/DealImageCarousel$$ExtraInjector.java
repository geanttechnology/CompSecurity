// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;
import com.groupon.models.nst.JsonEncodedNSTField;

// Referenced classes of package com.groupon.activity:
//            DealImageCarousel

public class 
{

    public static void inject(com.f2prateek.dart.r r, DealImageCarousel dealimagecarousel, Object obj)
    {
        Object obj1 = r.r(obj, "dealId");
        if (obj1 != null)
        {
            dealimagecarousel.dealId = (String)obj1;
        }
        obj1 = r.r(obj, "dealTitle");
        if (obj1 != null)
        {
            dealimagecarousel.dealTitle = (String)obj1;
        }
        obj1 = r.r(obj, "channel");
        if (obj1 != null)
        {
            dealimagecarousel.channel = (Channel)obj1;
        }
        r = ((com.f2prateek.dart.r) (r.r(obj, "impression_metadata")));
        if (r != null)
        {
            dealimagecarousel.jsonEncodedNSTField = (JsonEncodedNSTField)r;
        }
    }

    public ()
    {
    }
}
