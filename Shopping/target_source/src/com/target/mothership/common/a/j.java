// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.a;


public final class j extends Enum
{

    private static final j $VALUES[];
    public static final j LIST;
    public static final j REGISTRY;
    public static final j UNKNOWN;
    private String mValue;

    private j(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static j a(String s)
    {
        if (s != null)
        {
            j aj[] = values();
            int k = aj.length;
            for (int i = 0; i < k; i++)
            {
                j j1 = aj[i];
                if (s.equalsIgnoreCase(j1.mValue))
                {
                    return j1;
                }
            }

        }
        return UNKNOWN;
    }

    public static j valueOf(String s)
    {
        return (j)Enum.valueOf(com/target/mothership/common/a/j, s);
    }

    public static j[] values()
    {
        return (j[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        REGISTRY = new j("REGISTRY", 0, "R");
        LIST = new j("LIST", 1, "L");
        UNKNOWN = new j("UNKNOWN", 2, "");
        $VALUES = (new j[] {
            REGISTRY, LIST, UNKNOWN
        });
    }
}
