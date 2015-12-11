// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;


// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsAdapter

private static final class  extends Enum
{

    private static final Unknown $VALUES[];
    public static final Unknown Department;
    public static final Unknown Filter;
    public static final Unknown PrioritizedFilter;
    public static final Unknown SeeMore;
    public static final Unknown Sort;
    public static final Unknown Unknown;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PrioritizedFilter = new <init>("PrioritizedFilter", 0);
        Department = new <init>("Department", 1);
        Sort = new <init>("Sort", 2);
        Filter = new <init>("Filter", 3);
        SeeMore = new <init>("SeeMore", 4);
        Unknown = new <init>("Unknown", 5);
        $VALUES = (new .VALUES[] {
            PrioritizedFilter, Department, Sort, Filter, SeeMore, Unknown
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
