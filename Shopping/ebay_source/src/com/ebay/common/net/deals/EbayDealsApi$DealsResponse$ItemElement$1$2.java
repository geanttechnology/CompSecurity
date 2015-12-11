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

class this._cls1 extends com.ebay.nautilus.kernel.util.._cls1
{

    final  this$1;

    public void text(String s)
        throws SAXException
    {
        .item = s;
    }

    <init>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$1

/* anonymous class */
    class EbayDealsApi.DealsResponse.ItemElement._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.nautilus.kernel.util.SaxHandler.TextElement imageUrlElement;
        final EbayDealsApi.DealsResponse.ItemElement this$0;
        com.ebay.nautilus.kernel.util.SaxHandler.TextElement titleElement;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
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
                s = item;
                s1 = new ItemCurrency();
                s.convertedCurrentPrice = s1;
                return new CurrencyElement(s1, "CurrencyID", attributes);
            }
            if ("RRP".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.origRetailPrice = s1;
                return new CurrencyElement(s1, "CurrencyID", attributes);
            }
            if ("ShippingPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.shippingCost = s1;
                return new CurrencyElement(s1, "CurrencyID", attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

            
            {
                this$0 = EbayDealsApi.DealsResponse.ItemElement.this;
                super();
                titleElement = new EbayDealsApi.DealsResponse.ItemElement._cls1._cls1();
                imageUrlElement = new EbayDealsApi.DealsResponse.ItemElement._cls1._cls2();
            }

        // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$1$1

/* anonymous class */
        class EbayDealsApi.DealsResponse.ItemElement._cls1._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

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
        }

    }

}
