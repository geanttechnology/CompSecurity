// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.amazon.mobile.mash.appcontext.Capability;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.mobile.mash.util.MASHDebug;
import com.amazon.mobile.mash.util.Util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;
import org.apache.cordova.contacts.ContactAccessorSdk5;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHCordovaPlugin

public class MASHContactsPlugin extends MASHCordovaPlugin
{
    private static class AmazonContactAccessor extends ContactAccessorSdk5
    {

        public HashMap buildPopulationSet(JSONArray jsonarray)
        {
            return super.buildPopulationSet(jsonarray);
        }

        public JSONObject getContact(String s, JSONArray jsonarray)
            throws JSONException
        {
            Object obj = null;
            s = mApp.getActivity().getContentResolver().query(android.provider.ContactsContract.Data.CONTENT_URI, null, "contact_id = ? ", new String[] {
                s
            }, null);
            jsonarray = populateContactArray(1, buildPopulationSet(jsonarray), s);
            s = obj;
            if (jsonarray != null)
            {
                s = obj;
                if (jsonarray.length() == 1)
                {
                    s = jsonarray.getJSONObject(0);
                }
            }
            return s;
        }

        public JSONArray populateContactArray(int i, HashMap hashmap, Cursor cursor)
        {
            Method method = org/apache/cordova/contacts/ContactAccessorSdk5.getDeclaredMethod("populateContactArray", new Class[] {
                Integer.TYPE, java/util/HashMap, android/database/Cursor
            });
            method.setAccessible(true);
            hashmap = (JSONArray)method.invoke(this, new Object[] {
                Integer.valueOf(i), hashmap, cursor
            });
            return hashmap;
            hashmap;
            Log.e(MASHContactsPlugin.TAG, (new StringBuilder()).append("populateContactArray: ").append(hashmap.getMessage()).toString());
_L2:
            return null;
            hashmap;
            Log.e(MASHContactsPlugin.TAG, (new StringBuilder()).append("populateContactArray: ").append(hashmap.getMessage()).toString());
            continue; /* Loop/switch isn't completed */
            hashmap;
            Log.e(MASHContactsPlugin.TAG, (new StringBuilder()).append("populateContactArray: ").append(hashmap.getMessage()).toString());
            continue; /* Loop/switch isn't completed */
            hashmap;
            Log.e(MASHContactsPlugin.TAG, (new StringBuilder()).append("populateContactArray: ").append(hashmap.getMessage()).toString());
            if (true) goto _L2; else goto _L1
_L1:
        }

        public AmazonContactAccessor(CordovaInterface cordovainterface)
        {
            super(cordovainterface);
        }
    }


    public static final String SERVICE_NAME = "MASHContacts";
    private static final String TAG = com/amazon/mobile/mash/api/MASHContactsPlugin.getSimpleName();
    private CallbackContext mCallbackContext;
    private AmazonContactAccessor mContactAccessor;
    private JSONArray mReturnResultKey;

    public MASHContactsPlugin()
    {
    }

    private void showContactPicker(JSONArray jsonarray, CallbackContext callbackcontext)
    {
        if (!Capability.SHOW_CONTACT_PICKER.isAvailable())
        {
            mCallbackContext.error(MASHError.NOT_SUPPORTED.toJSONObejct());
            return;
        } else
        {
            mContactAccessor = new AmazonContactAccessor(cordova);
            mReturnResultKey = jsonarray;
            runOnUiThread(new Runnable() {

                final MASHContactsPlugin this$0;

                public void run()
                {
                    Object obj = new Intent("android.intent.action.PICK");
                    ((Intent) (obj)).setType("vnd.android.cursor.dir/contact");
                    cordova.startActivityForResult(MASHContactsPlugin.this, ((Intent) (obj)), 10001);
                    obj = new PluginResult(org.apache.cordova.PluginResult.Status.NO_RESULT);
                    ((PluginResult) (obj)).setKeepCallback(true);
                    mCallbackContext.sendPluginResult(((PluginResult) (obj)));
                    if (MASHDebug.isEnabled())
                    {
                        Log.i(MASHContactsPlugin.TAG, "MASH API ShowContactPicker is executed succeccfully.");
                    }
                }

            
            {
                this$0 = MASHContactsPlugin.this;
                super();
            }
            });
            return;
        }
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
    {
        mCallbackContext = callbackcontext;
        if ("ShowContactPicker".equals(s))
        {
            showContactPicker(jsonarray, callbackcontext);
        }
        return true;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 10001)
        {
            if (j == -1)
            {
                try
                {
                    intent = intent.getData();
                    intent = mContactAccessor.getContact(intent.getLastPathSegment(), mReturnResultKey);
                    mCallbackContext.success(intent);
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    if (!Util.isEmpty(intent.getMessage()))
                    {
                        Log.e(TAG, intent.getMessage());
                    }
                    mCallbackContext.error(MASHError.UNKNOWN.toJSONObejct());
                }
            }
            if (j == 0)
            {
                mCallbackContext.error(MASHError.USER_CANCELLED.toJSONObejct());
            }
        }
    }



}
