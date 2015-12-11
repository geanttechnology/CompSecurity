// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.nautilus.domain.dcs.DcsPropInteger;
import com.ebay.nautilus.domain.dcs.DcsState;

// Referenced classes of package com.ebay.mobile.dcs:
//            Dcs

public static final class defaultValue extends Enum
    implements DcsPropInteger
{

    private static final key $VALUES[] = new key[0];
    private final Object defaultValue;
    private final String key;

    public static opInteger valueOf(String s)
    {
        return (opInteger)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Selling$I, s);
    }

    public static opInteger[] values()
    {
        return (opInteger[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        return defaultValue;
    }

    public String key()
    {
        return key;
    }


    private ate(String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("selling.").append(name()).toString();
        defaultValue = Integer.valueOf(0);
    }

    private defaultValue(String s, int i, int j)
    {
        super(s, i);
        key = (new StringBuilder()).append("selling.").append(name()).toString();
        defaultValue = Integer.valueOf(j);
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("selling.").append(name()).toString();
        defaultValue = s1;
    }
}
