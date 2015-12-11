// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class l extends Enum
{

    private static final l $VALUES[];
    public static final l G;
    public static final l NC_17;
    public static final l PG;
    public static final l PG_13;
    public static final l R;
    public static final l UNKNOWN;
    private String mValue;

    private l(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static l a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        l l1 = UNKNOWN;
_L4:
        return l1;
_L2:
        l al[];
        int i;
        int j;
        al = values();
        j = al.length;
        i = 0;
_L6:
        l l2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        l2 = al[i];
        l1 = l2;
        if (s.equalsIgnoreCase(l2.toString())) goto _L4; else goto _L3
_L3:
        l1 = l2;
        if (s.equalsIgnoreCase(l2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static l valueOf(String s)
    {
        return (l)Enum.valueOf(com/target/mothership/common/product/l, s);
    }

    public static l[] values()
    {
        return (l[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        PG = new l("PG", 0, "PG");
        G = new l("G", 1, "G");
        PG_13 = new l("PG_13", 2, "PG_13");
        R = new l("R", 3, "R");
        NC_17 = new l("NC_17", 4, "NC_17");
        UNKNOWN = new l("UNKNOWN", 5, "");
        $VALUES = (new l[] {
            PG, G, PG_13, R, NC_17, UNKNOWN
        });
    }
}
