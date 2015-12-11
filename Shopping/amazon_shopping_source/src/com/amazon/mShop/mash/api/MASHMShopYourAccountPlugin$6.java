// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.smile.SmileHelper;
import com.amazon.mobile.mash.error.MASHError;
import org.apache.cordova.CallbackContext;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHMShopYourAccountPlugin

class val.callback
    implements Runnable
{

    final MASHMShopYourAccountPlugin this$0;
    final CallbackContext val$callback;
    final String val$charityName;
    final boolean val$isSmile;

    public void run()
    {
        if (SmileHelper.updateSmileInfo(val$isSmile, val$charityName))
        {
            val$callback.success();
            return;
        } else
        {
            val$callback.error(MASHError.UNKNOWN.toJSONObejct());
            return;
        }
    }

    ()
    {
        this$0 = final_mashmshopyouraccountplugin;
        val$isSmile = flag;
        val$charityName = s;
        val$callback = CallbackContext.this;
        super();
    }
}
