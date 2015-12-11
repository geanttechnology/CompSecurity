// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;


// Referenced classes of package com.amazon.mShop.gno:
//            GNOItemAdapter

private static final class mValue extends Enum
{

    private static final SUB_DIVIDER $VALUES[];
    public static final SUB_DIVIDER DIVIDER;
    public static final SUB_DIVIDER SUB_DIVIDER;
    private int mValue;

    public static mValue valueOf(String s)
    {
        return (mValue)Enum.valueOf(com/amazon/mShop/gno/GNOItemAdapter$DividerType, s);
    }

    public static mValue[] values()
    {
        return (mValue[])$VALUES.clone();
    }

    static 
    {
        DIVIDER = new <init>("DIVIDER", 0, 0);
        SUB_DIVIDER = new <init>("SUB_DIVIDER", 1, 1);
        $VALUES = (new .VALUES[] {
            DIVIDER, SUB_DIVIDER
        });
    }


    private (String s, int i, int j)
    {
        super(s, i);
        mValue = j;
    }
}
