// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.util.Log;
import com.amazon.mShop.opl.AddressPickerView;
import com.amazon.mobile.mash.error.MASHError;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHMShopCheckoutPlugin

class val.callback
    implements Runnable
{

    final MASHMShopCheckoutPlugin this$0;
    final CallbackContext val$callback;

    public void run()
    {
        MASHMShopCheckoutPlugin.access$002(MASHMShopCheckoutPlugin.this, val$callback);
        Object obj = cordova.getActivity();
        if (!AddressPickerView.hasCVSD(((android.content.Context) (obj))))
        {
            val$callback.error(MASHError.NOT_SUPPORTED.toJSONObejct());
            return;
        }
        try
        {
            obj = AddressPickerView.getCVSDMapActivityIntent(((android.app.Activity) (obj)));
            cordova.startActivityForResult(MASHMShopCheckoutPlugin.this, ((android.content.Intent) (obj)), 6);
            return;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.d(MASHMShopCheckoutPlugin.access$100(), (new StringBuilder()).append("").append(classnotfoundexception.getMessage()).toString());
        }
        val$callback.error(MASHError.UNKNOWN.toJSONObejct());
    }

    _cls9()
    {
        this$0 = final_mashmshopcheckoutplugin;
        val$callback = CallbackContext.this;
        super();
    }
}
