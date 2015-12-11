// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.page_item;


public final class c extends Enum
{

    private static final c $VALUES[];
    public static final c CARTWHEEL;
    public static final c FIXED;
    public static final c SCENE_7;
    public static final c SHOPLOCAL;
    public static final c UNKNOWN;
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
        return UNKNOWN;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/target/mothership/common/page_item/c, s);
    }

    public static c[] values()
    {
        return (c[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        CARTWHEEL = new c("CARTWHEEL", 0, "CARTWHEEL");
        FIXED = new c("FIXED", 1, "FIXED");
        SCENE_7 = new c("SCENE_7", 2, "SCENE_7");
        SHOPLOCAL = new c("SHOPLOCAL", 3, "SHOPLOCAL");
        UNKNOWN = new c("UNKNOWN", 4, "");
        $VALUES = (new c[] {
            CARTWHEEL, FIXED, SCENE_7, SHOPLOCAL, UNKNOWN
        });
    }
}
