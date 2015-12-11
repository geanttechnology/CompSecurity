// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.aiv.AmazonInstantVideoProxy;
import java.util.List;
import org.apache.cordova.CallbackContext;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHAivPlugin

static class <init>
    implements Runnable
{

    private final List mAsins;
    private final CallbackContext mCallbackContext;

    public void run()
    {
        AmazonInstantVideoProxy.getInstance().whisperCache(mAsins);
        mCallbackContext.success();
    }

    private (CallbackContext callbackcontext, List list)
    {
        mCallbackContext = callbackcontext;
        mAsins = list;
    }

    mAsins(CallbackContext callbackcontext, List list, mAsins masins)
    {
        this(callbackcontext, list);
    }
}
