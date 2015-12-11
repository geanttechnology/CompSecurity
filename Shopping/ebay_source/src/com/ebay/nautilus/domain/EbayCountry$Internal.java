// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain:
//            EbayCountry, EbaySite

private static final class 
{

    static final Map instances;

    static 
    {
        instances = new HashMap();
        Iterator iterator = EbaySite.getAvailableInstances().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            EbaySite ebaysite = (EbaySite)iterator.next();
            EbayCountry ebaycountry = new EbayCountry(ebaysite, null);
            instances.put(ebaysite.localeCountry, ebaycountry);
            instances.put(ebaysite.idString, ebaycountry);
            if (EbayCountry.log.ble)
            {
                EbayCountry.log.ble((new StringBuilder()).append("Created new country: ").append(ebaycountry).toString());
            }
        } while (true);
    }

    private ()
    {
    }
}
