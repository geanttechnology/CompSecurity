// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;


// Referenced classes of package com.ebay.common.net.api.inventory:
//            LookupAvailabilityRequest

public static final class displayString extends Enum
{

    private static final MILE $VALUES[];
    public static final MILE KM;
    public static final MILE MILE;
    private String displayString;

    public static displayString valueOf(String s)
    {
        return (displayString)Enum.valueOf(com/ebay/common/net/api/inventory/LookupAvailabilityRequest$Unit, s);
    }

    public static displayString[] values()
    {
        return (displayString[])$VALUES.clone();
    }

    public String toString()
    {
        return displayString;
    }

    static 
    {
        KM = new <init>("KM", 0, "km");
        MILE = new <init>("MILE", 1, "mi");
        $VALUES = (new .VALUES[] {
            KM, MILE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        displayString = s1;
    }
}
