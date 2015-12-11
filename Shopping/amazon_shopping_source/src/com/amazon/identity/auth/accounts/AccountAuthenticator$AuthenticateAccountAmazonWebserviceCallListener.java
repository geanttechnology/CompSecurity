// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.AuthenticateAccountError;
import com.amazon.identity.kcpsdk.auth.AuthenticationChallenge;
import com.amazon.identity.kcpsdk.auth.DefaultAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.PandaAuthenticateAccountResponse;
import com.amazon.identity.kcpsdk.common.ParseError;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountAuthenticator

private static class mCallback extends DefaultAmazonWebserviceCallListener
{

    protected final Callback mCallback;

    private Bundle bundleWithErrorCode(com.amazon.identity.auth.device.api.allback allback, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("com.amazon.dcp.sso.ErrorCode", allback.allback());
        bundle.putString("com.amazon.dcp.sso.ErrorMessage", s);
        return bundle;
    }

    public void onAuthenticationFailed()
    {
        MAPLog.e(AccountAuthenticator.access$000(), "Authentication failure performing authenticate account request");
        mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, "Failed to authenticate"));
    }

    public void onNetworkFailure()
    {
        MAPLog.e(AccountAuthenticator.access$000(), "Network failure performing authenticate account request. ");
        mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, "Network failure occured while authenticating account. Please check your internet connectivity"));
    }

    public void onParseError(ParseError parseerror)
    {
        MAPLog.e(AccountAuthenticator.access$000(), "Parsing failure performing authenticate account  request");
        mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, "Failed to parse the response"));
    }

    public void onResponseComplete(Object obj)
    {
        AccountAuthenticator.access$000();
        (new StringBuilder("Got completed response of type (")).append(obj.getClass().getName()).append("): ").append(obj).toString();
        obj = (PandaAuthenticateAccountResponse)obj;
        if (((PandaAuthenticateAccountResponse) (obj)).getError() != null)
        {
            AuthenticateAccountError authenticateaccounterror = ((PandaAuthenticateAccountResponse) (obj)).getError();
            switch (henticateAccountError[authenticateaccounterror.ordinal()])
            {
            default:
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Unrecognized response.");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, authenticateaccounterror.getErrorString()));
                return;

            case 1: // '\001'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Crentials Invalid");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, authenticateaccounterror.getErrorString()));
                return;

            case 2: // '\002'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Invalid Value");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, authenticateaccounterror.getErrorString()));
                return;

            case 3: // '\003'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Missing Value");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, authenticateaccounterror.getErrorString()));
                return;

            case 4: // '\004'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Server Error");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, authenticateaccounterror.getErrorString()));
                return;

            case 5: // '\005'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Service Unavailable");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, authenticateaccounterror.getErrorString()));
                return;

            case 6: // '\006'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Unknown.");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, authenticateaccounterror.getErrorString()));
                return;

            case 7: // '\007'
                MAPLog.i(AccountAuthenticator.access$000(), "Authentication Error: Challenge Exception.");
                break;
            }
            Bundle bundle1 = bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, authenticateaccounterror.getErrorString());
            obj = ((PandaAuthenticateAccountResponse) (obj)).getChallenge();
            if (obj == null)
            {
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Unknown. Challenge Exception was missing.");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, authenticateaccounterror.getErrorString()));
                return;
            } else
            {
                bundle1.putBundle("com.amazon.identity.auth.ChallengeException", ((AuthenticationChallenge) (obj)).toBundle());
                mCallback.onError(bundle1);
                return;
            }
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putString("com.amazon.dcp.sso.property.account.acctId", ((PandaAuthenticateAccountResponse) (obj)).getDirectedId());
            bundle.putString("com.amazon.dcp.sso.AddAccount.options.AccessToken", ((PandaAuthenticateAccountResponse) (obj)).getAccessToken());
            mCallback.onSuccess(bundle);
            return;
        }
    }

    public (Callback callback)
    {
        mCallback = callback;
    }
}
