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
        public static final B categoryServiceLimitByLevel;
        private final Object defaultValue;
        private final String key;

        public static B valueOf(String s)
        {
            return (B)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Verticals$B, s);
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
            categoryServiceLimitByLevel = new B("categoryServiceLimitByLevel", 0, true);
            $VALUES = (new B[] {
                categoryServiceLimitByLevel
            });
        }

        private B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = s1;
        }

        private B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Boolean.valueOf(flag);
        }
    }

    public static final class I extends Enum
        implements DcsPropInteger
    {

        private static final I $VALUES[];
        public static final I categoryServiceDiskCacheSize;
        public static final I categoryServiceFlatCacheSize;
        public static final I categoryServiceInflatedCacheSize;
        private final Object defaultValue;
        private final String key;

        public static I valueOf(String s)
        {
            return (I)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Verticals$I, s);
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

        static 
        {
            categoryServiceInflatedCacheSize = new I("categoryServiceInflatedCacheSize", 0, 5);
            categoryServiceFlatCacheSize = new I("categoryServiceFlatCacheSize", 1, -1);
            categoryServiceDiskCacheSize = new I("categoryServiceDiskCacheSize", 2, 15);
            $VALUES = (new I[] {
                categoryServiceInflatedCacheSize, categoryServiceFlatCacheSize, categoryServiceDiskCacheSize
            });
        }

        private I(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = s1;
        }
    }

    public static final class L extends Enum
        implements DcsPropLong
    {

        private static final L $VALUES[];
        public static final L categoryServiceMaxCacheTtl;
        private final Object defaultValue;
        private final String key;

        public static L valueOf(String s)
        {
            return (L)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Verticals$L, s);
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

        static 
        {
            categoryServiceMaxCacheTtl = new L("categoryServiceMaxCacheTtl", 0, 0x5265c00L);
            $VALUES = (new L[] {
                categoryServiceMaxCacheTtl
            });
        }

        private L(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
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
            return (S)Enum.valueOf(com/ebay/nautilus/domain/dcs/DcsDomain$Verticals$S, s);
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
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = null;
        }

        private S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("verticals.").append(name()).toString();
            defaultValue = s1;
        }
    }


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

    public S.defaultValue()
    {
    }
}
