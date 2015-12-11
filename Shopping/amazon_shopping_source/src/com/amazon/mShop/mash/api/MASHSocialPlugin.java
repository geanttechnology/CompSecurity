// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.app.Activity;
import android.content.Intent;
import com.amazon.mShop.AmazonChooserActivity;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class MASHSocialPlugin extends MASHCordovaPlugin
{

    private CallbackContext mCallback;

    public MASHSocialPlugin()
    {
    }

    private void handleActivityResultForShare(int i, int j, Intent intent)
    {
        if (j == -1)
        {
            intent = intent.getStringExtra("SelectedResult");
            intent = (new StringBuilder()).append("'").append(intent).append("'").toString();
            mCallback.success(intent);
        } else
        if (j == 0)
        {
            mCallback.success("null");
            return;
        }
    }

    private void share(JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        mCallback = callbackcontext;
        runOnUiThread(new Runnable() {

            final MASHSocialPlugin this$0;
            final CallbackContext val$callback;
            final String val$imageUrl;
            final String val$subject;
            final String val$text;
            final String val$url;

            public void run()
            {
                Object obj = new Intent("android.intent.action.SEND");
                ((Intent) (obj)).setType("text/plain");
                ((Intent) (obj)).putExtra("android.intent.extra.TEXT", text);
                ((Intent) (obj)).putExtra("android.intent.extra.SUBJECT", subject);
                ((Intent) (obj)).putExtra("imgUrl", imageUrl);
                ((Intent) (obj)).putExtra("url", url);
                ((Intent) (obj)).putExtra("android.intent.extra.TITLE", cordova.getActivity().getString(com.amazon.mShop.android.lib.R.string.sharing_share));
                obj = AmazonChooserActivity.getIntentToStart(cordova.getActivity(), ((Intent) (obj)));
                cordova.startActivityForResult(MASHSocialPlugin.this, ((Intent) (obj)), 15);
                obj = new PluginResult(org.apache.cordova.PluginResult.Status.NO_RESULT);
                ((PluginResult) (obj)).setKeepCallback(true);
                callback.sendPluginResult(((PluginResult) (obj)));
            }

            
            {
                this$0 = MASHSocialPlugin.this;
                text = s;
                subject = s1;
                imageUrl = s2;
                url = s3;
                callback = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("Share".equals(s))
        {
            share(jsonarray, callbackcontext);
            return true;
        } else
        {
            return false;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 15)
        {
            handleActivityResultForShare(i, j, intent);
        }
    }
}
