// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.sdk;


// Referenced classes of package com.inmobi.sdk:
//            InMobiSdk

public static final class a extends Enum
{

    private static final ABOVE_55 $VALUES[];
    public static final ABOVE_55 ABOVE_55;
    public static final ABOVE_55 BELOW_18;
    public static final ABOVE_55 BETWEEN_18_AND_20;
    public static final ABOVE_55 BETWEEN_21_AND_24;
    public static final ABOVE_55 BETWEEN_25_AND_34;
    public static final ABOVE_55 BETWEEN_35_AND_54;
    private String a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/inmobi/sdk/InMobiSdk$AgeGroup, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public String toString()
    {
        return a;
    }

    static 
    {
        BELOW_18 = new <init>("BELOW_18", 0, "below18");
        BETWEEN_18_AND_20 = new <init>("BETWEEN_18_AND_20", 1, "between18and20");
        BETWEEN_21_AND_24 = new <init>("BETWEEN_21_AND_24", 2, "between21and24");
        BETWEEN_25_AND_34 = new <init>("BETWEEN_25_AND_34", 3, "between25and34");
        BETWEEN_35_AND_54 = new <init>("BETWEEN_35_AND_54", 4, "between35and54");
        ABOVE_55 = new <init>("ABOVE_55", 5, "above55");
        $VALUES = (new .VALUES[] {
            BELOW_18, BETWEEN_18_AND_20, BETWEEN_21_AND_24, BETWEEN_25_AND_34, BETWEEN_35_AND_54, ABOVE_55
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        a = s1;
    }
}
