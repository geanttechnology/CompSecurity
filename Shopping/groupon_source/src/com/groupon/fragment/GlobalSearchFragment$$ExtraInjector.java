// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.models.category.Category;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

public class 
{

    public static void inject(com.f2prateek.dart.r r, GlobalSearchFragment globalsearchfragment, Object obj)
    {
        Object obj1 = r.r(obj, "category_from_goods");
        if (obj1 != null)
        {
            globalsearchfragment.categoryFromGoods = (Category)obj1;
        }
        obj1 = r.oods(obj, "search_term");
        if (obj1 != null)
        {
            globalsearchfragment.searchTerm = (String)obj1;
        }
        r = ((com.f2prateek.dart.oods) (r.oods(obj, "browse_by_category")));
        if (r != null)
        {
            globalsearchfragment.isBrowseByCategory = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
