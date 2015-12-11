// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class k extends Enum
{

    private static final k $VALUES[];
    public static final k CD;
    public static final k DIGITAL_DOWNLOAD;
    public static final k DVD;
    public static final k UNKNOWN;
    private String mValue;

    private k(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static k a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        k k1 = UNKNOWN;
_L4:
        return k1;
_L2:
        k ak[];
        int i;
        int j;
        ak = values();
        j = ak.length;
        i = 0;
_L6:
        k k2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        k2 = ak[i];
        k1 = k2;
        if (s.equalsIgnoreCase(k2.toString())) goto _L4; else goto _L3
_L3:
        k1 = k2;
        if (s.equalsIgnoreCase(k2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static k valueOf(String s)
    {
        return (k)Enum.valueOf(com/target/mothership/common/product/k, s);
    }

    public static k[] values()
    {
        return (k[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        CD = new k("CD", 0, "CD");
        DVD = new k("DVD", 1, "DVD");
        DIGITAL_DOWNLOAD = new k("DIGITAL_DOWNLOAD", 2, "DIGITAL_DOWNLOAD");
        UNKNOWN = new k("UNKNOWN", 3, "$UNKNOWN");
        $VALUES = (new k[] {
            CD, DVD, DIGITAL_DOWNLOAD, UNKNOWN
        });
    }
}
