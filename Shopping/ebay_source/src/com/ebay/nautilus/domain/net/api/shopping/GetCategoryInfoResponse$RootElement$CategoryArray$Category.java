// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayCategory;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetCategoryInfoResponse

private final class category extends com.ebay.nautilus.kernel.util.ay.Category
{

    private final EbayCategory category = new EbayCategory();
    final category this$2;

    public com.ebay.nautilus.kernel.util.ay.Category get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("CategoryID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetCategoryInfoResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(long l)
                        throws SAXException
                    {
                        category.id = l;
                    }

            
            {
                this$3 = GetCategoryInfoResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("CategoryParentID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetCategoryInfoResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(long l)
                        throws SAXException
                    {
                        category.parentId = l;
                    }

            
            {
                this$3 = GetCategoryInfoResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("CategoryLevel".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetCategoryInfoResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(int i)
                        throws SAXException
                    {
                        category.level = i;
                    }

            
            {
                this$3 = GetCategoryInfoResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("CategoryIDPath".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetCategoryInfoResponse.RootElement.CategoryArray.Category this$3;

                    public void text(String s3)
                        throws SAXException
                    {
                        category.idPath = s3;
                    }

            
            {
                this$3 = GetCategoryInfoResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("CategoryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetCategoryInfoResponse.RootElement.CategoryArray.Category this$3;

                    public void text(String s3)
                        throws SAXException
                    {
                        category.name = s3;
                    }

            
            {
                this$3 = GetCategoryInfoResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("CategoryNamePath".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetCategoryInfoResponse.RootElement.CategoryArray.Category this$3;

                    public void text(String s3)
                        throws SAXException
                    {
                        category.namePath = s3;
                    }

            
            {
                this$3 = GetCategoryInfoResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
            if ("LeafCategory".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetCategoryInfoResponse.RootElement.CategoryArray.Category this$3;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        category.isLeaf = flag;
                    }

            
            {
                this$3 = GetCategoryInfoResponse.RootElement.CategoryArray.Category.this;
                super();
            }
                };
            }
        }
        return super.Category(s, s1, s2, attributes);
    }


    public _cls7.this._cls3()
    {
        this$2 = this._cls2.this;
        super();
        categories.add(category);
    }
}
