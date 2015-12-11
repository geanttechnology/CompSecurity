// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.app.Activity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHNavigationPlugin

class val.callbackContext
    implements Runnable
{

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
        val$callbackContext.success();
    }

    ()
    {
        this$0 = final_mashnavigationplugin;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
