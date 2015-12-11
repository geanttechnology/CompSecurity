// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropBoolean, DcsDomain, DcsState

public static final class defaultValue extends Enum
    implements DcsPropBoolean
{

    private static final shopCaseCart $VALUES[];
    public static final shopCaseCart shopCaseCart;
    private final Object defaultValue;
    private final String key;

    public static defaultValue valueOf(String s)
    {
        return (defaultValue)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Payments$B, s);
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
        shopCaseCart = new <init>("shopCaseCart", 0, true);
        $VALUES = (new .VALUES[] {
            shopCaseCart
        });
    }

    private (String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("payments.").append(name()).toString();
        defaultValue = Boolean.FALSE;
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("payments.").append(name()).toString();
        defaultValue = s1;
    }

    private defaultValue(String s, int i, boolean flag)
    {
        super(s, i);
        key = (new StringBuilder()).append("payments.").append(name()).toString();
        defaultValue = Boolean.valueOf(flag);
    }
}
