// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

class this._cls1 extends com.ebay.nautilus.kernel.util.
{

    final em this$1;

    public void text(String s)
        throws SAXException
    {
        byte byte0;
        byte0 = 0;
        em.listingType = 0;
        s.hashCode();
        JVM INSTR lookupswitch 6: default 76
    //                   -2015334886: 129
    //                   -1626286402: 171
    //                   -607502763: 157
    //                   1002796579: 117
    //                   1377925531: 185
    //                   1711994419: 143;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        byte0 = -1;
          goto _L8
_L5:
        if (!s.equals("Auction")) goto _L1; else goto _L8
_L2:
        if (!s.equals("AdFormat")) goto _L1; else goto _L9
_L9:
        byte0 = 1;
          goto _L8
_L7:
        if (!s.equals("Classified")) goto _L1; else goto _L10
_L10:
        byte0 = 2;
          goto _L8
_L4:
        if (!s.equals("FixedPrice")) goto _L1; else goto _L11
_L11:
        byte0 = 3;
          goto _L8
_L3:
        if (!s.equals("AuctionWithBIN")) goto _L1; else goto _L12
_L12:
        byte0 = 4;
          goto _L8
_L6:
        if (!s.equals("StoreInventory")) goto _L1; else goto _L13
_L13:
        byte0 = 5;
_L8:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            em.listingType = 2;
            return;

        case 1: // '\001'
            em.listingType = 1;
            return;

        case 2: // '\002'
            em.listingType = 4;
            return;

        case 3: // '\003'
            em.listingType = 5;
            return;

        case 4: // '\004'
            em.listingType = 3;
            return;

        case 5: // '\005'
            em.listingType = 6;
            break;
        }
        return;
    }

    Q()
    {
        this$1 = this._cls1.this;
        super();
    }
}
