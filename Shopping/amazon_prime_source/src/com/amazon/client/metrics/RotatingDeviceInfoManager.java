// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.amazon.device.utils.DeviceUtil;
import java.util.Map;

// Referenced classes of package com.amazon.client.metrics:
//            OverridingDeviceInfoManager

public class RotatingDeviceInfoManager extends OverridingDeviceInfoManager
{

    private static final long DEFAULT_EXPIRATION_PERIOD_MILLIS = 0x5265c00L;
    private static final String LAST_ROTATION_TIME_KEY = "lastDSNRotationTime";
    private long mExpirationPeriodMillis;

    public RotatingDeviceInfoManager(Context context, DeviceUtil deviceutil, String s, String s1)
    {
        super(context, deviceutil, s, s1);
        mExpirationPeriodMillis = 0x5265c00L;
    }

    public RotatingDeviceInfoManager(Context context, DeviceUtil deviceutil, Map map, String s, String s1)
    {
        super(context, deviceutil, map, s, s1);
    }

    private void ensureSharedPrefsRotationUpToDate()
    {
        if (System.currentTimeMillis() - getLastRotationTime() > mExpirationPeriodMillis)
        {
            mCachedDSN = null;
            android.content.SharedPreferences.Editor editor = mSharedPrefs.edit();
            editor.remove(mSharedPrefsDSNKey);
            editor.remove(mSharedPrefsSessionIDKey);
            editor.putLong("lastDSNRotationTime", System.currentTimeMillis());
            editor.commit();
            Log.d("rotateCachedIDs", "Rotated the DSN and SessionID reported in non-anonymous metrics");
        }
    }

    private long getLastRotationTime()
    {
        return mSharedPrefs.getLong("lastDSNRotationTime", 0L);
    }

    protected String getDeviceSerialNumber()
    {
        ensureSharedPrefsRotationUpToDate();
        return super.getDeviceSerialNumber();
    }

    public String getSessionID()
    {
        ensureSharedPrefsRotationUpToDate();
        return super.getDeviceSerialNumber();
    }

    public void setExpirationPeriodMillis(long l)
    {
        mExpirationPeriodMillis = l;
    }
}
