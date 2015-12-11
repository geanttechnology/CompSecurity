// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.text.TextUtils;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mobile.mash.error.MASHError;
import org.apache.cordova.CallbackContext;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHPrivatePlugin

class val.callback
    implements Runnable
{

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
                    val$callback.success(jsonobject);
                    return;
                }
                catch (JSONException jsonexception)
                {
                    val$callback.error(MASHError.UNKNOWN.toJSONObejct());
                }
                return;
            }
        }
        val$callback.error(MASHError.UNKNOWN.toJSONObejct());
    }

    tionManager()
    {
        this$0 = final_mashprivateplugin;
        val$callback = CallbackContext.this;
        super();
    }
}
