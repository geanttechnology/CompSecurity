// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            ApsGetReminders

final class item extends com.ebay.nautilus.kernel.util.em
{

    private final MyEbayListItem item;
    final item this$1;

    public void text(String s)
        throws SAXException
    {
        item.listingType = 0;
        s.length();
        JVM INSTR tableswitch 7 16: default 68
    //                   7 69
    //                   8 87
    //                   9 68
    //                   10 105
    //                   11 68
    //                   12 68
    //                   13 68
    //                   14 141
    //                   15 68
    //                   16 196;
           goto _L1 _L2 _L3 _L1 _L4 _L1 _L1 _L1 _L5 _L1 _L6
_L1:
        return;
_L2:
        if (s.equals("Chinese"))
        {
            item.listingType = 2;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (s.equals("AdFormat"))
        {
            item.listingType = 1;
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (s.equals("Classified"))
        {
            item.listingType = 4;
            return;
        }
        if (s.equals("FixedPrice"))
        {
            item.listingType = 5;
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        if (s.equals("AuctionWithBIN"))
        {
            item.listingType = 3;
            return;
        }
        if (s.equals("FixedPriceItem"))
        {
            item.listingType = 5;
            return;
        }
        if (s.equals("StoreInventory"))
        {
            item.listingType = 6;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (s.equals("StoresFixedPrice"))
        {
            item.listingType = 5;
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public (MyEbayListItem myebaylistitem)
    {
        this$1 = this._cls1.this;
        super();
        item = myebaylistitem;
    }
}
