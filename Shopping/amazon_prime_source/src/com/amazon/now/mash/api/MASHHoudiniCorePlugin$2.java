// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHHoudiniCorePlugin

class val.callback
    implements Runnable
{

    final MASHHoudiniCorePlugin this$0;
    final CallbackContext val$callback;
    final String val$url;

    public void run()
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(val$url));
        cordova.getActivity().startActivity(intent);
        val$callback.success();
    }

    ()
    {
        this$0 = final_mashhoudinicoreplugin;
        val$url = s;
        val$callback = CallbackContext.this;
        super();
    }
}
