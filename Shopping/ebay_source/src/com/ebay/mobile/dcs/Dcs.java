// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.nautilus.domain.dcs.DcsPropBoolean;
import com.ebay.nautilus.domain.dcs.DcsPropInteger;
import com.ebay.nautilus.domain.dcs.DcsPropLong;
import com.ebay.nautilus.domain.dcs.DcsPropString;
import com.ebay.nautilus.domain.dcs.DcsState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.mobile.dcs:
//            DcsBoolean, DcsInteger, DcsLong, DcsString

public final class Dcs
{
    public static final class Ads
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

        protected static final String domainName = "ads";

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

        public Ads()
        {
        }
    }

    public static final class Ads.B extends Enum
        implements DcsPropBoolean
    {

        private static final Ads.B $VALUES[];
        public static final Ads.B hpShow20223;
        public static final Ads.B hpShow20255;
        public static final Ads.B viShow20188;
        public static final Ads.B viShow20221;
        public static final Ads.B vipShowDirectGoogleTextAd;
        private final Object defaultValue;
        private final String key;

        public static Ads.B valueOf(String s)
        {
            return (Ads.B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Ads$B, s);
        }

        public static Ads.B[] values()
        {
            return (Ads.B[])$VALUES.clone();
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
            hpShow20223 = new Ads.B("hpShow20223", 0);
            hpShow20255 = new Ads.B("hpShow20255", 1);
            viShow20221 = new Ads.B("viShow20221", 2);
            viShow20188 = new Ads.B("viShow20188", 3);
            vipShowDirectGoogleTextAd = new Ads.B("vipShowDirectGoogleTextAd", 4);
            $VALUES = (new Ads.B[] {
                hpShow20223, hpShow20255, viShow20221, viShow20188, vipShowDirectGoogleTextAd
            });
        }

        private Ads.B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("ads.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private Ads.B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("ads.").append(name()).toString();
            defaultValue = s1;
        }

        private Ads.B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("ads.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class Ads.I extends Enum
        implements DcsPropInteger
    {

        private static final Ads.I $VALUES[];
        public static final Ads.I viMaxLimitShown20188;
        private final Object defaultValue;
        private final String key;

        public static Ads.I valueOf(String s)
        {
            return (Ads.I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Ads$I, s);
        }

        public static Ads.I[] values()
        {
            return (Ads.I[])$VALUES.clone();
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
            viMaxLimitShown20188 = new Ads.I("viMaxLimitShown20188", 0, 6);
            $VALUES = (new Ads.I[] {
                viMaxLimitShown20188
            });
        }

        private Ads.I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("ads.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private Ads.I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("ads.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private Ads.I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("ads.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Ads.L extends Enum
        implements DcsPropLong
    {

        private static final Ads.L $VALUES[] = new Ads.L[0];
        private final Object defaultValue;
        private final String key;

        public static Ads.L valueOf(String s)
        {
            return (Ads.L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Ads$L, s);
        }

        public static Ads.L[] values()
        {
            return (Ads.L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Ads.L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("ads.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private Ads.L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("ads.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private Ads.L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("ads.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Ads.S extends Enum
        implements DcsPropString
    {

        private static final Ads.S $VALUES[] = new Ads.S[0];
        private final String defaultValue;
        private final String key;

        public static Ads.S valueOf(String s)
        {
            return (Ads.S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Ads$S, s);
        }

        public static Ads.S[] values()
        {
            return (Ads.S[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Ads.S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("ads.").append(name()).toString();
            defaultValue = null;
        }

        private Ads.S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("ads.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class App
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

        protected static final String domainName = "app";

        public final List getProperties()
        {
            int i = B.values().length + I.values().length + L.values().length + S.values().length + DcsBoolean.values().length + DcsInteger.values().length + DcsLong.values().length + DcsString.values().length;
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
                Collections.addAll(arraylist, DcsBoolean.values());
                Collections.addAll(arraylist, DcsInteger.values());
                Collections.addAll(arraylist, DcsLong.values());
                Collections.addAll(arraylist, DcsString.values());
                return Collections.unmodifiableList(arraylist);
            }
        }

        public App()
        {
        }
    }

    public static final class App.B extends Enum
        implements DcsPropBoolean
    {

        private static final App.B $VALUES[];
        public static final App.B ebayPlus;
        private final Object defaultValue;
        private final String key;

        public static App.B valueOf(String s)
        {
            return (App.B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$App$B, s);
        }

        public static App.B[] values()
        {
            return (App.B[])$VALUES.clone();
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
            ebayPlus = new App.B("ebayPlus", 0);
            $VALUES = (new App.B[] {
                ebayPlus
            });
        }

        private App.B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("app.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private App.B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("app.").append(name()).toString();
            defaultValue = s1;
        }

        private App.B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("app.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class App.I extends Enum
        implements DcsPropInteger
    {

        private static final App.I $VALUES[] = new App.I[0];
        private final Object defaultValue;
        private final String key;

        public static App.I valueOf(String s)
        {
            return (App.I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$App$I, s);
        }

        public static App.I[] values()
        {
            return (App.I[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private App.I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("app.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private App.I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("app.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private App.I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("app.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class App.L extends Enum
        implements DcsPropLong
    {

        private static final App.L $VALUES[] = new App.L[0];
        private final Object defaultValue;
        private final String key;

        public static App.L valueOf(String s)
        {
            return (App.L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$App$L, s);
        }

        public static App.L[] values()
        {
            return (App.L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private App.L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("app.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private App.L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("app.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private App.L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("app.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class App.S extends Enum
        implements DcsPropString
    {

        private static final App.S $VALUES[];
        public static final App.S eBayBuyerProtectionUrlFormat;
        private final String defaultValue;
        private final String key;

        public static App.S valueOf(String s)
        {
            return (App.S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$App$S, s);
        }

        public static App.S[] values()
        {
            return (App.S[])$VALUES.clone();
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
            eBayBuyerProtectionUrlFormat = new App.S("eBayBuyerProtectionUrlFormat", 0);
            $VALUES = (new App.S[] {
                eBayBuyerProtectionUrlFormat
            });
        }

        private App.S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("app.").append(name()).toString();
            defaultValue = null;
        }

        private App.S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("app.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Connect
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

        protected static final String domainName = "connect";

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

        public Connect()
        {
        }
    }

    public static final class Connect.B extends Enum
        implements DcsPropBoolean
    {

        private static final Connect.B $VALUES[];
        public static final Connect.B dealMakerNotification;
        public static final Connect.B eddQuestion;
        public static final Connect.B uciBanner;
        private final Object defaultValue;
        private final String key;

        public static Connect.B valueOf(String s)
        {
            return (Connect.B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Connect$B, s);
        }

        public static Connect.B[] values()
        {
            return (Connect.B[])$VALUES.clone();
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
            eddQuestion = new Connect.B("eddQuestion", 0);
            dealMakerNotification = new Connect.B("dealMakerNotification", 1);
            uciBanner = new Connect.B("uciBanner", 2);
            $VALUES = (new Connect.B[] {
                eddQuestion, dealMakerNotification, uciBanner
            });
        }

        private Connect.B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("connect.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private Connect.B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("connect.").append(name()).toString();
            defaultValue = s1;
        }

        private Connect.B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("connect.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class Connect.I extends Enum
        implements DcsPropInteger
    {

        private static final Connect.I $VALUES[];
        public static final Connect.I uciBannerDelay;
        private final Object defaultValue;
        private final String key;

        public static Connect.I valueOf(String s)
        {
            return (Connect.I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Connect$I, s);
        }

        public static Connect.I[] values()
        {
            return (Connect.I[])$VALUES.clone();
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
            uciBannerDelay = new Connect.I("uciBannerDelay", 0, 7);
            $VALUES = (new Connect.I[] {
                uciBannerDelay
            });
        }

        private Connect.I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("connect.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private Connect.I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("connect.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private Connect.I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("connect.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Connect.L extends Enum
        implements DcsPropLong
    {

        private static final Connect.L $VALUES[] = new Connect.L[0];
        private final Object defaultValue;
        private final String key;

        public static Connect.L valueOf(String s)
        {
            return (Connect.L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Connect$L, s);
        }

        public static Connect.L[] values()
        {
            return (Connect.L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Connect.L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("connect.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private Connect.L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("connect.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private Connect.L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("connect.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Connect.S extends Enum
        implements DcsPropString
    {

        private static final Connect.S $VALUES[];
        public static final Connect.S ocsSsoScope;
        public static final Connect.S ocsUrl;
        public static final Connect.S privacyNoticeUrl;
        public static final Connect.S userAgreementUrl;
        private final String defaultValue;
        private final String key;

        public static Connect.S valueOf(String s)
        {
            return (Connect.S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Connect$S, s);
        }

        public static Connect.S[] values()
        {
            return (Connect.S[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            dcsstate = dcsstate.ebayCountry;
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$mobile$dcs$Dcs$Connect$S[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$dcs$Dcs$Connect$S = new int[Connect.S.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$dcs$Dcs$Connect$S[Connect.S.userAgreementUrl.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$dcs$Dcs$Connect$S[Connect.S.privacyNoticeUrl.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$dcs$Dcs$Connect$S[Connect.S.ocsUrl.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.ebay.mobile.dcs.Dcs.Connect.S[ordinal()])
            {
            default:
                return defaultValue;

            case 1: // '\001'
                return com.ebay.common.view.util.EbayCountryManager.Default.getEulaUrl(dcsstate);

            case 2: // '\002'
                return com.ebay.common.view.util.EbayCountryManager.Default.getPrivacyUrl(dcsstate);

            case 3: // '\003'
                return com.ebay.common.view.util.EbayCountryManager.Default.getOcsUrl(dcsstate);
            }
        }

        public String key()
        {
            return key;
        }

        static 
        {
            userAgreementUrl = new Connect.S("userAgreementUrl", 0);
            privacyNoticeUrl = new Connect.S("privacyNoticeUrl", 1);
            ocsUrl = new Connect.S("ocsUrl", 2);
            ocsSsoScope = new Connect.S("ocsSsoScope", 3, "//EBAYSSO/EBAYCLASSIC");
            $VALUES = (new Connect.S[] {
                userAgreementUrl, privacyNoticeUrl, ocsUrl, ocsSsoScope
            });
        }

        private Connect.S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("connect.").append(name()).toString();
            defaultValue = null;
        }

        private Connect.S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("connect.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Merch
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

        protected static final String domainName = "merch";

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

        public Merch()
        {
        }
    }

    public static final class Merch.B extends Enum
        implements DcsPropBoolean
    {

        private static final Merch.B $VALUES[] = new Merch.B[0];
        private final Object defaultValue;
        private final String key;

        public static Merch.B valueOf(String s)
        {
            return (Merch.B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Merch$B, s);
        }

        public static Merch.B[] values()
        {
            return (Merch.B[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Merch.B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("merch.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private Merch.B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("merch.").append(name()).toString();
            defaultValue = s1;
        }

        private Merch.B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("merch.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class Merch.I extends Enum
        implements DcsPropInteger
    {

        private static final Merch.I $VALUES[] = new Merch.I[0];
        private final Object defaultValue;
        private final String key;

        public static Merch.I valueOf(String s)
        {
            return (Merch.I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Merch$I, s);
        }

        public static Merch.I[] values()
        {
            return (Merch.I[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Merch.I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("merch.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private Merch.I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("merch.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private Merch.I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("merch.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Merch.L extends Enum
        implements DcsPropLong
    {

        private static final Merch.L $VALUES[] = new Merch.L[0];
        private final Object defaultValue;
        private final String key;

        public static Merch.L valueOf(String s)
        {
            return (Merch.L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Merch$L, s);
        }

        public static Merch.L[] values()
        {
            return (Merch.L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Merch.L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("merch.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private Merch.L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("merch.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private Merch.L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("merch.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Merch.S extends Enum
        implements DcsPropString
    {

        private static final Merch.S $VALUES[] = new Merch.S[0];
        private final String defaultValue;
        private final String key;

        public static Merch.S valueOf(String s)
        {
            return (Merch.S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Merch$S, s);
        }

        public static Merch.S[] values()
        {
            return (Merch.S[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Merch.S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("merch.").append(name()).toString();
            defaultValue = null;
        }

        private Merch.S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("merch.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Payments
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

        protected static final String domainName = "payments";

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

        public Payments()
        {
        }
    }

    public static final class Payments.B extends Enum
        implements DcsPropBoolean
    {

        private static final Payments.B $VALUES[] = new Payments.B[0];
        private final Object defaultValue;
        private final String key;

        public static Payments.B valueOf(String s)
        {
            return (Payments.B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Payments$B, s);
        }

        public static Payments.B[] values()
        {
            return (Payments.B[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Payments.B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("payments.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private Payments.B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("payments.").append(name()).toString();
            defaultValue = s1;
        }

        private Payments.B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("payments.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class Payments.I extends Enum
        implements DcsPropInteger
    {

        private static final Payments.I $VALUES[] = new Payments.I[0];
        private final Object defaultValue;
        private final String key;

        public static Payments.I valueOf(String s)
        {
            return (Payments.I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Payments$I, s);
        }

        public static Payments.I[] values()
        {
            return (Payments.I[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Payments.I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("payments.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private Payments.I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("payments.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private Payments.I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("payments.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Payments.L extends Enum
        implements DcsPropLong
    {

        private static final Payments.L $VALUES[] = new Payments.L[0];
        private final Object defaultValue;
        private final String key;

        public static Payments.L valueOf(String s)
        {
            return (Payments.L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Payments$L, s);
        }

        public static Payments.L[] values()
        {
            return (Payments.L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Payments.L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("payments.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private Payments.L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("payments.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private Payments.L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("payments.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Payments.S extends Enum
        implements DcsPropString
    {

        private static final Payments.S $VALUES[] = new Payments.S[0];
        private final String defaultValue;
        private final String key;

        public static Payments.S valueOf(String s)
        {
            return (Payments.S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Payments$S, s);
        }

        public static Payments.S[] values()
        {
            return (Payments.S[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Payments.S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("payments.").append(name()).toString();
            defaultValue = null;
        }

        private Payments.S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("payments.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Search
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

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

        public Search()
        {
        }
    }

    public static final class Search.B extends Enum
        implements DcsPropBoolean
    {

        private static final Search.B $VALUES[] = new Search.B[0];
        private final Object defaultValue;
        private final String key;

        public static Search.B valueOf(String s)
        {
            return (Search.B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Search$B, s);
        }

        public static Search.B[] values()
        {
            return (Search.B[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Search.B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private Search.B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = s1;
        }

        private Search.B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class Search.I extends Enum
        implements DcsPropInteger
    {

        private static final Search.I $VALUES[] = new Search.I[0];
        private final Object defaultValue;
        private final String key;

        public static Search.I valueOf(String s)
        {
            return (Search.I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Search$I, s);
        }

        public static Search.I[] values()
        {
            return (Search.I[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Search.I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private Search.I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private Search.I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Search.L extends Enum
        implements DcsPropLong
    {

        private static final Search.L $VALUES[] = new Search.L[0];
        private final Object defaultValue;
        private final String key;

        public static Search.L valueOf(String s)
        {
            return (Search.L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Search$L, s);
        }

        public static Search.L[] values()
        {
            return (Search.L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Search.L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private Search.L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private Search.L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Search.S extends Enum
        implements DcsPropString
    {

        private static final Search.S $VALUES[] = new Search.S[0];
        private final String defaultValue;
        private final String key;

        public static Search.S valueOf(String s)
        {
            return (Search.S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Search$S, s);
        }

        public static Search.S[] values()
        {
            return (Search.S[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Search.S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = null;
        }

        private Search.S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("search.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Selling
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

        protected static final String domainName = "selling";

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

        public Selling()
        {
        }
    }

    public static final class Selling.B extends Enum
        implements DcsPropBoolean
    {

        private static final Selling.B $VALUES[] = new Selling.B[0];
        private final Object defaultValue;
        private final String key;

        public static Selling.B valueOf(String s)
        {
            return (Selling.B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Selling$B, s);
        }

        public static Selling.B[] values()
        {
            return (Selling.B[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Selling.B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("selling.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private Selling.B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("selling.").append(name()).toString();
            defaultValue = s1;
        }

        private Selling.B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("selling.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class Selling.I extends Enum
        implements DcsPropInteger
    {

        private static final Selling.I $VALUES[] = new Selling.I[0];
        private final Object defaultValue;
        private final String key;

        public static Selling.I valueOf(String s)
        {
            return (Selling.I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Selling$I, s);
        }

        public static Selling.I[] values()
        {
            return (Selling.I[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Selling.I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("selling.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private Selling.I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("selling.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private Selling.I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("selling.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Selling.L extends Enum
        implements DcsPropLong
    {

        private static final Selling.L $VALUES[] = new Selling.L[0];
        private final Object defaultValue;
        private final String key;

        public static Selling.L valueOf(String s)
        {
            return (Selling.L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Selling$L, s);
        }

        public static Selling.L[] values()
        {
            return (Selling.L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Selling.L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("selling.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private Selling.L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("selling.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private Selling.L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("selling.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Selling.S extends Enum
        implements DcsPropString
    {

        private static final Selling.S $VALUES[] = new Selling.S[0];
        private final String defaultValue;
        private final String key;

        public static Selling.S valueOf(String s)
        {
            return (Selling.S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Selling$S, s);
        }

        public static Selling.S[] values()
        {
            return (Selling.S[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Selling.S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("selling.").append(name()).toString();
            defaultValue = null;
        }

        private Selling.S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("selling.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Trust
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

        protected static final String domainName = "trust";

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

        public Trust()
        {
        }
    }

    public static final class Trust.B extends Enum
        implements DcsPropBoolean
    {

        private static final Trust.B $VALUES[] = new Trust.B[0];
        private final Object defaultValue;
        private final String key;

        public static Trust.B valueOf(String s)
        {
            return (Trust.B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Trust$B, s);
        }

        public static Trust.B[] values()
        {
            return (Trust.B[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Trust.B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("trust.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private Trust.B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("trust.").append(name()).toString();
            defaultValue = s1;
        }

        private Trust.B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("trust.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class Trust.I extends Enum
        implements DcsPropInteger
    {

        private static final Trust.I $VALUES[] = new Trust.I[0];
        private final Object defaultValue;
        private final String key;

        public static Trust.I valueOf(String s)
        {
            return (Trust.I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Trust$I, s);
        }

        public static Trust.I[] values()
        {
            return (Trust.I[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Trust.I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("trust.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private Trust.I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("trust.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private Trust.I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("trust.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Trust.L extends Enum
        implements DcsPropLong
    {

        private static final Trust.L $VALUES[] = new Trust.L[0];
        private final Object defaultValue;
        private final String key;

        public static Trust.L valueOf(String s)
        {
            return (Trust.L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Trust$L, s);
        }

        public static Trust.L[] values()
        {
            return (Trust.L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Trust.L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("trust.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private Trust.L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("trust.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private Trust.L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("trust.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Trust.S extends Enum
        implements DcsPropString
    {

        private static final Trust.S $VALUES[] = new Trust.S[0];
        private final String defaultValue;
        private final String key;

        public static Trust.S valueOf(String s)
        {
            return (Trust.S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Trust$S, s);
        }

        public static Trust.S[] values()
        {
            return (Trust.S[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Trust.S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("trust.").append(name()).toString();
            defaultValue = null;
        }

        private Trust.S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("trust.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Verticals
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

        protected static final String domainName = "verticals";

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

        public Verticals()
        {
        }
    }

    public static final class Verticals.B extends Enum
        implements DcsPropBoolean
    {

        private static final Verticals.B $VALUES[];
        public static final Verticals.B buyingOverview;
        public static final Verticals.B collections;
        public static final Verticals.B deals;
        public static final Verticals.B events;
        public static final Verticals.B following;
        public static final Verticals.B lockedPortraitOnPhone;
        public static final Verticals.B notifications;
        public static final Verticals.B rateThisApp;
        public static final Verticals.B recentlyViewedItems;
        public static final Verticals.B rtmCardStyle;
        public static final Verticals.B sellingOverview;
        public static final Verticals.B trendingTopics;
        public static final Verticals.B valet;
        public static final Verticals.B watchedItems;
        private final Object defaultValue;
        private final String key;

        public static Verticals.B valueOf(String s)
        {
            return (Verticals.B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Verticals$B, s);
        }

        public static Verticals.B[] values()
        {
            return (Verticals.B[])$VALUES.clone();
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
            buyingOverview = new Verticals.B("buyingOverview", 0);
            sellingOverview = new Verticals.B("sellingOverview", 1);
            notifications = new Verticals.B("notifications", 2);
            recentlyViewedItems = new Verticals.B("recentlyViewedItems", 3);
            following = new Verticals.B("following", 4);
            watchedItems = new Verticals.B("watchedItems", 5);
            lockedPortraitOnPhone = new Verticals.B("lockedPortraitOnPhone", 6, true);
            deals = new Verticals.B("deals", 7);
            events = new Verticals.B("events", 8);
            collections = new Verticals.B("collections", 9);
            trendingTopics = new Verticals.B("trendingTopics", 10);
            valet = new Verticals.B("valet", 11);
            rateThisApp = new Verticals.B("rateThisApp", 12);
            rtmCardStyle = new Verticals.B("rtmCardStyle", 13);
            $VALUES = (new Verticals.B[] {
                buyingOverview, sellingOverview, notifications, recentlyViewedItems, following, watchedItems, lockedPortraitOnPhone, deals, events, collections, 
                trendingTopics, valet, rateThisApp, rtmCardStyle
            });
        }

        private Verticals.B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private Verticals.B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = s1;
        }

        private Verticals.B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class Verticals.I extends Enum
        implements DcsPropInteger
    {

        private static final Verticals.I $VALUES[];
        public static final Verticals.I overlayVersion;
        public static final Verticals.I rateThisAppLaterDaysDelay;
        private final Object defaultValue;
        private final String key;

        public static Verticals.I valueOf(String s)
        {
            return (Verticals.I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Verticals$I, s);
        }

        public static Verticals.I[] values()
        {
            return (Verticals.I[])$VALUES.clone();
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
            overlayVersion = new Verticals.I("overlayVersion", 0);
            rateThisAppLaterDaysDelay = new Verticals.I("rateThisAppLaterDaysDelay", 1, 15);
            $VALUES = (new Verticals.I[] {
                overlayVersion, rateThisAppLaterDaysDelay
            });
        }

        private Verticals.I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private Verticals.I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private Verticals.I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Verticals.L extends Enum
        implements DcsPropLong
    {

        private static final Verticals.L $VALUES[] = new Verticals.L[0];
        private final Object defaultValue;
        private final String key;

        public static Verticals.L valueOf(String s)
        {
            return (Verticals.L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Verticals$L, s);
        }

        public static Verticals.L[] values()
        {
            return (Verticals.L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Verticals.L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private Verticals.L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private Verticals.L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Verticals.S extends Enum
        implements DcsPropString
    {

        private static final Verticals.S $VALUES[];
        public static final Verticals.S tourLink;
        private final String defaultValue;
        private final String key;

        public static Verticals.S valueOf(String s)
        {
            return (Verticals.S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Verticals$S, s);
        }

        public static Verticals.S[] values()
        {
            return (Verticals.S[])$VALUES.clone();
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
            tourLink = new Verticals.S("tourLink", 0, "http://anywhere.ebay.com/mobile/singlePageSites/0-inapp.html");
            $VALUES = (new Verticals.S[] {
                tourLink
            });
        }

        private Verticals.S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = null;
        }

        private Verticals.S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class ViewItem
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

        protected static final String domainName = "viewitem";

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

        public ViewItem()
        {
        }
    }

    public static final class ViewItem.B extends Enum
        implements DcsPropBoolean
    {

        private static final ViewItem.B $VALUES[];
        public static final ViewItem.B realtimeMtsFlush;
        private final Object defaultValue;
        private final String key;

        public static ViewItem.B valueOf(String s)
        {
            return (ViewItem.B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$ViewItem$B, s);
        }

        public static ViewItem.B[] values()
        {
            return (ViewItem.B[])$VALUES.clone();
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
            realtimeMtsFlush = new ViewItem.B("realtimeMtsFlush", 0);
            $VALUES = (new ViewItem.B[] {
                realtimeMtsFlush
            });
        }

        private ViewItem.B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private ViewItem.B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = s1;
        }

        private ViewItem.B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class ViewItem.I extends Enum
        implements DcsPropInteger
    {

        private static final ViewItem.I $VALUES[] = new ViewItem.I[0];
        private final Object defaultValue;
        private final String key;

        public static ViewItem.I valueOf(String s)
        {
            return (ViewItem.I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$ViewItem$I, s);
        }

        public static ViewItem.I[] values()
        {
            return (ViewItem.I[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private ViewItem.I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private ViewItem.I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private ViewItem.I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class ViewItem.L extends Enum
        implements DcsPropLong
    {

        private static final ViewItem.L $VALUES[] = new ViewItem.L[0];
        private final Object defaultValue;
        private final String key;

        public static ViewItem.L valueOf(String s)
        {
            return (ViewItem.L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$ViewItem$L, s);
        }

        public static ViewItem.L[] values()
        {
            return (ViewItem.L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private ViewItem.L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private ViewItem.L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private ViewItem.L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class ViewItem.S extends Enum
        implements DcsPropString
    {

        private static final ViewItem.S $VALUES[] = new ViewItem.S[0];
        private final String defaultValue;
        private final String key;

        public static ViewItem.S valueOf(String s)
        {
            return (ViewItem.S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$ViewItem$S, s);
        }

        public static ViewItem.S[] values()
        {
            return (ViewItem.S[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private ViewItem.S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = null;
        }

        private ViewItem.S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = s1;
        }
    }


    private Dcs()
    {
    }

    public static com.ebay.nautilus.domain.dcs.DcsDomain.Domain[] getDomains()
    {
        return (new com.ebay.nautilus.domain.dcs.DcsDomain.Domain[] {
            new App(), new Verticals(), new Search(), new ViewItem(), new Selling(), new Ads(), new Connect(), new Trust(), new Merch(), new Payments()
        });
    }
}
