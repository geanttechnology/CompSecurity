// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


// Referenced classes of package com.target.mothership.common.product:
//            ProductIdentifier

public static final class  extends Enum
{

    private static final BARCODE $VALUES[];
    public static final BARCODE BARCODE;
    public static final BARCODE CATENTRYID;
    public static final BARCODE DPCI;
    public static final BARCODE TCIN;
    public static final BARCODE UPC;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/mothership/common/product/ProductIdentifier$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TCIN = new <init>("TCIN", 0);
        UPC = new <init>("UPC", 1);
        DPCI = new <init>("DPCI", 2);
        CATENTRYID = new <init>("CATENTRYID", 3);
        BARCODE = new <init>("BARCODE", 4);
        $VALUES = (new .VALUES[] {
            TCIN, UPC, DPCI, CATENTRYID, BARCODE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
