// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;


public final class SigninOption extends Enum
{

    private static final SigninOption $VALUES[];
    public static final SigninOption MyAccountSignin;
    public static final SigninOption WebviewConfirmCredentials;
    public static final SigninOption WebviewCreateAccount;
    public static final SigninOption WebviewSignin;

    private SigninOption(String s, int i)
    {
        super(s, i);
    }

    public static SigninOption valueOf(String s)
    {
        return (SigninOption)Enum.valueOf(com/amazon/identity/auth/device/api/SigninOption, s);
    }

    public static SigninOption[] values()
    {
        return (SigninOption[])$VALUES.clone();
    }

    static 
    {
        WebviewSignin = new SigninOption("WebviewSignin", 0);
        WebviewCreateAccount = new SigninOption("WebviewCreateAccount", 1);
        MyAccountSignin = new SigninOption("MyAccountSignin", 2);
        WebviewConfirmCredentials = new SigninOption("WebviewConfirmCredentials", 3);
        $VALUES = (new SigninOption[] {
            WebviewSignin, WebviewCreateAccount, MyAccountSignin, WebviewConfirmCredentials
        });
    }
}
