// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.enums;


public final class NVGender extends Enum
{

    private static final NVGender $VALUES[];
    public static final NVGender F;
    public static final NVGender M;

    private NVGender(String s, int i)
    {
        super(s, i);
    }

    public static NVGender valueOf(String s)
    {
        return (NVGender)Enum.valueOf(com/jumio/netverify/sdk/enums/NVGender, s);
    }

    public static NVGender[] values()
    {
        return (NVGender[])$VALUES.clone();
    }

    static 
    {
        M = new NVGender("M", 0);
        F = new NVGender("F", 1);
        $VALUES = (new NVGender[] {
            M, F
        });
    }
}
