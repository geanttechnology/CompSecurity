// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class item extends com.ebay.nautilus.kernel.util.
{

    private final EbaySearchListItem item;
    final SearchServiceResponseV1 this$0;

    public void text(String s)
        throws SAXException
    {
        int i = 0;
        if (!"Ended".equals(s)) goto _L2; else goto _L1
_L1:
        i = 5;
_L4:
        item.sellingState = i;
        return;
_L2:
        if ("Active".equals(s))
        {
            i = 1;
        } else
        if ("Sold".equals(s))
        {
            i = 4;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public (EbaySearchListItem ebaysearchlistitem)
    {
        this$0 = SearchServiceResponseV1.this;
        super();
        item = ebaysearchlistitem;
    }
}
