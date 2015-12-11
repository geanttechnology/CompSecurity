// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import com.amazon.identity.kcpsdk.common.SoftwareVersion;

public abstract class SSODeviceInfo
{

    public SSODeviceInfo()
    {
    }

    public abstract String getBuildName();

    public abstract int getBuildNumber();

    public String getDeviceSecret()
    {
        return null;
    }

    public abstract String getDeviceSerialNumber();

    public abstract String getDeviceType();

    public String getMacAddress()
    {
        return null;
    }

    public SoftwareVersion getSoftwareVersion()
    {
        return new SoftwareVersion(Integer.toString(getBuildNumber()));
    }
}
