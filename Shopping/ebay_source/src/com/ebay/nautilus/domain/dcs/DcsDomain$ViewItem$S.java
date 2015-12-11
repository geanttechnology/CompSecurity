// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropString, DcsDomain, DcsState

public static final class defaultValue extends Enum
    implements DcsPropString
{

    private static final proofPointsUrlFormat $VALUES[];
    public static final proofPointsUrlFormat ebayPlusReturnsLearnMore;
    public static final proofPointsUrlFormat ebayPlusSignupLink;
    public static final proofPointsUrlFormat proofPointsUrlFormat;
    private final String defaultValue;
    private final String key;

    public static defaultValue valueOf(String s)
    {
        return (defaultValue)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$ViewItem$S, s);
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
        ebayPlusReturnsLearnMore = new <init>("ebayPlusReturnsLearnMore", 0, "http://pages.ebay.de/help/pay/ebay-plus-returns.html?rmvhdr=true");
        ebayPlusSignupLink = new <init>("ebayPlusSignupLink", 1, "https://www.signup.ebayplus.ebay.de/eplusweb/value");
        proofPointsUrlFormat = new <init>("proofPointsUrlFormat", 2);
        $VALUES = (new .VALUES[] {
            ebayPlusReturnsLearnMore, ebayPlusSignupLink, proofPointsUrlFormat
        });
    }

    private (String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("viewitem.").append(name()).toString();
        defaultValue = null;
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("viewitem.").append(name()).toString();
        defaultValue = s1;
    }
}
