// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class n extends Enum
{

    private static final n $VALUES[];
    public static final n RANGE;
    public static final n SINGLE;
    public static final n UNKNOWN;
    private String mValue;

    private n(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static n a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        n n1 = UNKNOWN;
_L4:
        return n1;
_L2:
        n an[];
        int i;
        int j;
        an = values();
        j = an.length;
        i = 0;
_L6:
        n n2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        n2 = an[i];
        n1 = n2;
        if (s.equalsIgnoreCase(n2.toString())) goto _L4; else goto _L3
_L3:
        n1 = n2;
        if (s.equalsIgnoreCase(n2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static n valueOf(String s)
    {
        return (n)Enum.valueOf(com/target/mothership/common/product/n, s);
    }

    public static n[] values()
    {
        return (n[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        SINGLE = new n("SINGLE", 0, "SINGLE");
        RANGE = new n("RANGE", 1, "RANGE");
        UNKNOWN = new n("UNKNOWN", 2, "$UNKNOWN");
        $VALUES = (new n[] {
            SINGLE, RANGE, UNKNOWN
        });
    }
}
