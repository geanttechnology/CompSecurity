// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            UserData

public static final class value extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER ASIAN;
    public static final OTHER BLACK;
    public static final OTHER HISPANIC;
    public static final OTHER INDIAN;
    public static final OTHER MIDDLE_EASTERN;
    public static final OTHER NATIVE_AMERICAN;
    public static final OTHER OTHER;
    public static final OTHER PACIFIC_ISLANDER;
    public static final OTHER WHITE;
    public final String value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/millennialmedia/UserData$Ethnicity, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        HISPANIC = new <init>("HISPANIC", 0, "hispanic");
        BLACK = new <init>("BLACK", 1, "africanamerican");
        ASIAN = new <init>("ASIAN", 2, "asian");
        INDIAN = new <init>("INDIAN", 3, "indian");
        MIDDLE_EASTERN = new <init>("MIDDLE_EASTERN", 4, "middleeastern");
        NATIVE_AMERICAN = new <init>("NATIVE_AMERICAN", 5, "nativeamerican");
        PACIFIC_ISLANDER = new <init>("PACIFIC_ISLANDER", 6, "pacificislander");
        WHITE = new <init>("WHITE", 7, "white");
        OTHER = new <init>("OTHER", 8, "other");
        $VALUES = (new .VALUES[] {
            HISPANIC, BLACK, ASIAN, INDIAN, MIDDLE_EASTERN, NATIVE_AMERICAN, PACIFIC_ISLANDER, WHITE, OTHER
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }
}
