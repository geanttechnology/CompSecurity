// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.app.Activity;
import android.content.Intent;
import com.amazon.mShop.AmazonChooserActivity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHSocialPlugin

class val.callback
    implements Runnable
{

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
        ((Intent) (obj)).putExtra("android.intent.extra.TEXT", val$text);
        ((Intent) (obj)).putExtra("android.intent.extra.SUBJECT", val$subject);
        ((Intent) (obj)).putExtra("imgUrl", val$imageUrl);
        ((Intent) (obj)).putExtra("url", val$url);
        ((Intent) (obj)).putExtra("android.intent.extra.TITLE", cordova.getActivity().getString(com.amazon.mShop.android.lib.are));
        obj = AmazonChooserActivity.getIntentToStart(cordova.getActivity(), ((Intent) (obj)));
        cordova.startActivityForResult(MASHSocialPlugin.this, ((Intent) (obj)), 15);
        obj = new PluginResult(org.apache.cordova..NO_RESULT);
        ((PluginResult) (obj)).setKeepCallback(true);
        val$callback.sendPluginResult(((PluginResult) (obj)));
    }

    ()
    {
        this$0 = final_mashsocialplugin;
        val$text = s;
        val$subject = s1;
        val$imageUrl = s2;
        val$url = s3;
        val$callback = CallbackContext.this;
        super();
    }
}
