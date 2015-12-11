// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.enums;


public final class NVScanSide extends Enum
{

    private static final NVScanSide $VALUES[];
    public static final NVScanSide BACK;
    public static final NVScanSide FACE;
    public static final NVScanSide FRONT;
    private int part;

    private NVScanSide(String s, int i, int j)
    {
        super(s, i);
        part = j;
    }

    public static NVScanSide valueOf(String s)
    {
        return (NVScanSide)Enum.valueOf(com/jumio/netverify/sdk/enums/NVScanSide, s);
    }

    public static NVScanSide[] values()
    {
        return (NVScanSide[])$VALUES.clone();
    }

    public final int getPartNumber()
    {
        return part;
    }

    static 
    {
        FRONT = new NVScanSide("FRONT", 0, 0);
        BACK = new NVScanSide("BACK", 1, 1);
        FACE = new NVScanSide("FACE", 2, 2);
        $VALUES = (new NVScanSide[] {
            FRONT, BACK, FACE
        });
    }
}
