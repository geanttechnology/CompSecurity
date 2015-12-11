// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.List;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class longs extends com.ebay.nautilus.kernel.util.
{

    private final List longs;
    final SearchServiceResponseV2 this$0;

    public void text(String s)
        throws SAXException
    {
        s = s.split(",");
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            String s1 = s[i];
            longs.add(Long.valueOf(Long.parseLong(s1)));
        }

    }

    (List list)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        if (list == null)
        {
            throw new IllegalArgumentException("List of longs must not be null");
        } else
        {
            longs = list;
            return;
        }
    }
}
