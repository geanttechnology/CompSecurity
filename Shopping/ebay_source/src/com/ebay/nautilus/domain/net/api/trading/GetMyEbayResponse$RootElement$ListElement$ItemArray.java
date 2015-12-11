// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import java.util.ArrayList;
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private static final class timestamp extends com.ebay.nautilus.kernel.util..ItemArray
{

    private final ArrayList items;
    private final Date timestamp;

    public com.ebay.nautilus.kernel.util..ItemArray get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Item".equals(s1))
        {
            s = new MyEbayListItem();
            items.add(s);
            return new items(s, timestamp);
        } else
        {
            return super.timestamp(s, s1, s2, attributes);
        }
    }

    public (ArrayList arraylist, Date date)
    {
        items = arraylist;
        timestamp = date;
    }
}
