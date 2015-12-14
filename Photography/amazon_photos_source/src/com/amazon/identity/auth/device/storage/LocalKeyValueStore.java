// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LocalKeyValueStore
{

    private static final String TAG = com/amazon/identity/auth/device/storage/LocalKeyValueStore.getName();
    private final SharedPreferences mSharedPrefs;

    public LocalKeyValueStore(Context context, String s)
    {
        mSharedPrefs = context.getSharedPreferences(s, 0);
    }

    public boolean clearStore()
    {
        boolean flag = mSharedPrefs.edit().clear().commit();
        if (!flag)
        {
            MAPLog.e(TAG, "Failed to clear the local key value store");
        }
        return flag;
    }

    public Map dumpAllData()
    {
        MAPLog.i(TAG, "Dumping MAP shared preferences... ");
        HashMap hashmap = new HashMap();
        Object obj = mSharedPrefs.getAll();
        if (obj == null || ((Map) (obj)).size() == 0)
        {
            MAPLog.i(TAG, "No data found in this MAP shared preferences");
        } else
        {
            obj = ((Map) (obj)).entrySet().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                Object obj1 = entry.getValue();
                if (obj1 instanceof String)
                {
                    hashmap.put(entry.getKey(), (String)obj1);
                } else
                {
                    MAPLog.logAndReportError(TAG, null, (new StringBuilder("Some value are not String in the shared preferences. The key is:")).append((String)entry.getKey()).toString(), "NonStringValueInSharedPreferences");
                }
            }
        }
        return hashmap;
    }

    public Map getAll()
    {
        return mSharedPrefs.getAll();
    }

    public long getLongValue(String s)
    {
        return mSharedPrefs.getLong(s, 0L);
    }

    public String getStringValue(String s)
    {
        return mSharedPrefs.getString(s, null);
    }

    public boolean setValue(String s, long l)
    {
        boolean flag = mSharedPrefs.edit().putLong(s, l).commit();
        if (!flag)
        {
            MAPLog.e(TAG, String.format("Failed to set key %s in the local key value store", new Object[] {
                s
            }));
        }
        return flag;
    }

    public boolean setValue(String s, String s1)
    {
        boolean flag = mSharedPrefs.edit().putString(s, s1).commit();
        if (!flag)
        {
            MAPLog.e(TAG, String.format("Failed to set key %s in the local key value store", new Object[] {
                s
            }));
        }
        return flag;
    }

    public void setValues(Map map)
    {
        android.content.SharedPreferences.Editor editor = mSharedPrefs.edit();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); editor.putString((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        if (!editor.commit())
        {
            MAPLog.e(TAG, "Failed to set keys in the local key value store");
        }
    }

}
