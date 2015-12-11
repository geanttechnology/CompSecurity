// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.util.HashMap;

// Referenced classes of package com.ebay.common.model:
//            EbaySite

private static final class 
{

    static final HashMap mapSiteIdToSite;

    static 
    {
        EbaySite aebaysite[] = new EbaySite[23];
        aebaysite[0] = EbaySite.AU;
        aebaysite[1] = EbaySite.AT;
        aebaysite[2] = EbaySite.NLBE;
        aebaysite[3] = EbaySite.FRBE;
        aebaysite[4] = EbaySite.CA;
        aebaysite[5] = EbaySite.CAFR;
        aebaysite[6] = EbaySite.MOTOR;
        aebaysite[7] = EbaySite.FR;
        aebaysite[8] = EbaySite.DE;
        aebaysite[9] = EbaySite.HK;
        aebaysite[10] = EbaySite.IN;
        aebaysite[11] = EbaySite.IE;
        aebaysite[12] = EbaySite.IT;
        aebaysite[13] = EbaySite.MY;
        aebaysite[14] = EbaySite.NL;
        aebaysite[15] = EbaySite.PH;
        aebaysite[16] = EbaySite.PL;
        aebaysite[17] = EbaySite.SG;
        aebaysite[18] = EbaySite.ES;
        aebaysite[19] = EbaySite.SE;
        aebaysite[20] = EbaySite.CH;
        aebaysite[21] = EbaySite.UK;
        aebaysite[22] = EbaySite.US;
        HashMap hashmap = new HashMap(aebaysite.length * 3);
        int j = aebaysite.length;
        for (int i = 0; i < j; i++)
        {
            EbaySite ebaysite = aebaysite[i];
            hashmap.put(ebaysite.idString, ebaysite);
            hashmap.put(ebaysite.id, ebaysite);
            hashmap.put(ebaysite.name, ebaysite);
        }

        mapSiteIdToSite = hashmap;
    }

    private ()
    {
    }
}
