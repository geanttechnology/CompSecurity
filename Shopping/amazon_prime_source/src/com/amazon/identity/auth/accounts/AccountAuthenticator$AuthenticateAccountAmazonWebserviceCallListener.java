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

    public void onParseError$6fe276bc()
    {
        MAPLog.e(AccountAuthenticator.access$000(), "Parsing failure performing authenticate account  request");
        mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, "Failed to parse the response"));
    }

    public void onResponseComplete(Object obj)
    {
        AccountAuthenticator.access$000();
        (new StringBuilder("Got completed response of type (")).append(obj.getClass().getName()).append("): ").append(obj);
        Object obj1 = (PandaAuthenticateAccountResponse)obj;
        if (((PandaAuthenticateAccountResponse) (obj1)).getError() != null)
        {
            obj = ((PandaAuthenticateAccountResponse) (obj1)).getError();
            obj1 = ((PandaAuthenticateAccountResponse) (obj1)).getChallenge();
            Bundle bundle;
            switch (henticateAccountError[((AuthenticateAccountError) (obj)).ordinal()])
            {
            default:
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Unrecognized response.");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, ((AuthenticateAccountError) (obj)).getErrorString()));
                return;

            case 1: // '\001'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Crentials Invalid");
                obj = bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, ((AuthenticateAccountError) (obj)).getErrorString());
                if (obj1 != null)
                {
                    ((AuthenticationChallenge) (obj1)).addAdditionalInfoToBundle(((Bundle) (obj)));
                }
                mCallback.onError(((Bundle) (obj)));
                return;

            case 2: // '\002'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Invalid Value");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, ((AuthenticateAccountError) (obj)).getErrorString()));
                return;

            case 3: // '\003'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Missing Value");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, ((AuthenticateAccountError) (obj)).getErrorString()));
                return;

            case 4: // '\004'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Server Error");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, ((AuthenticateAccountError) (obj)).getErrorString()));
                return;

            case 5: // '\005'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Service Unavailable");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, ((AuthenticateAccountError) (obj)).getErrorString()));
                return;

            case 6: // '\006'
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Unknown.");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, ((AuthenticateAccountError) (obj)).getErrorString()));
                return;

            case 7: // '\007'
                MAPLog.i(AccountAuthenticator.access$000(), "Authentication Error: Challenge Exception.");
                bundle = bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, ((AuthenticateAccountError) (obj)).getErrorString());
                break;
            }
            if (obj1 == null)
            {
                MAPLog.e(AccountAuthenticator.access$000(), "Authentication Error: Unknown. Challenge Exception was missing.");
                mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.ndleWithErrorCode, ((AuthenticateAccountError) (obj)).getErrorString()));
                return;
            } else
            {
                bundle.putBundle("com.amazon.identity.auth.ChallengeException", ((AuthenticationChallenge) (obj1)).toBundle());
                mCallback.onError(bundle);
                return;
            }
        } else
        {
            obj = new Bundle();
            ((Bundle) (obj)).putString("com.amazon.dcp.sso.property.account.acctId", ((PandaAuthenticateAccountResponse) (obj1)).getDirectedId());
            ((Bundle) (obj)).putString("com.amazon.dcp.sso.AddAccount.options.AccessToken", ((PandaAuthenticateAccountResponse) (obj1)).getAccessToken());
            mCallback.onSuccess(((Bundle) (obj)));
            return;
        }
    }

    public (Callback callback)
    {
        mCallback = callback;
    }
}
