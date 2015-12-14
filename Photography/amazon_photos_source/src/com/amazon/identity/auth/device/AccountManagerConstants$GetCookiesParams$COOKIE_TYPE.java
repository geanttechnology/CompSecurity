// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;


// Referenced classes of package com.amazon.identity.auth.device:
//            AccountManagerConstants

public static final class  extends Enum
{

    private static final DELEGATED_COOKIE $VALUES[];
    public static final DELEGATED_COOKIE COOKIE;
    public static final DELEGATED_COOKIE DELEGATED_COOKIE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        COOKIE = new <init>("COOKIE", 0);
        DELEGATED_COOKIE = new <init>("DELEGATED_COOKIE", 1);
        $VALUES = (new .VALUES[] {
            COOKIE, DELEGATED_COOKIE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
