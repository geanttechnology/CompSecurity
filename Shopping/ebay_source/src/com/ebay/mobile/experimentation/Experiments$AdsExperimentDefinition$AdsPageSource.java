// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.experimentation;


// Referenced classes of package com.ebay.mobile.experimentation:
//            Experiments

public static final class  extends Enum
{

    private static final AdsOnVip $VALUES[];
    public static final AdsOnVip AdsOnHp;
    public static final AdsOnVip AdsOnSrp;
    public static final AdsOnVip AdsOnVip;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/experimentation/Experiments$AdsExperimentDefinition$AdsPageSource, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AdsOnHp = new <init>("AdsOnHp", 0);
        AdsOnSrp = new <init>("AdsOnSrp", 1);
        AdsOnVip = new <init>("AdsOnVip", 2);
        $VALUES = (new .VALUES[] {
            AdsOnHp, AdsOnSrp, AdsOnVip
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
