// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

class this._cls1 extends com.ebay.nautilus.kernel.util.
{

    final d this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("id".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final SearchServiceResponseV2.CategoryElement._cls4 this$2;

                protected void setValue(long l)
                    throws SAXException
                {
                    SearchServiceResponseV2.CategoryElement.access$000(this$1).parentId = l;
                }

            
            {
                this$2 = SearchServiceResponseV2.CategoryElement._cls4.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    _cls1.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }
}
