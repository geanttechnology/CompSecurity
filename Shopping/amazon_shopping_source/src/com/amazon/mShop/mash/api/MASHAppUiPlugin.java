// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.actionBar.ActionBarHelper;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.mobile.mash.error.FocusOnItemError;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;

public class MASHAppUiPlugin extends MASHCordovaPlugin
{

    public MASHAppUiPlugin()
    {
    }

    private void cancelFullscreen(JSONArray jsonarray, final CallbackContext callback)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHAppUiPlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                ActionBarHelper.showActionBar((AmazonActivity)cordova.getActivity());
                callback.success();
            }

            
            {
                this$0 = MASHAppUiPlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    private void navMenuFocusOnItem(JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHAppUiPlugin this$0;
            final CallbackContext val$callback;
            final String val$menuItemId;

            public void run()
            {
                AmazonActivity amazonactivity = AmazonActivity.getTopMostBaseActivity();
                if (amazonactivity != null && cordova.getActivity() == amazonactivity)
                {
                    if (amazonactivity.getGNODrawer().focusOn(menuItemId))
                    {
                        callback.success();
                        return;
                    } else
                    {
                        callback.error(FocusOnItemError.NOT_FOUND.toJSONObejct());
                        return;
                    }
                } else
                {
                    callback.error(FocusOnItemError.ITEM_CAN_NOT_BE_IN_FOCUS.toJSONObejct());
                    return;
                }
            }

            
            {
                this$0 = MASHAppUiPlugin.this;
                menuItemId = s;
                callback = callbackcontext;
                super();
            }
        });
    }

    private void requestFullscreen(JSONArray jsonarray, final CallbackContext callback)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHAppUiPlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                ActionBarHelper.hideActionBar((AmazonActivity)cordova.getActivity());
                callback.success();
            }

            
            {
                this$0 = MASHAppUiPlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("CancelFullscreen".equals(s))
        {
            cancelFullscreen(jsonarray, callbackcontext);
        } else
        if ("RequestFullscreen".equals(s))
        {
            requestFullscreen(jsonarray, callbackcontext);
        } else
        if ("FocusOnItem".equals(s))
        {
            navMenuFocusOnItem(jsonarray, callbackcontext);
        } else
        {
            return false;
        }
        return true;
    }
}
