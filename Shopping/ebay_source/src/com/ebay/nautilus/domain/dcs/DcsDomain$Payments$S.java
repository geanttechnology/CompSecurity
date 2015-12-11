// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropString, DcsDomain, DcsState

public static final class defaultValue extends Enum
    implements DcsPropString
{

    private static final ccsSupportedVersion $VALUES[];
    public static final ccsSupportedVersion ccsSupportedVersion;
    private final String defaultValue;
    private final String key;

    public static defaultValue valueOf(String s)
    {
        return (defaultValue)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Payments$S, s);
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
        ccsSupportedVersion = new <init>("ccsSupportedVersion", 0, "4.1.0");
        $VALUES = (new .VALUES[] {
            ccsSupportedVersion
        });
    }

    private (String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("payments.").append(name()).toString();
        defaultValue = null;
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("payments.").append(name()).toString();
        defaultValue = s1;
    }
}
