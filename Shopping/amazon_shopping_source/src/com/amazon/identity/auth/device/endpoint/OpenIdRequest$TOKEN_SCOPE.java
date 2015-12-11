// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.endpoint;


// Referenced classes of package com.amazon.identity.auth.device.endpoint:
//            OpenIdRequest

public static final class  extends Enum
{

    private static final REFRESH $VALUES[];
    public static final REFRESH ACCESS;
    public static final REFRESH REFRESH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/device/endpoint/OpenIdRequest$TOKEN_SCOPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ACCESS = new <init>("ACCESS", 0);
        REFRESH = new <init>("REFRESH", 1);
        $VALUES = (new .VALUES[] {
            ACCESS, REFRESH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
