// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.registries;


public final class g extends Enum
{

    private static final g $VALUES[];
    public static final g ACTIVE;
    public static final g INACTIVE;
    public static final g UNKNOWN;
    private String mValue;

    private g(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static g a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        g g1 = UNKNOWN;
_L4:
        return g1;
_L2:
        g ag[];
        int i;
        int j;
        ag = values();
        j = ag.length;
        i = 0;
_L6:
        g g2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        g2 = ag[i];
        g1 = g2;
        if (s.equalsIgnoreCase(g2.toString())) goto _L4; else goto _L3
_L3:
        g1 = g2;
        if (s.equalsIgnoreCase(g2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static g valueOf(String s)
    {
        return (g)Enum.valueOf(com/target/mothership/common/registries/g, s);
    }

    public static g[] values()
    {
        return (g[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        ACTIVE = new g("ACTIVE", 0, "ACTIVE");
        INACTIVE = new g("INACTIVE", 1, "INACTIVE");
        UNKNOWN = new g("UNKNOWN", 2, "");
        $VALUES = (new g[] {
            ACTIVE, INACTIVE, UNKNOWN
        });
    }
}
