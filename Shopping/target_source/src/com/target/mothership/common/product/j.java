// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class j extends Enum
{

    private static final j $VALUES[];
    public static final j APPLE;
    public static final j OTHERS;
    private String mValue;

    private j(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static j a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        j j1 = OTHERS;
_L4:
        return j1;
_L2:
        j aj[];
        int i;
        int k;
        aj = values();
        k = aj.length;
        i = 0;
_L6:
        j j2;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        j2 = aj[i];
        j1 = j2;
        if (s.equalsIgnoreCase(j2.toString())) goto _L4; else goto _L3
_L3:
        j1 = j2;
        if (s.equalsIgnoreCase(j2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return OTHERS;
    }

    public static j valueOf(String s)
    {
        return (j)Enum.valueOf(com/target/mothership/common/product/j, s);
    }

    public static j[] values()
    {
        return (j[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        APPLE = new j("APPLE", 0, "APPLE");
        OTHERS = new j("OTHERS", 1, "");
        $VALUES = (new j[] {
            APPLE, OTHERS
        });
    }
}
