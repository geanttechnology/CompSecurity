// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.util.Log;
import com.amazon.now.mash.NavManager;
import com.amazon.now.util.AppUtils;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHNavigationPlugin

class val.callbackContext
    implements Runnable
{

    final MASHNavigationPlugin this$0;
    final JSONObject val$args;
    final CallbackContext val$callbackContext;

    public void run()
    {
        String s = val$args.optString("url");
        if (AppUtils.isDefined(s))
        {
            s = MASHNavigationPlugin.access$000(cordova.getActivity(), s);
            if (!NavManager.getInstance().navigate(s, cordova.getActivity()))
            {
                webView.loadUrl(s);
            }
        }
        if (AppUtils.isDefined(val$args.optString("transitionEffect")))
        {
            Log.i("MASHNavigation", "transition effects not yet supported");
            val$callbackContext.success();
        }
    }

    ()
    {
        this$0 = final_mashnavigationplugin;
        val$args = jsonobject;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
