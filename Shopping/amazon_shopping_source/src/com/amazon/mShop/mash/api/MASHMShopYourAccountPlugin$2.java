// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.youraccount.AmazonPointsView;
import com.amazon.mobile.mash.error.MASHError;
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
        AmazonActivity amazonactivity = (AmazonActivity)cordova.getActivity();
        if (ConfigUtils.isEnabled(amazonactivity, com.amazon.mShop.android.lib.va))
        {
            amazonactivity.pushView(new AmazonPointsView(amazonactivity));
            val$callback.success();
            return;
        } else
        {
            val$callback.error(MASHError.NOT_SUPPORTED.toJSONObejct());
            return;
        }
    }

    ()
    {
        this$0 = final_mashmshopyouraccountplugin;
        val$callback = CallbackContext.this;
        super();
    }
}
