// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.kcpsdk.auth.AuthenticateAccountError;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountAuthenticator

static class 
{

    static final int $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[];

    static 
    {
        $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError = new int[AuthenticateAccountError.values().length];
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorCredentialError.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorInvalidValue.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorMissingValue.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorServerError.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorServiceUnavailable.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorUnknown.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorChallengeException.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
