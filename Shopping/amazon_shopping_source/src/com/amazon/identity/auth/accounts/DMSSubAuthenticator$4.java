// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.RemoteException;
import com.amazon.dcp.sso.ISubAuthenticatorResponse;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.DefaultAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;
import com.amazon.identity.kcpsdk.common.ParseError;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            DMSSubAuthenticator

class allListener extends DefaultAmazonWebserviceCallListener
{

    final DMSSubAuthenticator this$0;
    final String val$directedId;
    final ISubAuthenticatorResponse val$subAuthenticatorResponse;

    public void onAuthenticationFailed()
    {
        try
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "Authentication failure when updating the credentials for child app.");
            android.os.Bundle bundle = DMSSubAuthenticator.access$300(DMSSubAuthenticator.this, 103, "Authentication error during update credentials");
            val$subAuthenticatorResponse.onResult(bundle);
            return;
        }
        catch (RemoteException remoteexception)
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "RemoteException during authentication failure callback for updateCredentials");
        }
    }

    public void onNetworkFailure()
    {
        try
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "Update SubAuthenticator Credentials onNetworkFailure");
            val$subAuthenticatorResponse.onError(3, "Network failure");
            return;
        }
        catch (RemoteException remoteexception)
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "RemoteException during network failure callback for updateCredentials");
        }
    }

    public void onParseError(ParseError parseerror)
    {
        try
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "Update SubAuthenticator Credentials onParseError");
            val$subAuthenticatorResponse.onError(5, "Received bad response");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ParseError parseerror)
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "RemoteException during invalid response callback for updateCredentials");
        }
    }

    public void onResponseComplete(Object obj)
    {
        MAPLog.i(DMSSubAuthenticator.access$100(), "Update credential request succeeded");
        try
        {
            obj = (RegisterDeviceResponse)obj;
            DMSSubAuthenticator.access$200(DMSSubAuthenticator.this, val$subAuthenticatorResponse, ((RegisterDeviceResponse) (obj)), val$directedId);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "RemoteException during update credentials call");
        }
    }

    allListener()
    {
        this$0 = final_dmssubauthenticator;
        val$subAuthenticatorResponse = isubauthenticatorresponse;
        val$directedId = String.this;
        super();
    }
}
