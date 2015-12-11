// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.mobile.mash.embeddedbrowser.EmbeddedBrowserActivity;
import com.amazon.mobile.mash.error.ExitEmbeddedBrowserError;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.mobile.mash.util.MASHDebug;
import com.amazon.mobile.mash.util.Util;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHCordovaPlugin

public class MASHEmbeddedBrowserPlugin extends MASHCordovaPlugin
{

    private CallbackContext mCallbackContext;

    public MASHEmbeddedBrowserPlugin()
    {
    }

    private void exitEmbeddedBrowser(JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        final String targetUrl = jsonarray.getString(0);
        if (!TextUtils.isEmpty(targetUrl) && !Util.isUrlWhitelisted(targetUrl))
        {
            callbackcontext.error(ExitEmbeddedBrowserError.TARGET_URL_NOT_ALLOWED.toJSONObejct());
            return;
        } else
        {
            runOnUiThread(new Runnable() {

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
                        intent.putExtra(WebConstants.getWebViewUrlKey(), targetUrl);
                        intent.putExtra("method", method);
                        intent.putExtra("postParams", postParameters);
                        Activity activity = cordova.getActivity();
                        activity.setResult(-1, intent);
                        activity.finish();
                    }
                    callback.success();
                    if (MASHDebug.isEnabled())
                    {
                        Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("exitEmbeddedBrowser is executed successfully. \n arguments: targetUrl=").append(targetUrl).append(" method=").append(method).toString());
                        if (postParameters != null)
                        {
                            Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append(" postData=").append(new String(postParameters)).toString());
                        }
                    }
                }

            
            {
                this$0 = MASHEmbeddedBrowserPlugin.this;
                targetUrl = s;
                method = s1;
                postParameters = abyte0;
                callback = callbackcontext;
                super();
            }
            });
            return;
        }
    }

    private void showEmbeddedBrowser(JSONArray jsonarray, final CallbackContext targetUrl)
        throws JSONException
    {
        mCallbackContext = targetUrl;
        targetUrl = jsonarray.getString(0);
        final String method = jsonarray.getString(1);
        final byte postDataByteArray[] = Util.getPostDataAsByteArray(jsonarray.getJSONObject(2));
        final boolean showRefreshButton = jsonarray.getBoolean(4);
        final boolean showActionButton = jsonarray.getBoolean(5);
        if (!"GET".equals(method) && !"POST".equals(method))
        {
            mCallbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            return;
        } else
        {
            runOnUiThread(new Runnable() {

                final MASHEmbeddedBrowserPlugin this$0;
                final String val$method;
                final byte val$postDataByteArray[];
                final boolean val$showActionButton;
                final boolean val$showRefreshButton;
                final String val$targetUrl;

                public void run()
                {
                    Object obj = new Intent(webView.getContext(), com/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity);
                    ((Intent) (obj)).putExtra(WebConstants.getWebViewUrlKey(), targetUrl);
                    ((Intent) (obj)).putExtra("postParams", postDataByteArray);
                    ((Intent) (obj)).putExtra("method", method);
                    ((Intent) (obj)).putExtra("showRefreshButton", showRefreshButton);
                    ((Intent) (obj)).putExtra("showActionButton", showActionButton);
                    cordova.startActivityForResult(MASHEmbeddedBrowserPlugin.this, ((Intent) (obj)), 10002);
                    obj = new PluginResult(org.apache.cordova.PluginResult.Status.OK, "successCallback");
                    ((PluginResult) (obj)).setKeepCallback(true);
                    mCallbackContext.sendPluginResult(((PluginResult) (obj)));
                    if (MASHDebug.isEnabled())
                    {
                        Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("MASH API ShowEmbeddedBrowser is executed successfully. targetUrl=").append(targetUrl).append(" method=").append(method).append(" showRefreshButton=").append(showRefreshButton).append(" showActionButton=").append(showActionButton).toString());
                    }
                }

            
            {
                this$0 = MASHEmbeddedBrowserPlugin.this;
                targetUrl = s;
                postDataByteArray = abyte0;
                method = s1;
                showRefreshButton = flag;
                showActionButton = flag1;
                super();
            }
            });
            return;
        }
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if (!"ShowEmbeddedBrowser".equals(s)) goto _L2; else goto _L1
_L1:
        showEmbeddedBrowser(jsonarray, callbackcontext);
_L4:
        return true;
_L2:
        if ("ExitEmbeddedBrowser".equals(s))
        {
            exitEmbeddedBrowser(jsonarray, callbackcontext);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i != 10002) goto _L2; else goto _L1
_L1:
        if (j != -1) goto _L4; else goto _L3
_L3:
        String s;
        String s1;
        s = intent.getStringExtra(WebConstants.getWebViewUrlKey());
        s1 = intent.getStringExtra("method");
        intent = intent.getByteArrayExtra("postParams");
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L5
_L5:
        if (!"POST".equalsIgnoreCase(s1)) goto _L7; else goto _L6
_L6:
        webView.postUrl(s, intent);
_L2:
        return;
_L7:
        webView.loadUrl(s);
        return;
_L4:
        if (j == 10002)
        {
            mCallbackContext.success("doneButtonCallback");
            return;
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

}
