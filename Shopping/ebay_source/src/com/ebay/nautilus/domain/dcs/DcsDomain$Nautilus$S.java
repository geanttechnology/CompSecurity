// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropString, DcsDomain, DcsState

public static final class defaultValue extends Enum
    implements DcsPropString
{

    private static final zoomUrlPrefix $VALUES[];
    public static final zoomUrlPrefix zoomImageWhitelistSizes;
    public static final zoomUrlPrefix zoomUrlPrefix;
    private final String defaultValue;
    private final String key;

    public static defaultValue valueOf(String s)
    {
        return (defaultValue)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Nautilus$S, s);
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
        zoomImageWhitelistSizes = new <init>("zoomImageWhitelistSizes", 0, "140,200,225,300,400,500,640,960,1600");
        zoomUrlPrefix = new <init>("zoomUrlPrefix", 1);
        $VALUES = (new .VALUES[] {
            zoomImageWhitelistSizes, zoomUrlPrefix
        });
    }

    private (String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("nautilus.").append(name()).toString();
        defaultValue = null;
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("nautilus.").append(name()).toString();
        defaultValue = s1;
    }
}
