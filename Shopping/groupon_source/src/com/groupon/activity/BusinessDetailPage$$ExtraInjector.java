// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage

public class 
{

    public static void inject(com.f2prateek.dart.r r, BusinessDetailPage businessdetailpage, Object obj)
    {
        Object obj1 = r.r(obj, "business_id");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'business_id' for field 'businessId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        businessdetailpage.businessId = (String)obj1;
        obj1 = r.r(obj, "is_list_offers");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'is_list_offers' for field 'isListOffers' was not found. If this extra is optional add '@Optional' annotation.");
        }
        businessdetailpage.isListOffers = ((Boolean)obj1).booleanValue();
        obj1 = r.r(obj, "is_request_deal_clicked");
        if (obj1 != null)
        {
            businessdetailpage.isFromRequestADeal = ((Boolean)obj1).booleanValue();
        }
        r = ((com.f2prateek.dart.ADeal) (r.ADeal(obj, "is_ratings_clicked")));
        if (r != null)
        {
            businessdetailpage.isRatingsClicked = (String)r;
        }
    }

    public ()
    {
    }
}
