// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.io.File;

// Referenced classes of package com.amazon.device.ads:
//            Settings, DebugProperties, RegistrationInfo, AppInfo, 
//            DeviceInfo, BasicUserAgentManager, SISRegistration

class MobileAdsInfoStore
{

    private static MobileAdsInfoStore instance = new MobileAdsInfoStore(Settings.getInstance(), DebugProperties.getInstance());
    private AppInfo appInfo;
    protected Context applicationContext;
    private boolean contextReceived;
    private final DebugProperties debugProperties;
    private DeviceInfo deviceInfo;
    private File filesDirectory;
    private boolean isAppDisabled;
    private boolean isRegistered;
    private long noRetryTtlExpiresMillis;
    private int noRetryTtlMillis;
    private RegistrationInfo registrationInfo;
    private final Settings settings;
    private SISRegistration sisRegistration;

    protected MobileAdsInfoStore(Settings settings1, DebugProperties debugproperties)
    {
        isAppDisabled = false;
        settings = settings1;
        debugProperties = debugproperties;
        debugProperties.readDebugProperties();
        registrationInfo = new RegistrationInfo();
    }

    public static MobileAdsInfoStore getInstance()
    {
        return instance;
    }

    static void setMobileAdsInfoStore(MobileAdsInfoStore mobileadsinfostore)
    {
        instance = mobileadsinfostore;
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

    public File getFilesDir()
    {
        return filesDirectory;
    }

    public boolean getIsAppDisabled()
    {
        return isAppDisabled;
    }

    public int getNoRetryTtlRemainingMillis()
    {
        if (noRetryTtlMillis == 0 || noRetryTtlExpiresMillis == 0L)
        {
            return 0;
        }
        long l = System.currentTimeMillis();
        if (l >= noRetryTtlExpiresMillis)
        {
            noRetryTtlMillis = 0;
            noRetryTtlExpiresMillis = 0L;
            return 0;
        } else
        {
            return (int)(noRetryTtlExpiresMillis - l);
        }
    }

    public RegistrationInfo getRegistrationInfo()
    {
        return registrationInfo;
    }

    public SISRegistration getSISRegistration()
    {
        return sisRegistration;
    }

    public boolean isContextReceived()
    {
        return contextReceived;
    }

    public boolean isRegistered()
    {
        return isRegistered;
    }

    public void register()
    {
        getSISRegistration().registerApp();
        isRegistered = true;
    }

    protected void setApplicationContextFromContext(Context context)
    {
        applicationContext = context.getApplicationContext();
    }

    protected void setFilesDirectory(Context context)
    {
        filesDirectory = context.getFilesDir();
    }

    public void setIsAppDisabled(boolean flag)
    {
        isAppDisabled = flag;
    }

    public void setNoRetryTtl(int i)
    {
        int k = debugProperties.getDebugPropertyAsInteger("debug.noRetryTTLMax", Integer.valueOf(0x493e0)).intValue();
        int j = i;
        if (k < i)
        {
            j = k;
        }
        if (j == 0)
        {
            noRetryTtlMillis = 0;
            noRetryTtlExpiresMillis = 0L;
            return;
        } else
        {
            noRetryTtlMillis = j * 1000;
            noRetryTtlExpiresMillis = System.currentTimeMillis() + (long)noRetryTtlMillis;
            return;
        }
    }

}
