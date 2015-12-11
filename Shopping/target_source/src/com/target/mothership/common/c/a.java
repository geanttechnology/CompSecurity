// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.c;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a GENERIC_ITEM;
    public static final a TCIN;
    private String mValue;

    private a(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/common/c/a, s);
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
        GENERIC_ITEM = new a("GENERIC_ITEM", 0, "GENERIC_ITEM");
        TCIN = new a("TCIN", 1, "TCIN");
        $VALUES = (new a[] {
            GENERIC_ITEM, TCIN
        });
    }
}
