// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.content.Intent;
import android.util.Log;
import com.amazon.mShop.util.Util;
import java.util.concurrent.ExecutorService;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHAivPlugin

static final class nit> extends nit>
{

    public boolean execute(JSONArray jsonarray, CallbackContext callbackcontext, CordovaPlugin cordovaplugin)
    {
        android.app.Activity activity = cordovaplugin.cordova.getActivity();
        String s;
        int i;
        try
        {
            s = jsonarray.getString(0);
            i = jsonarray.getInt(1);
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            if (!Util.isEmpty(jsonarray.getMessage()))
            {
                Log.e(getApiName(), jsonarray.getMessage());
            }
            callbackcontext.error((new StringBuilder()).append(getApiName()).append(" JSONException: ").append(jsonarray.getMessage()).toString());
            return false;
        }
        if (cess._mth200(activity, s))
        {
            return false;
        } else
        {
            jsonarray = new kTask(s, i, cordovaplugin, null);
            cordovaplugin.cordova.getThreadPool().execute(jsonarray);
            return true;
        }
    }

    public void onActivityResult(CallbackContext callbackcontext, int i, int j, Intent intent)
    {
        callbackcontext.success();
    }

    kTask(String s, int i, String s1)
    {
        super(s, i, s1, null);
    }
}
