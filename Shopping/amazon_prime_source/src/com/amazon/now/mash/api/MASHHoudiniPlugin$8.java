// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.text.TextUtils;
import com.amazon.now.AmazonActivity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
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
        String s = null;
        JSONArray jsonarray = val$args.optJSONArray("discriminators");
        Object obj = s;
        if (jsonarray != null)
        {
            obj = s;
            try
            {
                if (jsonarray.length() > 0)
                {
                    obj = jsonarray.getString(0);
                }
            }
            catch (JSONException jsonexception)
            {
                jsonexception = s;
            }
        }
        s = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s = val$args.optString("discriminator", null);
        }
        ((AmazonActivity)cordova.getActivity()).search(val$args.optString("merchantId", null), s);
        val$callbackContext.success();
        return;
    }

    ()
    {
        this$0 = final_mashhoudiniplugin;
        val$args = jsonobject;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
