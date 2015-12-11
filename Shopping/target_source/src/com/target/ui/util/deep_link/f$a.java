// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;


// Referenced classes of package com.target.ui.util.deep_link:
//            f

public static final class  extends Enum
{

    private static final PROMOTION $VALUES[];
    public static final PROMOTION PROMOTION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/util/deep_link/f$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PROMOTION = new <init>("PROMOTION", 0);
        $VALUES = (new .VALUES[] {
            PROMOTION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
