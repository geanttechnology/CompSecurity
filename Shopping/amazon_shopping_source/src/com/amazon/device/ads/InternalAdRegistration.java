// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.io.File;

// Referenced classes of package com.amazon.device.ads:
//            IInternalAdRegistration, DebugProperties, Version, RegistrationInfo, 
//            Settings, AppInfo, DeviceInfo, SISRegistration, 
//            Configuration

class InternalAdRegistration
    implements IInternalAdRegistration
{

    public static final String LOG_TAG = com/amazon/device/ads/InternalAdRegistration.getSimpleName();
    private static IInternalAdRegistration instance = new InternalAdRegistration();
    private AppInfo appInfo;
    protected Context applicationContext;
    private boolean contextReceived;
    private DeviceInfo deviceInfo;
    private File filesDirectory;
    private boolean isAppDisabled;
    private boolean isRegistered;
    private long noRetryTtlExpiresMillis;
    private int noRetryTtlMillis;
    private RegistrationInfo registrationInfo;
    private SISRegistration sisRegistration;

    protected InternalAdRegistration()
    {
        isAppDisabled = false;
        DebugProperties.readDebugProperties();
        Version.getSDKVersion();
        registrationInfo = new RegistrationInfo();
    }

    public static IInternalAdRegistration getInstance()
    {
        return instance;
    }

    protected static void setInstance(IInternalAdRegistration iinternaladregistration)
    {
        instance = iinternaladregistration;
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
            Settings.getInstance().contextReceived(context);
            createAppInfo(context);
            createDeviceInfo(context);
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

    protected void createDeviceInfo(Context context)
    {
        deviceInfo = new DeviceInfo(context);
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

    protected SISRegistration getSISRegistration()
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
        int k = Configuration.getMaxNoRetryTtl();
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
