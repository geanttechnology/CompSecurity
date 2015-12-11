// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            PrefHelper, ServerRequestActionCompleted, ServerRequestApplyReferralCode, ServerRequestCreateUrl, 
//            ServerRequestGetReferralCode, ServerRequestGetReferralCount, ServerRequestGetRewardHistory, ServerRequestGetRewards, 
//            ServerRequestIdentifyUserRequest, ServerRequestLogout, ServerRequestRedeemRewards, ServerRequestRegisterClose, 
//            ServerRequestRegisterInstall, ServerRequestRegisterOpen, ServerRequestSendAppList, ServerRequestValidateReferralCode, 
//            SystemObserver, ServerResponse, Branch

abstract class ServerRequest
{

    private static final String POST_KEY = "REQ_POST";
    private static final String POST_PATH_KEY = "REQ_POST_PATH";
    public boolean constructError_;
    private JSONObject post_;
    protected PrefHelper prefHelper_;
    protected String requestPath_;

    public ServerRequest(Context context, String s)
    {
        constructError_ = false;
        requestPath_ = s;
        prefHelper_ = PrefHelper.getInstance(context);
    }

    protected ServerRequest(String s, JSONObject jsonobject, Context context)
    {
        constructError_ = false;
        requestPath_ = s;
        post_ = jsonobject;
        prefHelper_ = PrefHelper.getInstance(context);
    }

    public static ServerRequest fromJSON(JSONObject jsonobject, Context context)
    {
        String s = null;
        String s1 = "";
        Object obj = s;
        try
        {
            if (jsonobject.has("REQ_POST"))
            {
                obj = jsonobject.getJSONObject("REQ_POST");
            }
        }
        catch (JSONException jsonexception)
        {
            jsonexception = s;
        }
        s = s1;
        try
        {
            if (jsonobject.has("REQ_POST_PATH"))
            {
                s = jsonobject.getString("REQ_POST_PATH");
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            s = s1;
        }
        if (s != null && s.length() > 0)
        {
            return getExtendedServerRequest(s, ((JSONObject) (obj)), context);
        } else
        {
            return null;
        }
    }

    private static ServerRequest getExtendedServerRequest(String s, JSONObject jsonobject, Context context)
    {
        ServerRequestActionCompleted serverrequestactioncompleted = null;
        if (s.equalsIgnoreCase(Defines.RequestPath.CompletedAction.getPath()))
        {
            serverrequestactioncompleted = new ServerRequestActionCompleted(s, jsonobject, context);
        } else
        {
            if (s.equalsIgnoreCase(Defines.RequestPath.ApplyReferralCode.getPath()))
            {
                return new ServerRequestApplyReferralCode(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.GetURL.getPath()))
            {
                return new ServerRequestCreateUrl(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.GetReferralCode.getPath()))
            {
                return new ServerRequestGetReferralCode(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.Referrals.getPath()))
            {
                return new ServerRequestGetReferralCount(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.GetCreditHistory.getPath()))
            {
                return new ServerRequestGetRewardHistory(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.GetCredits.getPath()))
            {
                return new ServerRequestGetRewards(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.IdentifyUser.getPath()))
            {
                return new ServerRequestIdentifyUserRequest(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.Logout.getPath()))
            {
                return new ServerRequestLogout(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.RedeemRewards.getPath()))
            {
                return new ServerRequestRedeemRewards(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.RegisterClose.getPath()))
            {
                return new ServerRequestRegisterClose(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.RegisterInstall.getPath()))
            {
                return new ServerRequestRegisterInstall(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.RegisterOpen.getPath()))
            {
                return new ServerRequestRegisterOpen(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.SendAPPList.getPath()))
            {
                return new ServerRequestSendAppList(s, jsonobject, context);
            }
            if (s.equalsIgnoreCase(Defines.RequestPath.ValidateReferralCode.getPath()))
            {
                return new ServerRequestValidateReferralCode(s, jsonobject, context);
            }
        }
        return serverrequestactioncompleted;
    }

    public abstract void clearCallbacks();

    protected boolean doesAppHasInternetPermission(Context context)
    {
        return context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    public JSONObject getPost()
    {
        return post_;
    }

    public final String getRequestPath()
    {
        return requestPath_;
    }

    public String getRequestUrl()
    {
        return (new StringBuilder()).append(prefHelper_.getAPIBaseUrl()).append(requestPath_).toString();
    }

    public abstract boolean handleErrors(Context context);

    public abstract void handleFailure(int i, String s);

    public abstract boolean isGetRequest();

    public abstract void onRequestSucceeded(ServerResponse serverresponse, Branch branch);

    protected void setPost(JSONObject jsonobject)
    {
        post_ = jsonobject;
    }

    public boolean shouldRetryOnFail()
    {
        return false;
    }

    public JSONObject toJSON()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("REQ_POST", post_);
            jsonobject.put("REQ_POST_PATH", requestPath_);
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return jsonobject;
    }

    public void updateGAdsParams(SystemObserver systemobserver)
    {
        String s;
        int i;
        try
        {
            s = systemobserver.getAdvertisingId();
        }
        // Misplaced declaration of an exception variable
        catch (SystemObserver systemobserver)
        {
            systemobserver.printStackTrace();
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (getPost() != null)
        {
            getPost().put(Defines.Jsonkey.GoogleAdvertisingID.getKey(), s);
        }
        i = systemobserver.getLATValue();
        if (getPost() != null)
        {
            getPost().put(Defines.Jsonkey.LATVal.getKey(), i);
        }
        return;
    }
}
