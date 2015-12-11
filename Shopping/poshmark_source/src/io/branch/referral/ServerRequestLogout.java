// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ServerRequest, PrefHelper, BranchError, ServerResponse, 
//            Branch

class ServerRequestLogout extends ServerRequest
{

    private Branch.LogoutStatusListener callback_;

    public ServerRequestLogout(Context context, Branch.LogoutStatusListener logoutstatuslistener)
    {
        super(context, Defines.RequestPath.Logout.getPath());
        callback_ = logoutstatuslistener;
        context = new JSONObject();
        try
        {
            context.put(Defines.Jsonkey.IdentityID.getKey(), prefHelper_.getIdentityID());
            context.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), prefHelper_.getDeviceFingerPrintID());
            context.put(Defines.Jsonkey.SessionID.getKey(), prefHelper_.getSessionID());
            if (!prefHelper_.getLinkClickID().equals("bnc_no_value"))
            {
                context.put(Defines.Jsonkey.LinkClickID.getKey(), prefHelper_.getLinkClickID());
            }
            setPost(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        constructError_ = true;
    }

    public ServerRequestLogout(String s, JSONObject jsonobject, Context context)
    {
        super(s, jsonobject, context);
    }

    public void clearCallbacks()
    {
        callback_ = null;
    }

    public boolean handleErrors(Context context)
    {
        boolean flag = false;
        if (!super.doesAppHasInternetPermission(context))
        {
            Log.i("BranchSDK", "Trouble executing your request. Please add 'android.permission.INTERNET' in your applications manifest file");
            if (callback_ != null)
            {
                callback_.onLogoutFinished(false, new BranchError("Logout failed", -102));
            }
            flag = true;
        }
        return flag;
    }

    public void handleFailure(int i, String s)
    {
        if (callback_ != null)
        {
            callback_.onLogoutFinished(false, new BranchError((new StringBuilder()).append("Logout error. ").append(s).toString(), i));
        }
    }

    public boolean isGetRequest()
    {
        return false;
    }

    public void onRequestSucceeded(ServerResponse serverresponse, Branch branch)
    {
        prefHelper_.setSessionID(serverresponse.getObject().getString(Defines.Jsonkey.SessionID.getKey()));
        prefHelper_.setIdentityID(serverresponse.getObject().getString(Defines.Jsonkey.IdentityID.getKey()));
        prefHelper_.setUserURL(serverresponse.getObject().getString(Defines.Jsonkey.Link.getKey()));
        prefHelper_.setInstallParams("bnc_no_value");
        prefHelper_.setSessionParams("bnc_no_value");
        prefHelper_.setIdentity("bnc_no_value");
        prefHelper_.clearUserValues();
        if (callback_ != null)
        {
            callback_.onLogoutFinished(true, null);
        }
_L2:
        return;
        serverresponse;
        serverresponse.printStackTrace();
        if (callback_ == null) goto _L2; else goto _L1
_L1:
        callback_.onLogoutFinished(true, null);
        return;
        serverresponse;
        if (callback_ != null)
        {
            callback_.onLogoutFinished(true, null);
        }
        throw serverresponse;
    }
}
