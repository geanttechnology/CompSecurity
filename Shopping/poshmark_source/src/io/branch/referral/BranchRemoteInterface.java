// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            RemoteInterface, SystemObserver, PrefHelper, ServerResponse, 
//            NetworkCallback, BranchLinkData

public class BranchRemoteInterface extends RemoteInterface
{

    private NetworkCallback callback_;
    private SystemObserver sysObserver_;

    public BranchRemoteInterface()
    {
    }

    public BranchRemoteInterface(Context context)
    {
        super(context);
        sysObserver_ = new SystemObserver(context);
    }

    public void connectToDebug()
    {
        if (prefHelper_.getSessionID().equals("bnc_no_value"))
        {
            callback_.finished(new ServerResponse("t_debug_connect", -1009));
            return;
        }
        Object obj;
        obj = new JSONObject();
        ((JSONObject) (obj)).put(Defines.Jsonkey.DeviceFingerprintID.getKey(), prefHelper_.getDeviceFingerPrintID());
        if (!sysObserver_.getBluetoothPresent())
        {
            break MISSING_BLOCK_LABEL_261;
        }
        ((JSONObject) (obj)).put("device_name", BluetoothAdapter.getDefaultAdapter().getName());
_L1:
        ((JSONObject) (obj)).put(Defines.Jsonkey.OS.getKey(), sysObserver_.getOS());
        ((JSONObject) (obj)).put(Defines.Jsonkey.OSVersion.getKey(), sysObserver_.getOSVersion());
        ((JSONObject) (obj)).put(Defines.Jsonkey.Model.getKey(), sysObserver_.getPhoneModel());
        ((JSONObject) (obj)).put("is_simulator", sysObserver_.isSimulator());
        ((JSONObject) (obj)).put(Defines.Jsonkey.SessionID.getKey(), prefHelper_.getSessionID());
        if (!prefHelper_.getIdentityID().equals("bnc_no_value"))
        {
            ((JSONObject) (obj)).put(Defines.Jsonkey.IdentityID.getKey(), prefHelper_.getIdentityID());
        }
        callback_.finished(make_restful_post(((JSONObject) (obj)), (new StringBuilder()).append(prefHelper_.getAPIBaseUrl()).append("v1/debug/connect").toString(), "t_debug_connect", prefHelper_.getTimeout(), true));
        return;
        try
        {
            ((JSONObject) (obj)).put("device_name", sysObserver_.getPhoneModel());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).printStackTrace();
            return;
        }
          goto _L1
    }

    public ServerResponse createCustomUrlSync(JSONObject jsonobject)
    {
        BranchLinkData branchlinkdata = null;
        if (jsonobject instanceof BranchLinkData)
        {
            branchlinkdata = (BranchLinkData)jsonobject;
        }
        return make_restful_post(jsonobject, (new StringBuilder()).append(prefHelper_.getAPIBaseUrl()).append("v1/url").toString(), Defines.RequestPath.GetURL.getPath(), prefHelper_.getTimeout(), branchlinkdata);
    }

    public void disconnectFromDebug()
    {
        if (prefHelper_.getDeviceFingerPrintID().equals("bnc_no_value"))
        {
            callback_.finished(new ServerResponse("t_debug_connect", -1009));
            return;
        }
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), prefHelper_.getDeviceFingerPrintID());
            if (!prefHelper_.getSessionID().equals("bnc_no_value"))
            {
                jsonobject.put(Defines.Jsonkey.SessionID.getKey(), prefHelper_.getSessionID());
            }
            if (!prefHelper_.getIdentityID().equals("bnc_no_value"))
            {
                jsonobject.put(Defines.Jsonkey.IdentityID.getKey(), prefHelper_.getIdentityID());
            }
            callback_.finished(make_restful_post(jsonobject, (new StringBuilder()).append(prefHelper_.getAPIBaseUrl()).append("v1/debug/disconnect").toString(), "t_debug_disconnect", prefHelper_.getTimeout(), true));
            return;
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
    }

    public SystemObserver getSystemObserver()
    {
        return sysObserver_;
    }

    public volatile ServerResponse make_restful_get(String s, String s1, int i)
    {
        return super.make_restful_get(s, s1, i);
    }

    public volatile ServerResponse make_restful_post(JSONObject jsonobject, String s, String s1, int i)
    {
        return super.make_restful_post(jsonobject, s, s1, i);
    }

    public volatile ServerResponse make_restful_post(JSONObject jsonobject, String s, String s1, int i, BranchLinkData branchlinkdata)
    {
        return super.make_restful_post(jsonobject, s, s1, i, branchlinkdata);
    }

    public volatile ServerResponse make_restful_post(JSONObject jsonobject, String s, String s1, int i, boolean flag)
    {
        return super.make_restful_post(jsonobject, s, s1, i, flag);
    }

    public void sendLog(String s)
    {
        if (prefHelper_.getDeviceFingerPrintID().equals("bnc_no_value"))
        {
            callback_.finished(new ServerResponse("t_debug_connect", -1009));
            return;
        }
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), prefHelper_.getDeviceFingerPrintID());
            if (!prefHelper_.getSessionID().equals("bnc_no_value"))
            {
                jsonobject.put(Defines.Jsonkey.SessionID.getKey(), prefHelper_.getSessionID());
            }
            if (!prefHelper_.getIdentityID().equals("bnc_no_value"))
            {
                jsonobject.put(Defines.Jsonkey.IdentityID.getKey(), prefHelper_.getIdentityID());
            }
            jsonobject.put("log", s);
            callback_.finished(make_restful_post(jsonobject, (new StringBuilder()).append(prefHelper_.getAPIBaseUrl()).append("v1/debug/log").toString(), "t_debug_log", prefHelper_.getTimeout(), true));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void setNetworkCallbackListener(NetworkCallback networkcallback)
    {
        callback_ = networkcallback;
    }
}
