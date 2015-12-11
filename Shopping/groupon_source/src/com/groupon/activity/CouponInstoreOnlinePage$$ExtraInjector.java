// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            CouponInstoreOnlinePage

public class e
{

    public static void inject(com.f2prateek.dart.r r, CouponInstoreOnlinePage couponinstoreonlinepage, Object obj)
    {
        Object obj1 = r.r(obj, "couponFilterId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'couponFilterId' for field 'filterId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        couponinstoreonlinepage.filterId = (String)obj1;
        obj1 = r.r(obj, "couponFilterPagerTitle");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'couponFilterPagerTitle' for field 'pagerTitle' was not found. If this extra is optional add '@Optional' annotation.");
        }
        couponinstoreonlinepage.pagerTitle = (String)obj1;
        obj1 = r.r(obj, "couponFilterItemType");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'couponFilterItemType' for field 'freebieListItemType' was not found. If this extra is optional add '@Optional' annotation.");
        }
        couponinstoreonlinepage.freebieListItemType = (com.groupon.v3.view.list_view.)obj1;
        obj1 = r.ype(obj, "couponFilterPagerSlug");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'couponFilterPagerSlug' for field 'couponSlug' was not found. If this extra is optional add '@Optional' annotation.");
        }
        couponinstoreonlinepage.couponSlug = (String)obj1;
        obj1 = r.ype(obj, "couponFilterStarterTab");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'couponFilterStarterTab' for field 'starterTab' was not found. If this extra is optional add '@Optional' annotation.");
        }
        couponinstoreonlinepage.starterTab = (e)obj1;
        r = ((com.f2prateek.dart.ype) (r.ype(obj, "isDeepLinked")));
        if (r != null)
        {
            couponinstoreonlinepage.isDeeplinkd = ((Boolean)r).booleanValue();
        }
    }

    public e()
    {
    }
}
