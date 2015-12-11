// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;


// Referenced classes of package com.supersonicads.sdk.data:
//            SSASession

public static final class  extends Enum
{

    private static final backFromBG $VALUES[];
    public static final backFromBG backFromBG;
    public static final backFromBG launched;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/supersonicads/sdk/data/SSASession$SessionType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        launched = new <init>("launched", 0);
        backFromBG = new <init>("backFromBG", 1);
        $VALUES = (new .VALUES[] {
            launched, backFromBG
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
