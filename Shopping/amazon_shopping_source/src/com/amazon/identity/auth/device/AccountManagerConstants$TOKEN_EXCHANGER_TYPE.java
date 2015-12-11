// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;


// Referenced classes of package com.amazon.identity.auth.device:
//            AccountManagerConstants

public static final class  extends Enum
{

    private static final REFRESH_FOR_COOKIES $VALUES[];
    public static final REFRESH_FOR_COOKIES DMS_FOR_ACCESS;
    public static final REFRESH_FOR_COOKIES REFRESH_FOR_ACCESS;
    public static final REFRESH_FOR_COOKIES REFRESH_FOR_COOKIES;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/identity/auth/device/AccountManagerConstants$TOKEN_EXCHANGER_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        REFRESH_FOR_ACCESS = new <init>("REFRESH_FOR_ACCESS", 0);
        DMS_FOR_ACCESS = new <init>("DMS_FOR_ACCESS", 1);
        REFRESH_FOR_COOKIES = new <init>("REFRESH_FOR_COOKIES", 2);
        $VALUES = (new .VALUES[] {
            REFRESH_FOR_ACCESS, DMS_FOR_ACCESS, REFRESH_FOR_COOKIES
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
