// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.content.Intent;
import android.util.Log;
import com.amazon.mShop.control.cvsd.CVSDReceivedResult;
import com.amazon.mShop.opl.AddressPickerView;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.rio.j2me.client.services.mShop.Address;
import com.amazon.rio.j2me.client.services.mShop.Coordinates;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MASHMShopCheckoutPlugin extends MASHCordovaPlugin
{

    private CallbackContext mCallback;

    public MASHMShopCheckoutPlugin()
    {
    }

    private JSONObject addressToJSON(Address address)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        JSONObject jsonobject1 = new JSONObject();
        Coordinates coordinates = address.getLocation();
        jsonobject1.put("type", address.getType());
        jsonobject1.put("addressId", address.getAddressId());
        jsonobject1.put("name", address.getName());
        jsonobject1.put("address1", address.getAddress1());
        jsonobject1.put("address2", address.getAddress2());
        jsonobject1.put("address3", address.getAddress3());
        jsonobject1.put("county", address.getCounty());
        jsonobject1.put("city", address.getCity());
        jsonobject1.put("state", address.getState());
        jsonobject1.put("zip", address.getZip());
        jsonobject1.put("country", address.getCountry());
        jsonobject1.put("countryCode", address.getCountryCode());
        jsonobject1.put("phone", address.getPhone());
        jsonobject1.put("information", address.getInformation());
        if (coordinates != null)
        {
            jsonobject.put("latitude", coordinates.getLatitude());
            jsonobject.put("longitude", coordinates.getLongitude());
            jsonobject1.put("location", jsonobject);
        }
        return jsonobject1;
    }

    private void handleActivityResultForShowDeliveryDestinationPicker(int i, Intent intent)
    {
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        intent = (Address)CVSDReceivedResult.receivedAddresss.get(0);
        if (intent == null) goto _L2; else goto _L1
_L1:
        mCallback.success(addressToJSON(intent));
_L3:
        return;
        intent;
        mCallback.error(MASHError.UNKNOWN.toJSONObejct());
        Log.e(TAG, "json error", intent);
        return;
_L2:
        Log.e(TAG, "onActivityResult: address is null");
        mCallback.error(MASHError.UNKNOWN.toJSONObejct());
        return;
        if (i == 0)
        {
            mCallback.error(MASHError.USER_CANCELLED.toJSONObejct());
            return;
        }
          goto _L3
    }

    private void showDeliveryDestinationPicker(JSONArray jsonarray, final CallbackContext callback)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHMShopCheckoutPlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                mCallback = callback;
                Object obj = cordova.getActivity();
                if (!AddressPickerView.hasCVSD(((android.content.Context) (obj))))
                {
                    callback.error(MASHError.NOT_SUPPORTED.toJSONObejct());
                    return;
                }
                try
                {
                    obj = AddressPickerView.getCVSDMapActivityIntent(((android.app.Activity) (obj)));
                    cordova.startActivityForResult(MASHMShopCheckoutPlugin.this, ((Intent) (obj)), 6);
                    return;
                }
                catch (ClassNotFoundException classnotfoundexception)
                {
                    Log.d(<init>, (new StringBuilder()).append("").append(classnotfoundexception.getMessage()).toString());
                }
                callback.error(MASHError.UNKNOWN.toJSONObejct());
            }

            
            {
                this$0 = MASHMShopCheckoutPlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("ShowDeliveryDestinationPicker".equals(s))
        {
            showDeliveryDestinationPicker(jsonarray, callbackcontext);
            return true;
        } else
        {
            return false;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 6)
        {
            handleActivityResultForShowDeliveryDestinationPicker(j, intent);
        }
    }


/*
    static CallbackContext access$002(MASHMShopCheckoutPlugin mashmshopcheckoutplugin, CallbackContext callbackcontext)
    {
        mashmshopcheckoutplugin.mCallback = callbackcontext;
        return callbackcontext;
    }

*/

}
