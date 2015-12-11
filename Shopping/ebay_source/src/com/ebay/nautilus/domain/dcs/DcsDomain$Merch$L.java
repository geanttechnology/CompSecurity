// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropLong, DcsDomain, DcsState

public static final class defaultValue extends Enum
    implements DcsPropLong
{

    private static final key $VALUES[] = new key[0];
    private final Object defaultValue;
    private final String key;

    public static defaultValue valueOf(String s)
    {
        return (defaultValue)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Merch$L, s);
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


    private (String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("merch.").append(name()).toString();
        defaultValue = Long.valueOf(0L);
    }

    private defaultValue(String s, int i, long l)
    {
        super(s, i);
        key = (new StringBuilder()).append("merch.").append(name()).toString();
        defaultValue = Long.valueOf(l);
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("merch.").append(name()).toString();
        defaultValue = s1;
    }
}
