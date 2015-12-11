// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;


// Referenced classes of package com.target.ui.view.checkout:
//            PromoCodeAppliedView

private static final class  extends Enum
{

    private static final TEAM_MEMBER_DISCOUNT $VALUES[];
    public static final TEAM_MEMBER_DISCOUNT PROMO_CODE;
    public static final TEAM_MEMBER_DISCOUNT TEAM_MEMBER_DISCOUNT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/view/checkout/PromoCodeAppliedView$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PROMO_CODE = new <init>("PROMO_CODE", 0);
        TEAM_MEMBER_DISCOUNT = new <init>("TEAM_MEMBER_DISCOUNT", 1);
        $VALUES = (new .VALUES[] {
            PROMO_CODE, TEAM_MEMBER_DISCOUNT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
