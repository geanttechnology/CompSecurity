// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;


// Referenced classes of package com.amazon.mShop.search.viewit:
//            ResultWrapper

public static final class mTypeValue extends Enum
{

    private static final IMAGE $VALUES[];
    public static final IMAGE BARCODE;
    public static final IMAGE IMAGE;
    private String mTypeValue;

    public static mTypeValue valueOf(String s)
    {
        return (mTypeValue)Enum.valueOf(com/amazon/mShop/search/viewit/ResultWrapper$ResultType, s);
    }

    public static mTypeValue[] values()
    {
        return (mTypeValue[])$VALUES.clone();
    }

    public String getTypeValue()
    {
        return mTypeValue;
    }

    static 
    {
        BARCODE = new <init>("BARCODE", 0, "barcode:");
        IMAGE = new <init>("IMAGE", 1, "image:");
        $VALUES = (new .VALUES[] {
            BARCODE, IMAGE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mTypeValue = null;
        mTypeValue = s1;
    }
}
