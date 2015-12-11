// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.branch.referral:
//            ServerRequest, PrefHelper, ServerResponse, Branch

class ServerRequestActionCompleted extends ServerRequest
{

    public ServerRequestActionCompleted(Context context, String s, JSONObject jsonobject)
    {
        super(context, Defines.RequestPath.CompletedAction.getPath());
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
            context.put(Defines.Jsonkey.Event.getKey(), s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            constructError_ = true;
            return;
        }
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        context.put(Defines.Jsonkey.Metadata.getKey(), jsonobject);
        setPost(context);
        return;
    }

    public ServerRequestActionCompleted(String s, JSONObject jsonobject, Context context)
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
    }

    public boolean shouldRetryOnFail()
    {
        return true;
    }
}
