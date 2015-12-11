// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class item extends com.ebay.nautilus.kernel.util.
{

    final EbaySearchListItem item;
    final SearchServiceResponseV2 this$0;

    public void text(String s)
        throws SAXException
    {
        int i;
        boolean flag;
        flag = false;
        i = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 44
    //                   2582772: 111
    //                   67099290: 83
    //                   1955883814: 97;
           goto _L1 _L2 _L3 _L4
_L1:
        i;
        JVM INSTR tableswitch 0 2: default 72
    //                   0 125
    //                   1 130
    //                   2 135;
           goto _L5 _L6 _L7 _L8
_L5:
        i = ((flag) ? 1 : 0);
_L9:
        item.sellingState = i;
        return;
_L3:
        if (s.equals("Ended"))
        {
            i = 0;
        }
          goto _L1
_L4:
        if (s.equals("Active"))
        {
            i = 1;
        }
          goto _L1
_L2:
        if (s.equals("Sold"))
        {
            i = 2;
        }
          goto _L1
_L6:
        i = 5;
          goto _L9
_L7:
        i = 1;
          goto _L9
_L8:
        i = 4;
          goto _L9
    }

    public (EbaySearchListItem ebaysearchlistitem)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        item = ebaysearchlistitem;
    }
}
