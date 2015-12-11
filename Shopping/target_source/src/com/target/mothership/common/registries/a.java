// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.registries;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a CO_REG;
    public static final a PRIMARY_REG;
    public static final a UNKNOWN;
    private String mValue;

    private a(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static a a(String s)
    {
        if (s != null)
        {
            a aa[] = values();
            int j = aa.length;
            for (int i = 0; i < j; i++)
            {
                a a1 = aa[i];
                if (s.equalsIgnoreCase(a1.mValue))
                {
                    return a1;
                }
            }

        }
        return UNKNOWN;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/common/registries/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        PRIMARY_REG = new a("PRIMARY_REG", 0, "PRIMARY_REG");
        CO_REG = new a("CO_REG", 1, "CO_REG");
        UNKNOWN = new a("UNKNOWN", 2, "");
        $VALUES = (new a[] {
            PRIMARY_REG, CO_REG, UNKNOWN
        });
    }
}
