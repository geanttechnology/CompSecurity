// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class aspectValue extends com.ebay.nautilus.kernel.util.
{

    final com.ebay.common.model.search.t aspectValue;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("aspectvalue".equals(s1))
        {
            return new it>(SearchServiceResponseV2.this, aspectValue);
        }
        if ("matchCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final SearchServiceResponseV2.ValueHistogramElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    aspectValue.count = i;
                }

            
            {
                this$1 = SearchServiceResponseV2.ValueHistogramElement.this;
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
        aspectValue = t;
    }
}
