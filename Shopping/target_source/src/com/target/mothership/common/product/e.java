// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class e extends Enum
{

    private static final e $VALUES[];
    public static final e ADULTS_ONLY;
    public static final e EARLY_CHILDHOOD;
    public static final e EVERYONE;
    public static final e EVERYONE_10_PLUS;
    public static final e MATURE;
    public static final e RATING_PENDING;
    public static final e TEEN;
    public static final e UNKNOWN;
    private String mValue;

    private e(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static e a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        e e1 = UNKNOWN;
_L4:
        return e1;
_L2:
        e ae[];
        int i;
        int j;
        ae = values();
        j = ae.length;
        i = 0;
_L6:
        e e2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        e2 = ae[i];
        e1 = e2;
        if (s.equalsIgnoreCase(e2.toString())) goto _L4; else goto _L3
_L3:
        e1 = e2;
        if (s.equalsIgnoreCase(e2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/target/mothership/common/product/e, s);
    }

    public static e[] values()
    {
        return (e[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        EARLY_CHILDHOOD = new e("EARLY_CHILDHOOD", 0, "EARLY_CHILDHOOD");
        EVERYONE = new e("EVERYONE", 1, "EVERYONE");
        EVERYONE_10_PLUS = new e("EVERYONE_10_PLUS", 2, "EVERYONE_10_PLUS");
        TEEN = new e("TEEN", 3, "TEEN");
        MATURE = new e("MATURE", 4, "MATURE");
        ADULTS_ONLY = new e("ADULTS_ONLY", 5, "ADULTS_ONLY");
        RATING_PENDING = new e("RATING_PENDING", 6, "RATING_PENDING");
        UNKNOWN = new e("UNKNOWN", 7, "");
        $VALUES = (new e[] {
            EARLY_CHILDHOOD, EVERYONE, EVERYONE_10_PLUS, TEEN, MATURE, ADULTS_ONLY, RATING_PENDING, UNKNOWN
        });
    }
}
