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

private final class <init> extends com.ebay.nautilus.kernel.util.y
{
    private final class SuggestedCategory extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySuggestedCategory suggestedCategory = new EbaySuggestedCategory();
        final GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
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

                        final SuggestedCategory this$3;

                        public void setValue(long l)
                            throws SAXException
                        {
                            suggestedCategory.percentItemFound = l;
                        }

            
            {
                this$3 = SuggestedCategory.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public SuggestedCategory()
        {
            this$2 = GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.this;
            super();
            suggestions.add(suggestedCategory);
        }
    }

    private final class SuggestedCategory.Category extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SuggestedCategory this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CategoryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final SuggestedCategory.Category this$4;

                        public void text(String s)
                            throws SAXException
                        {
                            suggestedCategory.name = s;
                        }

            
            {
                this$4 = SuggestedCategory.Category.this;
                super();
            }
                    };
                }
                if ("CategoryID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final SuggestedCategory.Category this$4;

                        public void setValue(long l)
                            throws SAXException
                        {
                            suggestedCategory.id = l;
                        }

            
            {
                this$4 = SuggestedCategory.Category.this;
                super();
            }
                    };
                }
                if ("CategoryParentID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final SuggestedCategory.Category this$4;

                        public void text(String s)
                            throws SAXException
                        {
                            suggestedCategory.parentIds.add(s);
                        }

            
            {
                this$4 = SuggestedCategory.Category.this;
                super();
            }
                    };
                }
                if ("CategoryParentName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final SuggestedCategory.Category this$4;

                        public void text(String s)
                            throws SAXException
                        {
                            suggestedCategory.parentNames.add(s);
                        }

            
            {
                this$4 = SuggestedCategory.Category.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private SuggestedCategory.Category()
        {
            this$3 = SuggestedCategory.this;
            super();
        }

        SuggestedCategory.Category(GetSuggestedCategoriesResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final SuggestedCategory this$1;

    public com.ebay.nautilus.kernel.util.y get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "SuggestedCategory".equals(s1))
        {
            return new SuggestedCategory();
        } else
        {
            return super.y(s, s1, s2, attributes);
        }
    }

    private SuggestedCategory.suggestedCategory()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
