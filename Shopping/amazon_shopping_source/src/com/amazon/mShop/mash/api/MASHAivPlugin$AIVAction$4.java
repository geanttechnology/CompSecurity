// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.util.Log;
import com.amazon.mShop.aiv.AIVAvailabilityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mobile.mash.error.MASHError;
import java.util.ArrayList;
import java.util.List;
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
        if (!AIVAvailabilityUtils.isAIVCompanionAppInstalled(cordovaplugin.cordova.getActivity()))
        {
            return false;
        }
        ArrayList arraylist;
        int i;
        try
        {
            jsonarray = jsonarray.getJSONArray(0);
            arraylist = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            if (!Util.isEmpty(jsonarray.getMessage()))
            {
                Log.e(getApiName(), jsonarray.getMessage());
            }
            callbackcontext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            return false;
        }
        i = 0;
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(jsonarray.getString(i));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_35;
_L1:
        cordovaplugin.cordova.getThreadPool().execute(new Task(callbackcontext, arraylist, null));
        return true;
    }

    Task(String s, int i, String s1)
    {
        super(s, i, s1, null);
    }
}
