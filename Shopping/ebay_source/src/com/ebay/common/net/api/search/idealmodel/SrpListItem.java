// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.idealmodel;


public abstract class SrpListItem
{
    public static final class SrpListItemType extends Enum
    {

        private static final SrpListItemType $VALUES[];
        public static final SrpListItemType ADS;
        public static final SrpListItemType LABELED_ANSWER;
        public static final SrpListItemType REGULAR;
        public static final SrpListItemType REWRITE_END;
        public static final SrpListItemType REWRITE_START;

        public static SrpListItemType valueOf(String s)
        {
            return (SrpListItemType)Enum.valueOf(com/ebay/common/net/api/search/idealmodel/SrpListItem$SrpListItemType, s);
        }

        public static SrpListItemType[] values()
        {
            return (SrpListItemType[])$VALUES.clone();
        }

        static 
        {
            REGULAR = new SrpListItemType("REGULAR", 0);
            LABELED_ANSWER = new SrpListItemType("LABELED_ANSWER", 1);
            REWRITE_START = new SrpListItemType("REWRITE_START", 2);
            REWRITE_END = new SrpListItemType("REWRITE_END", 3);
            ADS = new SrpListItemType("ADS", 4);
            $VALUES = (new SrpListItemType[] {
                REGULAR, LABELED_ANSWER, REWRITE_START, REWRITE_END, ADS
            });
        }

        private SrpListItemType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int NOT_RANKED = -1;
    public final String clickTracking;
    public final String impressionTracking;
    public final SrpListItemType itemType;
    public int trackingRank;

    SrpListItem(SrpListItemType srplistitemtype, String s, String s1)
    {
        trackingRank = -1;
        itemType = srplistitemtype;
        impressionTracking = s;
        clickTracking = s1;
    }

    public SrpListItem withTrackableRank(int i)
    {
        trackingRank = i;
        return this;
    }
}
