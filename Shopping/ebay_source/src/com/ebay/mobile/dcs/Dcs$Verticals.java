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
    implements com.ebay.nautilus.domain.dcs.in
{
    public static final class B extends Enum
        implements DcsPropBoolean
    {

        private static final B $VALUES[];
        public static final B buyingOverview;
        public static final B collections;
        public static final B deals;
        public static final B events;
        public static final B following;
        public static final B lockedPortraitOnPhone;
        public static final B notifications;
        public static final B rateThisApp;
        public static final B recentlyViewedItems;
        public static final B rtmCardStyle;
        public static final B sellingOverview;
        public static final B trendingTopics;
        public static final B valet;
        public static final B watchedItems;
        private final Object defaultValue;
        private final String key;

        public static B valueOf(String s)
        {
            return (B)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Verticals$B, s);
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
            buyingOverview = new B("buyingOverview", 0);
            sellingOverview = new B("sellingOverview", 1);
            notifications = new B("notifications", 2);
            recentlyViewedItems = new B("recentlyViewedItems", 3);
            following = new B("following", 4);
            watchedItems = new B("watchedItems", 5);
            lockedPortraitOnPhone = new B("lockedPortraitOnPhone", 6, true);
            deals = new B("deals", 7);
            events = new B("events", 8);
            collections = new B("collections", 9);
            trendingTopics = new B("trendingTopics", 10);
            valet = new B("valet", 11);
            rateThisApp = new B("rateThisApp", 12);
            rtmCardStyle = new B("rtmCardStyle", 13);
            $VALUES = (new B[] {
                buyingOverview, sellingOverview, notifications, recentlyViewedItems, following, watchedItems, lockedPortraitOnPhone, deals, events, collections, 
                trendingTopics, valet, rateThisApp, rtmCardStyle
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
        public static final I overlayVersion;
        public static final I rateThisAppLaterDaysDelay;
        private final Object defaultValue;
        private final String key;

        public static I valueOf(String s)
        {
            return (I)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Verticals$I, s);
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
            overlayVersion = new I("overlayVersion", 0);
            rateThisAppLaterDaysDelay = new I("rateThisAppLaterDaysDelay", 1, 15);
            $VALUES = (new I[] {
                overlayVersion, rateThisAppLaterDaysDelay
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

        private static final L $VALUES[] = new L[0];
        private final Object defaultValue;
        private final String key;

        public static L valueOf(String s)
        {
            return (L)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Verticals$L, s);
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

        private static final S $VALUES[];
        public static final S tourLink;
        private final String defaultValue;
        private final String key;

        public static S valueOf(String s)
        {
            return (S)Enum.valueOf(com/ebay/mobile/dcs/Dcs$Verticals$S, s);
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

        static 
        {
            tourLink = new S("tourLink", 0, "http://anywhere.ebay.com/mobile/singlePageSites/0-inapp.html");
            $VALUES = (new S[] {
                tourLink
            });
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
