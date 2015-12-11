// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final NOT_OFFERED $VALUES[];
    public static final NOT_OFFERED INCLUDED;
    public static final NOT_OFFERED NOT_OFFERED;
    public static final NOT_OFFERED OPTIONAL;
    public static final NOT_OFFERED REQUIRED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ShippingInsuranceOptionEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        INCLUDED = new <init>("INCLUDED", 0);
        OPTIONAL = new <init>("OPTIONAL", 1);
        REQUIRED = new <init>("REQUIRED", 2);
        NOT_OFFERED = new <init>("NOT_OFFERED", 3);
        $VALUES = (new .VALUES[] {
            INCLUDED, OPTIONAL, REQUIRED, NOT_OFFERED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
