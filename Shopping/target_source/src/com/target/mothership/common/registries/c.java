// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.registries;


public final class c extends Enum
{

    private static final c $VALUES[];
    public static final c BABY;
    public static final c COLLEGE;
    public static final c TARGET_LIST;
    public static final c UNKNOWN;
    public static final c WEDDING;
    private String mValue;

    private c(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static c a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        c c1 = UNKNOWN;
_L4:
        return c1;
_L2:
        c ac[];
        int i;
        int j;
        ac = values();
        j = ac.length;
        i = 0;
_L6:
        c c2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        c2 = ac[i];
        c1 = c2;
        if (s.equalsIgnoreCase(c2.toString())) goto _L4; else goto _L3
_L3:
        c1 = c2;
        if (s.equalsIgnoreCase(c2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/target/mothership/common/registries/c, s);
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
        WEDDING = new c("WEDDING", 0, "WEDDING");
        BABY = new c("BABY", 1, "BABY");
        COLLEGE = new c("COLLEGE", 2, "COLLEGE");
        TARGET_LIST = new c("TARGET_LIST", 3, "TARGET_LIST");
        UNKNOWN = new c("UNKNOWN", 4, "");
        $VALUES = (new c[] {
            WEDDING, BABY, COLLEGE, TARGET_LIST, UNKNOWN
        });
    }
}
