// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.RemoteException;
import com.amazon.dcp.sso.ISubAuthenticatorResponse;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            ChildApplicationRegistrarCallback, DMSSubAuthenticator

class val.directedId
    implements ChildApplicationRegistrarCallback
{

    final DMSSubAuthenticator this$0;
    final String val$directedId;
    final ISubAuthenticatorResponse val$subAuthenticatorResponse;

    public void onAuthenticationFailed()
    {
        try
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "Authentication error when registering the child app.");
            android.os.Bundle bundle = DMSSubAuthenticator.access$300(DMSSubAuthenticator.this, 103, "Authentication error during register");
            val$subAuthenticatorResponse.onResult(bundle);
            return;
        }
        catch (RemoteException remoteexception)
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "RemoteException during authentication failure callback for registerChildApplication");
        }
    }

    public void onBadResponse()
    {
        try
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "Bad response when registering the child app.");
            val$subAuthenticatorResponse.onError(5, "Received bad response");
            return;
        }
        catch (RemoteException remoteexception)
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "RemoteException during invalid response callback for registerChildApplication");
        }
    }

    public void onInvalidRequest()
    {
        try
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "Bad request when registering the child app.");
            val$subAuthenticatorResponse.onError(8, "Received bad request");
            return;
        }
        catch (RemoteException remoteexception)
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "RemoteException during bad request callback for registerChildApplication");
        }
    }

    public void onNetworkError()
    {
        try
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "Network error when registering the child app.");
            val$subAuthenticatorResponse.onError(3, "Network error");
            return;
        }
        catch (RemoteException remoteexception)
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "RemoteException during network failure callback for registerChildApplication");
        }
    }

    public void onRegisterChildApplicationComplete(RegisterDeviceResponse registerdeviceresponse)
    {
        try
        {
            MAPLog.i(DMSSubAuthenticator.access$100(), "Getting response for the child application registration. Storing results.");
            DMSSubAuthenticator.access$200(DMSSubAuthenticator.this, val$subAuthenticatorResponse, registerdeviceresponse, val$directedId);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RegisterDeviceResponse registerdeviceresponse)
        {
            MAPLog.e(DMSSubAuthenticator.access$100(), "RemoteException when credentials was received for registerChildApplication");
        }
    }

    rarCallback()
    {
        this$0 = final_dmssubauthenticator;
        val$subAuthenticatorResponse = isubauthenticatorresponse;
        val$directedId = String.this;
        super();
    }
}
