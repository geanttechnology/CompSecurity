// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ServerRequest, SystemObserver, PrefHelper, ServerResponse, 
//            Branch

class ServerRequestSendAppList extends ServerRequest
{

    public ServerRequestSendAppList(Context context)
    {
        super(context, Defines.RequestPath.SendAPPList.getPath());
        context = new SystemObserver(context);
        JSONObject jsonobject = new JSONObject();
        try
        {
            if (!context.getOS().equals("bnc_no_value"))
            {
                jsonobject.put(Defines.Jsonkey.OS.getKey(), context.getOS());
            }
            jsonobject.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), prefHelper_.getDeviceFingerPrintID());
            jsonobject.put("apps_data", context.getListOfApps());
            setPost(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        constructError_ = true;
    }

    public ServerRequestSendAppList(String s, JSONObject jsonobject, Context context)
    {
        super(s, jsonobject, context);
    }

    public void clearCallbacks()
    {
    }

    public boolean handleErrors(Context context)
    {
        if (!super.doesAppHasInternetPermission(context))
        {
            Log.i("BranchSDK", "Trouble executing your request. Please add 'android.permission.INTERNET' in your applications manifest file");
            return true;
        } else
        {
            return false;
        }
    }

    public void handleFailure(int i, String s)
    {
    }

    public boolean isGetRequest()
    {
        return false;
    }

    public void onRequestSucceeded(ServerResponse serverresponse, Branch branch)
    {
        prefHelper_.clearSystemReadStatus();
    }
}
