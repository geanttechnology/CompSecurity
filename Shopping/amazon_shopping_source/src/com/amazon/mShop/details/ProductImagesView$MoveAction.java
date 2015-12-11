// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;


// Referenced classes of package com.amazon.mShop.details:
//            ProductImagesView

public static final class  extends Enum
{

    private static final RIGHT $VALUES[];
    public static final RIGHT CLICK;
    public static final RIGHT LEFT;
    public static final RIGHT RIGHT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/details/ProductImagesView$MoveAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CLICK = new <init>("CLICK", 0);
        LEFT = new <init>("LEFT", 1);
        RIGHT = new <init>("RIGHT", 2);
        $VALUES = (new .VALUES[] {
            CLICK, LEFT, RIGHT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
