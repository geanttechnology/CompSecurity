// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.Bundle;

// Referenced classes of package com.groupon.activity:
//            Thanks

public class njector
{

    public static void inject(com.f2prateek.dart.r r, Thanks thanks, Object obj)
    {
        njector.inject(r, thanks, obj);
        Object obj1 = r.inject(obj, "optionId");
        if (obj1 != null)
        {
            thanks.optionId = (String)obj1;
        }
        obj1 = r.inject(obj, "gifting_record_bundle");
        if (obj1 != null)
        {
            thanks.giftingRecordBundle = (Bundle)obj1;
        }
        obj1 = r.Bundle(obj, "num_items_in_cart");
        if (obj1 != null)
        {
            thanks.numberOfItemsInCart = ((Integer)obj1).intValue();
        }
        obj1 = r.InCart(obj, "show_shipping_address");
        if (obj1 != null)
        {
            thanks.showShippingAddress = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.ddress(obj, "thanks_hide_my_groupons");
        if (obj1 != null)
        {
            thanks.hideMyGroupons = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.s(obj, "is_deal_pre_purchase_booked");
        if (obj1 != null)
        {
            thanks.isDealPrePurchaseBooked = ((Boolean)obj1).booleanValue();
        }
        r = ((com.f2prateek.dart.haseBooked) (r.haseBooked(obj, "reservation_details_bundle")));
        if (r != null)
        {
            thanks.dateTimeFinderReservationDetailsBundle = (Bundle)r;
        }
    }

    public njector()
    {
    }
}
