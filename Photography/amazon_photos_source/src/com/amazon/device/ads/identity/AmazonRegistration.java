// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import android.content.Context;
import java.io.File;

// Referenced classes of package com.amazon.device.ads.identity:
//            IAmazonRegistration, Settings, DebugProperties, RegistrationInfo, 
//            AppInfo, DeviceInfo, BasicUserAgentManager, SISRegistration

class AmazonRegistration
    implements IAmazonRegistration
{

    public static final String LOG_TAG = com/amazon/device/ads/identity/AmazonRegistration.getSimpleName();
    private static IAmazonRegistration instance = new AmazonRegistration(Settings.getInstance(), DebugProperties.getInstance());
    private AppInfo appInfo;
    protected Context applicationContext;
    private boolean contextReceived;
    private DeviceInfo deviceInfo;
    private File filesDirectory;
    private boolean isAppDisabled;
    private RegistrationInfo registrationInfo;
    private final Settings settings;
    private SISRegistration sisRegistration;

    protected AmazonRegistration(Settings settings1, DebugProperties debugproperties)
    {
        isAppDisabled = false;
        settings = settings1;
        debugproperties.readDebugProperties();
        registrationInfo = new RegistrationInfo();
    }

    public static IAmazonRegistration getInstance()
    {
        return instance;
    }

    public void contextReceived(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (!contextReceived)
        {
            contextReceived = true;
            setApplicationContextFromContext(context);
            setFilesDirectory(context);
            settings.contextReceived(context);
            createAppInfo(context);
            deviceInfo = createDeviceInfo(context);
            createSISRegistration();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    protected void createAppInfo(Context context)
    {
        appInfo = new AppInfo(context);
    }

    protected DeviceInfo createDeviceInfo(Context context)
    {
        return new DeviceInfo(context, new BasicUserAgentManager());
    }

    protected void createSISRegistration()
    {
        sisRegistration = new SISRegistration();
    }

    public AppInfo getAppInfo()
    {
        return appInfo;
    }

    public Context getApplicationContext()
    {
        return applicationContext;
    }

    public DeviceInfo getDeviceInfo()
    {
        return deviceInfo;
    }

    public RegistrationInfo getRegistrationInfo()
    {
        return registrationInfo;
    }

    protected void setApplicationContextFromContext(Context context)
    {
        applicationContext = context.getApplicationContext();
    }

    protected void setFilesDirectory(Context context)
    {
        filesDirectory = context.getFilesDir();
    }

}
