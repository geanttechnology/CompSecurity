// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelDetails

public static final class  extends Enum
{

    private static final SIG_CON $VALUES[];
    public static final SIG_CON SIG_CON;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/ShippingLabelDetails$ServiceFeature, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SIG_CON = new <init>("SIG_CON", 0);
        $VALUES = (new .VALUES[] {
            SIG_CON
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
