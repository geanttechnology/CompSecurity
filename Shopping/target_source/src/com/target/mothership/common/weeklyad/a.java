// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.weeklyad;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a ONLINE_ONLY;
    public static final a ONLINE_STORES;
    public static final a STORE_ONLY;
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
        return (a)Enum.valueOf(com/target/mothership/common/weeklyad/a, s);
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
        STORE_ONLY = new a("STORE_ONLY", 0, "available in stores only");
        ONLINE_ONLY = new a("ONLINE_ONLY", 1, "available online only");
        ONLINE_STORES = new a("ONLINE_STORES", 2, "sold online + in stores");
        UNKNOWN = new a("UNKNOWN", 3, "");
        $VALUES = (new a[] {
            STORE_ONLY, ONLINE_ONLY, ONLINE_STORES, UNKNOWN
        });
    }
}
