// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final HIDDEN_STYLE $VALUES[];
    public static final HIDDEN_STYLE BASIC_STYLE;
    public static final HIDDEN_STYLE GREEN_LED;
    public static final HIDDEN_STYLE HIDDEN;
    public static final HIDDEN_STYLE HIDDEN_STYLE;
    public static final HIDDEN_STYLE HONESTY_STYLE;
    public static final HIDDEN_STYLE NO_HIT_COUNTER;
    public static final HIDDEN_STYLE RETRO_STYLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$VisitCounterTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NO_HIT_COUNTER = new <init>("NO_HIT_COUNTER", 0);
        HONESTY_STYLE = new <init>("HONESTY_STYLE", 1);
        GREEN_LED = new <init>("GREEN_LED", 2);
        HIDDEN = new <init>("HIDDEN", 3);
        BASIC_STYLE = new <init>("BASIC_STYLE", 4);
        RETRO_STYLE = new <init>("RETRO_STYLE", 5);
        HIDDEN_STYLE = new <init>("HIDDEN_STYLE", 6);
        $VALUES = (new .VALUES[] {
            NO_HIT_COUNTER, HONESTY_STYLE, GREEN_LED, HIDDEN, BASIC_STYLE, RETRO_STYLE, HIDDEN_STYLE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
