// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.amazon.mobile.mash.event.AmazonMASHNotificationReceiver;
import com.amazon.mobile.mash.event.CartMASHNotificationReceiver;
import com.amazon.mobile.mash.event.MASHEventType;
import com.amazon.mobile.mash.util.MASHDebug;
import com.amazon.mobile.mash.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHCordovaPlugin

public class MASHEventPlugin extends MASHCordovaPlugin
{

    private Map mMashNotificationReceivers;

    public MASHEventPlugin()
    {
        mMashNotificationReceivers = new HashMap();
    }

    private void addEventListener(JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHEventPlugin this$0;
            final CallbackContext val$callback;
            final String val$eventType;

            public void run()
            {
                Object obj = createNotificationReceiver(eventType, callback);
                if (obj != null)
                {
                    mMashNotificationReceivers.put(eventType, obj);
                    if (((AmazonMASHNotificationReceiver) (obj)).useIntentReceiver())
                    {
                        LocalBroadcastManager.getInstance(webView.getContext()).registerReceiver(((android.content.BroadcastReceiver) (obj)), AmazonMASHNotificationReceiver.MASH_EVENT_INTENT_FILTER);
                    }
                    obj = new PluginResult(org.apache.cordova.PluginResult.Status.NO_RESULT);
                    ((PluginResult) (obj)).setKeepCallback(true);
                    callback.sendPluginResult(((PluginResult) (obj)));
                    if (MASHDebug.isEnabled())
                    {
                        Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("AddEventListener is executed successfully. eventType=").append(eventType).toString());
                    }
                }
            }

            
            {
                this$0 = MASHEventPlugin.this;
                eventType = s;
                callback = callbackcontext;
                super();
            }
        });
    }

    private void dispatchEvent(final JSONArray eventDetailJson, final CallbackContext callback)
        throws JSONException
    {
        final String eventType = eventDetailJson.getString(0);
        final String eventDetail = eventDetailJson.getString(1);
        if (Util.isEmpty(eventDetail))
        {
            eventDetailJson = null;
        } else
        {
            eventDetailJson = new JSONObject(eventDetail);
        }
        runOnUiThread(new Runnable() {

            final MASHEventPlugin this$0;
            final CallbackContext val$callback;
            final String val$eventDetail;
            final JSONObject val$eventDetailJson;
            final String val$eventType;

            public void run()
            {
                MASHEventPlugin.sendMASHEventBroadcast(eventType, eventDetailJson, webView.getContext());
                callback.success();
                if (MASHDebug.isEnabled())
                {
                    Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("DispatchEvent is executed succeccfully.\n eventType=").append(eventType).append(" eventDetail=").append(eventDetail).toString());
                }
            }

            
            {
                this$0 = MASHEventPlugin.this;
                eventType = s;
                eventDetailJson = jsonobject;
                callback = callbackcontext;
                eventDetail = s1;
                super();
            }
        });
    }

    private void removeEventListener(final JSONArray eventType, final CallbackContext callback)
        throws JSONException
    {
        eventType = eventType.getString(0);
        final JSONObject mashEvent = new JSONObject();
        mashEvent.put("type", eventType);
        runOnUiThread(new Runnable() {

            final MASHEventPlugin this$0;
            final CallbackContext val$callback;
            final String val$eventType;
            final JSONObject val$mashEvent;

            public void run()
            {
                AmazonMASHNotificationReceiver amazonmashnotificationreceiver = getReceiver(eventType);
                if (amazonmashnotificationreceiver != null)
                {
                    mMashNotificationReceivers.remove(eventType);
                    if (amazonmashnotificationreceiver.useIntentReceiver())
                    {
                        LocalBroadcastManager.getInstance(webView.getContext()).unregisterReceiver(amazonmashnotificationreceiver);
                    }
                }
                callback.success(mashEvent);
                if (MASHDebug.isEnabled())
                {
                    Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("RemoveEventListener is executed succeccfully. eventType=").append(eventType).toString());
                }
            }

            
            {
                this$0 = MASHEventPlugin.this;
                eventType = s;
                callback = callbackcontext;
                mashEvent = jsonobject;
                super();
            }
        });
    }

    private void resetMASHNotificationReceivers()
    {
        Iterator iterator = mMashNotificationReceivers.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AmazonMASHNotificationReceiver amazonmashnotificationreceiver = (AmazonMASHNotificationReceiver)iterator.next();
            if (amazonmashnotificationreceiver.useIntentReceiver())
            {
                LocalBroadcastManager.getInstance(webView.getContext()).unregisterReceiver(amazonmashnotificationreceiver);
            }
        } while (true);
        mMashNotificationReceivers.clear();
    }

    public static void sendMASHEventBroadcast(String s, JSONObject jsonobject, Context context)
    {
        Intent intent = new Intent("com.amazon.mShop.mash.notification");
        intent.putExtra("type", s);
        if (jsonobject != null)
        {
            intent.putExtra("detail", jsonobject.toString());
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    protected AmazonMASHNotificationReceiver createNotificationReceiver(String s, CallbackContext callbackcontext)
    {
        if (MASHEventType.cartUpdated.name().equalsIgnoreCase(s))
        {
            return new CartMASHNotificationReceiver(callbackcontext);
        }
        if (MASHEventType.appPause.name().equalsIgnoreCase(s) || MASHEventType.appResume.name().equalsIgnoreCase(s))
        {
            return new AmazonMASHNotificationReceiver(s, callbackcontext, false);
        } else
        {
            return null;
        }
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("AddEventListener".equals(s))
        {
            addEventListener(jsonarray, callbackcontext);
        } else
        if ("RemoveEventListener".equals(s))
        {
            removeEventListener(jsonarray, callbackcontext);
        } else
        if ("DispatchEvent".equals(s))
        {
            dispatchEvent(jsonarray, callbackcontext);
        } else
        {
            return false;
        }
        return true;
    }

    public AmazonMASHNotificationReceiver getReceiver(String s)
    {
        return (AmazonMASHNotificationReceiver)mMashNotificationReceivers.get(s);
    }

    public void onDestroy()
    {
        resetMASHNotificationReceivers();
    }

    public void onPause(boolean flag)
    {
        AmazonMASHNotificationReceiver amazonmashnotificationreceiver = getReceiver(MASHEventType.appPause.name());
        if (amazonmashnotificationreceiver != null)
        {
            amazonmashnotificationreceiver.notifyWebPage(null);
        }
    }

    public void onReset()
    {
        resetMASHNotificationReceivers();
    }

    public void onResume(boolean flag)
    {
        AmazonMASHNotificationReceiver amazonmashnotificationreceiver = getReceiver(MASHEventType.appResume.name());
        if (amazonmashnotificationreceiver != null)
        {
            amazonmashnotificationreceiver.notifyWebPage(null);
        }
    }

}
