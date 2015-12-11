// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.api.search.wiremodel.SearchResponse;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class category extends com.ebay.nautilus.kernel.util.
{

    final com.ebay.common.model.search.t category;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("category".equals(s1))
        {
            searchResponse.categoryHistogram.categories.add(category);
            return new category(SearchServiceResponseV2.this, category);
        }
        if ("categoryHistogram".equals(s1))
        {
            s = new com.ebay.common.model.search.t.category();
            return new <init>(s);
        }
        if ("matchCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final SearchServiceResponseV2.CategoryHistogramElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    category.count = i;
                }

            
            {
                this$1 = SearchServiceResponseV2.CategoryHistogramElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    public _cls1.this._cls1(com.ebay.common.model.search.t t)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        if (searchResponse.categoryHistogram == null)
        {
            searchResponse.categoryHistogram = new EbayCategoryHistogram();
        }
        category = t;
    }
}
