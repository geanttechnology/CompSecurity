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

    final this._cls3 this$3;

    public com.ebay.nautilus.kernel.util.y get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("CategoryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.Category this$4;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.access$300(this$3).name = s3;
                    }

            
            {
                this$4 = GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.Category.this;
                super();
            }
                };
            }
            if ("CategoryID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.Category this$4;

                    public void setValue(long l)
                        throws SAXException
                    {
                        GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.access$300(this$3).id = l;
                    }

            
            {
                this$4 = GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.Category.this;
                super();
            }
                };
            }
            if ("CategoryParentID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.Category this$4;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.access$300(this$3).parentIds.add(s3);
                    }

            
            {
                this$4 = GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.Category.this;
                super();
            }
                };
            }
            if ("CategoryParentName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.Category this$4;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.access$300(this$3).parentNames.add(s3);
                    }

            
            {
                this$4 = GetSuggestedCategoriesResponse.RootElement.SuggestedCategoryArray.SuggestedCategory.Category.this;
                super();
            }
                };
            }
        }
        return super.y(s, s1, s2, attributes);
    }

    private _cls4.this._cls4()
    {
        this$3 = this._cls3.this;
        super();
    }

    this._cls3(this._cls3 _pcls3_1)
    {
        this();
    }
}
