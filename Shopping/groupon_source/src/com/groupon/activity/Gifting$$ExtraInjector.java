// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import com.groupon.models.gift.GiftingRecord;

// Referenced classes of package com.groupon.activity:
//            Gifting

public class 
{

    public static void inject(com.f2prateek.dart.r r, Gifting gifting, Object obj)
    {
        Object obj1 = r.r(obj, "giftingRecord");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'giftingRecord' for field 'giftingRecord' was not found. If this extra is optional add '@Optional' annotation.");
        }
        gifting.giftingRecord = (GiftingRecord)obj1;
        obj1 = r.(obj, "dealId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'dealId' for field 'dealId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        gifting.dealId = (String)obj1;
        obj1 = r.(obj, "isGiftableDeal");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'isGiftableDeal' for field 'isGiftableDeal' was not found. If this extra is optional add '@Optional' annotation.");
        }
        gifting.isGiftableDeal = ((Boolean)obj1).booleanValue();
        r = ((com.f2prateek.dart.l) (r.l(obj, "next")));
        if (r != null)
        {
            gifting.next = (Intent)r;
        }
    }

    public ()
    {
    }
}
