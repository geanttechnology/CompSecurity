// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;


// Referenced classes of package com.amazon.sdk.availability:
//            Connectivity

public static final class  extends Enum
{

    private static final ETHERNET $VALUES[];
    public static final ETHERNET ETHERNET;
    public static final ETHERNET MOBILE;
    public static final ETHERNET WIFI;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/sdk/availability/Connectivity$Network, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MOBILE = new <init>("MOBILE", 0);
        WIFI = new <init>("WIFI", 1);
        ETHERNET = new <init>("ETHERNET", 2);
        $VALUES = (new .VALUES[] {
            MOBILE, WIFI, ETHERNET
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
