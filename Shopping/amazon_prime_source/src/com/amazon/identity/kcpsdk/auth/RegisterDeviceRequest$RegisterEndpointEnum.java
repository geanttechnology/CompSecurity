// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            RegisterDeviceRequest

public static final class  extends Enum
{

    private static final Panda $VALUES[];
    public static final Panda FIRS;
    public static final Panda Panda;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$RegisterEndpointEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FIRS = new <init>("FIRS", 0);
        Panda = new <init>("Panda", 1);
        $VALUES = (new .VALUES[] {
            FIRS, Panda
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
