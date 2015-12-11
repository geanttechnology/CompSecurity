// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebSettings

public static final class  extends Enum
{

    private static final OFF $VALUES[];
    public static final OFF OFF;
    public static final OFF ON;
    public static final OFF ON_DEMAND;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/android/webkit/AmazonWebSettings$PluginState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ON = new <init>("ON", 0);
        ON_DEMAND = new <init>("ON_DEMAND", 1);
        OFF = new <init>("OFF", 2);
        $VALUES = (new .VALUES[] {
            ON, ON_DEMAND, OFF
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
