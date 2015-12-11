// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

static final class item extends com.ebay.nautilus.kernel.util.
{

    private final EbaySearchListItem item;

    public void text(String s)
        throws SAXException
    {
        item.sellingState = 0;
        s.length();
        JVM INSTR lookupswitch 5: default 64
    //                   5: 65
    //                   6: 83
    //                   8: 101
    //                   14: 119
    //                   17: 137;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        return;
_L2:
        if (s.equals("Ended"))
        {
            item.sellingState = 3;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (s.equals("Active"))
        {
            item.sellingState = 1;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (s.equals("Canceled"))
        {
            item.sellingState = 2;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (s.equals("EndedWithSales"))
        {
            item.sellingState = 4;
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (s.equals("EndedWithoutSales"))
        {
            item.sellingState = 5;
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
    }

    public (EbaySearchListItem ebaysearchlistitem)
    {
        item = ebaysearchlistitem;
    }
}
