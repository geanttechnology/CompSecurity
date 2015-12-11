// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class item extends com.ebay.nautilus.kernel.util.
{

    private final EbaySearchListItem item;
    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("bidCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final SearchServiceResponseV1.SellingStatusElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    item.bidCount = i;
                }

            
            {
                this$1 = SearchServiceResponseV1.SellingStatusElement.this;
                super();
            }
            };
        }
        if ("convertedCurrentPrice".equals(s1))
        {
            item.convertedCurrentPrice = new ItemCurrency();
            return new >(SearchServiceResponseV1.this, item.convertedCurrentPrice);
        }
        if ("currentPrice".equals(s1))
        {
            item.currentPrice = new ItemCurrency();
            return new >(SearchServiceResponseV1.this, item.currentPrice);
        }
        if ("sellingState".equals(s1))
        {
            return new init>(SearchServiceResponseV1.this, item);
        } else
        {
            return super.item(s, s1, s2, attributes);
        }
    }


    public _cls1.this._cls1(EbaySearchListItem ebaysearchlistitem)
    {
        this$0 = SearchServiceResponseV1.this;
        super();
        item = ebaysearchlistitem;
    }
}
