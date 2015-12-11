// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsDomain, DcsPropBoolean, DcsState, DcsPropInteger, 
//            DcsPropLong, DcsPropString

public static final class S.defaultValue
    implements S.defaultValue
{
    public static final class B extends Enum
        implements DcsPropBoolean
    {

        private static final B $VALUES[];
        public static final B boxShaded;
        public static final B enableNavigationFallbackForBrowseFollows;
        public static final B enableSrpUndoDismissButton;
        public static final B enableSrpUnfollowAcknowledgement;
        public static final B madlanDisplayStrings;
        public static final B refineCharitySupportEnabled;
        public static final B refineExpeditedShippingEnabled;
        public static final B refineReturnsAcceptedEnabled;
        public static final B saasV2PromotedListingsEnabled;
        public static final B spellAutoCorrect;
        public static final B useQuotationMarksForRecourseKeywords;
        public static final B vqLandingPage;
        private final Object defaultValue;
        private final String key;

        public static B valueOf(String s)
        {
            return (B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Search$B, s);
        }

        public static B[] values()
        {
            return (B[])$VALUES.clone();
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
            vqLandingPage = new B("vqLandingPage", 0, true);
            madlanDisplayStrings = new B("madlanDisplayStrings", 1);
            spellAutoCorrect = new B("spellAutoCorrect", 2, true);
            useQuotationMarksForRecourseKeywords = new B("useQuotationMarksForRecourseKeywords", 3, true);
            enableNavigationFallbackForBrowseFollows = new B("enableNavigationFallbackForBrowseFollows", 4, false);
            refineExpeditedShippingEnabled = new B("refineExpeditedShippingEnabled", 5, "${prefCountry} in 'IT,ES'");
            refineReturnsAcceptedEnabled = new B("refineReturnsAcceptedEnabled", 6, "${prefCountry} in 'US' | ${isGbh}");
            refineCharitySupportEnabled = new B("refineCharitySupportEnabled", 7, "${prefCountry} in 'US,CA,DE' | ${isGbh}");
            saasV2PromotedListingsEnabled = new B("saasV2PromotedListingsEnabled", 8);
            enableSrpUnfollowAcknowledgement = new B("enableSrpUnfollowAcknowledgement", 9, true);
            enableSrpUndoDismissButton = new B("enableSrpUndoDismissButton", 10);
            boxShaded = new B("boxShaded", 11);
            $VALUES = (new B[] {
                vqLandingPage, madlanDisplayStrings, spellAutoCorrect, useQuotationMarksForRecourseKeywords, enableNavigationFallbackForBrowseFollows, refineExpeditedShippingEnabled, refineReturnsAcceptedEnabled, refineCharitySupportEnabled, saasV2PromotedListingsEnabled, enableSrpUnfollowAcknowledgement, 
                enableSrpUndoDismissButton, boxShaded
            });
        }

        private B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = s1;
        }

        private B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class I extends Enum
        implements DcsPropInteger
    {

        private static final I $VALUES[] = new I[0];
        private final Object defaultValue;
        private final String key;

        public static I valueOf(String s)
        {
            return (I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Search$I, s);
        }

        public static I[] values()
        {
            return (I[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class L extends Enum
        implements DcsPropLong
    {

        private static final L $VALUES[] = new L[0];
        private final Object defaultValue;
        private final String key;

        public static L valueOf(String s)
        {
            return (L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Search$L, s);
        }

        public static L[] values()
        {
            return (L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class S extends Enum
        implements DcsPropString
    {

        private static final S $VALUES[] = new S[0];
        private final String defaultValue;
        private final String key;

        public static S valueOf(String s)
        {
            return (S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Search$S, s);
        }

        public static S[] values()
        {
            return (S[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = null;
        }

        private S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = s1;
        }
    }


    protected static final String domainName = "search";

    public final List getProperties()
    {
        int i = B.values().length + I.values().length + L.values().length + S.values().length;
        if (i == 0)
        {
            return Collections.emptyList();
        } else
        {
            ArrayList arraylist = new ArrayList(i);
            Collections.addAll(arraylist, B.values());
            Collections.addAll(arraylist, I.values());
            Collections.addAll(arraylist, L.values());
            Collections.addAll(arraylist, S.values());
            return Collections.unmodifiableList(arraylist);
        }
    }

    public S.defaultValue()
    {
    }
}
