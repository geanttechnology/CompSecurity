// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetCategoryFeaturesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ootElement
{
    private final class Category extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private long categoryId;
        final GetCategoryFeaturesResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CategoryID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final Category this$2;

                        public void setValue(long l)
                            throws SAXException
                        {
                            categoryId = l;
                        }

            
            {
                this$2 = Category.this;
                super();
            }
                    };
                }
                if ("UserConsentRequired".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Category this$2;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            if (flag && categoryId > 0L)
                            {
                                categoriesRequiringConsent.add(Long.valueOf(categoryId));
                            }
                        }

            
            {
                this$2 = Category.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }



/*
        static long access$202(Category category, long l)
        {
            category.categoryId = l;
            return l;
        }

*/

        private Category()
        {
            this$1 = GetCategoryFeaturesResponse.RootElement.this;
            super();
        }

        Category(GetCategoryFeaturesResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final GetCategoryFeaturesResponse this$0;

    public com.ebay.nautilus.kernel.util.ootElement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(GetCategoryFeaturesResponse.this);
            }
            if ("Timestamp".equals(s1))
            {
                return new TimestampElement(GetCategoryFeaturesResponse.this);
            }
            if ("Category".equals(s1))
            {
                return new Category(null);
            }
        }
        return super.(s, s1, s2, attributes);
    }

    private Category()
    {
        this$0 = GetCategoryFeaturesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
