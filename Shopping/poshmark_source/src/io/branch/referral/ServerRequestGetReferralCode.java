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

class ServerRequestGetReferralCode extends ServerRequest
{

    Branch.BranchReferralInitListener callback_;

    public ServerRequestGetReferralCode(Context context, Branch.BranchReferralInitListener branchreferralinitlistener)
    {
        super(context, Defines.RequestPath.GetReferralCode.getPath());
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

    public ServerRequestGetReferralCode(Context context, String s, int i, String s1, String s2, int j, int k, 
            Branch.BranchReferralInitListener branchreferralinitlistener)
    {
        super(context, Defines.RequestPath.GetReferralCode.getPath());
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
            context.put(Defines.Jsonkey.CalculationType.getKey(), j);
            context.put(Defines.Jsonkey.Location.getKey(), k);
            context.put(Defines.Jsonkey.Type.getKey(), "credit");
            context.put(Defines.Jsonkey.CreationSource.getKey(), 2);
            context.put(Defines.Jsonkey.Amount.getKey(), i);
            branchreferralinitlistener = Defines.Jsonkey.Bucket.getKey();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            constructError_ = true;
            return;
        }
        if (s2 == null)
        {
            s2 = "default";
        }
        context.put(branchreferralinitlistener, s2);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        if (s.length() > 0)
        {
            context.put(Defines.Jsonkey.Prefix.getKey(), s);
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_238;
        }
        context.put(Defines.Jsonkey.Expiration.getKey(), s1);
        setPost(context);
        return;
    }

    public ServerRequestGetReferralCode(String s, JSONObject jsonobject, Context context)
    {
        super(s, jsonobject, context);
    }

    public void clearCallbacks()
    {
        callback_ = null;
    }

    public boolean handleErrors(Context context)
    {
        if (!super.doesAppHasInternetPermission(context))
        {
            if (callback_ != null)
            {
                callback_.onInitFinished(null, new BranchError("Trouble retrieving the referral code.", -102));
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
            callback_.onInitFinished(null, new BranchError((new StringBuilder()).append("Trouble retrieving the referral code. ").append(s).toString(), i));
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
        branch.put("error_message", "Failed to get referral code");
        serverresponse = new BranchError("Trouble retrieving the referral code.", -106);
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
