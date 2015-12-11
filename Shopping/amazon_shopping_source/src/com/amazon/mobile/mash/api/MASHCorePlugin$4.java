// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.amazon.mobile.mash.error.LaunchIntentURLError;
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
        try
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(val$url));
            cordova.getActivity().startActivity(intent);
            val$callback.success();
            if (MASHDebug.isEnabled())
            {
                Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("LaunchIntentURL is executed successfully. url=").append(val$url).toString());
            }
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Log.e(MASHCordovaPlugin.TAG, "", activitynotfoundexception);
        }
        val$callback.error(LaunchIntentURLError.INTENT_NOT_FOUND.toJSONObejct());
    }

    Error()
    {
        this$0 = final_mashcoreplugin;
        val$url = s;
        val$callback = CallbackContext.this;
        super();
    }
}
