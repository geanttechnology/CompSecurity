// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.amazon.mobile.mash.util.Util;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

public class AmazonMASHNotificationReceiver extends BroadcastReceiver
{

    public static final IntentFilter MASH_EVENT_INTENT_FILTER = new IntentFilter("com.amazon.mShop.mash.notification");
    private static final String TAG = com/amazon/mobile/mash/event/AmazonMASHNotificationReceiver.getSimpleName();
    private final CallbackContext mCallbackContext;
    private final String mEventType;
    private final boolean mUseIntentReceiver;

    public AmazonMASHNotificationReceiver(String s, CallbackContext callbackcontext, boolean flag)
    {
        mEventType = s;
        mCallbackContext = callbackcontext;
        mUseIntentReceiver = flag;
    }

    public void notifyWebPage(JSONObject jsonobject)
    {
        JSONObject jsonobject1;
        jsonobject1 = new JSONObject();
        jsonobject1.put("type", mEventType);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        jsonobject1.put("detail", jsonobject);
        jsonobject = new PluginResult(org.apache.cordova.PluginResult.Status.OK, jsonobject1);
        jsonobject.setKeepCallback(true);
        mCallbackContext.sendPluginResult(jsonobject);
_L1:
        return;
        jsonobject;
        if (!Util.isEmpty(jsonobject.getMessage()))
        {
            Log.e(TAG, jsonobject.getMessage());
            return;
        }
          goto _L1
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("type");
        if (!mEventType.equals(context))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        context = intent.getStringExtra("detail");
        if (!Util.isEmpty(context))
        {
            break MISSING_BLOCK_LABEL_40;
        }
        context = null;
_L1:
        try
        {
            notifyWebPage(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        break MISSING_BLOCK_LABEL_57;
        context = new JSONObject(context);
          goto _L1
    }

    public boolean useIntentReceiver()
    {
        return mUseIntentReceiver;
    }

}
