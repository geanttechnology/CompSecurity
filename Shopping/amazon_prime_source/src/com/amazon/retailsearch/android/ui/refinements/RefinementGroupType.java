// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;


// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementGroupViewType, RefinementItemViewType

public final class RefinementGroupType extends Enum
{

    private static final RefinementGroupType $VALUES[];
    public static final RefinementGroupType DDS;
    public static final RefinementGroupType DDS_CITY;
    public static final RefinementGroupType DDS_DISTRICT;
    public static final RefinementGroupType DDS_PROVINCE;
    public static final RefinementGroupType DEPARTMENT;
    public static final RefinementGroupType DIVIDER;
    public static final RefinementGroupType FILTER;
    public static final RefinementGroupType FILTER_ITEM;
    public static final RefinementGroupType SEEMORE;
    public static final RefinementGroupType SORT;
    public static final RefinementGroupType UNKNOWN;
    private RefinementItemViewType childViewType;
    private RefinementGroupViewType groupViewType;

    private RefinementGroupType(String s, int i, RefinementGroupViewType refinementgroupviewtype, RefinementItemViewType refinementitemviewtype)
    {
        super(s, i);
        groupViewType = refinementgroupviewtype;
        childViewType = refinementitemviewtype;
    }

    public static RefinementGroupType valueOf(String s)
    {
        return (RefinementGroupType)Enum.valueOf(com/amazon/retailsearch/android/ui/refinements/RefinementGroupType, s);
    }

    public static RefinementGroupType[] values()
    {
        return (RefinementGroupType[])$VALUES.clone();
    }

    public RefinementItemViewType getChildViewType()
    {
        return childViewType;
    }

    public RefinementGroupViewType getGroupViewType()
    {
        return groupViewType;
    }

    static 
    {
        UNKNOWN = new RefinementGroupType("UNKNOWN", 0, RefinementGroupViewType.GROUP, RefinementItemViewType.GENERAL);
        DEPARTMENT = new RefinementGroupType("DEPARTMENT", 1, RefinementGroupViewType.GROUP, RefinementItemViewType.GENERAL);
        SORT = new RefinementGroupType("SORT", 2, RefinementGroupViewType.GROUP, RefinementItemViewType.GENERAL);
        FILTER = new RefinementGroupType("FILTER", 3, RefinementGroupViewType.GROUP, RefinementItemViewType.GENERAL);
        FILTER_ITEM = new RefinementGroupType("FILTER_ITEM", 4, RefinementGroupViewType.FILTER_ITEM, RefinementItemViewType.GENERAL);
        SEEMORE = new RefinementGroupType("SEEMORE", 5, RefinementGroupViewType.GROUP, RefinementItemViewType.GENERAL);
        DIVIDER = new RefinementGroupType("DIVIDER", 6, RefinementGroupViewType.GROUP, RefinementItemViewType.GENERAL);
        DDS = new RefinementGroupType("DDS", 7, RefinementGroupViewType.GROUP, RefinementItemViewType.DDS);
        DDS_PROVINCE = new RefinementGroupType("DDS_PROVINCE", 8, RefinementGroupViewType.GROUP, RefinementItemViewType.DDS);
        DDS_CITY = new RefinementGroupType("DDS_CITY", 9, RefinementGroupViewType.GROUP, RefinementItemViewType.DDS);
        DDS_DISTRICT = new RefinementGroupType("DDS_DISTRICT", 10, RefinementGroupViewType.GROUP, RefinementItemViewType.DDS);
        $VALUES = (new RefinementGroupType[] {
            UNKNOWN, DEPARTMENT, SORT, FILTER, FILTER_ITEM, SEEMORE, DIVIDER, DDS, DDS_PROVINCE, DDS_CITY, 
            DDS_DISTRICT
        });
    }
}
