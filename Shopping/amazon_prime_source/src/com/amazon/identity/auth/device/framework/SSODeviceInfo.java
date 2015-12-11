// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.kcpsdk.common.SoftwareVersion;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            Tracer

public abstract class SSODeviceInfo
{

    public SSODeviceInfo()
    {
    }

    public abstract String getAppDSN();

    public abstract int getBuildNumber();

    public abstract String getDeviceSecret();

    public abstract String getDeviceSerialNumber();

    public abstract String getDeviceType();

    public abstract String getMacAddress(Tracer tracer);

    public SoftwareVersion getSoftwareVersion()
    {
        return new SoftwareVersion(Integer.toString(getBuildNumber()));
    }
}
