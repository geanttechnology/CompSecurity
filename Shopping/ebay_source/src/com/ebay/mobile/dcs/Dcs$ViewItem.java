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
//            Dcs

public static final class S.defaultValue
    implements com.ebay.nautilus.domain.dcs.ain
{
    public static final class B extends Enum
        implements DcsPropBoolean
    {

        private static final B $VALUES[];
        public static final B realtimeMtsFlush;
        private final Object defaultValue;
        private final String key;

        public static B valueOf(String s)
        {
            return (B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$ViewItem$B, s);
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
            realtimeMtsFlush = new B("realtimeMtsFlush", 0);
            $VALUES = (new B[] {
                realtimeMtsFlush
            });
        }

        private B(String s, int i)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = Boolean.FALSE;
        }

        private B(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = s1;
        }

        private B(String s, int i, boolean flag)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
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
            return (I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$ViewItem$I, s);
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
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = Integer.valueOf(0);
        }

        private I(String s, int i, int j)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = Integer.valueOf(j);
        }

        private I(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
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
            return (L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$ViewItem$L, s);
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
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = Long.valueOf(0L);
        }

        private L(String s, int i, long l)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = Long.valueOf(l);
        }

        private L(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
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
            return (S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$ViewItem$S, s);
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
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = null;
        }

        private S(String s, int i, String s1)
        {
            super(s, i);
            key = (new StringBuilder()).append("viewitem.").append(name()).toString();
            defaultValue = s1;
        }
    }


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

    public S.defaultValue()
    {
    }
}
