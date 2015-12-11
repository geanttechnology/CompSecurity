// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;


// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropBoolean, DcsDomain, DcsState

public static final class defaultValue extends Enum
    implements DcsPropBoolean
{

    private static final boxShaded $VALUES[];
    public static final boxShaded boxShaded;
    public static final boxShaded enableNavigationFallbackForBrowseFollows;
    public static final boxShaded enableSrpUndoDismissButton;
    public static final boxShaded enableSrpUnfollowAcknowledgement;
    public static final boxShaded madlanDisplayStrings;
    public static final boxShaded refineCharitySupportEnabled;
    public static final boxShaded refineExpeditedShippingEnabled;
    public static final boxShaded refineReturnsAcceptedEnabled;
    public static final boxShaded saasV2PromotedListingsEnabled;
    public static final boxShaded spellAutoCorrect;
    public static final boxShaded useQuotationMarksForRecourseKeywords;
    public static final boxShaded vqLandingPage;
    private final Object defaultValue;
    private final String key;

    public static defaultValue valueOf(String s)
    {
        return (defaultValue)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Search$B, s);
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
        vqLandingPage = new <init>("vqLandingPage", 0, true);
        madlanDisplayStrings = new <init>("madlanDisplayStrings", 1);
        spellAutoCorrect = new <init>("spellAutoCorrect", 2, true);
        useQuotationMarksForRecourseKeywords = new <init>("useQuotationMarksForRecourseKeywords", 3, true);
        enableNavigationFallbackForBrowseFollows = new <init>("enableNavigationFallbackForBrowseFollows", 4, false);
        refineExpeditedShippingEnabled = new <init>("refineExpeditedShippingEnabled", 5, "${prefCountry} in 'IT,ES'");
        refineReturnsAcceptedEnabled = new <init>("refineReturnsAcceptedEnabled", 6, "${prefCountry} in 'US' | ${isGbh}");
        refineCharitySupportEnabled = new <init>("refineCharitySupportEnabled", 7, "${prefCountry} in 'US,CA,DE' | ${isGbh}");
        saasV2PromotedListingsEnabled = new <init>("saasV2PromotedListingsEnabled", 8);
        enableSrpUnfollowAcknowledgement = new <init>("enableSrpUnfollowAcknowledgement", 9, true);
        enableSrpUndoDismissButton = new <init>("enableSrpUndoDismissButton", 10);
        boxShaded = new <init>("boxShaded", 11);
        $VALUES = (new .VALUES[] {
            vqLandingPage, madlanDisplayStrings, spellAutoCorrect, useQuotationMarksForRecourseKeywords, enableNavigationFallbackForBrowseFollows, refineExpeditedShippingEnabled, refineReturnsAcceptedEnabled, refineCharitySupportEnabled, saasV2PromotedListingsEnabled, enableSrpUnfollowAcknowledgement, 
            enableSrpUndoDismissButton, boxShaded
        });
    }

    private (String s, int i)
    {
        super(s, i);
        key = (new StringBuilder()).append("search.").append(name()).toString();
        defaultValue = Boolean.FALSE;
    }

    private defaultValue(String s, int i, String s1)
    {
        super(s, i);
        key = (new StringBuilder()).append("search.").append(name()).toString();
        defaultValue = s1;
    }

    private defaultValue(String s, int i, boolean flag)
    {
        super(s, i);
        key = (new StringBuilder()).append("search.").append(name()).toString();
        defaultValue = Boolean.valueOf(flag);
    }
}
