// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.amazon.mobile.mash.util.MASHDebug;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHCorePlugin, MASHCordovaPlugin

class val.callback
    implements Runnable
{

    final MASHCorePlugin this$0;
    final CallbackContext val$callback;
    final String val$url;

    public void run()
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(val$url));
        cordova.getActivity().startActivity(intent);
        val$callback.success();
        if (MASHDebug.isEnabled())
        {
            Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("OpenInExternalBrowser is executed successfully. url=").append(val$url).toString());
        }
    }

    ()
    {
        this$0 = final_mashcoreplugin;
        val$url = s;
        val$callback = CallbackContext.this;
        super();
    }
}
