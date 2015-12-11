// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.util.Log;
import com.amazon.mobile.mash.util.MASHDebug;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.json.JSONObject;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHEventPlugin, MASHCordovaPlugin

class val.eventDetail
    implements Runnable
{

    final MASHEventPlugin this$0;
    final CallbackContext val$callback;
    final String val$eventDetail;
    final JSONObject val$eventDetailJson;
    final String val$eventType;

    public void run()
    {
        MASHEventPlugin.sendMASHEventBroadcast(val$eventType, val$eventDetailJson, webView.getContext());
        val$callback.success();
        if (MASHDebug.isEnabled())
        {
            Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("DispatchEvent is executed succeccfully.\n eventType=").append(val$eventType).append(" eventDetail=").append(val$eventDetail).toString());
        }
    }

    ()
    {
        this$0 = final_masheventplugin;
        val$eventType = s;
        val$eventDetailJson = jsonobject;
        val$callback = callbackcontext;
        val$eventDetail = String.this;
        super();
    }
}
