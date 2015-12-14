// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;


// Referenced classes of package com.amazon.identity.auth.device:
//            AccountManagerConstants

public static final class  extends Enum
{

    private static final DELEGATED_ACCESS_TOKEN $VALUES[];
    public static final DELEGATED_ACCESS_TOKEN ACCESS_TOKEN;
    public static final DELEGATED_ACCESS_TOKEN DELEGATED_ACCESS_TOKEN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/device/AccountManagerConstants$GetTokenParams$TOKEN_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ACCESS_TOKEN = new <init>("ACCESS_TOKEN", 0);
        DELEGATED_ACCESS_TOKEN = new <init>("DELEGATED_ACCESS_TOKEN", 1);
        $VALUES = (new .VALUES[] {
            ACCESS_TOKEN, DELEGATED_ACCESS_TOKEN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
