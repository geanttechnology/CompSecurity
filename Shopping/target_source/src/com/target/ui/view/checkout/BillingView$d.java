// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;


// Referenced classes of package com.target.ui.view.checkout:
//            BillingView

private static final class  extends Enum
{

    private static final AddNewCard $VALUES[];
    public static final AddNewCard AddNewCard;
    public static final AddNewCard EditAddress;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/view/checkout/BillingView$d, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EditAddress = new <init>("EditAddress", 0);
        AddNewCard = new <init>("AddNewCard", 1);
        $VALUES = (new .VALUES[] {
            EditAddress, AddNewCard
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
