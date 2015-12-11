// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.nautilus.domain.dcs.DcsPropString;
import com.ebay.nautilus.domain.dcs.DcsState;

// Referenced classes of package com.ebay.mobile.dcs:
//            Dcs

public static final class defaultValue extends Enum
    implements DcsPropString
{

    private static final tourLink $VALUES[];
    public static final tourLink tourLink;
    private final String defaultValue;
    private final String key;

    public static String valueOf(String s)
    {
        return (String)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Verticals$S, s);
    }

    public static String[] values()
    {
        return (String[])$VALUES.clone();
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
        tourLink = new <init>("tourLink", 0, "http://anywhere.ebay.com/mobile/singlePageSites/0-inapp.html");
        $VALUES = (new .VALUES[] {
            tourLink
        });
    }

    private e(String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("verticals.").append(name()).toString();
        defaultValue = null;
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("verticals.").append(name()).toString();
        defaultValue = s1;
    }
}
