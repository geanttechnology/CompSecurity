// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutConfirmationFragment_Offers

static final class  extends Enum
{

    private static final NEW_OFFER $VALUES[];
    public static final NEW_OFFER EXISTING_OFFER;
    public static final NEW_OFFER NEW_OFFER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EXISTING_OFFER = new <init>("EXISTING_OFFER", 0);
        NEW_OFFER = new <init>("NEW_OFFER", 1);
        $VALUES = (new .VALUES[] {
            EXISTING_OFFER, NEW_OFFER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
