// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.system;


// Referenced classes of package com.amazon.insights.core.system:
//            AppDetails, Connectivity, DeviceDetails, FileManager, 
//            Preferences

public interface System
{

    public abstract AppDetails getAppDetails();

    public abstract Connectivity getConnectivity();

    public abstract DeviceDetails getDeviceDetails();

    public abstract FileManager getFileManager();

    public abstract Preferences getPreferences();
}
