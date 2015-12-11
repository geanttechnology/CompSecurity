// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import java.util.ArrayList;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            EbayFindingApi

static final class itemIds extends com.ebay.nautilus.kernel.util.
{

    private final EbaySearchListItem item;
    private final ArrayList itemIds;

    protected void setValue(long l)
        throws SAXException
    {
        item.id = l;
        itemIds.add(Long.valueOf(l));
    }

    public (EbaySearchListItem ebaysearchlistitem, ArrayList arraylist)
    {
        item = ebaysearchlistitem;
        itemIds = arraylist;
    }
}
