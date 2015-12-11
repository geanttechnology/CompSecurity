// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.a;


public final class i extends Enum
{

    private static final i $VALUES[];
    private static final String APPLIED = "Applied";
    public static final i Applied;
    private static final String ELIGIBLE = "Eligible";
    public static final i Eligible;
    public static final i Not_Eligible;

    private i(String s, int j)
    {
        super(s, j);
    }

    public static i valueOf(String s)
    {
        return (i)Enum.valueOf(com/target/mothership/common/a/i, s);
    }

    public static i[] values()
    {
        return (i[])$VALUES.clone();
    }

    static 
    {
        Applied = new i("Applied", 0);
        Eligible = new i("Eligible", 1);
        Not_Eligible = new i("Not_Eligible", 2);
        $VALUES = (new i[] {
            Applied, Eligible, Not_Eligible
        });
    }
}
