// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropBoolean, DcsDomain, DcsState

public static final class defaultValue extends Enum
    implements DcsPropBoolean
{

    private static final categoryServiceLimitByLevel $VALUES[];
    public static final categoryServiceLimitByLevel categoryServiceLimitByLevel;
    private final Object defaultValue;
    private final String key;

    public static defaultValue valueOf(String s)
    {
        return (defaultValue)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Verticals$B, s);
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
        categoryServiceLimitByLevel = new <init>("categoryServiceLimitByLevel", 0, true);
        $VALUES = (new .VALUES[] {
            categoryServiceLimitByLevel
        });
    }

    private (String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("verticals.").append(name()).toString();
        defaultValue = Boolean.FALSE;
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("verticals.").append(name()).toString();
        defaultValue = s1;
    }

    private defaultValue(String s, int i, boolean flag)
    {
        super(s, i);
        key = (new StringBuilder()).append("verticals.").append(name()).toString();
        defaultValue = Boolean.valueOf(flag);
    }
}
