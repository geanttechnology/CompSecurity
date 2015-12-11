// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.weeklyad;


public final class c extends Enum
{

    private static final c $VALUES[];
    public static final c COLORS;
    public static final c NONE;
    public static final c SIZES;
    public static final c SIZES_AND_COLORS;
    private final String mValue;

    private c(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static c a(String s)
    {
        if (s != null)
        {
            c ac[] = values();
            int j = ac.length;
            for (int i = 0; i < j; i++)
            {
                c c1 = ac[i];
                if (s.equalsIgnoreCase(c1.mValue))
                {
                    return c1;
                }
            }

        }
        return NONE;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/target/mothership/common/weeklyad/c, s);
    }

    public static c[] values()
    {
        return (c[])$VALUES.clone();
    }

    static 
    {
        SIZES_AND_COLORS = new c("SIZES_AND_COLORS", 0, "SIZE AND COLOR");
        SIZES = new c("SIZES", 1, "SIZES ONLY");
        COLORS = new c("COLORS", 2, "COLORS ONLY");
        NONE = new c("NONE", 3, "");
        $VALUES = (new c[] {
            SIZES_AND_COLORS, SIZES, COLORS, NONE
        });
    }
}
