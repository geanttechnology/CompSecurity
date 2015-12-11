// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.amazon.mobile.mash.event.AmazonMASHNotificationReceiver;
import com.amazon.mobile.mash.util.MASHDebug;
import java.util.Map;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHEventPlugin, MASHCordovaPlugin

class val.callback
    implements Runnable
{

    final MASHEventPlugin this$0;
    final CallbackContext val$callback;
    final String val$eventType;

    public void run()
    {
        Object obj = createNotificationReceiver(val$eventType, val$callback);
        if (obj != null)
        {
            MASHEventPlugin.access$000(MASHEventPlugin.this).put(val$eventType, obj);
            if (((AmazonMASHNotificationReceiver) (obj)).useIntentReceiver())
            {
                LocalBroadcastManager.getInstance(webView.getContext()).registerReceiver(((android.content.BroadcastReceiver) (obj)), AmazonMASHNotificationReceiver.MASH_EVENT_INTENT_FILTER);
            }
            obj = new PluginResult(org.apache.cordova.s.NO_RESULT);
            ((PluginResult) (obj)).setKeepCallback(true);
            val$callback.sendPluginResult(((PluginResult) (obj)));
            if (MASHDebug.isEnabled())
            {
                Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("AddEventListener is executed successfully. eventType=").append(val$eventType).toString());
            }
        }
    }

    ger()
    {
        this$0 = final_masheventplugin;
        val$eventType = s;
        val$callback = CallbackContext.this;
        super();
    }
}
