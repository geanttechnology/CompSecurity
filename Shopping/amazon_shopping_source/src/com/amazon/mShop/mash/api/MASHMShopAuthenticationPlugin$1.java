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
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mobile.mash.error.LogoutError;
import com.amazon.mobile.mash.error.MASHError;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHMShopAuthenticationPlugin

class val.callback
    implements Runnable
{

    final MASHMShopAuthenticationPlugin this$0;
    final CallbackContext val$callback;

    public void run()
    {
        if (!User.isLoggedIn()) goto _L2; else goto _L1
_L1:
        .SwitchMap.com.amazon.mShop.sso.IdentityType[SSOUtil.getCurrentIdentityType().ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 61
    //                   2 102
    //                   3 127;
           goto _L3 _L4 _L5 _L6
_L3:
        MASHMShopAuthenticationPlugin.access$000(MASHMShopAuthenticationPlugin.this).error(MASHError.UNKNOWN.toJSONObejct());
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
        val$callback.error(LogoutError.NOT_LOGGED_IN.toJSONObject());
        return;
    }

    ()
    {
        this$0 = final_mashmshopauthenticationplugin;
        val$callback = CallbackContext.this;
        super();
    }
}
