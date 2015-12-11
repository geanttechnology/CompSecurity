// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

class this._cls2 extends com.ebay.nautilus.kernel.util.
{

    final is._cls1 this$2;

    protected void setValue(long l)
        throws SAXException
    {
        ss._mth000(_fld1).d = l;
    }

    is._cls1()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/ebay/common/net/api/search/SearchServiceResponseV2$CategoryElement$4

/* anonymous class */
    class SearchServiceResponseV2.CategoryElement._cls4 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchServiceResponseV2.CategoryElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("id".equals(s1))
            {
                return new SearchServiceResponseV2.CategoryElement._cls4._cls1();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$1 = SearchServiceResponseV2.CategoryElement.this;
                super();
            }
    }

}
