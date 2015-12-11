// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import com.offerup.android.dto.Category;

// Referenced classes of package com.offerup.android.dto.response:
//            BaseResponse

public class CategoryResponse extends BaseResponse
{

    private LocalData data;

    public CategoryResponse()
    {
    }

    public Category[] getCategories()
    {
        Category acategory[] = null;
        if (data != null)
        {
            acategory = data.categories;
        }
        return acategory;
    }

    private class LocalData
    {

        private Category categories[];
        final CategoryResponse this$0;

        private Category[] getCategories()
        {
            return categories;
        }


        private LocalData()
        {
            this$0 = CategoryResponse.this;
            super();
        }
    }

}
