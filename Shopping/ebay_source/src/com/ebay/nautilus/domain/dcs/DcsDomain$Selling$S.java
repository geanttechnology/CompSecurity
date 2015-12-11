// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropString, DcsDomain, DcsState

public static final class defaultValue extends Enum
    implements DcsPropString
{

    private static final carsAndTrucksUrl $VALUES[];
    public static final carsAndTrucksUrl carsAndTrucksUrl;
    public static final carsAndTrucksUrl durationOverrideValueFixedPrice;
    private final String defaultValue;
    private final String key;

    public static defaultValue valueOf(String s)
    {
        return (defaultValue)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Selling$S, s);
    }

    public static defaultValue[] values()
    {
        return (defaultValue[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        return defaultValue;
    }

    public String key()
    {
        return key;
    }

    static 
    {
        durationOverrideValueFixedPrice = new <init>("durationOverrideValueFixedPrice", 0);
        carsAndTrucksUrl = new <init>("carsAndTrucksUrl", 1);
        $VALUES = (new .VALUES[] {
            durationOverrideValueFixedPrice, carsAndTrucksUrl
        });
    }

    private (String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("selling.").append(name()).toString();
        defaultValue = null;
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("selling.").append(name()).toString();
        defaultValue = s1;
    }
}
