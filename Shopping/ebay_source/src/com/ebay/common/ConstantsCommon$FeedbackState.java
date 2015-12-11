// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;


// Referenced classes of package com.ebay.common:
//            ConstantsCommon

public static final class  extends Enum
{

    private static final NotTransactioned $VALUES[];
    public static final NotTransactioned Left;
    public static final NotTransactioned NotLeft;
    public static final NotTransactioned NotTransactioned;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/ConstantsCommon$FeedbackState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Left = new <init>("Left", 0);
        NotLeft = new <init>("NotLeft", 1);
        NotTransactioned = new <init>("NotTransactioned", 2);
        $VALUES = (new .VALUES[] {
            Left, NotLeft, NotTransactioned
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
