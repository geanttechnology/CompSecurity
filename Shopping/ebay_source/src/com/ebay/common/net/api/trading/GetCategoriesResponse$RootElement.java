// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetCategoriesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t
{
    private final class CategoryArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetCategoriesResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Category".equals(s1))
            {
                return new Category();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private CategoryArray()
        {
            this$1 = GetCategoriesResponse.RootElement.this;
            super();
        }

        CategoryArray(GetCategoriesResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class CategoryArray.Category extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayCategory category = new EbayCategory();
        final CategoryArray this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CategoryID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(long l)
                            throws SAXException
                        {
                            category.id = l;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("CategoryParentID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(long l)
                            throws SAXException
                        {
                            category.parentId = l;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("CategoryLevel".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(int i)
                            throws SAXException
                        {
                            category.level = i;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("CategoryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final CategoryArray.Category this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            category.name = s;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("LeafCategory".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.isLeaf = flag;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("AutoPayEnabled".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.autoPayEnabled = flag;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("B2BVATEnabled".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.b2BVATEnabled = flag;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("BestOfferEnabled".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.bestOfferEnabled = flag;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("Expired".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.expired = flag;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("IntlAutosFixedCat".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.intlAutosFixedCat = flag;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("LSD".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.lsd = flag;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("ORPA".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.orpa = flag;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("ORRA".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.orra = flag;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("SellerGuaranteeEligible".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.sellerGuaranteeEligible = flag;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("Virtual".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.virtual = flag;
                        }

            
            {
                this$3 = CategoryArray.Category.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public CategoryArray.Category()
        {
            this$2 = CategoryArray.this;
            super();
            categories.add(category);
        }
    }


    final GetCategoriesResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(GetCategoriesResponse.this);
            }
            if (!GetCategoriesResponse.access$100(GetCategoriesResponse.this) && "Timestamp".equals(s1))
            {
                return new TimestampElement(GetCategoriesResponse.this);
            }
            if ("CategoryArray".equals(s1))
            {
                return new CategoryArray(null);
            }
        }
        return super.t(s, s1, s2, attributes);
    }

    private CategoryArray()
    {
        this$0 = GetCategoriesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
