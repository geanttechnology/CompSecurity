// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final VAT $VALUES[];
    public static final VAT Municipal;
    public static final VAT Region;
    public static final VAT State;
    public static final VAT VAT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$TaxTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Municipal = new <init>("Municipal", 0);
        State = new <init>("State", 1);
        Region = new <init>("Region", 2);
        VAT = new <init>("VAT", 3);
        $VALUES = (new .VALUES[] {
            Municipal, State, Region, VAT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
