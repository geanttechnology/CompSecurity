// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class c extends Enum
{

    private static final c $VALUES[];
    public static final c NOT_AVAILABLE;
    public static final c ONLINE_ONLY;
    public static final c ONLINE_STORES;
    public static final c STORE_ONLY;
    public static final c UNKNOWN;
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
        return (c)Enum.valueOf(com/target/mothership/common/product/c, s);
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
        STORE_ONLY = new c("STORE_ONLY", 0, "STORES_ONLY");
        ONLINE_ONLY = new c("ONLINE_ONLY", 1, "ONLINE_ONLY");
        ONLINE_STORES = new c("ONLINE_STORES", 2, "ONLINE_AND_STORES");
        NOT_AVAILABLE = new c("NOT_AVAILABLE", 3, "NOT_AVAILABLE");
        UNKNOWN = new c("UNKNOWN", 4, "$UNKNOWN");
        $VALUES = (new c[] {
            STORE_ONLY, ONLINE_ONLY, ONLINE_STORES, NOT_AVAILABLE, UNKNOWN
        });
    }
}
