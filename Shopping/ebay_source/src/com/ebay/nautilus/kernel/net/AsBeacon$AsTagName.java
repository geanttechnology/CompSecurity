// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;


// Referenced classes of package com.ebay.nautilus.kernel.net:
//            AsBeacon

public static final class  extends Enum
{

    private static final reload $VALUES[];
    public static final reload landscape;
    public static final reload launch;
    public static final reload reload;
    public static final reload signedout;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/kernel/net/AsBeacon$AsTagName, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        launch = new <init>("launch", 0);
        landscape = new <init>("landscape", 1);
        signedout = new <init>("signedout", 2);
        reload = new <init>("reload", 3);
        $VALUES = (new .VALUES[] {
            launch, landscape, signedout, reload
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
