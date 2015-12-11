// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbaySuggestedCategory;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetSuggestedCategoriesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t
{
    private final class SuggestedCategoryArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSuggestedCategoriesResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "SuggestedCategory".equals(s1))
            {
                return new SuggestedCategory();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SuggestedCategoryArray()
        {
            this$1 = GetSuggestedCategoriesResponse.RootElement.this;
            super();
        }

        SuggestedCategoryArray(GetSuggestedCategoriesResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class SuggestedCategoryArray.SuggestedCategory extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySuggestedCategory suggestedCategory = new EbaySuggestedCategory();
        final SuggestedCategoryArray this$2;

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

                        final SuggestedCategoryArray.SuggestedCategory this$3;

                        public void setValue(long l)
                            throws SAXException
                        {
                            suggestedCategory.percentItemFound = l;
                        }

            
            {
                this$3 = SuggestedCategoryArray.SuggestedCategory.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public SuggestedCategoryArray.SuggestedCategory()
        {
            this$2 = SuggestedCategoryArray.this;
            super();
            suggestions.add(suggestedCategory);
        }
    }

    private final class SuggestedCategoryArray.SuggestedCategory.Category extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SuggestedCategoryArray.SuggestedCategory this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CategoryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final SuggestedCategoryArray.SuggestedCategory.Category this$4;

                        public void text(String s)
                            throws SAXException
                        {
                            suggestedCategory.name = s;
                        }

            
            {
                this$4 = SuggestedC