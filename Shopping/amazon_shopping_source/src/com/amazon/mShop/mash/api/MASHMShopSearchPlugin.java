// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.content.Intent;
import com.amazon.mShop.search.viewit.ViewItScanEntryActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.mobile.mash.error.BarcodeScanError;
import com.amazon.mobile.mash.error.MASHError;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MASHMShopSearchPlugin extends MASHCordovaPlugin
{

    private CallbackContext mCallback;

    public MASHMShopSearchPlugin()
    {
    }

    private JSONObject barcodeToJSON(Intent intent)
        throws JSONException
    {
        Object obj = null;
        JSONObject jsonobject = obj;
        if (intent != null)
        {
            intent = intent.getStringExtra("BARCODE_STRING");
            jsonobject = obj;
            if (!Util.isEmpty(intent))
            {
                jsonobject = new JSONObject();
                jsonobject.put("barcodeData", intent);
                jsonobject.put("barcodeType", "");
            }
        }
        return jsonobject;
    }

    private void handleActivityResultForShowBarcodeScanner(int i, Intent intent)
    {
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        intent = barcodeToJSON(intent);
        if (intent != null)
        {
            try
            {
                mCallback.success(intent);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                mCallback.error(MASHError.UNKNOWN.toJSONObejct());
            }
            break MISSING_BLOCK_LABEL_52;
        }
        mCallback.error(MASHError.USER_CANCELLED.toJSONObejct());
        return;
        return;
        if (i == 0)
        {
            if (intent != null && intent.getBooleanExtra("CANNOT_OPEN_CAMERA", false))
            {
                mCallback.error(BarcodeScanError.CANNOT_OPEN_CAMERA.toJSONObject());
                return;
            } else
            {
                mCallback.error(MASHError.USER_CANCELLED.toJSONObejct());
                return;
            }
        } else
        {
            mCallback.error(MASHError.UNKNOWN.toJSONObejct());
            return;
        }
    }

    private void showBarcodeScanner(JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        mCallback = callbackcontext;
        runOnUiThread(new Runnable() {

            final MASHMShopSearchPlugin this$0;

            public void run()
            {
                Intent intent = new Intent(cordova.getActivity(), com/amazon/mShop/search/viewit/ViewItScanEntryActivity);
                intent.addFlags(0x20000);
                cordova.startActivityForResult(MASHMShopSearchPlugin.this, intent, 4);
            }

            
            {
                this$0 = MASHMShopSearchPlugin.this;
                super();
            }
        });
    }

    private void showShopByDepartment(JSONArray jsonarray, final CallbackContext callback)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHMShopSearchPlugin this$0;
            final CallbackContext val$callback;

            public void run()
            {
                ActivityUtils.startCategoryBrowseActivity(cordova.getActivity());
                callback.success();
            }

            
            {
                this$0 = MASHMShopSearchPlugin.this;
                callback = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("ShowShopByDepartment".equals(s))
        {
            showShopByDepartment(jsonarray, callbackcontext);
        } else
        if ("ShowBarcodeScanner".equals(s))
        {
            showBarcodeScanner(jsonarray, callbackcontext);
        } else
        {
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 4)
        {
            handleActivityResultForShowBarcodeScanner(j, intent);
        }
    }
}
