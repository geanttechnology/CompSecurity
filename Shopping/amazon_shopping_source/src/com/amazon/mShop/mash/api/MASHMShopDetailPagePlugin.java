// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.mash.OfferListingView;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;

public class MASHMShopDetailPagePlugin extends MASHCordovaPlugin
{

    public MASHMShopDetailPagePlugin()
    {
    }

    private void showOfferListingPage(JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHMShopDetailPagePlugin this$0;
            final String val$asin;
            final CallbackContext val$callback;
            final String val$listId;
            final String val$listItemId;

            public void run()
            {
                OfferListingView.show((AmazonActivity)cordova.getActivity(), asin, listId, listItemId);
                callback.success();
            }

            
            {
                this$0 = MASHMShopDetailPagePlugin.this;
                asin = s;
                listId = s1;
                listItemId = s2;
                callback = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("ShowOfferListingPage".equals(s))
        {
            showOfferListingPage(jsonarray, callbackcontext);
            return true;
        } else
        {
            return false;
        }
    }
}
