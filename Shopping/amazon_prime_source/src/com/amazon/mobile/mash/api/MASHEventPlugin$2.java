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
import org.json.JSONObject;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHEventPlugin, MASHCordovaPlugin

class val.mashEvent
    implements Runnable
{

    final MASHEventPlugin this$0;
    final CallbackContext val$callback;
    final String val$eventType;
    final JSONObject val$mashEvent;

    public void run()
    {
        AmazonMASHNotificationReceiver amazonmashnotificationreceiver = getReceiver(val$eventType);
        if (amazonmashnotificationreceiver != null)
        {
            MASHEventPlugin.access$000(MASHEventPlugin.this).remove(val$eventType);
            if (amazonmashnotificationreceiver.useIntentReceiver())
            {
                LocalBroadcastManager.getInstance(webView.getContext()).unregisterReceiver(amazonmashnotificationreceiver);
            }
        }
        val$callback.success(val$mashEvent);
        if (MASHDebug.isEnabled())
        {
            Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("RemoveEventListener is executed succeccfully. eventType=").append(val$eventType).toString());
        }
    }

    ger()
    {
        this$0 = final_masheventplugin;
        val$eventType = s;
        val$callback = callbackcontext;
        val$mashEvent = JSONObject.this;
        super();
    }
}
