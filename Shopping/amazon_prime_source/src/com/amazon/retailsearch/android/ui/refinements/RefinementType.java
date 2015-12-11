// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;


// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementGroupType

public final class RefinementType extends Enum
{

    private static final RefinementType $VALUES[];
    public static final RefinementType DDS_CITY;
    public static final RefinementType DDS_DISTRICT;
    public static final RefinementType DDS_PROVINCE;
    public static final RefinementType DEFAULT;
    private RefinementGroupType refinementGroupType;

    private RefinementType(String s, int i, RefinementGroupType refinementgrouptype)
    {
        super(s, i);
        refinementGroupType = refinementgrouptype;
    }

    public static RefinementType valueOf(String s)
    {
        return (RefinementType)Enum.valueOf(com/amazon/retailsearch/android/ui/refinements/RefinementType, s);
    }

    public static RefinementType[] values()
    {
        return (RefinementType[])$VALUES.clone();
    }

    public RefinementGroupType getRefinementGroupType()
    {
        return refinementGroupType;
    }

    static 
    {
        DEFAULT = new RefinementType("DEFAULT", 0, RefinementGroupType.UNKNOWN);
        DDS_PROVINCE = new RefinementType("DDS_PROVINCE", 1, RefinementGroupType.DDS_PROVINCE);
        DDS_CITY = new RefinementType("DDS_CITY", 2, RefinementGroupType.DDS_CITY);
        DDS_DISTRICT = new RefinementType("DDS_DISTRICT", 3, RefinementGroupType.DDS_DISTRICT);
        $VALUES = (new RefinementType[] {
            DEFAULT, DDS_PROVINCE, DDS_CITY, DDS_DISTRICT
        });
    }
}
