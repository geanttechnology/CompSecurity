// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.EbaySite;
import java.util.HashMap;
import java.util.TimeZone;

public class SiteTimeZones
{

    private static final String SITE_ID_CAFR = "210";
    private static final String SITE_ID_IE = "205";
    private static final String ZONE_0 = "America/Los_Angeles";
    private static final String ZONE_1 = "Europe/London";
    private static final String ZONE_17 = "Asia/Calcutta";
    private static final String ZONE_22 = "Asia/Kuala_Lumpur";
    private static final String ZONE_26 = "Asia/Manila";
    private static final String ZONE_3 = "America/Montreal";
    private static final String ZONE_31 = "Asia/Singapore";
    private static final String ZONE_38 = "America/Montreal";
    private static final String ZONE_4 = "Australia/Sydney";
    private static final String ZONE_5 = "Europe/Berlin";
    private static final String ZONE_6 = "Europe/Paris";
    private static final String ZONE_7 = "Europe/Paris";
    private static final String ZONE_9 = "Europe/Madrid";
    private static final HashMap zones;

    public SiteTimeZones()
    {
    }

    public static TimeZone fromSiteId(String s)
    {
        return TimeZone.getTimeZone((String)zones.get(s));
    }

    static 
    {
        zones = new HashMap();
        zones.put(EbaySite.AU.id, "Australia/Sydney");
        zones.put(EbaySite.AT.id, "Europe/Berlin");
        zones.put(EbaySite.NLBE.id, "Europe/Paris");
        zones.put(EbaySite.FRBE.id, "Europe/Paris");
        zones.put(EbaySite.CA.id, "America/Montreal");
        zones.put("210", "America/Montreal");
        zones.put(EbaySite.FR.id, "Europe/Paris");
        zones.put(EbaySite.DE.id, "Europe/Berlin");
        zones.put("205", "Europe/London");
        zones.put(EbaySite.IT.id, "Europe/Paris");
        zones.put(EbaySite.NL.id, "Europe/Paris");
        zones.put(EbaySite.ES.id, "Europe/Madrid");
        zones.put(EbaySite.CH.id, "Europe/Berlin");
        zones.put(EbaySite.UK.id, "Europe/London");
        zones.put(EbaySite.US.id, "America/Los_Angeles");
        zones.put(EbaySite.MOTOR.id, "America/Los_Angeles");
        zones.put(EbaySite.IN.id, "Asia/Calcutta");
        zones.put(EbaySite.SG.id, "Asia/Singapore");
        zones.put(EbaySite.MY.id, "Asia/Kuala_Lumpur");
        zones.put(EbaySite.PH.id, "Asia/Manila");
    }
}
