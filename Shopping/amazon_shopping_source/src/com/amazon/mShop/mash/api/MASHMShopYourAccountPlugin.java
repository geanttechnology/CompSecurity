// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.mobileads.AdsHelper;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.smile.SmileHelper;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.youraccount.AmazonPointsView;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.mobile.mash.error.MASHError;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;

public class MASHMShopYourAccountPlugin extends MASHCordovaPlugin
{

    public MASHMShopYourAccountPlugin()
    {
    }

    private void changedSmileStatus(final JSONArray charityName, final CallbackContext callback)
        throws JSONException
    {
        final boolean isSmile = charityName.getBoolean(0);
        if (isSmile && charityName.isNull(1))
        {
            callback.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            return;
        }
        charityName = charityName.getString(1);
        if (SmileHelper.shouldSyncSmileInfo() && charityName.equals(User.getUser().getCharity()))
        {
            callback.success();
            return;
        } else
        {
            runOnUiThread(new Runnable() {

                final MASHMShopYourAccountPlugin this$0;
                final CallbackContext val$callback;
                final String val$charityName;
                final boolean val$isSmile;

                public void run()
                {
                    if (SmileHelper.updateSmileInfo(isSmile, charityName))
                    {
                        callback.success();
                        return;
                    } else
                    {
                        callback.error(MASHError.UNKNOWN.toJSONObejct());
                        return;
                    }
                }

            
            {
                this$0 = MASHMShopYourAccountPlugin.this;
                isSmile = flag;
                charityName = s;
                callback = callbackcontext;
                super();
            }
            });
            return;
        }
    }

    private void showAdsPreferences(JSONArray jsonarray, final CallbackContext callback)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHMShopYourAccountPlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                if (AdsHelper.isAdsEnabled())
                {
                    AdsHelper.openUserPreferences((AmazonActivity)cordova.getActivity());
                    callback.success();
                    return;
                } else
                {
                    callback.error(MASHError.NOT_SUPPORTED.toJSONObejct());
                    return;
                }
            }

            
            {
                this$0 = MASHMShopYourAccountPlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    private void showAmazonPoints(JSONArray jsonarray, final CallbackContext callback)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHMShopYourAccountPlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                AmazonActivity amazonactivity = (AmazonActivity)cordova.getActivity();
                if (ConfigUtils.isEnabled(amazonactivity, com.amazon.mShop.android.lib.R.string.config_hasPoints))
                {
                    amazonactivity.pushView(new AmazonPointsView(amazonactivity));
                    callback.success();
                    return;
                } else
                {
                    callback.error(MASHError.NOT_SUPPORTED.toJSONObejct());
                    return;
                }
            }

            
            {
                this$0 = MASHMShopYourAccountPlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    private void showOneClickSettings(JSONArray jsonarray, final CallbackContext callback)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHMShopYourAccountPlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                ActivityUtils.startOneClickSettingActivity((AmazonActivity)cordova.getActivity(), false, false);
                callback.success();
            }

            
            {
                this$0 = MASHMShopYourAccountPlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    private void showRecommendations(JSONArray jsonarray, final CallbackContext callback)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHMShopYourAccountPlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                ActivityUtils.startRecommendationsActivity(cordova.getActivity());
                callback.success();
            }

            
            {
                this$0 = MASHMShopYourAccountPlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    private void showYourAccount(JSONArray jsonarray, final CallbackContext callback)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHMShopYourAccountPlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                ActivityUtils.startYourAccountActivity(cordova.getActivity());
                callback.success();
            }

            
            {
                this$0 = MASHMShopYourAccountPlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("ShowYourAccount".equals(s))
        {
            showYourAccount(jsonarray, callbackcontext);
        } else
        if ("ShowRecommendations".equals(s))
        {
            showRecommendations(jsonarray, callbackcontext);
        } else
        if ("ShowOneClickSettings".equals(s))
        {
            showOneClickSettings(jsonarray, callbackcontext);
        } else
        if ("ShowAmazonPoints".equals(s))
        {
            showAmazonPoints(jsonarray, callbackcontext);
        } else
        if ("ShowAdsPreferences".equals(s))
        {
            showAdsPreferences(jsonarray, callbackcontext);
        } else
        if ("UserChangedSmileStatus".equals(s))
        {
            changedSmileStatus(jsonarray, callbackcontext);
        } else
        {
            return false;
        }
        return true;
    }
}
