// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;


// Referenced classes of package com.ebay.common.net.api.local:
//            EbayNowTimeSlotRequest

public static class phoneNumber
{

    public final String name;
    public final String phoneNumber;

    public (String s, String s1)
    {
        name = s;
        if (s1 != null)
        {
            s = s1.replaceAll("\\s+", "");
        } else
        {
            s = null;
        }
        phoneNumber = s;
    }
}
