// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.utils.meta_data:
//            SizesMetaData

class sizes_by_category
{
    class CategorySizes
    {

        String categoryName;
        List sizes;
        final SizesMetaData.Sizes this$1;

        CategorySizes()
        {
            this$1 = SizesMetaData.Sizes.this;
            super();
            sizes = new ArrayList();
        }
    }


    List sizes_by_category;
    final SizesMetaData this$0;

    public List getSizesForCategory(String s)
    {
        for (Iterator iterator = sizes_by_category.iterator(); iterator.hasNext();)
        {
            CategorySizes categorysizes = (CategorySizes)iterator.next();
            if (categorysizes.categoryName.equals(s))
            {
                return categorysizes.sizes;
            }
        }

        return null;
    }

    CategorySizes.sizes()
    {
        this$0 = SizesMetaData.this;
        super();
        sizes_by_category = new ArrayList();
    }
}
