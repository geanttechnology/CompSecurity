// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.util.DisplayMetrics;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ServerRequestInitSession, PrefHelper, SystemObserver, BranchError, 
//            ServerResponse, Branch

class ServerRequestRegisterInstall extends ServerRequestInitSession
{

    Branch.BranchReferralInitListener callback_;

    public ServerRequestRegisterInstall(Context context, Branch.BranchReferralInitListener branchreferralinitlistener, SystemObserver systemobserver, String s)
    {
        super(context, Defines.RequestPath.RegisterInstall.getPath());
        callback_ = branchreferralinitlistener;
        context = new JSONObject();
        if (!s.equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.LinkClickID.getKey(), s);
        }
        branchreferralinitlistener = systemobserver.getUniqueID(prefHelper_.getExternDebug());
        if (!branchreferralinitlistener.equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.HardwareID.getKey(), branchreferralinitlistener);
            context.put(Defines.Jsonkey.IsHardwareIDReal.getKey(), systemobserver.hasRealHardwareId());
        }
        if (!systemobserver.getAppVersion().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.AppVersion.getKey(), systemobserver.getAppVersion());
        }
        if (!systemobserver.getCarrier().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.Carrier.getKey(), systemobserver.getCarrier());
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            context.put(Defines.Jsonkey.Bluetooth.getKey(), systemobserver.getBluetoothPresent());
        }
        if (!systemobserver.getBluetoothVersion().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.BluetoothVersion.getKey(), systemobserver.getBluetoothVersion());
        }
        context.put(Defines.Jsonkey.HasNfc.getKey(), systemobserver.getNFCPresent());
        context.put(Defines.Jsonkey.HasTelephone.getKey(), systemobserver.getTelephonePresent());
        if (!systemobserver.getPhoneBrand().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.Brand.getKey(), systemobserver.getPhoneBrand());
        }
        if (!systemobserver.getPhoneModel().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.Model.getKey(), systemobserver.getPhoneModel());
        }
        if (!systemobserver.getOS().equals("bnc_no_value"))
        {
            context.put(Defines.Jsonkey.OS.getKey(), systemobserver.getOS());
        }
        if (prefHelper_.isDebug())
        {
            branchreferralinitlistener = systemobserver.getURIScheme();
            if (!branchreferralinitlistener.equals("bnc_no_value"))
            {
                context.put(Defines.Jsonkey.URIScheme.getKey(), branchreferralinitlistener);
            }
        }
        context.put(Defines.Jsonkey.OSVersion.getKey(), systemobserver.getOSVersion());
        branchreferralinitlistener = systemobserver.getScreenDisplay();
        context.put(Defines.Jsonkey.ScreenDpi.getKey(), ((DisplayMetrics) (branchreferralinitlistener)).densityDpi);
        context.put(Defines.Jsonkey.ScreenHeight.getKey(), ((DisplayMetrics) (branchreferralinitlistener)).heightPixels);
        context.put(Defines.Jsonkey.ScreenWidth.getKey(), ((DisplayMetrics) (branchreferralinitlistener)).widthPixels);
        context.put(Defines.Jsonkey.WiFi.getKey(), systemobserver.getWifiConnected());
        context.put(Defines.Jsonkey.IsReferrable.getKey(), prefHelper_.getIsReferrable());
        context.put(Defines.Jsonkey.Update.getKey(), systemobserver.getUpdateState(true));
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

    public ServerRequestRegisterInstall(String s, JSONObject jsonobject, Context context)
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
        prefHelper_.setUserURL(serverresponse.getObject().getString(Defines.Jsonkey.Link.getKey()));
        prefHelper_.setLinkClickIdentifier("bnc_no_value");
        prefHelper_.setExternalIntentUri("bnc_no_value");
        prefHelper_.setExternalIntentExtra("bnc_no_value");
        prefHelper_.setAppLink("bnc_no_value");
        if (serverresponse.getObject().has(Defines.Jsonkey.Data.getKey()))
        {
            JSONObject jsonobject = JSONObjectInstrumentation.init(serverresponse.getObject().getString(Defines.Jsonkey.Data.getKey()));
            if (jsonobject.has(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && jsonobject.getBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && prefHelper_.getInstallParams().equals("bnc_no_value") && prefHelper_.getIsReferrable() == 1)
            {
                String s = serverresponse.getObject().getString(Defines.Jsonkey.Data.getKey());
                prefHelper_.setInstallParams(s);
            }
        }
        if (!serverresponse.getObject().has(Defines.Jsonkey.LinkClickID.getKey())) goto _L2; else goto _L1
_L1:
        prefHelper_.setLinkClickID(serverresponse.getObject().getString(Defines.Jsonkey.LinkClickID.getKey()));
_L8:
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
