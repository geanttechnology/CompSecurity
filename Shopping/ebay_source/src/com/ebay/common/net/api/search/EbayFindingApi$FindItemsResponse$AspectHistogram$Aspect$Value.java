// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            EbayFindingApi

static final class v extends com.ebay.nautilus.kernel.util.
{

    private com.ebay.common.model.search.e v;

    v add(ArrayList arraylist, Attributes attributes)
    {
        com.ebay.common.model.search.e e = new com.ebay.common.model.search.e();
        v = e;
        arraylist.add(e);
        v.v = attributes.getValue("valueName");
        return this;
    }

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("count".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final EbayFindingApi.FindItemsResponse.AspectHistogram.Aspect.Value this$0;

                public void setValue(int i)
                    throws SAXException
                {
                    v.count = i;
                }

            
            {
                this$0 = EbayFindingApi.FindItemsResponse.AspectHistogram.Aspect.Value.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }


    _cls1.this._cls0()
    {
        v = null;
    }
}
