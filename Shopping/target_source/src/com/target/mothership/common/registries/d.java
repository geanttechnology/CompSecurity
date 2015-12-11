// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.registries;


public final class d extends Enum
{

    private static final d $VALUES[];
    public static final d BRIDE;
    public static final d FATHER;
    public static final d GROOM;
    public static final d MOTHER;
    public static final d NA;
    public static final d PARENT;
    public static final d PARTNER;
    public static final d UNKNOWN;
    private String mValue;

    private d(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static d a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        d d1 = UNKNOWN;
_L4:
        return d1;
_L2:
        d ad[];
        int i;
        int j;
        ad = values();
        j = ad.length;
        i = 0;
_L6:
        d d2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        d2 = ad[i];
        d1 = d2;
        if (s.equalsIgnoreCase(d2.toString())) goto _L4; else goto _L3
_L3:
        d1 = d2;
        if (s.equalsIgnoreCase(d2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/target/mothership/common/registries/d, s);
    }

    public static d[] values()
    {
        return (d[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        MOTHER = new d("MOTHER", 0, "MOTHER");
        FATHER = new d("FATHER", 1, "FATHER");
        PARENT = new d("PARENT", 2, "PARENT");
        BRIDE = new d("BRIDE", 3, "BRIDE");
        GROOM = new d("GROOM", 4, "GROOM");
        PARTNER = new d("PARTNER", 5, "PARTNER");
        NA = new d("NA", 6, "NA");
        UNKNOWN = new d("UNKNOWN", 7, "");
        $VALUES = (new d[] {
            MOTHER, FATHER, PARENT, BRIDE, GROOM, PARTNER, NA, UNKNOWN
        });
    }
}
