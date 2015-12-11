// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropBoolean, DcsState, DcsPropInteger, DcsPropLong, 
//            DcsPropString, DcsNautilusBoolean, DcsNautilusInteger, DcsNautilusLong, 
//            DcsNautilusString

public final class DcsDomain
{
    public static final class Ads
        implements Domain
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
        public static final Ads.B srpShow19791;
        public static final Ads.B srpShowDirectGoogleTextAd;
        private final Object defaultValue;
        private final String key;

        public static Ads.B valueOf(String s)
        {
            return (Ads.B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Ads$B, s);
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
            srpShow19791 = new Ads.B("srpShow19791", 0, false);
            srpShowDirectGoogleTextAd = new Ads.B("srpShowDirectGoogleTextAd", 1, false);
            $VALUES = (new Ads.B[] {
                srpShow19791, srpShowDirectGoogleTextAd
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
        public static final Ads.I srpMaxLimitShown19791;
        public static final Ads.I srpThresholdResultCount19791;
        private final Object defaultValue;
        private final String key;

        public static Ads.I valueOf(String s)
        {
            return (Ads.I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Ads$I, s);
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
            srpThresholdResultCount19791 = new Ads.I("srpThresholdResultCount19791", 0, 50);
            srpMaxLimitShown19791 = new Ads.I("srpMaxLimitShown19791", 1, 10);
            $VALUES = (new Ads.I[] {
                srpThresholdResultCount19791, srpMaxLimitShown19791
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
            return (Ads.L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Ads$L, s);
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
            return (Ads.S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Ads$S, s);
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

    public static final class Connect
        implements Domain
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
        public static final Connect.B uciNotification;
        private final Object defaultValue;
        private final String key;

        public static Connect.B valueOf(String s)
        {
            return (Connect.B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Connect$B, s);
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
            uciNotification = new Connect.B("uciNotification", 0);
            $VALUES = (new Connect.B[] {
                uciNotification
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

        private static final Connect.I $VALUES[] = new Connect.I[0];
        private final Object defaultValue;
        private final String key;

        public static Connect.I valueOf(String s)
        {
            return (Connect.I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Connect$I, s);
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
            return (Connect.L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Connect$L, s);
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

        private static final Connect.S $VALUES[] = new Connect.S[0];
        private final String defaultValue;
        private final String key;

        public static Connect.S valueOf(String s)
        {
            return (Connect.S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Connect$S, s);
        }

        public static Connect.S[] values()
        {
            return (Connect.S[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
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

    public static interface Domain
    {

        public abstract List getProperties();
    }

    public static final class Merch
        implements Domain
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
            return (Merch.B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Merch$B, s);
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
            return (Merch.I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Merch$I, s);
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
            return (Merch.L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Merch$L, s);
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
            return (Merch.S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Merch$S, s);
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

    public static final class Nautilus
        implements Domain
    {

        protected static final String domainName = "nautilus";

        public final List getProperties()
        {
            int i = B.values().length + I.values().length + L.values().length + S.values().length + DcsNautilusBoolean.values().length + DcsNautilusInteger.values().length + DcsNautilusLong.values().length + DcsNautilusString.values().length;
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
                Collections.addAll(arraylist, DcsNautilusBoolean.values());
                Collections.addAll(arraylist, DcsNautilusInteger.values());
                Collections.addAll(arraylist, DcsNautilusLong.values());
                Collections.addAll(arraylist, DcsNautilusString.values());
                return Collections.unmodifiableList(arraylist);
            }
        }

        public Nautilus()
        {
        }
    }

    public static final class Nautilus.B extends Enum
        implements DcsPropBoolean
    {

        private static final Nautilus.B $VALUES[];
        public static final Nautilus.B appSpeed;
        public static final Nautilus.B invalidIafTokenValidation;
        private final Object defaultValue;
        private final String key;

        public static Nautilus.B valueOf(String s)
        {
            return (Nautilus.B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Nautilus$B, s);
        }

        public static Nautilus.B[] values()
        {
            return (Nautilus.B[])$VALUES.clone();
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
            invalidIafTokenValidation = new Nautilus.B("invalidIafTokenValidation", 0);
            appSpeed = new Nautilus.B("appSpeed", 1);
            $VALUES = (new Nautilus.B[] {
                invalidIafTokenValidation, appSpeed
            });
        }

        private Nautilus.B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("nautilus.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private Nautilus.B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("nautilus.").append(name()).toString();
            defaultValue = s1;
        }

        private Nautilus.B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("nautilus.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class Nautilus.I extends Enum
        implements DcsPropInteger
    {

        private static final Nautilus.I $VALUES[] = new Nautilus.I[0];
        private final Object defaultValue;
        private final String key;

        public static Nautilus.I valueOf(String s)
        {
            return (Nautilus.I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Nautilus$I, s);
        }

        public static Nautilus.I[] values()
        {
            return (Nautilus.I[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Nautilus.I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("nautilus.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private Nautilus.I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("nautilus.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private Nautilus.I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("nautilus.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Nautilus.L extends Enum
        implements DcsPropLong
    {

        private static final Nautilus.L $VALUES[] = new Nautilus.L[0];
        private final Object defaultValue;
        private final String key;

        public static Nautilus.L valueOf(String s)
        {
            return (Nautilus.L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Nautilus$L, s);
        }

        public static Nautilus.L[] values()
        {
            return (Nautilus.L[])$VALUES.clone();
        }

        public Object defaultValue(DcsState dcsstate)
        {
            return defaultValue;
        }

        public String key()
        {
            return key;
        }


        private Nautilus.L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("nautilus.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private Nautilus.L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("nautilus.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private Nautilus.L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("nautilus.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Nautilus.S extends Enum
        implements DcsPropString
    {

        private static final Nautilus.S $VALUES[];
        public static final Nautilus.S zoomImageWhitelistSizes;
        public static final Nautilus.S zoomUrlPrefix;
        private final String defaultValue;
        private final String key;

        public static Nautilus.S valueOf(String s)
        {
            return (Nautilus.S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Nautilus$S, s);
        }

        public static Nautilus.S[] values()
        {
            return (Nautilus.S[])$VALUES.clone();
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
            zoomImageWhitelistSizes = new Nautilus.S("zoomImageWhitelistSizes", 0, "140,200,225,300,400,500,640,960,1600");
            zoomUrlPrefix = new Nautilus.S("zoomUrlPrefix", 1);
            $VALUES = (new Nautilus.S[] {
                zoomImageWhitelistSizes, zoomUrlPrefix
            });
        }

        private Nautilus.S(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("nautilus.").append(name()).toString();
            defaultValue = null;
        }

        private Nautilus.S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("nautilus.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class Payments
        implements Domain
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

        private static final Payments.B $VALUES[];
        public static final Payments.B shopCaseCart;
        private final Object defaultValue;
        private final String key;

        public static Payments.B valueOf(String s)
        {
            return (Payments.B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Payments$B, s);
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

        static 
        {
            shopCaseCart = new Payments.B("shopCaseCart", 0, true);
            $VALUES = (new Payments.B[] {
                shopCaseCart
            });
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
            return (Payments.I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Payments$I, s);
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
            return (Payments.L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Payments$L, s);
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

        private static final Payments.S $VALUES[];
        public static final Payments.S ccsSupportedVersion;
        private final String defaultValue;
        private final String key;

        public static Payments.S valueOf(String s)
        {
            return (Payments.S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Payments$S, s);
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

        static 
        {
            ccsSupportedVersion = new Payments.S("ccsSupportedVersion", 0, "4.1.0");
            $VALUES = (new Payments.S[] {
                ccsSupportedVersion
            });
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
        implements Domain
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

        private static final Search.B $VALUES[];
        public static final Search.B boxShaded;
        public static final Search.B enableNavigationFallbackForBrowseFollows;
        public static final Search.B enableSrpUndoDismissButton;
        public static final Search.B enableSrpUnfollowAcknowledgement;
        public static final Search.B madlanDisplayStrings;
        public static final Search.B refineCharitySupportEnabled;
        public static final Search.B refineExpeditedShippingEnabled;
        public static final Search.B refineReturnsAcceptedEnabled;
        public static final Search.B saasV2PromotedListingsEnabled;
        public static final Search.B spellAutoCorrect;
        public static final Search.B useQuotationMarksForRecourseKeywords;
        public static final Search.B vqLandingPage;
        private final Object defaultValue;
        private final String key;

        public static Search.B valueOf(String s)
        {
            return (Search.B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Search$B, s);
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

        static 
        {
            vqLandingPage = new Search.B("vqLandingPage", 0, true);
            madlanDisplayStrings = new Search.B("madlanDisplayStrings", 1);
            spellAutoCorrect = new Search.B("spellAutoCorrect", 2, true);
            useQuotationMarksForRecourseKeywords = new Search.B("useQuotationMarksForRecourseKeywords", 3, true);
            enableNavigationFallbackForBrowseFollows = new Search.B("enableNavigationFallbackForBrowseFollows", 4, false);
            refineExpeditedShippingEnabled = new Search.B("refineExpeditedShippingEnabled", 5, "${prefCountry} in 'IT,ES'");
            refineReturnsAcceptedEnabled = new Search.B("refineReturnsAcceptedEnabled", 6, "${prefCountry} in 'US' | ${isGbh}");
            refineCharitySupportEnabled = new Search.B("refineCharitySupportEnabled", 7, "${prefCountry} in 'US,CA,DE' | ${isGbh}");
            saasV2PromotedListingsEnabled = new Search.B("saasV2PromotedListingsEnabled", 8);
            enableSrpUnfollowAcknowledgement = new Search.B("enableSrpUnfollowAcknowledgement", 9, true);
            enableSrpUndoDismissButton = new Search.B("enableSrpUndoDismissButton", 10);
            boxShaded = new Search.B("boxShaded", 11);
            $VALUES = (new Search.B[] {
                vqLandingPage, madlanDisplayStrings, spellAutoCorrect, useQuotationMarksForRecourseKeywords, enableNavigationFallbackForBrowseFollows, refineExpeditedShippingEnabled, refineReturnsAcceptedEnabled, refineCharitySupportEnabled, saasV2PromotedListingsEnabled, enableSrpUnfollowAcknowledgement, 
                enableSrpUndoDismissButton, boxShaded
            });
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
            return (Search.I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Search$I, s);
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
            return (Search.L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Search$L, s);
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
            return (Search.S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Search$S, s);
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
        implements Domain
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

        private static final Selling.B $VALUES[];
        public static final Selling.B guarantee;
        private final Object defaultValue;
        private final String key;

        public static Selling.B valueOf(String s)
        {
            return (Selling.B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Selling$B, s);
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

        static 
        {
            guarantee = new Selling.B("guarantee", 0);
            $VALUES = (new Selling.B[] {
                guarantee
            });
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
            return (Selling.I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Selling$I, s);
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
            return (Selling.L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Selling$L, s);
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

        private static final Selling.S $VALUES[];
        public static final Selling.S carsAndTrucksUrl;
        public static final Selling.S durationOverrideValueFixedPrice;
        private final String defaultValue;
        private final String key;

        public static Selling.S valueOf(String s)
        {
            return (Selling.S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Selling$S, s);
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

        static 
        {
            durationOverrideValueFixedPrice = new Selling.S("durationOverrideValueFixedPrice", 0);
            carsAndTrucksUrl = new Selling.S("carsAndTrucksUrl", 1);
            $VALUES = (new Selling.S[] {
                durationOverrideValueFixedPrice, carsAndTrucksUrl
            });
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
        implements Domain
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
            return (Trust.B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Trust$B, s);
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
            return (Trust.I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Trust$I, s);
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
            return (Trust.L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Trust$L, s);
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
            return (Trust.S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Trust$S, s);
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
        implements Domain
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
        public static final Verticals.B categoryServiceLimitByLevel;
        private final Object defaultValue;
        private final String key;

        public static Verticals.B valueOf(String s)
        {
            return (Verticals.B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Verticals$B, s);
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
            categoryServiceLimitByLevel = new Verticals.B("categoryServiceLimitByLevel", 0, true);
            $VALUES = (new Verticals.B[] {
                categoryServiceLimitByLevel
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
        public static final Verticals.I categoryServiceDiskCacheSize;
        public static final Verticals.I categoryServiceFlatCacheSize;
        public static final Verticals.I categoryServiceInflatedCacheSize;
        private final Object defaultValue;
        private final String key;

        public static Verticals.I valueOf(String s)
        {
            return (Verticals.I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Verticals$I, s);
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
            categoryServiceInflatedCacheSize = new Verticals.I("categoryServiceInflatedCacheSize", 0, 5);
            categoryServiceFlatCacheSize = new Verticals.I("categoryServiceFlatCacheSize", 1, -1);
            categoryServiceDiskCacheSize = new Verticals.I("categoryServiceDiskCacheSize", 2, 15);
            $VALUES = (new Verticals.I[] {
                categoryServiceInflatedCacheSize, categoryServiceFlatCacheSize, categoryServiceDiskCacheSize
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

        private static final Verticals.L $VALUES[];
        public static final Verticals.L categoryServiceMaxCacheTtl;
        private final Object defaultValue;
        private final String key;

        public static Verticals.L valueOf(String s)
        {
            return (Verticals.L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Verticals$L, s);
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

        static 
        {
            categoryServiceMaxCacheTtl = new Verticals.L("categoryServiceMaxCacheTtl", 0, 0x5265c00L);
            $VALUES = (new Verticals.L[] {
                categoryServiceMaxCacheTtl
            });
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

        private static final Verticals.S $VALUES[] = new Verticals.S[0];
        private final String defaultValue;
        private final String key;

        public static Verticals.S valueOf(String s)
        {
            return (Verticals.S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Verticals$S, s);
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
        implements Domain
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
        public static final ViewItem.B productReviewStarsInTitleSection;
        public static final ViewItem.B pullToRefresh;
        public static final ViewItem.B shareAsButton;
        private final Object defaultValue;
        private final String key;

        public static ViewItem.B valueOf(String s)
        {
            return (ViewItem.B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$ViewItem$B, s);
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
            pullToRefresh = new ViewItem.B("pullToRefresh", 0);
            shareAsButton = new ViewItem.B("shareAsButton", 1);
            productReviewStarsInTitleSection = new ViewItem.B("productReviewStarsInTitleSection", 2);
            $VALUES = (new ViewItem.B[] {
                pullToRefresh, shareAsButton, productReviewStarsInTitleSection
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
            return (ViewItem.I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$ViewItem$I, s);
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
            return (ViewItem.L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$ViewItem$L, s);
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

        private static final ViewItem.S $VALUES[];
        public static final ViewItem.S ebayPlusReturnsLearnMore;
        public static final ViewItem.S ebayPlusSignupLink;
        public static final ViewItem.S proofPointsUrlFormat;
        private final String defaultValue;
        private final String key;

        public static ViewItem.S valueOf(String s)
        {
            return (ViewItem.S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$ViewItem$S, s);
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

        static 
        {
            ebayPlusReturnsLearnMore = new ViewItem.S("ebayPlusReturnsLearnMore", 0, "http://pages.ebay.de/help/pay/ebay-plus-returns.html?rmvhdr=true");
            ebayPlusSignupLink = new ViewItem.S("ebayPlusSignupLink", 1, "https://www.signup.ebayplus.ebay.de/eplusweb/value");
            proofPointsUrlFormat = new ViewItem.S("proofPointsUrlFormat", 2);
            $VALUES = (new ViewItem.S[] {
                ebayPlusReturnsLearnMore, ebayPlusSignupLink, proofPointsUrlFormat
            });
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


    private DcsDomain()
    {
    }

    public static Domain[] getDomains()
    {
        return (new Domain[] {
            new Nautilus(), new Verticals(), new Search(), new ViewItem(), new Selling(), new Ads(), new Connect(), new Trust(), new Merch(), new Payments()
        });
    }
}
