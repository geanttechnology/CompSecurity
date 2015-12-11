// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbaySuggestedCategory;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetSuggestedCategoriesResponse

private final class suggestedCategory extends com.ebay.nautilus.kernel.util.y
{
    private final class Category extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CategoryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Category this$4;

                        public void text(String s)
                            throws SAXException
                        {
                            suggestedCategory.name = s;
                        }

            
            {
                this$4 = Category.this;
                super();
            }
                    };
                }
                if ("CategoryID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final Category this$4;

                        public void setValue(long l)
                            throws SAXException
                        {
                            suggestedCategory.id = l;
                        }

            
            {
                this$4 = Category.this;
                super();
            }
                    };
                }
                if ("CategoryParentID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Category this$4;

                        public void text(String s)
                            throws SAXException
                        {
                            suggestedCategory.parentIds.add(s);
                        }

            
            {
                this$4 = Category.this;
                super();
            }
                    };
                }
                if ("CategoryParentName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Category this$4;

                        public void text(String s)
                            throws SAXException
                        {
                            suggestedCategory.parentNames.add(s);
                        }

            
            {
                this$4 = Category.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Category()
        {
            this$3 = GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.this;
            super();
        }

        Category(GetSuggestedCategoriesResponse._cls1 _pcls1)
        {
            this();
        }
    }


    private final EbaySuggestedCategory suggestedCategory = new EbaySuggestedCategory();
    final suggestedCategory this$2;

    public com.ebay.nautilus.kernel.util.y get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Category".equals(s1))
            {
                return new Category(null);
            }
            if ("PercentItemFound".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory this$3;

                    public void setValue(long l)
                        throws SAXException
                    {
                        suggestedCategory.percentItemFound = l;
                    }

            
            {
                this$3 = GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.this;
                super();
            }
                };
            }
        }
        return super.y(s, s1, s2, attributes);
    }


    public _cls1.this._cls3()
    {
        this$2 = this._cls2.this;
        super();
        suggestions.add(suggestedCategory);
    }
}
