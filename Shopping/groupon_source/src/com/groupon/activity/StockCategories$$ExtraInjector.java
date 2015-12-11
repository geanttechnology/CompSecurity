// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.db.models.StockValue;

// Referenced classes of package com.groupon.activity:
//            StockCategories

public class _cls9
{

    public static void inject(com.f2prateek.dart.r r, StockCategories stockcategories, Object obj)
    {
        Object obj1 = r.r(obj, "dealId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'dealId' for field 'dealId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        stockcategories.dealId = (String)obj1;
        obj1 = r.r(obj, "optionId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'optionId' for field 'dealOptionId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        stockcategories.dealOptionId = (String)obj1;
        r = ((com.f2prateek.dart.r) (r.r(obj, "stockValue")));
        if (r != null)
        {
            stockcategories.stockValue = (StockValue)r;
        }
    }

    public _cls9()
    {
    }
}
