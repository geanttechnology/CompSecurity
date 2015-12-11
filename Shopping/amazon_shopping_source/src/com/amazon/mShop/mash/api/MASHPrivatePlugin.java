// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.text.TextUtils;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.mobile.mash.error.MASHError;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MASHPrivatePlugin extends MASHCordovaPlugin
{

    public MASHPrivatePlugin()
    {
    }

    private void getPushNotificationInfo(JSONArray jsonarray, final CallbackContext callback)
    {
        runOnUiThread(new Runnable() {

            final MASHPrivatePlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                Object obj = PushNotificationManager.getInstance();
                if (obj != null)
                {
                    obj = ((PushNotificationManager) (obj)).getCurrentMShopDeviceToken();
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        try
                        {
                            JSONObject jsonobject = new JSONObject();
                            jsonobject.put("pushToken", obj);
                            jsonobject.put("appID", "com.amazon.mShop.android");
                            jsonobject.put("protocol", "GCM");
                            callback.success(jsonobject);
                            return;
                        }
                        catch (JSONException jsonexception)
                        {
                            callback.error(MASHError.UNKNOWN.toJSONObejct());
                        }
                        return;
                    }
                }
                callback.error(MASHError.UNKNOWN.toJSONObejct());
            }

            
            {
                this$0 = MASHPrivatePlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("GetPushNotificationInfo".equals(s))
        {
            getPushNotificationInfo(jsonarray, callbackcontext);
            return true;
        } else
        {
            return false;
        }
    }
}
