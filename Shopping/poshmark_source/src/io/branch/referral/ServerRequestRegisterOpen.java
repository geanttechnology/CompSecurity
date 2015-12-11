// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ServerRequestInitSession, PrefHelper, SystemObserver, BranchError, 
//            ServerResponse, Branch

class ServerRequestRegisterOpen extends ServerRequestInitSession
{

    Branch.BranchReferralInitListener callback_;

    public ServerRequestRegisterOpen(Context context, Branch.BranchReferralInitListener branchreferralinitlistener, SystemObserver systemobserver)
    {
        super(context, Defines.RequestPath.RegisterOpen.getPath());
        callback_ = branchreferralinitlistener;
        context = new JSONObject();
        context.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), prefHelper_.getDeviceFingerPrintID());
        context.put(Defines.Jsonkey.IdentityID.getKey(), prefHelper_.getIdentityID());
        context.put(Defines.Jsonkey.IsReferrable.getKey(), prefHelper_.getIsReferrable());
        if (!systemobserver.getAppVersion().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.AppVersion.getKey(), systemobserver.getAppVersion());
        }
        context.put(Defines.Jsonkey.OSVersion.getKey(), systemobserver.getOSVersion());
        context.put(Defines.Jsonkey.Update.getKey(), systemobserver.getUpdateState(true));
        if (!systemobserver.getOS().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.OS.getKey(), systemobserver.getOS());
        }
        if (!prefHelper_.getLinkClickIdentifier().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.LinkIdentifier.getKey(), prefHelper_.getLinkClickIdentifier());
        }
        if (!prefHelper_.getAppLink().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.AndroidAppLinkURL.getKey(), prefHelper_.getAppLink());
        }
        if (!prefHelper_.getExternalIntentUri().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.External_Intent_URI.getKey(), prefHelper_.getExternalIntentUri());
        }
        if (!prefHelper_.getExternalIntentExtra().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.External_Intent_Extra.getKey(), prefHelper_.getExternalIntentExtra());
        }
        branchreferralinitlistener = Defines.Jsonkey.Debug.getKey();
        boolean flag;
        if (!prefHelper_.isDebug() && !prefHelper_.getExternDebug())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        try
        {
            context.put(branchreferralinitlistener, flag);
            setPost(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        constructError_ = true;
        return;
    }

    public ServerRequestRegisterOpen(String s, JSONObject jsonobject, Context context)
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
                callback_.onInitFinished(null, new BranchError("Trouble initializing Branch.", -102));
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
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("error_message", "Trouble reaching server. Please try again in a few minutes");
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
            callback_.onInitFinished(jsonobject, new BranchError((new StringBuilder()).append("Trouble initializing Branch. ").append(s).toString(), i));
        }
    }

    public boolean hasCallBack()
    {
        return callback_ != null;
    }

    public boolean isGetRequest()
    {
        return false;
    }

    public void onRequestSucceeded(ServerResponse serverresponse, Branch branch)
    {
        prefHelper_.setLinkClickIdentifier("bnc_no_value");
        prefHelper_.setExternalIntentUri("bnc_no_value");
        prefHelper_.setExternalIntentExtra("bnc_no_value");
        prefHelper_.setAppLink("bnc_no_value");
        if (!serverresponse.getObject().has(Defines.Jsonkey.LinkClickID.getKey())) goto _L2; else goto _L1
_L1:
        prefHelper_.setLinkClickID(serverresponse.getObject().getString(Defines.Jsonkey.LinkClickID.getKey()));
_L8:
        if (serverresponse.getObject().has(Defines.Jsonkey.Data.getKey()))
        {
            JSONObject jsonobject = JSONObjectInstrumentation.init(serverresponse.getObject().getString(Defines.Jsonkey.Data.getKey()));
            if (jsonobject.has(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && jsonobject.getBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && prefHelper_.getInstallParams().equals("bnc_no_value") && prefHelper_.getIsReferrable() == 1)
            {
                String s = serverresponse.getObject().getString(Defines.Jsonkey.Data.getKey());
                prefHelper_.setInstallParams(s);
            }
        }
        if (!serverresponse.getObject().has(Defines.Jsonkey.Data.getKey())) goto _L4; else goto _L3
_L3:
        serverresponse = serverresponse.getObject().getString(Defines.Jsonkey.Data.getKey());
        prefHelper_.setSessionParams(serverresponse);
_L6:
        if (callback_ != null)
        {
            callback_.onInitFinished(branch.getLatestReferringParams(), null);
            return;
        }
          goto _L5
_L2:
        try
        {
            prefHelper_.setLinkClickID("bnc_no_value");
        }
        // Misplaced declaration of an exception variable
        catch (ServerResponse serverresponse)
        {
            serverresponse.printStackTrace();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        prefHelper_.setSessionParams("bnc_no_value");
          goto _L6
_L5:
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void setInitFinishedCallback(Branch.BranchReferralInitListener branchreferralinitlistener)
    {
        if (branchreferralinitlistener != null)
        {
            callback_ = branchreferralinitlistener;
        }
    }
}
