// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.device.utils.DeviceUtil;
import java.util.Map;

// Referenced classes of package com.amazon.client.metrics:
//            DSNOverridingDeviceInfoManager

public class DSNRotatingDeviceInfoManager extends DSNOverridingDeviceInfoManager
{

    private static final long DEFAULT_EXPIRATION_PERIOD_MILLIS = 0x5265c00L;
    private static final String LAST_ROTATION_TIME_KEY = "lastDSNRotationTime";
    private long mExpirationPeriodMillis;

    public DSNRotatingDeviceInfoManager(Context context, DeviceUtil deviceutil, String s)
    {
        super(context, deviceutil, s);
        mExpirationPeriodMillis = 0x5265c00L;
    }

    public DSNRotatingDeviceInfoManager(Context context, DeviceUtil deviceutil, Map map, String s)
    {
        super(context, deviceutil, map, s);
    }

    private long getLastRotationTime()
    {
        return mSharedPrefs.getLong("lastDSNRotationTime", 0L);
    }

    protected String getDeviceSerialNumber()
    {
        long l = getLastRotationTime();
        if (System.currentTimeMillis() - l > mExpirationPeriodMillis)
        {
            mCachedAnonymousDSN = null;
            android.content.SharedPreferences.Editor editor = mSharedPrefs.edit();
            editor.remove(mSharedPrefsDSNKey);
            editor.putLong("lastDSNRotationTime", System.currentTimeMillis());
            editor.commit();
        }
        return super.getDeviceSerialNumber();
    }

    public void setExpirationPeriodMillis(long l)
    {
        mExpirationPeriodMillis = l;
    }
}
