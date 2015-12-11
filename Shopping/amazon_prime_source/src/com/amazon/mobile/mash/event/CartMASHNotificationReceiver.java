// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.event;

import android.util.Log;
import org.apache.cordova.CallbackContext;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.mobile.mash.event:
//            AmazonMASHNotificationReceiver, MASHEventType

public class CartMASHNotificationReceiver extends AmazonMASHNotificationReceiver
{

    private static final String TAG = com/amazon/mobile/mash/event/CartMASHNotificationReceiver.getSimpleName();

    public CartMASHNotificationReceiver(CallbackContext callbackcontext)
    {
        super(MASHEventType.cartUpdated.name(), callbackcontext, true);
    }

    public static JSONObject getCartUpdateJSONObject(int i)
    {
        Object obj = null;
        Object obj1 = new JSONObject();
        obj = new JSONObject();
        ((JSONObject) (obj)).put("itemCount", i);
        ((JSONObject) (obj1)).put("cart", obj);
        return ((JSONObject) (obj1));
        obj1;
_L2:
        Log.e(TAG, (new StringBuilder()).append("Created a bad JSON object. Error : ").append(((JSONException) (obj1)).getMessage()).toString());
        return ((JSONObject) (obj));
        JSONException jsonexception;
        jsonexception;
        obj = obj1;
        obj1 = jsonexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
