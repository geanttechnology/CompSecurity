// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayCategoryHistogram;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

static final class data extends com.ebay.nautilus.kernel.util.
{
    private static class CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected com.ebay.common.model.search.EbayCategoryHistogram.Category category;
        private final FieldElement field;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if ("categoryId".equals(s1))
                {
                    return field.getId();
                }
                if ("categoryName".equals(s1))
                {
                    return field.getName();
                }
                if ("count".equals(s1))
                {
                    return field.getCount();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private CategoryElement()
        {
            category = null;
            field = new FieldElement(null);
        }

        CategoryElement(SavedSearchesApi._cls1 _pcls1)
        {
            this();
        }
    }

    private final class CategoryElement.FieldElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private int field;
        final CategoryElement this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getCount()
        {
            field = 2;
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getId()
        {
            field = 0;
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getName()
        {
            field = 1;
            return this;
        }

        public void text(String s)
            throws SAXException
        {
            switch (field)
            {
            default:
                return;

            case 0: // '\0'
                category.id = Long.parseLong(s);
                return;

            case 1: // '\001'
                category.name = s;
                return;

            case 2: // '\002'
                category.count = Integer.parseInt(s);
                break;
            }
        }

        private CategoryElement.FieldElement()
        {
            this$0 = CategoryElement.this;
            super();
            field = 0;
        }

        CategoryElement.FieldElement(SavedSearchesApi._cls1 _pcls1)
        {
            this();
        }
    }

    private static final class ChildCategoryElement extends CategoryElement
    {

        public final com.ebay.nautilus.kernel.util.SaxHandler.Element add(ArrayList arraylist)
        {
            com.ebay.common.model.search.EbayCategoryHistogram.Category category = new com.ebay.common.model.search.EbayCategoryHistogram.Category();
            this.category = category;
            arraylist.add(category);
            return this;
        }

        private ChildCategoryElement()
        {
            super(null);
        }

        ChildCategoryElement(SavedSearchesApi._cls1 _pcls1)
        {
            this();
        }
    }

    private static final class ParentCategoryElement extends CategoryElement
    {

        private final ChildCategoryElement child;

        public final com.ebay.nautilus.kernel.util.SaxHandler.Element add(ArrayList arraylist)
        {
            com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory = new com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory();
            category = parentcategory;
            arraylist.add(parentcategory);
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s) && "childCategoryHistogram".equals(s1))
            {
                return child.add(((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)category).children);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ParentCategoryElement()
        {
            super(null);
            child = new ChildCategoryElement(null);
        }

        ParentCategoryElement(SavedSearchesApi._cls1 _pcls1)
        {
            this();
        }
    }


    private final ParentCategoryElement child = new ParentCategoryElement(null);
    private final EbayCategoryHistogram data;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/search/v1/services".equals(s) && "categoryHistogram".equals(s1))
        {
            return child.add(data.categories);
        } else
        {
            return super.data(s, s1, s2, attributes);
        }
    }

    public ParentCategoryElement(EbayCategoryHistogram ebaycategoryhistogram)
    {
        super();
        data = ebaycategoryhistogram;
    }
}
