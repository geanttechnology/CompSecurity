// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetCategoryFeaturesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t.Category
{

    private long categoryId;
    final categoryId this$1;

    public com.ebay.nautilus.kernel.util.t.Category get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("CategoryID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetCategoryFeaturesResponse.RootElement.Category this$2;

                    public void setValue(long l)
                        throws SAXException
                    {
                        categoryId = l;
                    }

            
            {
                this$2 = GetCategoryFeaturesResponse.RootElement.Category.this;
                super();
            }
                };
            }
            if ("UserConsentRequired".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoryFeaturesResponse.RootElement.Category this$2;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        if (flag && categoryId > 0L)
                        {
                            categoriesRequiringConsent.add(Long.valueOf(categoryId));
                        }
                    }

            
            {
                this$2 = GetCategoryFeaturesResponse.RootElement.Category.this;
                super();
            }
                };
            }
        }
        return super.Category(s, s1, s2, attributes);
    }



/*
    static long access$202(_cls2 _pcls2, long l)
    {
        _pcls2.categoryId = l;
        return l;
    }

*/

    private _cls2.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
