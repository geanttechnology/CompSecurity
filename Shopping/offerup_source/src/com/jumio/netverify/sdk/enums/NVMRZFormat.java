// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.enums;


public final class NVMRZFormat extends Enum
{

    private static final NVMRZFormat $VALUES[];
    public static final NVMRZFormat CNIS;
    public static final NVMRZFormat MRP;
    public static final NVMRZFormat MRV_A;
    public static final NVMRZFormat MRV_B;
    public static final NVMRZFormat TD1;
    public static final NVMRZFormat TD2;
    public static final NVMRZFormat Unknown;

    private NVMRZFormat(String s, int i)
    {
        super(s, i);
    }

    public static NVMRZFormat valueOf(String s)
    {
        return (NVMRZFormat)Enum.valueOf(com/jumio/netverify/sdk/enums/NVMRZFormat, s);
    }

    public static NVMRZFormat[] values()
    {
        return (NVMRZFormat[])$VALUES.clone();
    }

    static 
    {
        Unknown = new NVMRZFormat("Unknown", 0);
        MRP = new NVMRZFormat("MRP", 1);
        MRV_A = new NVMRZFormat("MRV_A", 2);
        MRV_B = new NVMRZFormat("MRV_B", 3);
        TD1 = new NVMRZFormat("TD1", 4);
        TD2 = new NVMRZFormat("TD2", 5);
        CNIS = new NVMRZFormat("CNIS", 6);
        $VALUES = (new NVMRZFormat[] {
            Unknown, MRP, MRV_A, MRV_B, TD1, TD2, CNIS
        });
    }
}
