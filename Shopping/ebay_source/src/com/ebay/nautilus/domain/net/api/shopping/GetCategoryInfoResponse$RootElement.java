// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetCategoryInfoResponse

private final class <init> extends com.ebay.nautilus.kernel.util.RootElement
{
    private final class CategoryArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetCategoryInfoResponse.RootElement this$1;

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
            this$1 = GetCategoryInfoResponse.RootElement.this;
            super();
        }

        CategoryArray(GetCategoryInfoResponse._cls1 _pcls1)
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
                if ("CategoryIDPath".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final CategoryArray.Category this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            category.idPath = s;
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
                if ("CategoryNamePath".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final CategoryArray.Category this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            category.namePath = s;
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


    final GetCategoryInfoResponse this$0;

    public com.ebay.nautilus.kernel.util.RootElement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(GetCategoryInfoResponse.this);
            }
            if ("Timestamp".equals(s1))
            {
                return new TimestampElement(GetCategoryInfoResponse.this);
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(GetCategoryInfoResponse.this, "urn:ebay:apis:eBLBaseComponents");
            }
            if ("CategoryArray".equals(s1))
            {
                return new CategoryArray(null);
            }
        }
        return super._mth1(s, s1, s2, attributes);
    }

    private CategoryArray()
    {
        this$0 = GetCategoryInfoResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
