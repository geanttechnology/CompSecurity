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
        if ("convertedShippingCost".equals(s1))
        {
            s = SearchServiceResponseV1.this;
            s1 = item;
            s2 = new ItemCurrency();
            s1.shippingCost = s2;
            return new t>(s, s2);
        }
        if (item.shippingCost == null && "shippingCost".equals(s1))
        {
            s = SearchServiceResponseV1.this;
            s1 = item;
            s2 = new ItemCurrency();
            s1.shippingCost = s2;
            return new t>(s, s2);
        }
        if ("shippingType".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ShippingInfoElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.shippingType = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.ShippingInfoElement.this;
                super();
            }
            };
        }
        if ("shipsToLocation".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ShippingInfoElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.shipToLocation = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.ShippingInfoElement.this;
                super();
            }
            };
        }
        if ("localMerchantOption".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ShippingInfoElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if ("StorePickup".equals(s3))
                    {
                        item.isInStorePickup = true;
                    } else
                    {
                        if ("EbayNow".equals(s3))
                        {
                            item.isEbn = true;
                            return;
                        }
                        if ("LockerPickupOptionAvailable".equals(s3))
                        {
                            item.isPickupAndDropOff = true;
                            return;
                        }
                    }
                }

            
            {
                this$1 = SearchServiceResponseV1.ShippingInfoElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }


    public _cls3.this._cls1(EbaySearchListItem ebaysearchlistitem)
    {
        this$0 = SearchServiceResponseV1.this;
        super();
        item = ebaysearchlistitem;
    }
}
