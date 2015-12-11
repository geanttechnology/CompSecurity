// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.mash.OfferListingView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHMShopDetailPagePlugin

class val.callback
    implements Runnable
{

    final MASHMShopDetailPagePlugin this$0;
    final String val$asin;
    final CallbackContext val$callback;
    final String val$listId;
    final String val$listItemId;

    public void run()
    {
        OfferListingView.show((AmazonActivity)cordova.getActivity(), val$asin, val$listId, val$listItemId);
        val$callback.success();
    }

    ()
    {
        this$0 = final_mashmshopdetailpageplugin;
        val$asin = s;
        val$listId = s1;
        val$listItemId = s2;
        val$callback = CallbackContext.this;
        super();
    }
}
