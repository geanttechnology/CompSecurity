// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.Variation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class variation extends com.ebay.nautilus.kernel.util.llingStatus
{

    final variation this$1;
    final Variation variation;

    public com.ebay.nautilus.kernel.util.llingStatus get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "QuantitySold".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetSingleItemResponse.Item.SellingStatus this$2;

                public void setValue(int i)
                    throws SAXException
                {
                    variation.setQuantitySold(i);
                }

            
            {
                this$2 = GetSingleItemResponse.Item.SellingStatus.this;
                super();
            }
            };
        } else
        {
            return super.llingStatus(s, s1, s2, attributes);
        }
    }

    public _cls1.this._cls2(Variation variation1)
    {
        this$1 = this._cls1.this;
        super();
        variation = variation1;
    }
}
