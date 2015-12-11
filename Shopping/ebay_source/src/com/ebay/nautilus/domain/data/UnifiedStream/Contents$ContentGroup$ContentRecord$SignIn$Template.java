// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;


// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents

public static final class  extends Enum
{

    private static final MINI $VALUES[];
    public static final MINI FULLSCREEN;
    public static final MINI MINI;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/data/UnifiedStream/Contents$ContentGroup$ContentRecord$SignIn$Template, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FULLSCREEN = new <init>("FULLSCREEN", 0);
        MINI = new <init>("MINI", 1);
        $VALUES = (new .VALUES[] {
            FULLSCREEN, MINI
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
