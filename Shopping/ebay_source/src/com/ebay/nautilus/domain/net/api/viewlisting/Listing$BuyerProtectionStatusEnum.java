// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final NO_COVERAGE $VALUES[];
    public static final NO_COVERAGE ELIGIBLE;
    public static final NO_COVERAGE NOT_ELIGIBLE;
    public static final NO_COVERAGE NO_COVERAGE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$BuyerProtectionStatusEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ELIGIBLE = new <init>("ELIGIBLE", 0);
        NOT_ELIGIBLE = new <init>("NOT_ELIGIBLE", 1);
        NO_COVERAGE = new <init>("NO_COVERAGE", 2);
        $VALUES = (new .VALUES[] {
            ELIGIBLE, NOT_ELIGIBLE, NO_COVERAGE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
