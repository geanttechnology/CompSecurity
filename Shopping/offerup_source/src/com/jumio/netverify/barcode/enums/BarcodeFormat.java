// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.barcode.enums;


public final class BarcodeFormat extends Enum
{

    private static final BarcodeFormat $VALUES[];
    public static final BarcodeFormat CODE128;
    public static final BarcodeFormat CODE39;
    public static final BarcodeFormat EAN13;
    public static final BarcodeFormat EAN8;
    public static final BarcodeFormat ITF;
    public static final BarcodeFormat PDF417;
    public static final BarcodeFormat QR;
    public static final BarcodeFormat UPCA;
    public static final BarcodeFormat UPCE;
    private int type;

    private BarcodeFormat(String s, int i, int j)
    {
        super(s, i);
        type = j;
    }

    public static BarcodeFormat valueOf(String s)
    {
        return (BarcodeFormat)Enum.valueOf(com/jumio/netverify/barcode/enums/BarcodeFormat, s);
    }

    public static BarcodeFormat[] values()
    {
        return (BarcodeFormat[])$VALUES.clone();
    }

    public final int getType()
    {
        return type;
    }

    static 
    {
        UPCA = new BarcodeFormat("UPCA", 0, 1);
        UPCE = new BarcodeFormat("UPCE", 1, 2);
        ITF = new BarcodeFormat("ITF", 2, 3);
        EAN8 = new BarcodeFormat("EAN8", 3, 4);
        EAN13 = new BarcodeFormat("EAN13", 4, 5);
        CODE39 = new BarcodeFormat("CODE39", 5, 6);
        CODE128 = new BarcodeFormat("CODE128", 6, 7);
        QR = new BarcodeFormat("QR", 7, 8);
        PDF417 = new BarcodeFormat("PDF417", 8, 9);
        $VALUES = (new BarcodeFormat[] {
            UPCA, UPCE, ITF, EAN8, EAN13, CODE39, CODE128, QR, PDF417
        });
    }
}
