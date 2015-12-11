// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class Y extends Enum
{

    private static final MONEY_BACK $VALUES[];
    public static final MONEY_BACK MONEY_BACK;

    public static Y valueOf(String s)
    {
        return (Y)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$MinimumRemnantSetTreatmentEnum, s);
    }

    public static Y[] values()
    {
        return (Y[])$VALUES.clone();
    }

    static 
    {
        MONEY_BACK = new <init>("MONEY_BACK", 0);
        $VALUES = (new .VALUES[] {
            MONEY_BACK
        });
    }

    private Y(String s, int i)
    {
        super(s, i);
    }
}
