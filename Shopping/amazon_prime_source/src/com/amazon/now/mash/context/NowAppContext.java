// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.context;

import com.amazon.mobile.mash.appcontext.AppContext;
import com.amazon.mobile.mash.appcontext.CapabilityManager;
import com.amazon.now.platform.AndroidPlatform;

public class NowAppContext extends AppContext
{

    public NowAppContext(CapabilityManager capabilitymanager)
    {
        super(capabilitymanager);
    }

    public String getAppName()
    {
        return AndroidPlatform.getInstance().getApplicationName();
    }

    public String getAppVersion()
    {
        return AndroidPlatform.getInstance().getApplicationVersion();
    }

    public String getDebugWeinreServerHost()
    {
        return "";
    }

    public int getDebugWeinreServerPort()
    {
        return 0;
    }

    public boolean getDebugWeinreServerSatus()
    {
        return false;
    }

    public String getDeviceDmsDeviceType()
    {
        return "";
    }

    public String getDeviceDmsSerialNumber()
    {
        return "";
    }

    public String getOSName()
    {
        return "Android";
    }
}
