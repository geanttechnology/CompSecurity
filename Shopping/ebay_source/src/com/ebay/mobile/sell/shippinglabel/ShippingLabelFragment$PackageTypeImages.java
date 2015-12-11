// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;


// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelFragment

public static final class displayImg extends Enum
{

    private static final YR_PKG $VALUES[];
    public static final YR_PKG BOX;
    public static final YR_PKG ENVLP;
    public static final YR_PKG PAK;
    public static final YR_PKG TUBE;
    public static final YR_PKG YR_PKG;
    public int displayImg;

    public static displayImg valueOf(String s)
    {
        return (displayImg)Enum.valueOf(com/ebay/mobile/sell/shippinglabel/ShippingLabelFragment$PackageTypeImages, s);
    }

    public static displayImg[] values()
    {
        return (displayImg[])$VALUES.clone();
    }

    static 
    {
        ENVLP = new <init>("ENVLP", 0, 0x7f020220);
        PAK = new <init>("PAK", 1, 0x7f020221);
        BOX = new <init>("BOX", 2, 0x7f02021f);
        TUBE = new <init>("TUBE", 3, 0x7f020222);
        YR_PKG = new <init>("YR_PKG", 4, 0x7f020223);
        $VALUES = (new .VALUES[] {
            ENVLP, PAK, BOX, TUBE, YR_PKG
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        displayImg = ordinal();
        displayImg = j;
    }
}
