// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.enums;


public final class NVScanMode extends Enum
{

    private static final NVScanMode $VALUES[];
    public static final NVScanMode BARCODE;
    public static final NVScanMode FACE;
    public static final NVScanMode FACE_MANUAL;
    public static final NVScanMode LINE_FINDER;
    public static final NVScanMode MANUAL;
    public static final NVScanMode MRZ;
    public static final NVScanMode TEMPLATE_MATCHER;

    private NVScanMode(String s, int i)
    {
        super(s, i);
    }

    public static NVScanMode valueOf(String s)
    {
        return (NVScanMode)Enum.valueOf(com/jumio/netverify/sdk/enums/NVScanMode, s);
    }

    public static NVScanMode[] values()
    {
        return (NVScanMode[])$VALUES.clone();
    }

    static 
    {
        TEMPLATE_MATCHER = new NVScanMode("TEMPLATE_MATCHER", 0);
        LINE_FINDER = new NVScanMode("LINE_FINDER", 1);
        MRZ = new NVScanMode("MRZ", 2);
        BARCODE = new NVScanMode("BARCODE", 3);
        MANUAL = new NVScanMode("MANUAL", 4);
        FACE_MANUAL = new NVScanMode("FACE_MANUAL", 5);
        FACE = new NVScanMode("FACE", 6);
        $VALUES = (new NVScanMode[] {
            TEMPLATE_MATCHER, LINE_FINDER, MRZ, BARCODE, MANUAL, FACE_MANUAL, FACE
        });
    }
}
