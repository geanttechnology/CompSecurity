// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.content.Intent;
import android.util.Log;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.mobile.mash.embeddedbrowser.EmbeddedBrowserActivity;
import com.amazon.mobile.mash.util.MASHDebug;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHEmbeddedBrowserPlugin, MASHCordovaPlugin

class val.showActionButton
    implements Runnable
{

    final MASHEmbeddedBrowserPlugin this$0;
    final String val$method;
    final byte val$postDataByteArray[];
    final boolean val$showActionButton;
    final boolean val$showRefreshButton;
    final String val$targetUrl;

    public void run()
    {
        Object obj = new Intent(webView.getContext(), com/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity);
        ((Intent) (obj)).putExtra(WebConstants.getWebViewUrlKey(), val$targetUrl);
        ((Intent) (obj)).putExtra("postParams", val$postDataByteArray);
        ((Intent) (obj)).putExtra("method", val$method);
        ((Intent) (obj)).putExtra("showRefreshButton", val$showRefreshButton);
        ((Intent) (obj)).putExtra("showActionButton", val$showActionButton);
        cordova.startActivityForResult(MASHEmbeddedBrowserPlugin.this, ((Intent) (obj)), 10002);
        obj = new PluginResult(org.apache.cordova.lugin, "successCallback");
        ((PluginResult) (obj)).setKeepCallback(true);
        MASHEmbeddedBrowserPlugin.access$000(MASHEmbeddedBrowserPlugin.this).sendPluginResult(((PluginResult) (obj)));
        if (MASHDebug.isEnabled())
        {
            Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("MASH API ShowEmbeddedBrowser is executed successfully. targetUrl=").append(val$targetUrl).append(" method=").append(val$method).append(" showRefreshButton=").append(val$showRefreshButton).append(" showActionButton=").append(val$showActionButton).toString());
        }
    }

    ctivity()
    {
        this$0 = final_mashembeddedbrowserplugin;
        val$targetUrl = s;
        val$postDataByteArray = abyte0;
        val$method = s1;
        val$showRefreshButton = flag;
        val$showActionButton = Z.this;
        super();
    }
}
