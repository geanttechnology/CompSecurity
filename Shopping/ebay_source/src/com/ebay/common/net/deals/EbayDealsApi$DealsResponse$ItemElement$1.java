// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.deals;

import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.deals:
//            EbayDealsApi

class em extends com.ebay.nautilus.kernel.util.eUrlElement
{

    com.ebay.nautilus.kernel.util.eUrlElement imageUrlElement;
    final em this$0;
    com.ebay.nautilus.kernel.util.eUrlElement titleElement;

    public com.ebay.nautilus.kernel.util.eUrlElement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Title".equals(s1))
        {
            return titleElement;
        }
        if ("GalleryURL".equals(s1))
        {
            return imageUrlElement;
        }
        if ("ConvertedCurrentPrice".equals(s1))
        {
            s = em;
            s1 = new ItemCurrency();
            s.item = s1;
            return new CurrencyElement(s1, "CurrencyID", attributes);
        }
        if ("RRP".equals(s1))
        {
            s = em;
            s1 = new ItemCurrency();
            s.item = s1;
            return new CurrencyElement(s1, "CurrencyID", attributes);
        }
        if ("ShippingPrice".equals(s1))
        {
            s = em;
            s1 = new ItemCurrency();
            s.item = s1;
            return new CurrencyElement(s1, "CurrencyID", attributes);
        } else
        {
            return super.eUrlElement(s, s1, s2, attributes);
        }
    }

    _cls2.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
        titleElement = new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

            final EbayDealsApi.DealsResponse.ItemElement._cls1 this$1;

            public void text(String s)
                throws SAXException
            {
                item.title = s;
            }

            
            {
                this$1 = EbayDealsApi.DealsResponse.ItemElement._cls1.this;
                super();
            }
        };
        imageUrlElement = new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

            final EbayDealsApi.DealsResponse.ItemElement._cls1 this$1;

            public void text(String s)
                throws SAXException
            {
                item.imageUrl = s;
            }

            
            {
                this$1 = EbayDealsApi.DealsResponse.ItemElement._cls1.this;
                super();
            }
        };
    }
}
