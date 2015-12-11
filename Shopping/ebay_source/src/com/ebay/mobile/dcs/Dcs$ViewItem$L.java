// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.nautilus.domain.dcs.DcsPropLong;
import com.ebay.nautilus.domain.dcs.DcsState;

// Referenced classes of package com.ebay.mobile.dcs:
//            Dcs

public static final class defaultValue extends Enum
    implements DcsPropLong
{

    private static final key $VALUES[] = new key[0];
    private final Object defaultValue;
    private final String key;

    public static pLong valueOf(String s)
    {
        return (pLong)Enum.valueOf(com/ebay/mobile/dcs/Dcs$ViewItem$L, s);
    }

    public static pLong[] values()
    {
        return (pLong[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        return defaultValue;
    }

    public String key()
    {
        return key;
    }


    private te(String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("viewitem.").append(name()).toString();
        defaultValue = Long.valueOf(0L);
    }

    private defaultValue(String s, int i, long l)
    {
        super(s, i);
        key = (new StringBuilder()).append("viewitem.").append(name()).toString();
        defaultValue = Long.valueOf(l);
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("viewitem.").append(name()).toString();
        defaultValue = s1;
    }
}
