// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;


// Referenced classes of package com.groupon.view:
//            CreditCardOneLine

public static final class  extends Enum
{

    private static final CREDIT_CARD_OTHER_EDIT $VALUES[];
    public static final CREDIT_CARD_OTHER_EDIT CREDIT_CARD_NUMBER_EDIT;
    public static final CREDIT_CARD_OTHER_EDIT CREDIT_CARD_OTHER_EDIT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/view/CreditCardOneLine$CreditCardState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CREDIT_CARD_NUMBER_EDIT = new <init>("CREDIT_CARD_NUMBER_EDIT", 0);
        CREDIT_CARD_OTHER_EDIT = new <init>("CREDIT_CARD_OTHER_EDIT", 1);
        $VALUES = (new .VALUES[] {
            CREDIT_CARD_NUMBER_EDIT, CREDIT_CARD_OTHER_EDIT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
