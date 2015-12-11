// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPOptionManager

static final class  extends Enum
{

    private static final TPOptionDisableCaching_system $VALUES[];
    public static final TPOptionDisableCaching_system TPOptionDisableCaching_library;
    public static final TPOptionDisableCaching_system TPOptionDisableCaching_none;
    public static final TPOptionDisableCaching_system TPOptionDisableCaching_system;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/twinprime/TwinPrimeSDK/TPOptionManager$TPOptionDisableCaching, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TPOptionDisableCaching_none = new <init>("TPOptionDisableCaching_none", 0);
        TPOptionDisableCaching_library = new <init>("TPOptionDisableCaching_library", 1);
        TPOptionDisableCaching_system = new <init>("TPOptionDisableCaching_system", 2);
        $VALUES = (new .VALUES[] {
            TPOptionDisableCaching_none, TPOptionDisableCaching_library, TPOptionDisableCaching_system
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
