// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutFormFragment

static final class _cls9 extends Enum
{

    private static final OFFER_MODE $VALUES[];
    public static final OFFER_MODE BUY_MODE;
    public static final OFFER_MODE OFFER_MODE;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/poshmark/ui/fragments/CheckoutFormFragment$MODE, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        BUY_MODE = new <init>("BUY_MODE", 0);
        OFFER_MODE = new <init>("OFFER_MODE", 1);
        $VALUES = (new .VALUES[] {
            BUY_MODE, OFFER_MODE
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
