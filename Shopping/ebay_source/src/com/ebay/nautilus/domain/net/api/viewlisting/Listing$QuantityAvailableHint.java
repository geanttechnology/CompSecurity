// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final LIMITED $VALUES[];
    public static final LIMITED LIMITED;
    public static final LIMITED MORE_THAN;
    public static final LIMITED NONE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$QuantityAvailableHint, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        MORE_THAN = new <init>("MORE_THAN", 1);
        LIMITED = new <init>("LIMITED", 2);
        $VALUES = (new .VALUES[] {
            NONE, MORE_THAN, LIMITED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
