// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final DROPOFF $VALUES[];
    public static final DROPOFF DROPOFF;
    public static final DROPOFF PICKUP;
    public static final DROPOFF SHIPPING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$StepTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SHIPPING = new <init>("SHIPPING", 0);
        PICKUP = new <init>("PICKUP", 1);
        DROPOFF = new <init>("DROPOFF", 2);
        $VALUES = (new .VALUES[] {
            SHIPPING, PICKUP, DROPOFF
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
