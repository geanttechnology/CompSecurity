// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            EbayFindingApi

static final class item extends com.ebay.nautilus.kernel.util.
{

    private final EbaySearchListItem item;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
        {
            if (item.shippingCost == null && "shippingServiceCost".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.shippingCost = s1;
                return new CurrencyElement(s1, "currencyId", attributes);
            }
            if ("shippingType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final EbayFindingApi.FindItemsResponse.SearchResult.Item.ShippingInfo this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.shippingType = s3;
                    }

            
            {
                this$0 = EbayFindingApi.FindItemsResponse.SearchResult.Item.ShippingInfo.this;
                super();
            }
                };
            }
            if ("shipToLocations".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final EbayFindingApi.FindItemsResponse.SearchResult.Item.ShippingInfo this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.shipToLocation = s3;
                    }

            
            {
                this$0 = EbayFindingApi.FindItemsResponse.SearchResult.Item.ShippingInfo.this;
                super();
            }
                };
            }
        }
        return super.(s, s1, s2, attributes);
    }


    protected _cls2.this._cls0(EbaySearchListItem ebaysearchlistitem)
    {
        item = ebaysearchlistitem;
    }
}
