// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.contacts.ContactAccessorSdk5;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHContactsPlugin

private static class I extends ContactAccessorSdk5
{

    public HashMap buildPopulationSet(JSONArray jsonarray)
    {
        return super.buildPopulationSet(jsonarray);
    }

    public JSONObject getContact(String s, JSONArray jsonarray)
        throws JSONException
    {
        Object obj = null;
        s = mApp.getActivity().getContentResolver().query(android.provider.tAccessor.mApp, null, "contact_id = ? ", new String[] {
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
        Log.e(MASHContactsPlugin.access$100(), (new StringBuilder()).append("populateContactArray: ").append(hashmap.getMessage()).toString());
_L2:
        return null;
        hashmap;
        Log.e(MASHContactsPlugin.access$100(), (new StringBuilder()).append("populateContactArray: ").append(hashmap.getMessage()).toString());
        continue; /* Loop/switch isn't completed */
        hashmap;
        Log.e(MASHContactsPlugin.access$100(), (new StringBuilder()).append("populateContactArray: ").append(hashmap.getMessage()).toString());
        continue; /* Loop/switch isn't completed */
        hashmap;
        Log.e(MASHContactsPlugin.access$100(), (new StringBuilder()).append("populateContactArray: ").append(hashmap.getMessage()).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public I(CordovaInterface cordovainterface)
    {
        super(cordovainterface);
    }
}
