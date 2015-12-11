// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import android.os.Build;
import com.amazon.device.utils.DeviceUtil;
import com.amazon.dp.logger.DPLogger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.client.metrics:
//            DeviceInfoManager, MetricsDeviceInfo

public class AndroidDeviceInfoManager
    implements DeviceInfoManager
{

    private static final String TAG = "Metrics.AndroidDeviceInfoManager";
    protected static final DPLogger log = new DPLogger();
    protected final DeviceUtil mDeviceUtil;
    protected final MetricsDeviceInfo mMetricsDeviceInfo;

    public AndroidDeviceInfoManager(DeviceUtil deviceutil)
    {
        if (deviceutil == null)
        {
            throw new IllegalArgumentException("Device Util must not be null.");
        } else
        {
            mDeviceUtil = deviceutil;
            mMetricsDeviceInfo = new MetricsDeviceInfo();
            addToMetricsDeviceInfo("softwareVersion", android.os.Build.VERSION.INCREMENTAL);
            addToMetricsDeviceInfo("hardware", Build.HARDWARE);
            addToMetricsDeviceInfo("buildType", Build.TYPE);
            addToMetricsDeviceInfo("platform", Build.DEVICE);
            addToMetricsDeviceInfo("model", Build.MODEL);
            log.verbose("Metrics.AndroidDeviceInfoManager", "deviceInfo", new Object[] {
                "softwareVersion", mMetricsDeviceInfo.getDeviceInfo("softwareVersion"), "hardware", mMetricsDeviceInfo.getDeviceInfo("hardware"), "buildType", mMetricsDeviceInfo.getDeviceInfo("buildType"), "platform", mMetricsDeviceInfo.getDeviceInfo("platform"), "model", mMetricsDeviceInfo.getDeviceInfo("model")
            });
            return;
        }
    }

    public AndroidDeviceInfoManager(DeviceUtil deviceutil, Map map)
    {
        this(deviceutil);
        if (map == null)
        {
            throw new IllegalArgumentException("Extra info must not be null.");
        }
        for (deviceutil = map.entrySet().iterator(); deviceutil.hasNext(); log.verbose("Metrics.AndroidDeviceInfoManager", "extraInfo", new Object[] {
    map.getKey(), map.getValue()
}))
        {
            map = (java.util.Map.Entry)deviceutil.next();
            addToMetricsDeviceInfo((String)map.getKey(), (String)map.getValue());
        }

    }

    private void addToMetricsDeviceInfo(String s, String s1)
    {
        if (s == null)
        {
            log.error("Metrics.AndroidDeviceInfoManager", "Not adding key-value to metrics device info as key is null", new Object[0]);
            return;
        } else
        {
            mMetricsDeviceInfo.addDeviceInfoData(s, s1);
            return;
        }
    }

    private String getCountryOfResidence()
    {
        return mDeviceUtil.fetchCountryOfResidence();
    }

    private String getDeviceLanguage()
    {
        return mDeviceUtil.fetchDeviceLanguage();
    }

    private String getDeviceMode()
    {
        return mDeviceUtil.fetchDeviceMode();
    }

    private String getPreferredMarketplace()
    {
        return mDeviceUtil.fetchPreferredMarketplace();
    }

    private String getRsmGroup()
    {
        return mDeviceUtil.fetchRsmGroupName();
    }

    public String getCustomerID()
    {
        return mDeviceUtil.fetchCustomerID();
    }

    public MetricsDeviceInfo getDeviceInfo()
    {
        addToMetricsDeviceInfo("deviceId", getDeviceSerialNumber());
        addToMetricsDeviceInfo("deviceType", getDeviceType());
        addToMetricsDeviceInfo("countryOfResidence", getCountryOfResidence());
        addToMetricsDeviceInfo("MarketplaceID", getPreferredMarketplace());
        addToMetricsDeviceInfo("deviceLanguage", getDeviceLanguage());
        addToMetricsDeviceInfo("deviceMode", getDeviceMode());
        addToMetricsDeviceInfo("remoteSettingsGroup", getRsmGroup());
        addToMetricsDeviceInfo("Session", getSessionID());
        addToMetricsDeviceInfo("CustomerId", getCustomerID());
        addToMetricsDeviceInfo("HTTP_USER_AGENT", getUserAgent());
        addToMetricsDeviceInfo("REMOTE_ADDR", getIPAddress());
        return mMetricsDeviceInfo;
    }

    protected String getDeviceSerialNumber()
    {
        return mDeviceUtil.fetchDeviceSerialNumberOrAnonymous();
    }

    protected String getDeviceType()
    {
        return mDeviceUtil.fetchDeviceType();
    }

    public String getIPAddress()
    {
        return mDeviceUtil.fetchRemoteIP();
    }

    public String getSessionID()
    {
        return mDeviceUtil.fetchSessionID();
    }

    public String getUserAgent()
    {
        return mDeviceUtil.fetchUserAgent();
    }

}
