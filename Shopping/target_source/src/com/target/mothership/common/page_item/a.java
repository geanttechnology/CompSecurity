// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.page_item;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a ONE_X_ONE;
    public static final a ONE_X_TWO;
    public static final a THREE_X_ONE;
    public static final a THREE_X_TWO;
    public static final a TWO_X_ONE;
    public static final a TWO_X_TWO;
    public static final a UNKNOWN;
    private final String mValue;

    private a(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static a a(String s)
    {
        if (s != null)
        {
            a aa[] = values();
            int j = aa.length;
            for (int i = 0; i < j; i++)
            {
                a a1 = aa[i];
                if (s.equalsIgnoreCase(a1.mValue))
                {
                    return a1;
                }
            }

        }
        return UNKNOWN;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/common/page_item/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        ONE_X_ONE = new a("ONE_X_ONE", 0, "1x1");
        ONE_X_TWO = new a("ONE_X_TWO", 1, "1x2");
        TWO_X_ONE = new a("TWO_X_ONE", 2, "2x1");
        TWO_X_TWO = new a("TWO_X_TWO", 3, "2x2");
        THREE_X_ONE = new a("THREE_X_ONE", 4, "3x1");
        THREE_X_TWO = new a("THREE_X_TWO", 5, "3x2");
        UNKNOWN = new a("UNKNOWN", 6, "");
        $VALUES = (new a[] {
            ONE_X_ONE, ONE_X_TWO, TWO_X_ONE, TWO_X_TWO, THREE_X_ONE, THREE_X_TWO, UNKNOWN
        });
    }
}
