// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.identity.auth.device.utils.MAPLog;

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

    public String getValue(String s)
    {
        return mSharedPrefs.getString(s, null);
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

}
