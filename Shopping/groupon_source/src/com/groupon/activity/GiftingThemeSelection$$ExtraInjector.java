// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import com.groupon.models.gift.GiftingRecord;

// Referenced classes of package com.groupon.activity:
//            GiftingThemeSelection

public class 
{

    public static void inject(com.f2prateek.dart.r r, GiftingThemeSelection giftingthemeselection, Object obj)
    {
        Object obj1 = r.r(obj, "giftingRecord");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'giftingRecord' for field 'giftingRecord' was not found. If this extra is optional add '@Optional' annotation.");
        }
        giftingthemeselection.giftingRecord = (GiftingRecord)obj1;
        r = ((com.f2prateek.dart.) (r.(obj, "next")));
        if (r != null)
        {
            giftingthemeselection.next = (Intent)r;
        }
    }

    public ()
    {
    }
}
