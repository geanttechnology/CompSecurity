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

class ServerRequestGetRewards extends ServerRequest
{

    Branch.BranchReferralStateChangedListener callback_;

    public ServerRequestGetRewards(Context context, Branch.BranchReferralStateChangedListener branchreferralstatechangedlistener)
    {
        super(context, Defines.RequestPath.GetCredits.getPath());
        callback_ = branchreferralstatechangedlistener;
    }

    public ServerRequestGetRewards(String s, JSONObject jsonobject, Context context)
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
                callback_.onStateChanged(false, new BranchError("Trouble retrieving user credits.", -102));
            }
            flag = true;
        }
        return flag;
    }

    public void handleFailure(int i, String s)
    {
        if (callback_ != null)
        {
            callback_.onStateChanged(false, new BranchError((new StringBuilder()).append("Trouble retrieving user credits. ").append(s).toString(), i));
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
_L2:
        String s;
        boolean flag2;
        if (!branch.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)branch.next();
        flag2 = flag;
        int i = serverresponse.getObject().getInt(s);
        boolean flag1;
        flag1 = flag;
        flag2 = flag;
        if (i != prefHelper_.getCreditCount(s))
        {
            flag1 = true;
        }
        flag2 = flag1;
        prefHelper_.setCreditCount(s, i);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        flag = flag2;
        if (true) goto _L2; else goto _L1
_L1:
        if (callback_ != null)
        {
            callback_.onStateChanged(flag, null);
        }
        return;
    }
}
