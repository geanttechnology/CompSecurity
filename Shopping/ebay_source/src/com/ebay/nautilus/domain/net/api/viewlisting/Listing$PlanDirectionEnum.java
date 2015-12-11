// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final REVERSE $VALUES[];
    public static final REVERSE FORWARD;
    public static final REVERSE REVERSE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$PlanDirectionEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FORWARD = new <init>("FORWARD", 0);
        REVERSE = new <init>("REVERSE", 1);
        $VALUES = (new .VALUES[] {
            FORWARD, REVERSE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
