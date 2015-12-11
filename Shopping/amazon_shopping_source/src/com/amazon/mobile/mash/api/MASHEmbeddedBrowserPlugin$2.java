// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.mobile.mash.util.MASHDebug;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHEmbeddedBrowserPlugin, MASHCordovaPlugin

class val.callback
    implements Runnable
{

    final MASHEmbeddedBrowserPlugin this$0;
    final CallbackContext val$callback;
    final String val$method;
    final byte val$postParameters[];
    final String val$targetUrl;

    public void run()
    {
        if (((MASHWebView)webView).isInEmbeddedBrowserMode())
        {
            Intent intent = new Intent();
            intent.putExtra(WebConstants.getWebViewUrlKey(), val$targetUrl);
            intent.putExtra("method", val$method);
            intent.putExtra("postParams", val$postParameters);
            Activity activity = cordova.getActivity();
            activity.setResult(-1, intent);
            activity.finish();
        }
        val$callback.success();
        if (MASHDebug.isEnabled())
        {
            Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("exitEmbeddedBrowser is executed successfully. \n arguments: targetUrl=").append(val$targetUrl).append(" method=").append(val$method).toString());
            if (val$postParameters != null)
            {
                Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append(" postData=").append(new String(val$postParameters)).toString());
            }
        }
    }

    ()
    {
        this$0 = final_mashembeddedbrowserplugin;
        val$targetUrl = s;
        val$method = s1;
        val$postParameters = abyte0;
        val$callback = CallbackContext.this;
        super();
    }
}
