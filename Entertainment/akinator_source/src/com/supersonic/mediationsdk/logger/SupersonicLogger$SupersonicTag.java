// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.logger;


// Referenced classes of package com.supersonic.mediationsdk.logger:
//            SupersonicLogger

public static final class  extends Enum
{

    private static final NATIVE $VALUES[];
    public static final NATIVE ADAPTER_API;
    public static final NATIVE ADAPTER_CALLBACK;
    public static final NATIVE API;
    public static final NATIVE CALLBACK;
    public static final NATIVE INTERNAL;
    public static final NATIVE NATIVE;
    public static final NATIVE NETWORK;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/supersonic/mediationsdk/logger/SupersonicLogger$SupersonicTag, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        API = new <init>("API", 0);
        ADAPTER_API = new <init>("ADAPTER_API", 1);
        CALLBACK = new <init>("CALLBACK", 2);
        ADAPTER_CALLBACK = new <init>("ADAPTER_CALLBACK", 3);
        NETWORK = new <init>("NETWORK", 4);
        INTERNAL = new <init>("INTERNAL", 5);
        NATIVE = new <init>("NATIVE", 6);
        $VALUES = (new .VALUES[] {
            API, ADAPTER_API, CALLBACK, ADAPTER_CALLBACK, NETWORK, INTERNAL, NATIVE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
