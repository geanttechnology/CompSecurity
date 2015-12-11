// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            CheckoutFlowHandler

public static final class  extends Enum
{

    private static final OFFER_MODE $VALUES[];
    public static final OFFER_MODE BUY_MODE;
    public static final OFFER_MODE OFFER_MODE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/utils/CheckoutFlowHandler$MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BUY_MODE = new <init>("BUY_MODE", 0);
        OFFER_MODE = new <init>("OFFER_MODE", 1);
        $VALUES = (new .VALUES[] {
            BUY_MODE, OFFER_MODE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
