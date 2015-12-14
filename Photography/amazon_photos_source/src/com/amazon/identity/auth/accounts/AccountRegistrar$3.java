// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.DefaultAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.DeregisterDeviceError;
import com.amazon.identity.kcpsdk.auth.DeregisterDeviceErrorType;
import com.amazon.identity.kcpsdk.auth.DeregisterDeviceResponse;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountRegistrar, AccountRegistrarAuthenticator

class ceCallListener extends DefaultAmazonWebserviceCallListener
{

    final AccountRegistrar this$0;
    final AccountRegistrarAuthenticator val$accountRegAuth;
    final boolean val$deregisterAllAccounts;
    final stener val$listener;
    final Tracer val$tracer;

    public void onAuthenticationFailed()
    {
        MAPLog.e(AccountRegistrar.access$000(), "Authentication failure performing deregistration request");
        val$listener.failure(com.amazon.identity.auth.device.api.egistrationError.AUTHENTICATION_FAILED, null);
    }

    public void onNetworkFailure()
    {
        MAPLog.e(AccountRegistrar.access$000(), "Network failure performing deregistration request");
        val$listener.failure(com.amazon.identity.auth.device.api.egistrationError.NETWORK_FAILURE, null);
    }

    public void onParseError$6fe276bc()
    {
        MAPLog.e(AccountRegistrar.access$000(), "Parsing failure performing deregistration request");
        val$listener.failure(com.amazon.identity.auth.device.api.egistrationError.PARSE_ERROR, null);
    }

    public void onResponseComplete(Object obj)
    {
        MAPLog.i(AccountRegistrar.access$000(), "Successfully completed the deregistration request");
        obj = (DeregisterDeviceResponse)obj;
        if (obj == null)
        {
            MAPLog.e(AccountRegistrar.access$000(), "Deregistration Error: Null response");
            val$listener.failure(com.amazon.identity.auth.device.api.egistrationError.UNRECOGNIZED, null);
            return;
        }
        if (((DeregisterDeviceResponse) (obj)).getError() != null)
        {
            obj = ((DeregisterDeviceResponse) (obj)).getError();
            switch (.SwitchMap.com.amazon.identity.kcpsdk.auth.DeregisterDeviceErrorType[((DeregisterDeviceError) (obj)).getType().ordinal()])
            {
            default:
                MAPLog.e(AccountRegistrar.access$000(), "Deregistration Error: Unrecognized response");
                val$listener.failure(com.amazon.identity.auth.device.api.egistrationError.UNRECOGNIZED, null);
                return;

            case 1: // '\001'
                MAPLog.e(AccountRegistrar.access$000(), "Deregistration Error: Failed");
                break;
            }
            val$listener.failure(com.amazon.identity.auth.device.api.egistrationError.DEREGISTER_FAILED, null);
            return;
        }
        if (val$deregisterAllAccounts)
        {
            AccountRegistrar.access$200(AccountRegistrar.this, val$accountRegAuth, val$listener, val$tracer);
            return;
        } else
        {
            val$listener.success(null, null, null);
            return;
        }
    }

    henticator()
    {
        this$0 = final_accountregistrar;
        val$listener = stener;
        val$deregisterAllAccounts = flag;
        val$accountRegAuth = accountregistrarauthenticator;
        val$tracer = Tracer.this;
        super();
    }
}
