// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.tender;


public final class b extends Enum
{

    private static final b $VALUES[];
    public static final b April;
    public static final b August;
    public static final b December;
    public static final b February;
    public static final b January;
    public static final b July;
    public static final b June;
    public static final b March;
    public static final b May;
    public static final b November;
    public static final b October;
    public static final b September;
    private String mMonthNumberString;

    private b(String s, int i, String s1)
    {
        super(s, i);
        mMonthNumberString = s1;
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
                if (s.equalsIgnoreCase(b1.mMonthNumberString))
                {
                    return b1;
                }
            }

        }
        return null;
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/target/mothership/common/tender/b, s);
    }

    public static b[] values()
    {
        return (b[])$VALUES.clone();
    }

    public String toString()
    {
        return mMonthNumberString;
    }

    static 
    {
        January = new b("January", 0, "1");
        February = new b("February", 1, "2");
        March = new b("March", 2, "3");
        April = new b("April", 3, "4");
        May = new b("May", 4, "5");
        June = new b("June", 5, "6");
        July = new b("July", 6, "7");
        August = new b("August", 7, "8");
        September = new b("September", 8, "9");
        October = new b("October", 9, "10");
        November = new b("November", 10, "11");
        December = new b("December", 11, "12");
        $VALUES = (new b[] {
            January, February, March, April, May, June, July, August, September, October, 
            November, December
        });
    }
}
