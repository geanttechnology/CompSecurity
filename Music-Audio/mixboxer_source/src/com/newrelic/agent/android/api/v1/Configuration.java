// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.api.v1;


// Referenced classes of package com.newrelic.agent.android.api.v1:
//            DeviceForm

public final class Configuration
{

    private String androidRelease;
    private String appName;
    private String appVersion;
    private String collectorHost;
    private DeviceForm deviceForm;
    private String deviceId;
    private String deviceManufacturer;
    private String deviceModel;
    private String licenseKey;
    private String packageId;
    private boolean ssl;

    public Configuration()
    {
    }

    public String getAndroidRelease()
    {
        return androidRelease;
    }

    public String getAppName()
    {
        return appName;
    }

    public String getAppVersion()
    {
        return appVersion;
    }

    public String getCollectorHost()
    {
        return collectorHost;
    }

    public DeviceForm getDeviceForm()
    {
        return deviceForm;
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public String getDeviceManufacturer()
    {
        return deviceManufacturer;
    }

    public String getDeviceModel()
    {
        return deviceModel;
    }

    public String getLicenseKey()
    {
        return licenseKey;
    }

    public String getPackageId()
    {
        return packageId;
    }

    public boolean isSslEnabled()
    {
        return ssl;
    }

    public void setAndroidRelease(String s)
    {
        androidRelease = s;
    }

    public void setAppName(String s)
    {
        appName = s;
    }

    public void setAppVersion(String s)
    {
        appVersion = s;
    }

    public void setCollectorHost(String s)
    {
        collectorHost = s;
    }

    public void setDeviceForm(DeviceForm deviceform)
    {
        deviceForm = deviceform;
    }

    public void setDeviceId(String s)
    {
        deviceId = s;
    }

    public void setDeviceManufacturer(String s)
    {
        deviceManufacturer = s;
    }

    public void setDeviceModel(String s)
    {
        deviceModel = s;
    }

    public void setLicenseKey(String s)
    {
        licenseKey = s;
    }

    public void setPackageId(String s)
    {
        packageId = s;
    }

    public void setSslEnabled(boolean flag)
    {
        ssl = flag;
    }

    public boolean validate()
    {
        return true;
    }
}
