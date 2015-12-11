// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.map.MapWebActivity;
import com.amazon.now.util.AppUtils;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHHoudiniPlugin

class val.callbackContext
    implements Runnable
{

    final MASHHoudiniPlugin this$0;
    final JSONObject val$args;
    final CallbackContext val$callbackContext;

    public void run()
    {
        MapWebActivity mapwebactivity = (MapWebActivity)cordova.getActivity();
        Object obj1 = val$args.optJSONObject("left");
        Object obj = val$args.optJSONObject("right");
        if (obj1 != null && obj != null)
        {
            String s = ((JSONObject) (obj1)).optString("text");
            obj1 = ((JSONObject) (obj1)).optString("color");
            String s1 = ((JSONObject) (obj)).optString("text");
            obj = ((JSONObject) (obj)).optString("color");
            if (AppUtils.isDefined(s) && AppUtils.isDefined(((String) (obj1))) && AppUtils.isDefined(s1) && AppUtils.isDefined(((String) (obj))))
            {
                mapwebactivity.displayMapBar(s, ((String) (obj1)), s1, ((String) (obj)));
                val$callbackContext.success();
                return;
            }
        }
        val$callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
    }

    ()
    {
        this$0 = final_mashhoudiniplugin;
        val$args = jsonobject;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
