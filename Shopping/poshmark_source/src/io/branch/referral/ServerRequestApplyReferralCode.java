// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ServerRequest, PrefHelper, BranchError, ServerResponse, 
//            Branch

class ServerRequestApplyReferralCode extends ServerRequest
{

    Branch.BranchReferralInitListener callback_;

    public ServerRequestApplyReferralCode(Context context, Branch.BranchReferralInitListener branchreferralinitlistener, String s)
    {
        super(context, Defines.RequestPath.ApplyReferralCode.getPath());
        callback_ = branchreferralinitlistener;
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
            context.put(Defines.Jsonkey.ReferralCode.getKey(), s);
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

    public ServerRequestApplyReferralCode(String s, JSONObject jsonobject, Context context)
    {
        super(s, jsonobject, context);
    }

    public void clearCallbacks()
    {
        callback_ = null;
    }

    public String getRequestUrl()
    {
        String s = "";
        String s1 = getPost().getString(Defines.Jsonkey.ReferralCode.getKey());
        s = s1;
_L2:
        return (new StringBuilder()).append(super.getRequestUrl()).append(s).toString();
        Exception exception;
        exception;
        exception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean handleErrors(Context context)
    {
        if (!super.doesAppHasInternetPermission(context))
        {
            if (callback_ != null)
            {
                callback_.onInitFinished(null, new BranchError("Trouble applying the referral code.", -102));
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void handleFailure(int i, String s)
    {
        if (callback_ != null)
        {
            callback_.onInitFinished(null, new BranchError((new StringBuilder()).append("Trouble applying the referral code. ").append(s).toString(), i));
        }
    }

    public boolean isGetRequest()
    {
        return false;
    }

    public void onRequestSucceeded(ServerResponse serverresponse, Branch branch)
    {
        Object obj;
        if (callback_ == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        obj = null;
        if (serverresponse.getObject().has("referral_code")) goto _L2; else goto _L1
_L1:
        branch = new JSONObject();
        branch.put("error_message", "Invalid referral code");
        serverresponse = new BranchError("Trouble applying referral code.", -103);
_L3:
        callback_.onInitFinished(branch, serverresponse);
        return;
_L2:
        branch = serverresponse.getObject();
        serverresponse = obj;
          goto _L3
        serverresponse;
        serverresponse.printStackTrace();
    }
}
