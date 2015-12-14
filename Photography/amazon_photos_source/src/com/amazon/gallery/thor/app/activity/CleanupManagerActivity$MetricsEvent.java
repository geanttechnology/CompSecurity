// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;


// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            CleanupManagerActivity

public static final class  extends Enum
{

    private static final CleanupActivityAmountFound $VALUES[];
    public static final CleanupActivityAmountFound CleanupActivityAmountFound;
    public static final CleanupActivityAmountFound CleanupActivityDeleteExecuted;
    public static final CleanupActivityAmountFound CleanupActivityEntered;
    public static final CleanupActivityAmountFound CleanupActivityExited;
    public static final CleanupActivityAmountFound CleanupActivityInfoExecuted;
    public static final CleanupActivityAmountFound CleanupActivityNoneFound;
    public static final CleanupActivityAmountFound CleanupActivitySelect1Gb;
    public static final CleanupActivityAmountFound CleanupActivitySelect2Gb;
    public static final CleanupActivityAmountFound CleanupActivitySelect500Mb;
    public static final CleanupActivityAmountFound CleanupActivitySelectAll;
    public static final CleanupActivityAmountFound CleanupActivitySortChangedToLargest;
    public static final CleanupActivityAmountFound CleanupActivitySortChangedToOldest;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/app/activity/CleanupManagerActivity$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CleanupActivityEntered = new <init>("CleanupActivityEntered", 0);
        CleanupActivityExited = new <init>("CleanupActivityExited", 1);
        CleanupActivityDeleteExecuted = new <init>("CleanupActivityDeleteExecuted", 2);
        CleanupActivitySortChangedToOldest = new <init>("CleanupActivitySortChangedToOldest", 3);
        CleanupActivitySortChangedToLargest = new <init>("CleanupActivitySortChangedToLargest", 4);
        CleanupActivitySelect500Mb = new <init>("CleanupActivitySelect500Mb", 5);
        CleanupActivitySelect1Gb = new <init>("CleanupActivitySelect1Gb", 6);
        CleanupActivitySelect2Gb = new <init>("CleanupActivitySelect2Gb", 7);
        CleanupActivitySelectAll = new <init>("CleanupActivitySelectAll", 8);
        CleanupActivityInfoExecuted = new <init>("CleanupActivityInfoExecuted", 9);
        CleanupActivityNoneFound = new <init>("CleanupActivityNoneFound", 10);
        CleanupActivityAmountFound = new <init>("CleanupActivityAmountFound", 11);
        $VALUES = (new .VALUES[] {
            CleanupActivityEntered, CleanupActivityExited, CleanupActivityDeleteExecuted, CleanupActivitySortChangedToOldest, CleanupActivitySortChangedToLargest, CleanupActivitySelect500Mb, CleanupActivitySelect1Gb, CleanupActivitySelect2Gb, CleanupActivitySelectAll, CleanupActivityInfoExecuted, 
            CleanupActivityNoneFound, CleanupActivityAmountFound
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
