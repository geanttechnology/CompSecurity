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
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 4: default 48
    //                   -642369759: 135
    //                   -295659006: 105
    //                   623540754: 90
    //                   1454999376: 120;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_135;
_L6:
        switch (byte0)
        {
        default:
            return super.(s, s1, s2, attributes);

        case 0: // '\0'
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final SearchServiceResponseV2.SellingStatusElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    item.bidCount = i;
                }

            
            {
                this$1 = SearchServiceResponseV2.SellingStatusElement.this;
                super();
            }
            };

        case 1: // '\001'
            item.convertedCurrentPrice = new ItemCurrency();
            return new >(SearchServiceResponseV2.this, item.convertedCurrentPrice);

        case 2: // '\002'
            item.currentPrice = new ItemCurrency();
            return new >(SearchServiceResponseV2.this, item.currentPrice);

        case 3: // '\003'
            return new init>(SearchServiceResponseV2.this, item);
        }
_L4:
        if (s1.equals("bidCount"))
        {
            byte0 = 0;
        }
          goto _L6
_L3:
        if (s1.equals("convertedCurrentPrice"))
        {
            byte0 = 1;
        }
          goto _L6
_L5:
        if (s1.equals("currentPrice"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s1.equals("sellingState"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    public _cls1.this._cls1(EbaySearchListItem ebaysearchlistitem)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        item = ebaysearchlistitem;
    }
}
