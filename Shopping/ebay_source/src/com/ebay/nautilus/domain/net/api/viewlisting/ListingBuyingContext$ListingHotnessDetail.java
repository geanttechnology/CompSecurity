// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            ListingBuyingContext

public static final class yEnum
    implements Comparable
{

    public int hotnessLevel;
    public String hotnessMessage;
    public int hotnessRank;
    public List properties;
    protected transient Map propertyMap;
    public propertyMap signal;
    public yEnum signalCategory;

    public int compareTo(yEnum yenum)
    {
        return hotnessRank - yenum.hotnessRank;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public Map getPropertyMap()
    {
        if (propertyMap == null)
        {
            propertyMap = new HashMap();
            if (properties != null)
            {
                Iterator iterator = properties.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    com.ebay.nautilus.domain.data.gHotnessDetail ghotnessdetail = (com.ebay.nautilus.domain.data.gHotnessDetail.properties)iterator.next();
                    if (ghotnessdetail != null)
                    {
                        propertyMap.put(ghotnessdetail.propertyMap, ghotnessdetail.propertyMap);
                    }
                } while (true);
            }
        }
        return propertyMap;
    }

    public yEnum()
    {
    }
}
