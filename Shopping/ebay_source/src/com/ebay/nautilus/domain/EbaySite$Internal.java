// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain:
//            EbaySite

private static final class 
{

    static final Map domainToSiteMap;
    static final Map variousToSiteMap;

    static 
    {
        domainToSiteMap = new HashMap();
        variousToSiteMap = new HashMap();
        EbaySite aebaysite[] = new EbaySite[22];
        aebaysite[0] = EbaySite.AU;
        aebaysite[1] = EbaySite.AT;
        aebaysite[2] = EbaySite.NLBE;
        aebaysite[3] = EbaySite.FRBE;
        aebaysite[4] = EbaySite.CA;
        aebaysite[5] = EbaySite.CAFR;
        aebaysite[6] = EbaySite.MOTOR;
        aebaysite[7] = EbaySite.FR;
        aebaysite[8] = EbaySite.DE;
        aebaysite[9] = EbaySite.IN;
        aebaysite[10] = EbaySite.IE;
        aebaysite[11] = EbaySite.IT;
        aebaysite[12] = EbaySite.MY;
        aebaysite[13] = EbaySite.NL;
        aebaysite[14] = EbaySite.PH;
        aebaysite[15] = EbaySite.PL;
        aebaysite[16] = EbaySite.SG;
        aebaysite[17] = EbaySite.ES;
        aebaysite[18] = EbaySite.CH;
        aebaysite[19] = EbaySite.UK;
        aebaysite[20] = EbaySite.RU;
        aebaysite[21] = EbaySite.US;
        int j = aebaysite.length;
        for (int i = 0; i < j; i++)
        {
            EbaySite ebaysite = aebaysite[i];
            domainToSiteMap.put(EbaySite.access$000(ebaysite), ebaysite);
            variousToSiteMap.put(ebaysite.name, ebaysite);
            variousToSiteMap.put(ebaysite.id, ebaysite);
            variousToSiteMap.put(ebaysite.idString, ebaysite);
        }

    }

    private ()
    {
    }
}
