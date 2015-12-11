// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class r extends Enum
{

    private static final r $VALUES[];
    public static final r FAILURE;
    public static final r NON_PILOT_STORE;
    public static final r NOT_FOUND;
    public static final r OK;
    public static final r OUTSIDE_STORE;
    public static final r TIMED_OUT;
    public static final r UNKNOWN;
    private String mValue;

    private r(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static r a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        r r1 = UNKNOWN;
_L4:
        return r1;
_L2:
        r ar[];
        int i;
        int j;
        ar = values();
        j = ar.length;
        i = 0;
_L6:
        r r2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        r2 = ar[i];
        r1 = r2;
        if (s.equalsIgnoreCase(r2.toString())) goto _L4; else goto _L3
_L3:
        r1 = r2;
        if (s.equalsIgnoreCase(r2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static r valueOf(String s)
    {
        return (r)Enum.valueOf(com/target/mothership/common/product/r, s);
    }

    public static r[] values()
    {
        return (r[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        OK = new r("OK", 0, "OK");
        NOT_FOUND = new r("NOT_FOUND", 1, "NOT_FOUND");
        FAILURE = new r("FAILURE", 2, "FAILURE");
        OUTSIDE_STORE = new r("OUTSIDE_STORE", 3, "OUTSIDE_STORE");
        NON_PILOT_STORE = new r("NON_PILOT_STORE", 4, "NON_PILOT_STORE");
        TIMED_OUT = new r("TIMED_OUT", 5, "TIMED_OUT");
        UNKNOWN = new r("UNKNOWN", 6, "$UNKNOWN");
        $VALUES = (new r[] {
            OK, NOT_FOUND, FAILURE, OUTSIDE_STORE, NON_PILOT_STORE, TIMED_OUT, UNKNOWN
        });
    }
}
