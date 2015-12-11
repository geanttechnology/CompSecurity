// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.util.ActivityUtils;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHMShopYourAccountPlugin

class val.callback
    implements Runnable
{

    final MASHMShopYourAccountPlugin this$0;
    final CallbackContext val$callback;

    public void run()
    {
        ActivityUtils.startOneClickSettingActivity((AmazonActivity)cordova.getActivity(), false, false);
        val$callback.success();
    }

    ()
    {
        this$0 = final_mashmshopyouraccountplugin;
        val$callback = CallbackContext.this;
        super();
    }
}
