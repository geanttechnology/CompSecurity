// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.models.category.Category;
import java.util.Comparator;

// Referenced classes of package com.groupon.util:
//            CategoriesUtil

public static final class 
    implements Comparator
{

    public int compare(Category category, Category category1)
    {
        return category.friendlyName.compareTo(category1.friendlyName);
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Category)obj, (Category)obj1);
    }

    public ()
    {
    }
}
