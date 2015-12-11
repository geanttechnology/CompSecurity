// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class b extends Enum
{

    private static final b $VALUES[];
    public static final b FAILURE;
    public static final b NOT_FOUND;
    public static final b NOT_REQUESTED;
    public static final b OK;
    public static final b TIMED_OUT;
    public static final b UNKNOWN;
    private String mValue;

    private b(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static b a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        b b1 = UNKNOWN;
_L4:
        return b1;
_L2:
        b ab[];
        int i;
        int j;
        ab = values();
        j = ab.length;
        i = 0;
_L6:
        b b2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        b2 = ab[i];
        b1 = b2;
        if (s.equalsIgnoreCase(b2.toString())) goto _L4; else goto _L3
_L3:
        b1 = b2;
        if (s.equalsIgnoreCase(b2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/target/mothership/common/product/b, s);
    }

    public static b[] values()
    {
        return (b[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        OK = new b("OK", 0, "OK");
        NOT_REQUESTED = new b("NOT_REQUESTED", 1, "NOT_REQUESTED");
        NOT_FOUND = new b("NOT_FOUND", 2, "NOT_FOUND");
        FAILURE = new b("FAILURE", 3, "FAILURE");
        TIMED_OUT = new b("TIMED_OUT", 4, "TIMED_OUT");
        UNKNOWN = new b("UNKNOWN", 5, "$UNKNOWN");
        $VALUES = (new b[] {
            OK, NOT_REQUESTED, NOT_FOUND, FAILURE, TIMED_OUT, UNKNOWN
        });
    }
}
