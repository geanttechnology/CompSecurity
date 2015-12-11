// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.device.utils.DeviceUtil;
import com.amazon.dp.logger.DPLogger;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.amazon.client.metrics:
//            AndroidDeviceInfoManager

public class DSNOverridingDeviceInfoManager extends AndroidDeviceInfoManager
{

    protected static final String SHARED_PREFS_FILENAME = "com.amazon.client.metrics";
    protected static final DPLogger log = new DPLogger();
    protected String mCachedAnonymousDSN;
    protected SharedPreferences mSharedPrefs;
    protected String mSharedPrefsDSNKey;

    public DSNOverridingDeviceInfoManager(Context context, DeviceUtil deviceutil, String s)
    {
        super(deviceutil);
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        } else
        {
            mSharedPrefsDSNKey = s;
            mSharedPrefs = context.getSharedPreferences("com.amazon.client.metrics", 0);
            mCachedAnonymousDSN = fetchAnonymousDeviceSerialNumber();
            return;
        }
    }

    public DSNOverridingDeviceInfoManager(Context context, DeviceUtil deviceutil, Map map, String s)
    {
        super(deviceutil, map);
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        } else
        {
            mSharedPrefsDSNKey = s;
            mSharedPrefs = context.getSharedPreferences("com.amazon.client.metrics", 0);
            mCachedAnonymousDSN = fetchAnonymousDeviceSerialNumber();
            return;
        }
    }

    private String fetchAnonymousDeviceSerialNumber()
    {
        String s1 = mSharedPrefs.getString(mSharedPrefsDSNKey, null);
        String s = s1;
        if (s1 == null)
        {
            log.verbose("fetchAnonymousDeviceSerialNumber", " No existing ID found, generating a new UUID", new Object[0]);
            s = UUID.randomUUID().toString();
            android.content.SharedPreferences.Editor editor = mSharedPrefs.edit();
            editor.putString(mSharedPrefsDSNKey, s);
            editor.commit();
        }
        return s;
    }

    protected String getDeviceSerialNumber()
    {
        if (mDeviceUtil.isDeviceSerialNumberAnonymous())
        {
            log.verbose("getDeviceSerialNumber", "Returning secondary anonymous DSN", new Object[0]);
            if (mCachedAnonymousDSN == null)
            {
                mCachedAnonymousDSN = fetchAnonymousDeviceSerialNumber();
            }
            return mCachedAnonymousDSN;
        } else
        {
            return super.getDeviceSerialNumber();
        }
    }

}
