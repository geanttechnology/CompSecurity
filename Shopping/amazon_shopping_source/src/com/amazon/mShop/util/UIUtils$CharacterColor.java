// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;


// Referenced classes of package com.amazon.mShop.util:
//            UIUtils

public static final class  extends Enum
{

    private static final BLACK $VALUES[];
    public static final BLACK BLACK;
    public static final BLACK DARK_GRAY;
    public static final BLACK RED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/util/UIUtils$CharacterColor, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        RED = new <init>("RED", 0);
        DARK_GRAY = new <init>("DARK_GRAY", 1);
        BLACK = new <init>("BLACK", 2);
        $VALUES = (new .VALUES[] {
            RED, DARK_GRAY, BLACK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
