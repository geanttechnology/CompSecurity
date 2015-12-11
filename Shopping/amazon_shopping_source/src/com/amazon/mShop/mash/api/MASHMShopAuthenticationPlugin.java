// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.content.Intent;
import com.amazon.mShop.account.LogoutActivity;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.sso.CentralSSOLogoutActivity;
import com.amazon.mShop.sso.DistributedSSOLogoutActivity;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.MShopCheckLogin;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.mobile.mash.error.LogoutError;
import com.amazon.mobile.mash.error.MASHError;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;

public class MASHMShopAuthenticationPlugin extends MASHCordovaPlugin
{

    private CallbackContext mCallback;

    public MASHMShopAuthenticationPlugin()
    {
    }

    private void handleActivityResultForLogout(int i)
    {
        if (i == -1)
        {
            mCallback.success();
        } else
        if (i == 0)
        {
            mCallback.error(MASHError.USER_CANCELLED.toJSONObejct());
            return;
        }
    }

    private void logout(JSONArray jsonarray, final CallbackContext callback)
        throws JSONException
    {
        mCallback = callback;
        runOnUiThread(new Runnable() {

            final MASHMShopAuthenticationPlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                if (!User.isLoggedIn()) goto _L2; else goto _L1
_L1:
                static class _cls3
                {

                    static final int $SwitchMap$com$amazon$mShop$sso$IdentityType[];

                    static 
                    {
                        $SwitchMap$com$amazon$mShop$sso$IdentityType = new int[IdentityType.values().length];
                        try
                        {
                            $SwitchMap$com$amazon$mShop$sso$IdentityType[IdentityType.CENTRAL_SSO_TYPE.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$amazon$mShop$sso$IdentityType[IdentityType.DISTRIBUTED_SSO_TYPE.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$amazon$mShop$sso$IdentityType[IdentityType.NON_SSO_TYPE.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                _cls3..SwitchMap.com.amazon.mShop.sso.IdentityType[SSOUtil.getCurrentIdentityType().ordinal()];
                JVM INSTR tableswitch 1 3: default 44
            //                           1 61
            //                           2 102
            //                           3 127;
                   goto _L3 _L4 _L5 _L6
_L3:
                mCallback.error(MASHError.UNKNOWN.toJSONObejct());
                return;
_L4:
                Intent intent = new Intent(cordova.getActivity(), com/amazon/mShop/sso/CentralSSOLogoutActivity);
_L7:
                cordova.startActivityForResult(MASHMShopAuthenticationPlugin.this, intent, 1);
                return;
_L5:
                intent = new Intent(cordova.getActivity(), com/amazon/mShop/sso/DistributedSSOLogoutActivity);
                continue; /* Loop/switch isn't completed */
_L6:
                intent = new Intent(cordova.getActivity(), com/amazon/mShop/account/LogoutActivity);
                if (true) goto _L7; else goto _L2
_L2:
                callback.error(LogoutError.NOT_LOGGED_IN.toJSONObject());
                return;
            }

            
            {
                this$0 = MASHMShopAuthenticationPlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    private void userChangedPrimeStatus(JSONArray jsonarray, final CallbackContext callback)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHMShopAuthenticationPlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                (new MShopCheckLogin(cordova.getActivity(), false, null)).checkLogin();
                callback.success();
            }

            
            {
                this$0 = MASHMShopAuthenticationPlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("Logout".equals(s))
        {
            logout(jsonarray, callbackcontext);
        } else
        if ("UserChangedPrimeStatus".equals(s))
        {
            userChangedPrimeStatus(jsonarray, callbackcontext);
        } else
        {
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 1)
        {
            handleActivityResultForLogout(j);
        }
    }

}
