// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.endpoint;


// Referenced classes of package com.amazon.identity.auth.device.endpoint:
//            OpenIdRequest

public static final class I extends Enum
{

    private static final FORGOT_PASSWORD $VALUES[];
    public static final FORGOT_PASSWORD AUTHENTICATE;
    public static final FORGOT_PASSWORD CONFIRM_CREDENTIAL;
    public static final FORGOT_PASSWORD FORGOT_PASSWORD;
    public static final FORGOT_PASSWORD REGISTER;
    public static final FORGOT_PASSWORD SIGN_IN;

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
        FORGOT_PASSWORD = new <init>("FORGOT_PASSWORD", 4);
        $VALUES = (new .VALUES[] {
            SIGN_IN, REGISTER, CONFIRM_CREDENTIAL, AUTHENTICATE, FORGOT_PASSWORD
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
