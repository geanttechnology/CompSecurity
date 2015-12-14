// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.system;

import android.content.Context;
import com.amazon.insights.InsightsCredentials;

// Referenced classes of package com.amazon.insights.core.system:
//            System, AndroidPreferences, DefaultFileManager, AndroidConnectivity, 
//            AndroidAppDetails, AndroidDeviceDetails, AppDetails, Connectivity, 
//            DeviceDetails, FileManager, Preferences

public class AndroidSystem
    implements System
{

    private final AppDetails appDetails;
    private final Connectivity connectivity;
    private final DeviceDetails deviceDetails = new AndroidDeviceDetails();
    private final FileManager fileManager;
    private final Preferences preferences;

    public AndroidSystem(Context context, InsightsCredentials insightscredentials)
    {
        preferences = new AndroidPreferences(context, insightscredentials);
        fileManager = new DefaultFileManager(context.getDir(insightscredentials.getApplicationKey(), 0));
        connectivity = new AndroidConnectivity(context);
        appDetails = new AndroidAppDetails(context);
    }

    public AppDetails getAppDetails()
    {
        return appDetails;
    }

    public Connectivity getConnectivity()
    {
        return connectivity;
    }

    public DeviceDetails getDeviceDetails()
    {
        return deviceDetails;
    }

    public FileManager getFileManager()
    {
        return fileManager;
    }

    public Preferences getPreferences()
    {
        return preferences;
    }
}
