// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.data.EbayCategory;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetCategoriesResponse

private final class category extends com.ebay.nautilus.kernel.util.y
{

    private final EbayCategory category = new EbayCategory();
    final category this$2;

    public com.ebay.nautilus.kernel.util.y get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("CategoryID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(long l)
                        throws SAXException
                    {
                        category.id = l;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("CategoryParentID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(long l)
                        throws SAXException
                    {
                        category.parentId = l;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("CategoryLevel".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(int i)
                        throws SAXException
                    {
                        category.level = i;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("CategoryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void text(String s3)
                        throws SAXException
                    {
                        category.name = s3;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("LeafCategory".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.isLeaf = flag;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("AutoPayEnabled".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.autoPayEnabled = flag;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("B2BVATEnabled".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.b2BVATEnabled = flag;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("BestOfferEnabled".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.bestOfferEnabled = flag;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("Expired".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.expired = flag;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("IntlAutosFixedCat".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.intlAutosFixedCat = flag;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("LSD".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.lsd = flag;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("ORPA".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.orpa = flag;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("ORRA".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.orra = flag;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("SellerGuaranteeEligible".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.sellerGuaranteeEligible = flag;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("Virtual".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoriesResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.virtual = flag;
                    }

            
            {
                this$3 = GetCategoriesResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
        }
        return super.y(s, s1, s2, attributes);
    }


    public _cls9.this._cls3()
    {
        this$2 = this._cls2.this;
        super();
        categories.add(category);
    }
}
