// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.analytics;


// Referenced classes of package com.pointinside.analytics:
//            MapAnalyticData

public final class MapMarkerAnalyticData extends MapAnalyticData
{
    public static final class Builder extends MapAnalyticData.Builder
    {

        private String mItemId;
        private ItemType mItemType;

        public volatile MapAnalyticData build()
        {
            return build();
        }

        public MapMarkerAnalyticData build()
        {
            return new MapMarkerAnalyticData(this);
        }

        public Builder itemId(String s)
        {
            mItemId = s;
            return this;
        }

        public Builder itemType(ItemType itemtype)
        {
            mItemType = itemtype;
            return this;
        }



/*
        static String access$002(Builder builder, String s)
        {
            builder.mItemId = s;
            return s;
        }

*/



/*
        static ItemType access$102(Builder builder, ItemType itemtype)
        {
            builder.mItemType = itemtype;
            return itemtype;
        }

*/

        public Builder()
        {
        }
    }

    public static final class ItemType extends Enum
    {

        private static final ItemType $VALUES[];
        public static final ItemType OTHER;
        public static final ItemType PRODUCT;
        public static final ItemType SERVICE;
        public static final ItemType TERM;

        public static ItemType valueOf(String s)
        {
            return (ItemType)Enum.valueOf(com/pointinside/analytics/MapMarkerAnalyticData$ItemType, s);
        }

        public static ItemType[] values()
        {
            return (ItemType[])$VALUES.clone();
        }

        static 
        {
            PRODUCT = new ItemType("PRODUCT", 0);
            SERVICE = new ItemType("SERVICE", 1);
            TERM = new ItemType("TERM", 2);
            OTHER = new ItemType("OTHER", 3);
            $VALUES = (new ItemType[] {
                PRODUCT, SERVICE, TERM, OTHER
            });
        }

        private ItemType(String s, int i)
        {
            super(s, i);
        }
    }


    public final String itemId;
    public final ItemType itemType;

    private MapMarkerAnalyticData(Builder builder)
    {
        super(builder);
        itemId = builder.mItemId;
        itemType = builder.mItemType;
    }


    public static Builder newBuilder(MapMarkerAnalyticData mapmarkeranalyticdata)
    {
        Builder builder = new Builder();
        builder.mItemId = mapmarkeranalyticdata.itemId;
        builder.mItemType = mapmarkeranalyticdata.itemType;
        return builder;
    }
}
