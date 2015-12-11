// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ServerRequest, PrefHelper, BranchError, Branch, 
//            ServerResponse

class ServerRequestIdentifyUserRequest extends ServerRequest
{

    Branch.BranchReferralInitListener callback_;
    String userId_;

    public ServerRequestIdentifyUserRequest(Context context, Branch.BranchReferralInitListener branchreferralinitlistener, String s)
    {
        super(context, Defines.RequestPath.IdentifyUser.getPath());
        userId_ = null;
        callback_ = branchreferralinitlistener;
        userId_ = s;
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
            context.put(Defines.Jsonkey.Identity.getKey(), s);
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

    public ServerRequestIdentifyUserRequest(String s, JSONObject jsonobject, Context context)
    {
        super(s, jsonobject, context);
        userId_ = null;
    }

    public void clearCallbacks()
    {
        callback_ = null;
    }

    public boolean handleErrors(Context context)
    {
        if (super.doesAppHasInternetPermission(context)) goto _L2; else goto _L1
_L1:
        if (callback_ != null)
        {
            callback_.onInitFinished(null, new BranchError("Trouble setting the user alias.", -102));
        }
_L4:
        return true;
_L2:
        boolean flag;
        try
        {
            context = getPost().getString(Defines.Jsonkey.Identity.getKey());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return true;
        }
        if (context == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (context.length() == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = context.equals(prefHelper_.getIdentity());
        if (!flag)
        {
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void handleFailure(int i, String s)
    {
        if (callback_ != null)
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("error_message", "Trouble reaching server. Please try again in a few minutes");
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
            callback_.onInitFinished(jsonobject, new BranchError((new StringBuilder()).append("Trouble setting the user alias. ").append(s).toString(), i));
        }
    }

    public void handleUserExist(Branch branch)
    {
        if (callback_ != null)
        {
            callback_.onInitFinished(branch.getFirstReferringParams(), null);
        }
    }

    public boolean isExistingID()
    {
        boolean flag1 = false;
        String s;
        boolean flag;
        boolean flag2;
        try
        {
            s = getPost().getString(Defines.Jsonkey.Identity.getKey());
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return false;
        }
        flag = flag1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        flag2 = s.equals(prefHelper_.getIdentity());
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
        return flag;
    }

    public boolean isGetRequest()
    {
        return false;
    }

    public void onRequestSucceeded(ServerResponse serverresponse, Branch branch)
    {
        try
        {
            if (getPost() != null && getPost().has(Defines.Jsonkey.Identity.getKey()))
            {
                prefHelper_.setIdentity(getPost().getString(Defines.Jsonkey.Identity.getKey()));
            }
            prefHelper_.setIdentityID(serverresponse.getObject().getString(Defines.Jsonkey.IdentityID.getKey()));
            prefHelper_.setUserURL(serverresponse.getObject().getString(Defines.Jsonkey.Link.getKey()));
            if (serverresponse.getObject().has(Defines.Jsonkey.ReferringData.getKey()))
            {
                serverresponse = serverresponse.getObject().getString(Defines.Jsonkey.ReferringData.getKey());
                prefHelper_.setInstallParams(serverresponse);
            }
            if (callback_ != null)
            {
                callback_.onInitFinished(branch.getFirstReferringParams(), null);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ServerResponse serverresponse)
        {
            serverresponse.printStackTrace();
        }
    }

    public boolean shouldRetryOnFail()
    {
        return true;
    }
}
