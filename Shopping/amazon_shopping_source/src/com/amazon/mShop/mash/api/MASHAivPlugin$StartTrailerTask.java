// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.app.Activity;
import com.amazon.mShop.aiv.AmazonInstantVideoProxy;
import org.apache.cordova.CallbackContext;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHAivPlugin

static class <init>
    implements Runnable
{

    private final Activity mActivity;
    private final String mAsin;
    private final CallbackContext mCallbackContext;

    public void run()
    {
        AmazonInstantVideoProxy.getInstance().startTrailer(mActivity, mAsin);
        mCallbackContext.success();
    }

    private (CallbackContext callbackcontext, Activity activity, String s)
    {
        mCallbackContext = callbackcontext;
        mActivity = activity;
        mAsin = s;
    }

    mAsin(CallbackContext callbackcontext, Activity activity, String s, mAsin masin)
    {
        this(callbackcontext, activity, s);
    }
}
