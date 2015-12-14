// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;


// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils

public static final class value extends Enum
{

    private static final XXXHIGH $VALUES[];
    public static final XXXHIGH DENSITY_TV;
    public static final XXXHIGH HIGH;
    public static final XXXHIGH LOW;
    public static final XXXHIGH MEDIUM;
    public static final XXXHIGH XHIGH;
    public static final XXXHIGH XXHIGH;
    public static final XXXHIGH XXXHIGH;
    int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/aviary/android/feather/cds/CdsUtils$Resolution, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        LOW = new <init>("LOW", 0, 120);
        MEDIUM = new <init>("MEDIUM", 1, 160);
        DENSITY_TV = new <init>("DENSITY_TV", 2, 213);
        HIGH = new <init>("HIGH", 3, 240);
        XHIGH = new <init>("XHIGH", 4, 320);
        XXHIGH = new <init>("XXHIGH", 5, 480);
        XXXHIGH = new <init>("XXXHIGH", 6, 640);
        $VALUES = (new .VALUES[] {
            LOW, MEDIUM, DENSITY_TV, HIGH, XHIGH, XXHIGH, XXXHIGH
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
