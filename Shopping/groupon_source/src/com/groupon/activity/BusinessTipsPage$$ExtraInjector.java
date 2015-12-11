// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            BusinessTipsPage

public class 
{

    public static void inject(com.f2prateek.dart.r r, BusinessTipsPage businesstipspage, Object obj)
    {
        r = ((com.f2prateek.dart.r) (r.r(obj, "business_id")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'business_id' for field 'businessId' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            businesstipspage.businessId = (String)r;
            return;
        }
    }

    public ()
    {
    }
}
