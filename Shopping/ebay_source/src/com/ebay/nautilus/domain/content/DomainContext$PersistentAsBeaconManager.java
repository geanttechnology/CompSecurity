// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.AsBeaconManager;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DomainContext, EbayPreferences

private static final class prefs extends AsBeaconManager
{

    static final String ID_KEY = "app_speed_beacon_id";
    final EbayPreferences prefs;

    public int nextIdentifier()
    {
        int i = super.nextIdentifier();
        prefs prefs1 = prefs.edit();
        prefs1.prefs(false, "app_speed_beacon_id", i);
        prefs1.prefs();
        return i;
    }

    (EbayContext ebaycontext)
    {
        prefs = DomainContext.getPreferences(ebaycontext);
        id = prefs.getInt(false, "app_speed_beacon_id", 0);
    }
}
