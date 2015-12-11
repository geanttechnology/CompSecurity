// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayCategorySummary;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

final class categoryName extends com.ebay.nautilus.kernel.util.
{
    final class CategoryId extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final SavedSearchesApi.FindItemsResponse.SearchResult.Item.PrimaryCategory this$1;

        public void text(String s)
            throws SAXException
        {
            if (response.fillCategories != null)
            {
                category = (EbayCategorySummary)response.fillCategories.remove(s);
                if (response.fillCategories.isEmpty())
                {
                    response.fillCategories = null;
                }
                test();
            }
        }

        CategoryId()
        {
            this$1 = SavedSearchesApi.FindItemsResponse.SearchResult.Item.PrimaryCategory.this;
            super();
        }
    }

    final class CategoryName extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final SavedSearchesApi.FindItemsResponse.SearchResult.Item.PrimaryCategory this$1;

        public void text(String s)
            throws SAXException
        {
            categoryName = s;
            test();
        }

        CategoryName()
        {
            this$1 = SavedSearchesApi.FindItemsResponse.SearchResult.Item.PrimaryCategory.this;
            super();
        }
    }


    private EbayCategorySummary category;
    private String categoryName;
    final categoryName this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("categoryId".equals(s1))
        {
            return new CategoryId();
        }
        if ("categoryName".equals(s1))
        {
            return new CategoryName();
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    void test()
    {
        if (category != null && categoryName != null)
        {
            category.name = categoryName;
        }
    }


/*
    static EbayCategorySummary access$302(CategoryName categoryname, EbayCategorySummary ebaycategorysummary)
    {
        categoryname.category = ebaycategorysummary;
        return ebaycategorysummary;
    }

*/


/*
    static String access$402(category category1, String s)
    {
        category1.categoryName = s;
        return s;
    }

*/

    CategoryName.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
        category = null;
        categoryName = null;
    }
}
