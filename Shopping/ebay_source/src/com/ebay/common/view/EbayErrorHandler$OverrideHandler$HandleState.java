// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;


// Referenced classes of package com.ebay.common.view:
//            EbayErrorHandler

public static final class  extends Enum
{

    private static final Ignored $VALUES[];
    public static final Ignored DefaultHandling;
    public static final Ignored Handled;
    public static final Ignored Ignored;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/view/EbayErrorHandler$OverrideHandler$HandleState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DefaultHandling = new <init>("DefaultHandling", 0);
        Handled = new <init>("Handled", 1);
        Ignored = new <init>("Ignored", 2);
        $VALUES = (new .VALUES[] {
            DefaultHandling, Handled, Ignored
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
