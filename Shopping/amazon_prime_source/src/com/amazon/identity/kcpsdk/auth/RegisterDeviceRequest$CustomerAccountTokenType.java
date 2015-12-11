// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            RegisterDeviceRequest

public static final class mValue extends Enum
{

    private static final AUTH_TOKEN $VALUES[];
    public static final AUTH_TOKEN ACCESS_TOKEN;
    public static final AUTH_TOKEN AT_MAIN;
    public static final AUTH_TOKEN AUTH_TOKEN;
    private final String mValue;

    public static mValue valueOf(String s)
    {
        return (mValue)Enum.valueOf(com/amazon/identity/kcpsdk/auth/RegisterDeviceRequest$CustomerAccountTokenType, s);
    }

    public static mValue[] values()
    {
        return (mValue[])$VALUES.clone();
    }

    public String getValue()
    {
        return mValue;
    }

    static 
    {
        AT_MAIN = new <init>("AT_MAIN", 0, "ATMain");
        ACCESS_TOKEN = new <init>("ACCESS_TOKEN", 1, "AccessToken");
        AUTH_TOKEN = new <init>("AUTH_TOKEN", 2, "AuthToken");
        $VALUES = (new .VALUES[] {
            AT_MAIN, ACCESS_TOKEN, AUTH_TOKEN
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }
}
