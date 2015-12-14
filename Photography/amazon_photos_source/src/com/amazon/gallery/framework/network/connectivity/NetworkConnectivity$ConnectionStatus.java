// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.connectivity;


// Referenced classes of package com.amazon.gallery.framework.network.connectivity:
//            NetworkConnectivity

public static final class  extends Enum
{

    private static final ETHERNET $VALUES[];
    public static final ETHERNET ETHERNET;
    public static final ETHERNET NONE;
    public static final ETHERNET WAN;
    public static final ETHERNET WIFI;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/network/connectivity/NetworkConnectivity$ConnectionStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        WAN = new <init>("WAN", 1);
        WIFI = new <init>("WIFI", 2);
        ETHERNET = new <init>("ETHERNET", 3);
        $VALUES = (new .VALUES[] {
            NONE, WAN, WIFI, ETHERNET
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
