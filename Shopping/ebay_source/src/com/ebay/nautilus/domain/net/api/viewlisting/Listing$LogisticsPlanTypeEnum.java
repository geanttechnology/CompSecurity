// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final PUDO $VALUES[];
    public static final PUDO EBN;
    public static final PUDO GSP;
    public static final PUDO ISPU;
    public static final PUDO LOCAL_PICKUP;
    public static final PUDO PICKUP_DROP_OFF;
    public static final PUDO PUDO;
    public static final PUDO SHIP_TO_HOME;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$LogisticsPlanTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SHIP_TO_HOME = new <init>("SHIP_TO_HOME", 0);
        ISPU = new <init>("ISPU", 1);
        EBN = new <init>("EBN", 2);
        GSP = new <init>("GSP", 3);
        LOCAL_PICKUP = new <init>("LOCAL_PICKUP", 4);
        PICKUP_DROP_OFF = new <init>("PICKUP_DROP_OFF", 5);
        PUDO = new <init>("PUDO", 6);
        $VALUES = (new .VALUES[] {
            SHIP_TO_HOME, ISPU, EBN, GSP, LOCAL_PICKUP, PICKUP_DROP_OFF, PUDO
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
