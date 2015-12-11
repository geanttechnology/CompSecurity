// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.notifications:
//            PollServiceListCache

private static final class timestamp extends com.ebay.nautilus.kernel.util.timestamp
{

    private final ArrayList items;
    private final long timestamp;

    public com.ebay.nautilus.kernel.util.timestamp get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Item".equals(s1))
        {
            s = new timestamp();
            items.add(s);
            return new items(s, timestamp);
        } else
        {
            return super.timestamp(s, s1, s2, attributes);
        }
    }

    public (ArrayList arraylist, long l)
    {
        items = arraylist;
        timestamp = l;
    }
}
