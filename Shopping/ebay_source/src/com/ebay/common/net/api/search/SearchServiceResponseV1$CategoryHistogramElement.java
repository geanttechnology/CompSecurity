// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayCategoryHistogram;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class category extends com.ebay.nautilus.kernel.util.
{

    private final com.ebay.common.model.search.t category;
    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("category".equals(s1))
        {
            SearchServiceResponseV1.access$1100(SearchServiceResponseV1.this).categories.add(category);
            return new category(SearchServiceResponseV1.this, category);
        }
        if ("categoryHistogram".equals(s1))
        {
            s = new com.ebay.common.model.search.t.category();
            return new <init>(s);
        }
        if ("matchCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final SearchServiceResponseV1.CategoryHistogramElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    category.count = i;
                }

            
            {
                this$1 = SearchServiceResponseV1.CategoryHistogramElement.this;
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
        this$0 = SearchServiceResponseV1.this;
        super();
        if (SearchServiceResponseV1.access$1100(SearchServiceResponseV1.this) == null)
        {
            SearchServiceResponseV1.access$1102(SearchServiceResponseV1.this, new EbayCategoryHistogram());
        }
        category = t;
    }
}
