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

public class OverridingDeviceInfoManager extends AndroidDeviceInfoManager
{

    protected static final String SHARED_PREFS_FILENAME = "com.amazon.client.metrics";
    protected static final DPLogger log = new DPLogger();
    protected String mCachedDSN;
    protected String mCachedSessionID;
    protected SharedPreferences mSharedPrefs;
    protected String mSharedPrefsDSNKey;
    protected String mSharedPrefsSessionIDKey;

    public OverridingDeviceInfoManager(Context context, DeviceUtil deviceutil, String s, String s1)
    {
        super(deviceutil);
        initialize(context, s, s1);
    }

    public OverridingDeviceInfoManager(Context context, DeviceUtil deviceutil, Map map, String s, String s1)
    {
        super(deviceutil, map);
        initialize(context, s, s1);
    }

    private String getOrCreateUUIDSharedPref(String s)
    {
        String s2 = mSharedPrefs.getString(s, null);
        String s1 = s2;
        if (s2 == null)
        {
            log.verbose("getOrCreateUUIDSharedPref", String.format("No existing id found for %s, generating a new UUID", new Object[] {
                s
            }), new Object[0]);
            s1 = UUID.randomUUID().toString();
            android.content.SharedPreferences.Editor editor = mSharedPrefs.edit();
            editor.putString(s, s1);
            editor.commit();
        }
        return s1;
    }

    private void initialize(Context context, String s, String s1)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null.");
        } else
        {
            mSharedPrefsDSNKey = s;
            mSharedPrefsSessionIDKey = s1;
            mSharedPrefs = context.getSharedPreferences("com.amazon.client.metrics", 0);
            mCachedDSN = getOrCreateUUIDSharedPref(mSharedPrefsDSNKey);
            mCachedSessionID = getOrCreateUUIDSharedPref(mSharedPrefsSessionIDKey);
            return;
        }
    }

    protected String getDeviceSerialNumber()
    {
        if (mDeviceUtil.isDeviceSerialNumberAnonymous())
        {
            log.verbose("getDeviceSerialNumber", "Returning unique device id for non-anonymous metrics", new Object[0]);
            if (mCachedDSN == null)
            {
                mCachedDSN = getOrCreateUUIDSharedPref(mSharedPrefsDSNKey);
            }
            return mCachedDSN;
        } else
        {
            return super.getDeviceSerialNumber();
        }
    }

    public String getSessionID()
    {
        if (mDeviceUtil.isDeviceSerialNumberAnonymous())
        {
            log.verbose("getSessionID", "Returning unique session id for non-anonymous metrics", new Object[0]);
            if (mCachedSessionID == null)
            {
                mCachedSessionID = getOrCreateUUIDSharedPref(mSharedPrefsSessionIDKey);
            }
            return mCachedSessionID;
        } else
        {
            return super.getSessionID();
        }
    }

}
