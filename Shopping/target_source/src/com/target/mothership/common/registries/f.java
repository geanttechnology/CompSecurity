// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.registries;


public final class f extends Enum
{

    private static final f $VALUES[];
    public static final f ASCENDING_ORDER;
    public static final f DESCENDING_ORDER;
    public static final f UNKNOWN;
    private String mValue;

    private f(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static f a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        f f1 = UNKNOWN;
_L4:
        return f1;
_L2:
        f af[];
        int i;
        int j;
        af = values();
        j = af.length;
        i = 0;
_L6:
        f f2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        f2 = af[i];
        f1 = f2;
        if (s.equalsIgnoreCase(f2.toString())) goto _L4; else goto _L3
_L3:
        f1 = f2;
        if (s.equalsIgnoreCase(f2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/target/mothership/common/registries/f, s);
    }

    public static f[] values()
    {
        return (f[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        ASCENDING_ORDER = new f("ASCENDING_ORDER", 0, "asc");
        DESCENDING_ORDER = new f("DESCENDING_ORDER", 1, "desc");
        UNKNOWN = new f("UNKNOWN", 2, "");
        $VALUES = (new f[] {
            ASCENDING_ORDER, DESCENDING_ORDER, UNKNOWN
        });
    }
}
