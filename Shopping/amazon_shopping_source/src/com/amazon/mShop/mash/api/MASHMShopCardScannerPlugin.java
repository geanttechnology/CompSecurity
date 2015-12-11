// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.content.Intent;
import android.os.Bundle;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.mobile.mash.error.CardScannerError;
import com.amazon.mobile.mash.error.MASHError;
import com.creditcardreader.activities.CreditCardScanActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MASHMShopCardScannerPlugin extends MASHCordovaPlugin
{

    private static final List validCardTypes = new ArrayList() {

            
            {
                add(Integer.valueOf(1));
                add(Integer.valueOf(2));
                add(Integer.valueOf(3));
                add(Integer.valueOf(4));
            }
    };
    private CallbackContext mCallback;

    public MASHMShopCardScannerPlugin()
    {
    }

    private JSONObject cardToJSON(Intent intent)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        if (intent != null)
        {
            JSONArray jsonarray = generateCardData(intent.getStringArrayListExtra("CARD_NUMBERS"), intent.getStringArrayListExtra("NUMBER_CONFIDENCE"));
            JSONObject jsonobject1 = new JSONObject();
            if (intent.getExtras().containsKey("CARD_EXPIRATION_MONTHS"))
            {
                Object obj = intent.getStringArrayListExtra("CARD_EXPIRATION_MONTHS");
                ArrayList arraylist = intent.getStringArrayListExtra("CARD_EXPIRATION_YEARS");
                intent = intent.getStringArrayListExtra("EXPIRAITON_CONFIDENCE");
                obj = generateCardData(((List) (obj)), intent);
                intent = generateCardData(arraylist, intent);
                jsonobject1.put("expirationMonth", obj);
                jsonobject1.put("expirationYear", intent);
            }
            jsonobject1.put("number", jsonarray);
            jsonobject.put("cardData", jsonobject1);
            jsonobject.put("cardType", 1);
        }
        return jsonobject;
    }

    private boolean existsInvalidCardType(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            int i = ((Integer)list.next()).intValue();
            if (!validCardTypes.contains(Integer.valueOf(i)))
            {
                return true;
            }
        }

        return false;
    }

    private JSONArray generateCardData(List list, List list1)
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        for (int i = 0; i < list.size(); i++)
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("value", list.get(i));
            jsonobject.put("confidence", list1.get(i));
            jsonarray.put(jsonobject);
        }

        return jsonarray;
    }

    private List getCardTypes(JSONArray jsonarray)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        jsonarray = jsonarray.getJSONArray(0);
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(Integer.valueOf(jsonarray.getInt(i)));
        }

        return arraylist;
    }

    private void handleActivityResultForShowCardScanner(int i, Intent intent)
    {
        if (i == -1)
        {
            try
            {
                intent = cardToJSON(intent);
                mCallback.success(intent);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                mCallback.error(MASHError.UNKNOWN.toJSONObejct());
            }
            return;
        }
        if (i == 0)
        {
            if (intent != null && intent.getBooleanExtra("CANNOT_OPEN_CAMERA", false))
            {
                mCallback.error(CardScannerError.CANNOT_OPEN_CAMERA.toJSONObject());
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

    private void showCardScanner(JSONArray jsonarray, CallbackContext callbackcontext)
    {
        mCallback = callbackcontext;
        try
        {
            jsonarray = getCardTypes(jsonarray);
            if (existsInvalidCardType(jsonarray))
            {
                callbackcontext.error(CardScannerError.INVALID_CARD_TYPE.toJSONObject());
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            mCallback.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            return;
        }
        if (jsonarray.contains(Integer.valueOf(1)))
        {
            runOnUiThread(new Runnable() {

                final MASHMShopCardScannerPlugin this$0;

                public void run()
                {
                    Intent intent = new Intent(cordova.getActivity(), com/creditcardreader/activities/CreditCardScanActivity);
                    intent.addFlags(0x20000);
                    cordova.startActivityForResult(MASHMShopCardScannerPlugin.this, intent, 20);
                }

            
            {
                this$0 = MASHMShopCardScannerPlugin.this;
                super();
            }
            });
            return;
        }
        callbackcontext.error(CardScannerError.NO_SUPPORTED_CARD_TYPES.toJSONObject());
        return;
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("ShowCardScanner".equals(s))
        {
            showCardScanner(jsonarray, callbackcontext);
            return true;
        } else
        {
            return false;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 20)
        {
            handleActivityResultForShowCardScanner(j, intent);
        }
    }

}
