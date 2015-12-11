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
    //                   -1382007273: 90
    //                   -1273988663: 105
    //                   394189381: 120
    //                   502207991: 135;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_135;
_L6:
        switch (byte0)
        {
        default:
            return super.(s, s1, s2, attributes);

        case 0: // '\0'
            item.minPrice = new ItemCurrency();
            return new nit>(SearchServiceResponseV2.this, item.minPrice);

        case 1: // '\001'
            item.convertedMinPrice = new ItemCurrency();
            return new nit>(SearchServiceResponseV2.this, item.convertedMinPrice);

        case 2: // '\002'
            item.maxPrice = new ItemCurrency();
            return new nit>(SearchServiceResponseV2.this, item.maxPrice);

        case 3: // '\003'
            item.convertedMaxPrice = new ItemCurrency();
            break;
        }
        break MISSING_BLOCK_LABEL_263;
_L2:
        if (s1.equals("minPrice"))
        {
            byte0 = 0;
        }
          goto _L6
_L3:
        if (s1.equals("convertedMinPrice"))
        {
            byte0 = 1;
        }
          goto _L6
_L4:
        if (s1.equals("maxPrice"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s1.equals("convertedMaxPrice"))
        {
            byte0 = 3;
        }
          goto _L6
        return new nit>(SearchServiceResponseV2.this, item.convertedMaxPrice);
    }

    public (EbaySearchListItem ebaysearchlistitem)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        item = ebaysearchlistitem;
    }
}
