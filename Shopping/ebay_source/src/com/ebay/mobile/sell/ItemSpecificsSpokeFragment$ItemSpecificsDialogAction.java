// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;


// Referenced classes of package com.ebay.mobile.sell:
//            ItemSpecificsSpokeFragment

public static final class  extends Enum
{

    private static final SAVE_CUSTOM $VALUES[];
    public static final SAVE_CUSTOM SAVE_CUSTOM;
    public static final SAVE_CUSTOM SAVE_MULTIPLE;
    public static final SAVE_CUSTOM SAVE_SINGLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/sell/ItemSpecificsSpokeFragment$ItemSpecificsDialogAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SAVE_SINGLE = new <init>("SAVE_SINGLE", 0);
        SAVE_MULTIPLE = new <init>("SAVE_MULTIPLE", 1);
        SAVE_CUSTOM = new <init>("SAVE_CUSTOM", 2);
        $VALUES = (new .VALUES[] {
            SAVE_SINGLE, SAVE_MULTIPLE, SAVE_CUSTOM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
