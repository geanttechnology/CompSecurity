// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.kcpsdk.auth.RegisterDeviceErrorType;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountRegistrar, AccountRegistrarAuthenticator

class stener extends gisterDeviceAmazonWebserviceCallListener
{

    final AccountRegistrar this$0;
    final AccountRegistrarAuthenticator val$accountRegAuth;

    protected void cleanupDeviceState(RegisterDeviceErrorType registerdeviceerrortype)
    {
    }

    protected gisterInfo onRegisterResponseComplete(RegisterDeviceResponse registerdeviceresponse)
    {
        AccountRegistrar.access$300$32336411(AccountRegistrar.this, registerdeviceresponse);
        if (AccountRegistrar.access$400(AccountRegistrar.this, registerdeviceresponse, val$accountRegAuth))
        {
            return new gisterInfo();
        } else
        {
            return new gisterInfo(com.amazon.identity.auth.device.api.egistrationError.UNRECOGNIZED);
        }
    }

    stener(AccountRegistrarAuthenticator accountregistrarauthenticator)
    {
        this$0 = final_accountregistrar;
        val$accountRegAuth = accountregistrarauthenticator;
        super(stener.this);
    }
}
