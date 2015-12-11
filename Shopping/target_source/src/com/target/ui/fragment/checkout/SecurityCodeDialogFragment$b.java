// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;


// Referenced classes of package com.target.ui.fragment.checkout:
//            SecurityCodeDialogFragment

private static final class  extends Enum
{

    private static final Cvv $VALUES[];
    public static final Cvv Cvv;
    public static final Cvv TargetDebitCardPin;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/fragment/checkout/SecurityCodeDialogFragment$b, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TargetDebitCardPin = new <init>("TargetDebitCardPin", 0);
        Cvv = new <init>("Cvv", 1);
        $VALUES = (new .VALUES[] {
            TargetDebitCardPin, Cvv
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
