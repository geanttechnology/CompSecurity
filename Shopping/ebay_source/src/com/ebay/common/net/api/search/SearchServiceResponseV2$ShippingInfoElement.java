// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class item extends com.ebay.nautilus.kernel.util.
{

    final EbaySearchListItem item;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("convertedShippingCost".equals(s1))
        {
            s = SearchServiceResponseV2.this;
            s1 = item;
            s2 = new ItemCurrency();
            s1.shippingCost = s2;
            return new t>(s, s2);
        }
        if (item.shippingCost == null && "shippingCost".equals(s1))
        {
            s = SearchServiceResponseV2.this;
            s1 = item;
            s2 = new ItemCurrency();
            s1.shippingCost = s2;
            return new t>(s, s2);
        }
        if ("shippingType".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ShippingInfoElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.shippingType = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.ShippingInfoElement.this;
                super();
            }
            };
        }
        if ("shipsToLocation".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ShippingInfoElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.shipToLocation = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.ShippingInfoElement.this;
                super();
            }
            };
        }
        if ("localMerchantOption".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ShippingInfoElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    byte byte0 = -1;
                    s3.hashCode();
                    JVM INSTR lookupswitch 3: default 40
                //                               -287833887: 83
                //                               -256988515: 69
                //                               1000546144: 97;
                       goto _L1 _L2 _L3 _L4
_L1:
                    break; /* Loop/switch isn't completed */
_L4:
                    break MISSING_BLOCK_LABEL_97;
_L5:
                    switch (byte0)
                    {
                    default:
                        return;

                    case 0: // '\0'
                        item.isInStorePickup = true;
                        return;

                    case 1: // '\001'
                        item.isEbn = true;
                        return;

                    case 2: // '\002'
                        item.isPickupAndDropOff = true;
                        break;
                    }
                    break MISSING_BLOCK_LABEL_146;
_L3:
                    if (s3.equals("StorePickup"))
                    {
                        byte0 = 0;
                    }
                      goto _L5
_L2:
                    if (s3.equals("EbayNow"))
                    {
                        byte0 = 1;
                    }
                      goto _L5
                    if (s3.equals("LockerPickupOptionAvailable"))
                    {
                        byte0 = 2;
                    }
                      goto _L5
                }

            
            {
                this$1 = SearchServiceResponseV2.ShippingInfoElement.this;
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
        this$0 = SearchServiceResponseV2.this;
        super();
        item = ebaysearchlistitem;
    }
}
