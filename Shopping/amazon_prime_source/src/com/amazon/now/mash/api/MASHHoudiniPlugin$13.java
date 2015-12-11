// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.AmazonActivity;
import com.amazon.now.util.UpdateUtil;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHHoudiniPlugin

class val.callbackContext
    implements Runnable
{

    final MASHHoudiniPlugin this$0;
    final CallbackContext val$callbackContext;

    public void run()
    {
        if (UpdateUtil.launchAppStore((AmazonActivity)cordova.getActivity()))
        {
            val$callbackContext.success();
            return;
        } else
        {
            val$callbackContext.error(MASHError.UNKNOWN.toJSONObejct());
            return;
        }
    }

    ()
    {
        this$0 = final_mashhoudiniplugin;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
