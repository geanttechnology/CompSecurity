// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.i;


public final class b extends Enum
{

    private static final b $VALUES[];
    public static final b FOUR_X_FIVE;
    public static final b FOUR_X_FOUR;
    public static final b FOUR_X_ONE;
    public static final b FOUR_X_THREE;
    public static final b FOUR_X_TWO;
    public static final b ONE_X_FIVE;
    public static final b ONE_X_FOUR;
    public static final b ONE_X_ONE;
    public static final b ONE_X_THREE;
    public static final b ONE_X_TWO;
    public static final b THREE_X_FIVE;
    public static final b THREE_X_FOUR;
    public static final b THREE_X_ONE;
    public static final b THREE_X_THREE;
    public static final b THREE_X_TWO;
    public static final b TWO_X_FIVE;
    public static final b TWO_X_FOUR;
    public static final b TWO_X_ONE;
    public static final b TWO_X_THREE;
    public static final b TWO_X_TWO;
    public static final b UNKNOWN;
    private final String mValue;

    private b(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static b a(String s)
    {
        if (s != null)
        {
            b ab[] = values();
            int j = ab.length;
            for (int i = 0; i < j; i++)
            {
                b b1 = ab[i];
                if (s.equalsIgnoreCase(b1.mValue))
                {
                    return b1;
                }
            }

        }
        return UNKNOWN;
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/target/ui/util/i/b, s);
    }

    public static b[] values()
    {
        return (b[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        ONE_X_ONE = new b("ONE_X_ONE", 0, "1x1");
        ONE_X_TWO = new b("ONE_X_TWO", 1, "1x2");
        ONE_X_THREE = new b("ONE_X_THREE", 2, "1x3");
        ONE_X_FOUR = new b("ONE_X_FOUR", 3, "1x4");
        ONE_X_FIVE = new b("ONE_X_FIVE", 4, "1x5");
        TWO_X_ONE = new b("TWO_X_ONE", 5, "2x1");
        TWO_X_TWO = new b("TWO_X_TWO", 6, "2x2");
        TWO_X_THREE = new b("TWO_X_THREE", 7, "2x3");
        TWO_X_FOUR = new b("TWO_X_FOUR", 8, "2x4");
        TWO_X_FIVE = new b("TWO_X_FIVE", 9, "2x5");
        THREE_X_ONE = new b("THREE_X_ONE", 10, "3x1");
        THREE_X_TWO = new b("THREE_X_TWO", 11, "3x2");
        THREE_X_THREE = new b("THREE_X_THREE", 12, "3x3");
        THREE_X_FOUR = new b("THREE_X_FOUR", 13, "3x4");
        THREE_X_FIVE = new b("THREE_X_FIVE", 14, "3x5");
        FOUR_X_ONE = new b("FOUR_X_ONE", 15, "4x1");
        FOUR_X_TWO = new b("FOUR_X_TWO", 16, "4x2");
        FOUR_X_THREE = new b("FOUR_X_THREE", 17, "4x3");
        FOUR_X_FOUR = new b("FOUR_X_FOUR", 18, "4x4");
        FOUR_X_FIVE = new b("FOUR_X_FIVE", 19, "5x5");
        UNKNOWN = new b("UNKNOWN", 20, "");
        $VALUES = (new b[] {
            ONE_X_ONE, ONE_X_TWO, ONE_X_THREE, ONE_X_FOUR, ONE_X_FIVE, TWO_X_ONE, TWO_X_TWO, TWO_X_THREE, TWO_X_FOUR, TWO_X_FIVE, 
            THREE_X_ONE, THREE_X_TWO, THREE_X_THREE, THREE_X_FOUR, THREE_X_FIVE, FOUR_X_ONE, FOUR_X_TWO, FOUR_X_THREE, FOUR_X_FOUR, FOUR_X_FIVE, 
            UNKNOWN
        });
    }
}
