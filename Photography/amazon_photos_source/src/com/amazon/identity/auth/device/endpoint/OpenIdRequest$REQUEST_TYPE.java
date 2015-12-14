// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.endpoint;


// Referenced classes of package com.amazon.identity.auth.device.endpoint:
//            OpenIdRequest

public static final class I extends Enum
{

    private static final AUTHENTICATE $VALUES[];
    public static final AUTHENTICATE AUTHENTICATE;
    public static final AUTHENTICATE CONFIRM_CREDENTIAL;
    public static final AUTHENTICATE REGISTER;
    public static final AUTHENTICATE SIGN_IN;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        SIGN_IN = new <init>("SIGN_IN", 0);
        REGISTER = new <init>("REGISTER", 1);
        CONFIRM_CREDENTIAL = new <init>("CONFIRM_CREDENTIAL", 2);
        AUTHENTICATE = new <init>("AUTHENTICATE", 3);
        $VALUES = (new .VALUES[] {
            SIGN_IN, REGISTER, CONFIRM_CREDENTIAL, AUTHENTICATE
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
