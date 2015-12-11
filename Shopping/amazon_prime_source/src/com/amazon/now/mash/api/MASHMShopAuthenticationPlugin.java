// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.app.Activity;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.account.SSO;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONException;

public class MASHMShopAuthenticationPlugin extends MASHCordovaPlugin
{

    public static final String SERVICE_NAME = "MASHMShopAuthentication";

    public MASHMShopAuthenticationPlugin()
    {
    }

    private void logout(final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHMShopAuthenticationPlugin this$0;
            final CallbackContext val$callbackContext;

            public void run()
            {
                SSO.deRegisterUser(cordova.getActivity(), callbackContext);
            }

            
            {
                this$0 = MASHMShopAuthenticationPlugin.this;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void showLoginDialog(final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHMShopAuthenticationPlugin this$0;
            final CallbackContext val$callbackContext;

            public void run()
            {
                SSO.authenticateUser(cordova.getActivity(), new com.amazon.now.account.SSO.SignInCallback() {

                    final _cls1 this$1;

                    public void failure()
                    {
                        callbackContext.error(MASHError.UNKNOWN.toJSONObejct());
                    }

                    public void success(Activity activity)
                    {
                        callbackContext.success();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = MASHMShopAuthenticationPlugin.this;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, String s1, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("ShowLoginDialog".equalsIgnoreCase(s))
        {
            showLoginDialog(callbackcontext);
            return true;
        }
        if ("Logout".equalsIgnoreCase(s))
        {
            logout(callbackcontext);
            return true;
        } else
        {
            return false;
        }
    }
}
