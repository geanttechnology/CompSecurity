// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.aiv.AmazonInstantVideoProxy;
import org.apache.cordova.CallbackContext;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHAivPlugin

static class <init>
    implements Runnable
{

    private final CallbackContext mCallbackContext;

    public void run()
    {
        boolean flag = AmazonInstantVideoProxy.getInstance().isPlaybackSustainable();
        mCallbackContext.success(String.valueOf(flag));
    }

    private (CallbackContext callbackcontext)
    {
        mCallbackContext = callbackcontext;
    }

    mCallbackContext(CallbackContext callbackcontext, mCallbackContext mcallbackcontext)
    {
        this(callbackcontext);
    }
}
