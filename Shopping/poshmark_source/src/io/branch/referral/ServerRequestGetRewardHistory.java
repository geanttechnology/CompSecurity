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

class ServerRequestGetRewardHistory extends ServerRequest
{

    Branch.BranchListResponseListener callback_;

    public ServerRequestGetRewardHistory(Context context, String s, String s1, int i, Branch.CreditHistoryOrder credithistoryorder, Branch.BranchListResponseListener branchlistresponselistener)
    {
        super(context, Defines.RequestPath.GetCreditHistory.getPath());
        callback_ = branchlistresponselistener;
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
            context.put(Defines.Jsonkey.Length.getKey(), i);
            context.put(Defines.Jsonkey.Direction.getKey(), credithistoryorder.ordinal());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            constructError_ = true;
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        context.put(Defines.Jsonkey.Bucket.getKey(), s);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        context.put(Defines.Jsonkey.BeginAfterID.getKey(), s1);
        setPost(context);
        return;
    }

    public ServerRequestGetRewardHistory(String s, JSONObject jsonobject, Context context)
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
                callback_.onReceivingResponse(null, new BranchError("Trouble retrieving user credit history.", -102));
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
            callback_.onReceivingResponse(null, new BranchError((new StringBuilder()).append("Trouble retrieving user credit history. ").append(s).toString(), i));
        }
    }

    public boolean isGetRequest()
    {
        return false;
    }

    public void onRequestSucceeded(ServerResponse serverresponse, Branch branch)
    {
        if (callback_ != null)
        {
            callback_.onReceivingResponse(serverresponse.getArray(), null);
        }
    }
}
