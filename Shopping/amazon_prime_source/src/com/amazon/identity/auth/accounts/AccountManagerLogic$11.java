// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.api.SigninOption;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerLogic

static class 
{

    static final int $SwitchMap$com$amazon$identity$auth$device$api$SigninOption[];

    static 
    {
        $SwitchMap$com$amazon$identity$auth$device$api$SigninOption = new int[SigninOption.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$SigninOption[SigninOption.WebviewSignin.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$SigninOption[SigninOption.WebviewCreateAccount.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$SigninOption[SigninOption.MyAccountSignin.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$identity$auth$device$api$SigninOption[SigninOption.WebviewConfirmCredentials.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
