// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

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
        try
        {
            jsonarray = jsonarray.getString(0);
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
        if (cess._mth200(activity, jsonarray))
        {
            return false;
        } else
        {
            cordovaplugin.cordova.getThreadPool().execute(new Task(callbackcontext, activity, jsonarray, null));
            return true;
        }
    }

    Task(String s, int i, String s1)
    {
        super(s, i, s1, null);
    }
}
