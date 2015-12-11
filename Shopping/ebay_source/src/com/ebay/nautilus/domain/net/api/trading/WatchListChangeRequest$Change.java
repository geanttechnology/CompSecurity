// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.EbayItemIdAndVariationSpecifics;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            WatchListChangeRequest

public static abstract class operation
{

    final String operation;

    public static transient operation addItems(long al[])
    {
        return create(true, al);
    }

    public static transient create addItems(EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
    {
        return create(true, aebayitemidandvariationspecifics);
    }

    public static transient create create(boolean flag, long al[])
    {
        if (al == null || al.length == 0)
        {
            throw new IllegalArgumentException("ids is invalid");
        } else
        {
            return new it>(flag, al);
        }
    }

    public static transient it> create(boolean flag, EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
    {
        if (aebayitemidandvariationspecifics == null || aebayitemidandvariationspecifics.length == 0)
        {
            throw new IllegalArgumentException("items is invalid");
        } else
        {
            return new ons(flag, aebayitemidandvariationspecifics);
        }
    }

    public static ons removeAllItems()
    {
        return new ll();
    }

    public static transient ll removeItems(long al[])
    {
        return create(false, al);
    }

    public static transient create removeItems(EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
    {
        return create(false, aebayitemidandvariationspecifics);
    }

    abstract void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException;

    ll(boolean flag)
    {
        String s;
        if (flag)
        {
            s = "AddToWatchList";
        } else
        {
            s = "RemoveFromWatchList";
        }
        operation = s;
    }
}
