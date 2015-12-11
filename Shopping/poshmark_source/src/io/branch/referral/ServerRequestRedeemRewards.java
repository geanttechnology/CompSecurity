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

class ServerRequestRedeemRewards extends ServerRequest
{

    int actualNumOfCreditsToRedeem_;
    Branch.BranchReferralStateChangedListener callback_;

    public ServerRequestRedeemRewards(Context context, String s, int i, Branch.BranchReferralStateChangedListener branchreferralstatechangedlistener)
    {
        super(context, Defines.RequestPath.RedeemRewards.getPath());
        actualNumOfCreditsToRedeem_ = 0;
        callback_ = branchreferralstatechangedlistener;
        int j = prefHelper_.getCreditCount(s);
        actualNumOfCreditsToRedeem_ = i;
        if (i > j)
        {
            actualNumOfCreditsToRedeem_ = j;
            Log.i("BranchSDK", "Branch Warning: You're trying to redeem more credits than are available. Have you updated loaded rewards");
        }
        if (actualNumOfCreditsToRedeem_ <= 0)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        context = new JSONObject();
        context.put(Defines.Jsonkey.IdentityID.getKey(), prefHelper_.getIdentityID());
        context.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), prefHelper_.getDeviceFingerPrintID());
        context.put(Defines.Jsonkey.SessionID.getKey(), prefHelper_.getSessionID());
        if (!prefHelper_.getLinkClickID().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.LinkClickID.getKey(), prefHelper_.getLinkClickID());
        }
        context.put(Defines.Jsonkey.Bucket.getKey(), s);
        context.put(Defines.Jsonkey.Amount.getKey(), actualNumOfCreditsToRedeem_);
        setPost(context);
        return;
        context;
        context.printStackTrace();
        constructError_ = true;
        return;
    }

    public ServerRequestRedeemRewards(String s, JSONObject jsonobject, Context context)
    {
        super(s, jsonobject, context);
        actualNumOfCreditsToRedeem_ = 0;
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
                callback_.onStateChanged(false, new BranchError("Trouble redeeming rewards.", -102));
            }
        } else
        if (actualNumOfCreditsToRedeem_ <= 0)
        {
            if (callback_ != null)
            {
                callback_.onStateChanged(false, new BranchError("Trouble redeeming rewards.", -107));
                return true;
            }
        } else
        {
            return false;
        }
        return true;
    }

    public void handleFailure(int i, String s)
    {
        if (callback_ != null)
        {
            callback_.onStateChanged(false, new BranchError((new StringBuilder()).append("Trouble redeeming rewards. ").append(s).toString(), i));
        }
    }

    public boolean isGetRequest()
    {
        return false;
    }

    public void onRequestSucceeded(ServerResponse serverresponse, Branch branch)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        serverresponse = getPost();
        flag = flag1;
        if (serverresponse == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        flag = flag1;
        if (!serverresponse.has(Defines.Jsonkey.Bucket.getKey()))
        {
            break MISSING_BLOCK_LABEL_120;
        }
        flag = flag1;
        if (!serverresponse.has(Defines.Jsonkey.Amount.getKey()))
        {
            break MISSING_BLOCK_LABEL_120;
        }
        flag1 = flag2;
        int i = serverresponse.getInt(Defines.Jsonkey.Amount.getKey());
        flag1 = flag2;
        serverresponse = serverresponse.getString(Defines.Jsonkey.Bucket.getKey());
        int j;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        j = prefHelper_.getCreditCount(serverresponse);
        flag1 = flag;
        try
        {
            prefHelper_.setCreditCount(serverresponse, j - i);
        }
        // Misplaced declaration of an exception variable
        catch (ServerResponse serverresponse)
        {
            serverresponse.printStackTrace();
            flag = flag1;
        }
        if (callback_ != null)
        {
            if (flag)
            {
                serverresponse = null;
            } else
            {
                serverresponse = new BranchError("Trouble redeeming rewards.", -107);
            }
            callback_.onStateChanged(flag, serverresponse);
        }
        return;
    }
}
