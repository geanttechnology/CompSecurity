// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage

public class 
{

    public static void inject(com.f2prateek.dart.r r, BusinessSpecialPage businessspecialpage, Object obj)
    {
        Object obj1 = r.r(obj, "special_id");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'special_id' for field 'specialId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        businessspecialpage.specialId = (String)obj1;
        obj1 = r.r(obj, "business_id");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'business_id' for field 'businessId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        businessspecialpage.businessId = (String)obj1;
        obj1 = r.r(obj, "isDeepLinked");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'isDeepLinked' for field 'isDeepLinked' was not found. If this extra is optional add '@Optional' annotation.");
        }
        businessspecialpage.isDeepLinked = ((Boolean)obj1).booleanValue();
        r = ((com.f2prateek.dart.r) (r.r(obj, "is_claim_special_clicked")));
        if (r != null)
        {
            businessspecialpage.isClaimSpecialClicked = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
