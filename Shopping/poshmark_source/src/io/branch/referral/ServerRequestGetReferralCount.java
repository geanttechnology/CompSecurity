// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ServerRequest, PrefHelper, BranchError, ServerResponse, 
//            Branch

class ServerRequestGetReferralCount extends ServerRequest
{

    Branch.BranchReferralStateChangedListener callback_;

    public ServerRequestGetReferralCount(Context context, Branch.BranchReferralStateChangedListener branchreferralstatechangedlistener)
    {
        super(context, Defines.RequestPath.Referrals.getPath());
        callback_ = branchreferralstatechangedlistener;
    }

    public ServerRequestGetReferralCount(String s, JSONObject jsonobject, Context context)
    {
        super(s, jsonobject, context);
    }

    public void clearCallbacks()
    {
        callback_ = null;
    }

    public String getRequestUrl()
    {
        return (new StringBuilder()).append(super.getRequestUrl()).append(prefHelper_.getIdentityID()).toString();
    }

    public boolean handleErrors(Context context)
    {
        boolean flag = false;
        if (!super.doesAppHasInternetPermission(context))
        {
            if (callback_ != null)
            {
                callback_.onStateChanged(false, new BranchError("Trouble retrieving referral counts.", -102));
            }
            flag = true;
        }
        return flag;
    }

    public void handleFailure(int i, String s)
    {
        if (callback_ != null)
        {
            callback_.onStateChanged(false, new BranchError((new StringBuilder()).append("Trouble retrieving referral counts. ").append(s).toString(), i));
        }
    }

    public boolean isGetRequest()
    {
        return true;
    }

    public void onRequestSucceeded(ServerResponse serverresponse, Branch branch)
    {
        boolean flag;
        flag = false;
        branch = serverresponse.getObject().keys();
_L3:
        if (!branch.hasNext()) goto _L2; else goto _L1
_L1:
        String s;
        boolean flag2;
        s = (String)branch.next();
        flag2 = flag;
        JSONObject jsonobject = serverresponse.getObject().getJSONObject(s);
        flag2 = flag;
        int i = jsonobject.getInt(Defines.Jsonkey.Total.getKey());
        flag2 = flag;
        int j = jsonobject.getInt(Defines.Jsonkey.Unique.getKey());
        flag2 = flag;
        if (i != prefHelper_.getActionTotalCount(s))
        {
            break MISSING_BLOCK_LABEL_186;
        }
        boolean flag1;
        flag1 = flag;
        flag2 = flag;
        if (j != prefHelper_.getActionUniqueCount(s))
        {
            break MISSING_BLOCK_LABEL_186;
        }
_L4:
        flag2 = flag1;
        prefHelper_.setActionTotalCount(s, i);
        flag2 = flag1;
        prefHelper_.setActionUniqueCount(s, j);
        flag = flag1;
          goto _L3
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        flag = flag2;
          goto _L3
_L2:
        if (callback_ != null)
        {
            callback_.onStateChanged(flag, null);
        }
        return;
        flag1 = true;
          goto _L4
    }
}
