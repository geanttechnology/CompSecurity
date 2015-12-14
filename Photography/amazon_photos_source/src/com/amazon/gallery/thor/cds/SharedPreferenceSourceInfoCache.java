// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.SharedPreferences;
import android.os.Build;
import com.amazon.clouddrive.configuration.SourceInfoCache;
import com.amazon.clouddrive.internal.BasicSourceInfo;
import com.amazon.clouddrive.model.SetupSourceRequest;
import com.amazon.gallery.foundation.metrics.customer.CustomerMetricsInfo;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.auth.mapr5.MapAttributeHelper;
import com.amazon.gallery.framework.network.upload.DeviceAttributeStore;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import org.apache.commons.lang3.StringUtils;

public class SharedPreferenceSourceInfoCache
    implements SourceInfoCache
{

    private static final String TAG = com/amazon/gallery/thor/cds/SharedPreferenceSourceInfoCache.getName();
    private final AuthenticationManager authenticationManager;
    private final CustomerAttributeStore customerAttributeStore;
    private final CustomerMetricsInfo customerMetricsInfo;
    private final DeviceAttributeStore deviceAttributeStore;
    private String dsn;
    private final SharedPreferences sharedPreferences;

    public SharedPreferenceSourceInfoCache(BeanAwareApplication beanawareapplication, String s)
    {
        sharedPreferences = beanawareapplication.getSharedPreferences((new StringBuilder()).append("source_info_cache_").append(s).toString(), 0);
        customerMetricsInfo = (CustomerMetricsInfo)beanawareapplication.getBeanFactory().getBean(Keys.CUSTOMER_METRICS_INFO);
        deviceAttributeStore = (DeviceAttributeStore)beanawareapplication.getBeanFactory().getBean(Keys.DEVICE_ATTRIBUTE_STORE);
        authenticationManager = (AuthenticationManager)beanawareapplication.getBeanFactory().getBean(Keys.AUTHENTICATING_MANAGER);
        customerAttributeStore = CustomerAttributeStore.getInstance(beanawareapplication);
    }

    private String getDSN()
    {
        if (dsn == null)
        {
            if (StringUtils.isNotEmpty(Build.SERIAL) && !Build.SERIAL.equalsIgnoreCase("UNKNOWN"))
            {
                dsn = Build.SERIAL;
            } else
            {
                dsn = MapAttributeHelper.getDeviceAttribute(customerAttributeStore, authenticationManager.getAccountId(), "com.amazon.dcp.sso.token.device.deviceserialname", "");
            }
        }
        return dsn;
    }

    public void cacheSourceInfo(BasicSourceInfo basicsourceinfo)
    {
        sharedPreferences.edit().putString("cachedAccount", authenticationManager.getAccountId()).putString("sourceId", basicsourceinfo.getSourceId()).putString("deviceId", basicsourceinfo.getDeviceId()).apply();
    }

    public void clear()
    {
        sharedPreferences.edit().clear().apply();
    }

    public SetupSourceRequest getSetupSourceRequest()
    {
        Object obj;
        String s;
        if (deviceAttributeStore.isTablet())
        {
            obj = "TABLET";
        } else
        {
            obj = "MOBILE";
        }
        if (BuildFlavors.isAosp())
        {
            s = "ANDROID";
        } else
        {
            s = "FIREOS";
        }
        obj = new SetupSourceRequest("CloudDrivePhotosAndroid", customerMetricsInfo.getAppVersionName(), ((String) (obj)), s);
        ((SetupSourceRequest) (obj)).setDeviceSerialNumber(getDSN());
        ((SetupSourceRequest) (obj)).setDeviceFriendlyName(customerMetricsInfo.getDeviceName());
        ((SetupSourceRequest) (obj)).setDeviceModel(Build.MODEL);
        ((SetupSourceRequest) (obj)).setOsVersion(android.os.Build.VERSION.RELEASE);
        return ((SetupSourceRequest) (obj));
    }

    public BasicSourceInfo getSourceInfo()
    {
        return new BasicSourceInfo(sharedPreferences.getString("sourceId", null), sharedPreferences.getString("deviceId", null));
    }

    public boolean isSourceInfoCached()
    {
        String s = authenticationManager.getAccountId();
        return s != null && s.equals(sharedPreferences.getString("cachedAccount", "")) && sharedPreferences.getString("deviceId", null) != null && sharedPreferences.getString("sourceId", null) != null;
    }

}
