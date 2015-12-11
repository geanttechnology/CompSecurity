// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.now.mash.NavManager;
import com.amazon.now.util.AppUtils;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONException;
import org.json.JSONObject;

public class MASHNavigationPlugin extends MASHCordovaPlugin
{

    public static final String SERVICE_NAME = "MASHNavigation";

    public MASHNavigationPlugin()
    {
    }

    private static String canonicalizeIfRelativeUrl(Context context, String s)
    {
label0:
        {
            String s1 = AppUtils.getServiceUrl(context);
            context = s;
            if (!TextUtils.isEmpty(s))
            {
                context = Uri.parse(s);
                s = Uri.parse(s1);
                if (context.getHost() != null || context.getScheme() != null)
                {
                    break label0;
                }
                context = context.buildUpon();
                context.encodedAuthority(s.getAuthority());
                context.scheme(s.getScheme());
                context = context.build().toString();
            }
            return context;
        }
        return context.toString();
    }

    private void goBack(final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHNavigationPlugin this$0;
            final CallbackContext val$callbackContext;

            public void run()
            {
                if (webView.canGoBack())
                {
                    webView.goBack();
                } else
                {
                    cordova.getActivity().onBackPressed();
                }
                callbackContext.success();
            }

            
            {
                this$0 = MASHNavigationPlugin.this;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void navigate(final JSONObject args, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHNavigationPlugin this$0;
            final JSONObject val$args;
            final CallbackContext val$callbackContext;

            public void run()
            {
                String s = args.optString("url");
                if (AppUtils.isDefined(s))
                {
                    s = MASHNavigationPlugin.canonicalizeIfRelativeUrl(cordova.getActivity(), s);
                    if (!NavManager.getInstance().navigate(s, cordova.getActivity()))
                    {
                        webView.loadUrl(s);
                    }
                }
                if (AppUtils.isDefined(args.optString("transitionEffect")))
                {
                    Log.i("MASHNavigation", "transition effects not yet supported");
                    callbackContext.success();
                }
            }

            
            {
                this$0 = MASHNavigationPlugin.this;
                args = jsonobject;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, String s1, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("Navigate".equalsIgnoreCase(s))
        {
            navigate(new JSONObject(s1), callbackcontext);
            return true;
        }
        if ("GoBack".equalsIgnoreCase(s))
        {
            goBack(callbackcontext);
            return true;
        } else
        {
            return false;
        }
    }

}
