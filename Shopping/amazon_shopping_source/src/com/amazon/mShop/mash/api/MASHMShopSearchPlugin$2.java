// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.util.ActivityUtils;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHMShopSearchPlugin

class val.callback
    implements Runnable
{

    final MASHMShopSearchPlugin this$0;
    final CallbackContext val$callback;

    public void run()
    {
        ActivityUtils.startCategoryBrowseActivity(cordova.getActivity());
        val$callback.success();
    }

    ()
    {
        this$0 = final_mashmshopsearchplugin;
        val$callback = CallbackContext.this;
        super();
    }
}
