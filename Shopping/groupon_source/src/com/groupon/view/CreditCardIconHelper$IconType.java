// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;


// Referenced classes of package com.groupon.view:
//            CreditCardIconHelper

public static final class  extends Enum
{

    private static final REDESIGNED_SMALL $VALUES[];
    public static final REDESIGNED_SMALL LARGE;
    public static final REDESIGNED_SMALL PAYMENT_ICON;
    public static final REDESIGNED_SMALL REDESIGNED;
    public static final REDESIGNED_SMALL REDESIGNED_SMALL;
    public static final REDESIGNED_SMALL SMALL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/view/CreditCardIconHelper$IconType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SMALL = new <init>("SMALL", 0);
        LARGE = new <init>("LARGE", 1);
        REDESIGNED = new <init>("REDESIGNED", 2);
        PAYMENT_ICON = new <init>("PAYMENT_ICON", 3);
        REDESIGNED_SMALL = new <init>("REDESIGNED_SMALL", 4);
        $VALUES = (new .VALUES[] {
            SMALL, LARGE, REDESIGNED, PAYMENT_ICON, REDESIGNED_SMALL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
