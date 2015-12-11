// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.analytics:
//            Tracking

public static final class offerType
{

    private static final String RECORD_DELIMITER = ";";
    private static final String VALUE_DELIMITER = "-";
    public final long itemId;
    public final String offerId;
    public final String offerType;

    public static String format(List list)
    {
        if (list == null || list.isEmpty())
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        offerType offertype;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append(offertype.itemId).append("-").append(offertype.offerId).append("-").append(offertype.offerType).append(";"))
        {
            offertype = (offerType)list.next();
        }

        stringbuilder.deleteCharAt(stringbuilder.length() - ";".length());
        return stringbuilder.toString();
    }

    public (long l, String s, String s1)
    {
        itemId = l;
        offerId = s;
        offerType = s1;
    }
}
